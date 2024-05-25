package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class CurrencyConverter extends JFrame {

    //variables here
    private JComboBox<String> fromCurrency;
    private JComboBox<String> toCurrency;
    private JTextField fromAmount;
    private JTextField toAmount;
    private Map<String, Double> conversionRates;

    private final String[] countries = {"India", "China", "US", "England", "Japan", "Russia"};
    private final Map<String, String> currencyCodes = Map.of(
            "India", "INR",
            "China", "CNY",
            "US", "USD",
            "England", "GBP",
            "Japan", "JPY",
            "Russia", "RUB"
    );

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        add(leftPanel);
        add(rightPanel);

        conversionRates = new HashMap<>();
        //fetch conversion rates method to be created here


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
    }




    public static void main(String[] args) {

        System.out.println("Hello world!");
    }
}