package nl.louisa.service;

import java.util.Map;

public class ATMClient {
    public static void main(String[] args) {
        Dispenser dispenser = Dispenser.create(
                new Dispenser(Denomination.FIFTY_EURO),
                new Dispenser(Denomination.TWENTY_EURO),
                new Dispenser(Denomination.TEN_EURO)
        );

        ATMService service = new ATMService(dispenser);
        Map<Denomination, Integer> wallet = service.withdraw(180);

        System.out.println("Wallet : " + wallet);
    }
}
