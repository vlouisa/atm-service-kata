package nl.louisa.service;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;

import static nl.louisa.service.Denomination.*;
import static nl.louisa.service.WalletBuilder.aWallet;
import static nl.louisa.service.Denomination.TEN_EURO;
import static nl.louisa.service.Denomination.TWENTY_EURO;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(JUnitParamsRunner.class)
public class ATMServiceShould {
    private ATMService atmService;

    @Before
    public void setUp() throws Exception {
        atmService = new ATMService();
    }


    @Parameters(method="params")
    @Test public void
    dispense_requested_amount(int amount, Map<Denomination, Integer> wallet) {
        assertThat(atmService.withdraw(amount), is(wallet));
    }

    public static Object[] params(){
        return new Object[]{
                    new Object[]{180, aWallet()
                                        .add(FIFTY_EURO, 3)
                                        .add(TWENTY_EURO, 1)
                                        .add(TEN_EURO, 1)
                                        .build()},

                new Object[]{70, aWallet()
                        .add(FIFTY_EURO, 1)
                        .add(TWENTY_EURO, 1)
                        .build()},
        };
    }


}