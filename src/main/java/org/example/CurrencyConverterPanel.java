package org.example;

import javax.swing.*;
import java.awt.*;

public class CurrencyConverterPanel extends JPanel {
    private JComboBox<String> fromCurrency;
    private JComboBox<String> toCurrency;
    private JTextField fromAmount;
    private JTextField toAmount;
    private JButton convertButton;

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

    public CurrencyConverterPanel() {
        String[] countries = {"India", "China", "US", "England", "Japan", "Russia", "Cayman Islands", "Kenya", "Vietnam"};

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

        convertButton = new JButton("Convert");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(convertButton);
        add(buttonPanel, BorderLayout.SOUTH);

        CurrencyConverterLogic logic = new CurrencyConverterLogic();
        convertButton.addActionListener(new ActionHandler(this, logic));


    }
}
