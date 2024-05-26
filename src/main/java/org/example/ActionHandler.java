package org.example;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
    private CurrencyConverterPanel panel;
    private CurrencyConverterLogic logic;

    public ActionHandler(CurrencyConverterPanel panel, CurrencyConverterLogic logic) {
        this.panel = panel;
        this.logic = logic;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String fromCurrencyStr = (String) panel.getFromCurrency().getSelectedItem();
            String toCurrencyStr = (String) panel.getToCurrency().getSelectedItem();
            double fromValue = Double.parseDouble(panel.getFromAmount().getText());
            double convertedValue = logic.convert(fromCurrencyStr, toCurrencyStr, fromValue);

            String toCurrencyCode = logic.getCurrencyCode(toCurrencyStr);
            String formattedValue = logic.formatCurrency(convertedValue, toCurrencyCode);
            panel.getToAmount().setText(formattedValue);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(panel, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
