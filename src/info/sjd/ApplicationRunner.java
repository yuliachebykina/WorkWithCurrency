package info.sjd;


import info.sjd.model.CommercialCurrency;
import info.sjd.model.Currency;
import info.sjd.service.CurrencyTransformService;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class ApplicationRunner {

    private static Logger logger = Logger.getLogger(ApplicationRunner.class.getName());

    public static void main(String[] args) {

        Long currentTime = new Date().getTime();
        logger.info("Start at " + new Date() + " it equals " + currentTime + " milliseconds");


        Currency euro = new Currency ("EUR", "EURO", 978, "Э", 2827);
        Currency usd = new Currency ("USD", "US_Dollar", 840, "$", 2540);
        Currency rub = new Currency ("RUB", "Russian_Rubble", 643, "p", 39);

        List<Currency> currencies = new ArrayList<>();


        currencies.add(euro);
        currencies.add(usd);
        currencies.add(rub);

        String currenciesASText = CurrencyTransformService.getCurrenciesList(currencies);

        logger.info("\n" + currenciesASText);

        List<CommercialCurrency> commercialCurrencies = CurrencyTransformService.getCommercialCurrenciesFromText(currenciesASText);

        for (CommercialCurrency commercialCurrency: commercialCurrencies) {
            logger.info(commercialCurrency.toString());
        }
    }
}
