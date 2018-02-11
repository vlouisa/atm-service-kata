package nl.louisa.service;

import java.util.HashMap;
import java.util.Map;

public class ATMService {
    private Map<Denomination, Integer> wallet = new HashMap<>();
    private Dispenser dispenser;

    public ATMService(Dispenser dispenser){
        this.dispenser = dispenser;
    }

    public Map<Denomination, Integer> withdraw(int amount){
        validate(amount);
        dispenseToWallet(amount);
        return wallet;
    }

    private void validate(int amount) {
        if(amount % Denomination.smallest() != 0) {
            throw new IllegalArgumentException("ATM cannot dispense the requested amount!");
        }
    }

    private void dispenseToWallet(int amount) {
        dispenser.execute(amount, wallet);
    }
}
