package nl.louisa.service;

import java.util.HashMap;
import java.util.Map;

import static nl.louisa.service.Denomination.*;

public class ATMService {
    private Map<Denomination, Integer> wallet = new HashMap<>();

    public Map<Denomination, Integer> withdraw(int amount){
            if(amount >= FIFTY_EURO.getValue()){
                int quantity = amount / FIFTY_EURO.getValue();
                if (quantity != 0) {
                    wallet.put(FIFTY_EURO, quantity);
                }

                amount = amount - (quantity * FIFTY_EURO.getValue());
            }

            if(amount >= TWENTY_EURO.getValue()){
                int quantity = amount / TWENTY_EURO.getValue();
                if (quantity != 0) {
                    wallet.put(TWENTY_EURO, quantity);
                }

                amount = amount - (quantity * TWENTY_EURO.getValue());
            }

            if(amount >= TEN_EURO.getValue()) {
                int quantity = amount / TEN_EURO.getValue();
                if (quantity != 0) {
                    wallet.put(TEN_EURO, quantity);
                }
            }

            return wallet;
    }
}
