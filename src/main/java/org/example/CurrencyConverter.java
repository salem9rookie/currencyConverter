package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;


public class CurrencyConverter extends JFrame {

    //variables here
    private JComboBox<String> fromCurrency;
    private JComboBox<String> toCurrency;
    private JTextField fromAmount;
    private JTextField toAmount;
    private Map<String, Double> conversionRates;

    //getters


    public JComboBox<String> getFromCurrency() {
        return fromCurrency;
    }

    public JComboBox<String> getToCurrency() {
        return toCurrency;
    }

    public JTextField getFromAmount() {
        return fromAmount;
    }

    public JTextField getToAmount() {
        return toAmount;
    }


    public CurrencyConverter() {
        String[] countries = {"India", "China", "US", "England", "Japan", "Russia"};
        //conversion rates put into hashmap for easier retrieval
        conversionRates = new HashMap<String, Double>();
        conversionRates.put("India", 74.0); // 1 USD to INR
        conversionRates.put("China", 6.5); // 1 USD to CNY
        conversionRates.put("US", 1.0); // 1 USD to USD
        conversionRates.put("England", 0.75); // 1 USD to GBP
        conversionRates.put("Japan", 110.0); // 1 USD to JPY
        conversionRates.put("Russia", 74.0); // 1 USD to RUB

        //setting up GUI aspects
        setTitle("Currency Converter");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        add(leftPanel);
        add(rightPanel);

        //creating left panel

        leftPanel.setLayout(new GridLayout(3, 1));

        fromCurrency = new JComboBox<>(countries);
        fromAmount = new JTextField();
        leftPanel.add(new JLabel("From Currency:"));
        leftPanel.add(fromCurrency);
        leftPanel.add(new JLabel("Amount:"));
        leftPanel.add(fromAmount);

        //creating right panel

        rightPanel.setLayout(new GridLayout(3, 1));
        toCurrency = new JComboBox<>(countries);
        toAmount = new JTextField();
        toAmount.setEditable(false);
        rightPanel.add(new JLabel("To Currency:"));
        rightPanel.add(toCurrency);
        rightPanel.add(new JLabel("Converted Amount:"));
        rightPanel.add(toAmount);

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ConvertAction());

        // Add the button at the bottom
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(convertButton);
        add(buttonPanel, BorderLayout.SOUTH);





    }

    private class ConvertAction implements ActionListener{

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

                toAmount.setText(String.format("%.2f", convertedValue));

            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(CurrencyConverter.this, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CurrencyConverter().setVisible(true);
            }
        });
    }
}