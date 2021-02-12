import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

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
        //if(stocksList.contains(productID.contains())){}
        return 0;
    }

    @Override
    public double price(String exchange, String contractCode, int month, int year) {
        return 0;
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
        int totalForDay = 0;
        for( Stocks astock : stocksList){
            totalForDay = astock.getQuantity() + totalForDay;
        }
        for(Futures afuture : futuresList){
            totalForDay = afuture.getQuantity() + totalForDay;
        }
        return  totalForDay;
    }

    @Override
    public double totalValueOfDaysTradedProducts() {
        return 0;
    }
}
