package nl.louisa.service;

import java.util.Map;

public class Dispenser {
    private Dispenser nextDispenser;
    private Denomination denomination;

    public Dispenser(Denomination denomination) {
        this.denomination = denomination;
    }

    public static Dispenser create(Dispenser... dispensers) {
        for (int i = 0; i < dispensers.length; i++) {
            if (i == dispensers.length - 1)
                return dispensers[0];

            dispensers[i].setNextDispenser(dispensers[i + 1]);
        }
        throw new IllegalStateException("Chain error!");
    }

    public void setNextDispenser(Dispenser nextDispenser) {
        this.nextDispenser = nextDispenser;
    }

    public void execute(int amount, Map<Denomination, Integer> wallet) {
        int remainder = addToWallet(amount, wallet);

        if(nextDispenser != null)
            nextDispenser.execute(remainder, wallet);
    }

    private int addToWallet(int amount, Map<Denomination, Integer> wallet) {
        if (numberOfDenominations(amount) != 0) {
            wallet.put(denomination, numberOfDenominations(amount));
        }

        return amount - (numberOfDenominations(amount) * denomination.getValue());
    }

    private int numberOfDenominations(int amount) {
        return amount / denomination.getValue();
    }
}