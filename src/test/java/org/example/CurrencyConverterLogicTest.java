package org.example;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class CurrencyConverterLogicTest {

    private CurrencyConverterLogic logic;

    @Before
    public void setUp(){
        logic = new CurrencyConverterLogic();
    }

    //since there is no state that needs to be maintained, as it isn't attached to a database, there is no need for a tear down method

    @Test
    public void testConvert() {
        double result = logic.convert("US", "India", 1);
        assertEquals(74.0, result, 0.01);
    }

    @Test
    public void testFormatCurrency() {
        String formatted = logic.formatCurrency(100, "USD");
        assertEquals("$100.00", formatted);
    }

    @Test
    public void testGetCurrencyCode() {
        String code = logic.getCurrencyCode("India");
        assertEquals("INR", code);
    }

}
