package nl.louisa.service;

import java.util.HashMap;
import java.util.Map;

public class ATMService {
    private Map<Money, Integer> dispenser = new HashMap<>();

    public Map<Money, Integer> withdraw(int amount){


            if(amount >= Money.FIFTY_EURO.getValue()){
                int quantity = amount / Money.FIFTY_EURO.getValue();
                dispenser.put(Money.FIFTY_EURO, quantity);
                amount = amount - (quantity * Money.FIFTY_EURO.getValue());
            }

            if(amount >= Money.TWENTY_EURO.getValue()){
                int quantity = amount / Money.TWENTY_EURO.getValue();
                dispenser.put(Money.TWENTY_EURO, quantity);
                amount = amount - (quantity * Money.TWENTY_EURO.getValue());
            }

            if(amount >= Money.TEN_EURO.getValue()){
                int quantity = amount / Money.TEN_EURO.getValue();
                dispenser.put(Money.TEN_EURO, quantity);
            }

            return dispenser;
    }
}
