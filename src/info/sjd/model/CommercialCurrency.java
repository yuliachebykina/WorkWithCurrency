package info.sjd.model;

public class CommercialCurrency extends Currency{


    private Integer buyValue;
    private Integer sellValue;


    public Integer getBuyValue() {
        return buyValue;
    }

    public void setBuyValue(Integer buyValue) {
        this.buyValue = buyValue;
    }

    public Integer getSellValue() {
        return sellValue;
    }

    public void setSellValue(Integer sellValue) {
        this.sellValue = sellValue;
    }

    public CommercialCurrency(Integer buyValue, Integer sellValue) {
        this.buyValue = buyValue;
        this.sellValue = sellValue;
    }

    public CommercialCurrency(String shortName, String fullName, Integer code, String symbol, Integer value, Integer buyValue, Integer sellValue) {
        super(shortName, fullName, code, symbol, value);
        this.buyValue = buyValue;
        this.sellValue = sellValue;
    }

    public CommercialCurrency() {
    }

    @Override
    public String toString() {
        return super.getShortName() + " " + super.getFullName().replaceAll("_"," ") + " " + super.getCode() + " " + super.getSymbol() + " " + super.getValue() + " " + buyValue + " " +sellValue;
    }
}
