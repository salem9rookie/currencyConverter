package org.example;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverterLogic {

    private Map<String, Double> conversionRates;
    private Map<String, String> countryToCurrencyCode;

    public CurrencyConverterLogic(){
        //conversion rates put into hashmap for easier retrieval
        conversionRates = new HashMap<String, Double>();
        conversionRates.put("India", 74.0); // 1 USD to INR
        conversionRates.put("China", 6.5); // 1 USD to CNY
        conversionRates.put("US", 1.0); // 1 USD to USD
        conversionRates.put("England", 0.75); // 1 USD to GBP
        conversionRates.put("Japan", 156.9); // 1 USD to JPY
        conversionRates.put("Russia", 74.0); // 1 USD to RUB
        conversionRates.put("Cayman Islands", 0.83);
        conversionRates.put("Kenya", 130.34);
        conversionRates.put("Vietnam", 25471.00);

        countryToCurrencyCode = new HashMap<>();
        countryToCurrencyCode.put("India", "INR");
        countryToCurrencyCode.put("China", "CNY");
        countryToCurrencyCode.put("US", "USD");
        countryToCurrencyCode.put("England", "GBP");
        countryToCurrencyCode.put("Japan", "JPY");
        countryToCurrencyCode.put("Russia", "RUB");
        countryToCurrencyCode.put("Cayman Islands", "KYD");
        countryToCurrencyCode.put("Kenya", "KES");
        countryToCurrencyCode.put("Vietnam", "VND");
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        double conversionRateFrom = conversionRates.get(fromCurrency);
        double conversionRateTo = conversionRates.get(toCurrency);

        double amountInUSD = amount / conversionRateFrom;
        return amountInUSD * conversionRateTo;
    }

    public String formatCurrency(double amount, String currencyCode) {
        Currency currency = Currency.getInstance(currencyCode);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        currencyFormat.setCurrency(currency);
        return currencyFormat.format(amount);
    }

    public String getCurrencyCode(String country) {
        return countryToCurrencyCode.get(country);
    }
}
