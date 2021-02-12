import java.util.ArrayList;
import java.util.List;

public class Product implements  ProductPricingService, MontrealTradedProducts{
    private String productID;
    private Double currentPrice;
    private Integer quantity;
    public List<Stocks> stocksList =  new ArrayList<>();
    public List<Futures> futuresList =  new ArrayList<>();

    public Product(String productID, Double currentPrice) {
        this.productID = productID;
        this.currentPrice = currentPrice;
        this.quantity = 0;
    }

    public String getProductID() {
        return productID;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Stocks> getStocksList() {
        return stocksList;
    }

    public List<Futures> getFuturesList() {
        return futuresList;
    }

    @Override
    public double price(String exchange, String ticker) {
        double stockpilesOnExchange = 0.0; //eg NYSE
        for(Stocks stock : stocksList){
            if(stock.getStockTicker() == ticker && stock.getExchange()== exchange){
                stockpilesOnExchange = stock.getQuantity() * stock.getCurrentPrice();
            }
        }

        return stockpilesOnExchange;
    }

    @Override
    public double price(String exchange, String contractCode, int month, int year) {
        double futureValuationOnExchange = 0.0; //eg NYSE
        for(Futures future : futuresList){
            if(future.getContractCode() == contractCode && future.getMonth() == month && future.getYear() == year
                    && future.getExchange()== exchange){
                futureValuationOnExchange = future.getQuantity() * future.getCurrentPrice();
            }
        }

        return futureValuationOnExchange;
    }

    @Override
    public void addNewProduct(Product product) throws ProductAlreadyRegisteredException {
        if(product instanceof  Stocks){
            if(!stocksList.contains(product.getProductID())){
                stocksList.add((Stocks)product);
            }
        }
        if(product instanceof Futures){
            if(!futuresList.contains(product.getProductID())){
                futuresList.add((Futures)product);
            }
        }else {
            throw new ProductAlreadyRegisteredException("This stock with " + product.productID  + " exist.");
        }
    }


    @Override
    public void trade(Product product, int quantity) {
        if(product instanceof  Stocks){
            if(stocksList.contains(product.getProductID())){
                product.setQuantity(product.getQuantity()+ quantity);
            }
        }

    }

    @Override
    public int totalTradeQuantityForDay() {
        int quantityForDay = 0;
        for( Stocks stock : stocksList){
            quantityForDay = stock.getQuantity() + quantityForDay;
        }
        for(Futures future : futuresList){
            quantityForDay = future.getQuantity() + quantityForDay;
        }
        return  quantityForDay;
    }

    @Override
    public double totalValueOfDaysTradedProducts() {
        double talValueOfDaysTrade = 0;
        for( Stocks stock : stocksList){
            talValueOfDaysTrade = talValueOfDaysTrade + (stock.getQuantity() * stock.getCurrentPrice());
        }
        for(Futures future : futuresList){
            talValueOfDaysTrade = talValueOfDaysTrade + (future.getQuantity() * future.getCurrentPrice());
        }
        return  talValueOfDaysTrade;
    }
}
