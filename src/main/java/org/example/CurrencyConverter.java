package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Currency;


public class CurrencyConverter extends JFrame {

    //variables here


    //getters





    public CurrencyConverter() {



        //setting up GUI aspects
        setTitle("Currency Converter");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CurrencyConverterPanel panel = new CurrencyConverterPanel();
        add(panel);










    }

    /*private class ConvertAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String fromCurrencyStr = (String) fromCurrency.getSelectedItem();
                String toCurrencyStr = (String) toCurrency.getSelectedItem();
                double fromValue = Double.parseDouble(fromAmount.getText());
                double conversionRateFrom = conversionRates.get(fromCurrencyStr);
                double conversionRateTo = conversionRates.get(toCurrencyStr);

                // Convert from base (USD) to target currency
                double amountInUSD = fromValue / conversionRateFrom;
                double convertedValue = amountInUSD * conversionRateTo;

                String toCurrencyCode = countryToCurrencyCode.get(toCurrencyStr);
                Currency currency = Currency.getInstance(toCurrencyCode);
                NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
                currencyFormat.setCurrency(currency);

                toAmount.setText(currencyFormat.format(convertedValue));

            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(CurrencyConverter.this, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }*/




    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CurrencyConverter().setVisible(true));
    }
}