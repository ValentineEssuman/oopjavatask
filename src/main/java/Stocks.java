public class Stocks extends Product {

    private String stockTicker;
    private String exchange;

    public Stocks(String productID, Double currentPrice, String exchange, String stockTicker ) {
        super(productID, currentPrice);
        this.exchange = exchange;
        this.stockTicker = stockTicker;
    }

    @Override
    public Double getCurrentPrice() {
        return super.getCurrentPrice();
    }

    public String getStockTicker() {
        return stockTicker;
    }

    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }
g
    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

}
