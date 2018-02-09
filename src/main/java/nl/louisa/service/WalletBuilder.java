package nl.louisa.service;

import java.util.HashMap;
import java.util.Map;

public class WalletBuilder {
    private Map<Denomination, Integer> wallet = new HashMap<>();

    public static WalletBuilder aWallet() {
        return new WalletBuilder();
    }

    public WalletBuilder add(Denomination denomination, int quantity) {
        wallet.put(denomination, quantity);
        return this;
    }


    public Map<Denomination, Integer> build() {
        return wallet;
    }
}
