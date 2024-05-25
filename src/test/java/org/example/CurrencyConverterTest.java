package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConverterTest {
    //variables
    private CurrencyConverter currencyConverter;
    private JButton convertButton;

    @BeforeEach
    public void setUp(){
        currencyConverter = new CurrencyConverter();
        convertButton = (JButton) ((JPanel) currencyConverter.getContentPane().getComponent(2)).getComponent(0);
    }
    @AfterEach
    public void tearDown() {
        // Placeholder for any future cleanup code
        currencyConverter.dispose();
    }
    @Test
    public void currencyConverter_USDtoJPY(){

        currencyConverter.getFromCurrency().setSelectedItem("US");
        currencyConverter.getToCurrency().setSelectedItem("Japan");
        currencyConverter.getFromAmount().setText("1");
        //trigger the conversion
        convertButton.doClick();

        String expectedValue = String.format("%.2f", 110.0); // 1 USD = 110 JPY
        assertEquals(expectedValue, currencyConverter.getToAmount().getText());

    }
    @Test
    public void currencyConverter_JPYtoUSD(){
        currencyConverter.getFromCurrency().setSelectedItem("Japan");
        currencyConverter.getToCurrency().setSelectedItem("US");
        currencyConverter.getFromAmount().setText("1");
        //trigger the conversion
        convertButton.doClick();

        String expectedValue = String.format("%.2f", 0.01); // 1 USD = 110 JPY
        assertEquals(expectedValue, currencyConverter.getToAmount().getText());
    }
    @Test
    public void currencyConverter_testEmptyInput(){
        currencyConverter.getFromCurrency().setSelectedItem("US");
        currencyConverter.getToCurrency().setSelectedItem("Japan");
        currencyConverter.getFromAmount().setText("");
        //trigger the conversion
        convertButton.doClick();
        assertEquals("", currencyConverter.getToAmount().getText());

    }
    @Test
    public void currencyConverter_nonNumericInput(){
        currencyConverter.getFromCurrency().setSelectedItem("US");
        currencyConverter.getToCurrency().setSelectedItem("Japan");
        currencyConverter.getFromAmount().setText("invalid");
        convertButton.doClick();
        assertEquals("", currencyConverter.getToAmount().getText());
    }
    @Test
    public void currencyConverter_specialCharacterInput(){
        currencyConverter.getFromCurrency().setSelectedItem("US");
        currencyConverter.getToCurrency().setSelectedItem("Japan");
        currencyConverter.getFromAmount().setText("#$%&*");
        convertButton.doClick();
        assertEquals("", currencyConverter.getToAmount().getText());
    }
}