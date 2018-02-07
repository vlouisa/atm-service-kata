package nl.louisa.service;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;

import static nl.louisa.service.DispenserBuilder.aDispenser;
import static nl.louisa.service.Money.TEN_EURO;
import static nl.louisa.service.Money.TWENTY_EURO;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(JUnitParamsRunner.class)
public class ATMServiceShould {
    private ATMService atmService;
    private Map<Money, Integer> dispenser;

    @Before
    public void setUp() throws Exception {
        atmService = new ATMService();
    }


    @Parameters(method="params")
    @Test public void
    dispense_requested_amount_with_minimal_quantity_of_bills(int amount, Map<Money, Integer> dispenser) {
            this.dispenser = dispenser;

        assertThat(atmService.withdraw(amount), is(this.dispenser));
    }

    public static Object[] params(){
        return new Object[]{
                    new Object[]{180, aDispenser()
                                        .add(Money.FIFTY_EURO, 3)
                                        .add(TWENTY_EURO, 1)
                                        .add(TEN_EURO, 1)
                                        .build()},
//                    new Object[]{40, aDispenser()
//                                        .add(TWENTY_EURO, 2)
//                                        .build()},
        };
    }


}