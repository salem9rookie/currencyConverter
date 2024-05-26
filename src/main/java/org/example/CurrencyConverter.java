package org.example;

import javax.swing.*;


public class CurrencyConverter extends JFrame {

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CurrencyConverterPanel panel = new CurrencyConverterPanel();
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CurrencyConverter().setVisible(true));
    }
}