package nl.louisa.service;

import java.util.HashMap;
import java.util.Map;

public class DispenserBuilder {
    private Map<Money, Integer> dispenser = new HashMap<>();

    public static DispenserBuilder aDispenser() {
        return new DispenserBuilder();
    }

    public DispenserBuilder add(Money money, int quantity) {
        dispenser.put(money, quantity);
        return this;
    }


    public Map<Money, Integer> build() {
        return dispenser;
    }
}
