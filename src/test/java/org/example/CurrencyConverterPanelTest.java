package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CurrencyConverterPanelTest {

    private CurrencyConverterPanel panel;

    @Before
    public void setUp(){
        panel = new CurrencyConverterPanel();
    }

    @Test
    public void testComponentsInitialization() {
        assertNotNull(panel.getFromCurrency());
        assertNotNull(panel.getToCurrency());
        assertNotNull(panel.getFromAmount());
        assertNotNull(panel.getToAmount());
    }

    @Test
    public void testDefaultSelection() {
        assertEquals("India", panel.getFromCurrency().getSelectedItem());
        assertEquals("India", panel.getToCurrency().getSelectedItem());
    }




}
