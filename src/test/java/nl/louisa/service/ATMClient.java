package nl.louisa.service;

import java.util.Map;

public class ATMClient {
    public static void main(String[] args) {
        ATMService service = new ATMService();
        Map<Denomination, Integer> wallet = service.withdraw(195);
        System.out.println("Wallet : " + wallet);
    }
}
