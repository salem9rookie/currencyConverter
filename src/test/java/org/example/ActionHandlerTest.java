package org.example;

import org.junit.*;

import java.awt.event.ActionEvent;

import static org.junit.Assert.assertEquals;

public class ActionHandlerTest {

    private CurrencyConverterPanel panel;
    private CurrencyConverterLogic logic;
    private ActionHandler handler;

    @Before
    public void setUp(){
        panel = new CurrencyConverterPanel();
        logic = new CurrencyConverterLogic();
        handler = new ActionHandler(panel, logic);
    }

    @Test
    public void testActionPerformed() {
        panel.getFromCurrency().setSelectedItem("US");
        panel.getToCurrency().setSelectedItem("India");
        panel.getFromAmount().setText("1");

        handler.actionPerformed(new ActionEvent(panel, ActionEvent.ACTION_PERFORMED, null));

        assertEquals("₹74.00", panel.getToAmount().getText());
    }
    @Test
    public void testEmptyInput() {
        panel.getFromCurrency().setSelectedItem("US");
        panel.getToCurrency().setSelectedItem("India");
        panel.getFromAmount().setText(""); // Empty input

        handler.actionPerformed(new ActionEvent(panel, ActionEvent.ACTION_PERFORMED, null));

        // Verify that the output is still empty or an error message is shown (depending on the implementation)
        assertEquals("", panel.getToAmount().getText());
    }

    @Test
    public void testInvalidInput() {
        panel.getFromCurrency().setSelectedItem("US");
        panel.getToCurrency().setSelectedItem("India");
        panel.getFromAmount().setText("abc"); // Invalid input

        handler.actionPerformed(new ActionEvent(panel, ActionEvent.ACTION_PERFORMED, null));

        // Verify that the output is still empty or an error message is shown (depending on the implementation)
        assertEquals("", panel.getToAmount().getText());
    }
}
