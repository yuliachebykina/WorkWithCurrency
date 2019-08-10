package info.sjd.service;


import info.sjd.model.CommercialCurrency;
import info.sjd.model.Currency;
import info.sjd.util.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class CurrencyTransformService {

    public static String getCurrenciesList(List<Currency> currencies) {
        String currenciesList = "";
        for (Currency currency: currencies) {
            currenciesList += currency.toString() + "\n";
        }
        return currenciesList;
    }

    public static CommercialCurrency getCommercialCurrency(Currency currency) {
        Integer buyValue = currency.getValue() * 120/100;
        Integer sellValue = currency.getValue() * 140/100;

        return new CommercialCurrency(currency.getShortName(), currency.getFullName(), currency.getCode(), currency.getSymbol(), currency.getValue(), buyValue, sellValue);
    }

    public static List<CommercialCurrency> getCommercialCurrenciesFromText(String currenciesAsText) {
        List<CommercialCurrency> commercialCurrencies = new ArrayList<>();

        String[] lines = currenciesAsText.split("\n");

        for (String line: lines) {
            Currency currency = getCurrencyFromLine(line);
            CommercialCurrency commercialCurrency = getCommercialCurrency(currency);
            commercialCurrencies.add(commercialCurrency);
        }

        return commercialCurrencies;
    }

    private static Currency getCurrencyFromLine(String line) {
        String[] words = line.split(" ");
        return new Currency(words[0], words[1], Integer.parseInt(words[2]), words[3], Integer.parseInt(words[4]));
    }
}
