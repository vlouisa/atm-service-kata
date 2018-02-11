package nl.louisa.service;

import java.util.HashMap;
import java.util.Map;

import static nl.louisa.service.Denomination.*;

public class ATMService {
    private Map<Denomination, Integer> wallet = new HashMap<>();

    public Map<Denomination, Integer> withdraw(int amount){
        validate(amount);

        if(amount >= FIFTY_EURO.getValue()){
            amount = processWallet(amount, FIFTY_EURO);
        }

        if(amount >= TWENTY_EURO.getValue()){
            amount = processWallet(amount, TWENTY_EURO);
        }

        if(amount >= TEN_EURO.getValue()) {
            processWallet(amount, TEN_EURO);
        }

        return wallet;

    }

    private void validate(int amount) {
        if(amount % Denomination.smallest() != 0) {
            throw new IllegalArgumentException("ATM cannot dispense the requested amount!");
        }
    }

    private int processWallet(int amount, Denomination denomination) {
        int quantity = amount / denomination.getValue();
        if (quantity != 0) {
            wallet.put(denomination, quantity);
        }

        return amount - (quantity * denomination.getValue());
    }
}
