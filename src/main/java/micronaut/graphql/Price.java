package micronaut.graphql;

public class Price {
    private String productId;
    private String sizeName;
    private String discountedPrice;
    private String currentPrice;

    public Price(String productId, String sizeName, String discountedPrice, String currentPrice) {
        this.productId = productId;
        this.sizeName = sizeName;
        this.discountedPrice = discountedPrice;
        this.currentPrice = currentPrice;
    }

    public String getProductId() {
        return productId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    @Override
    public String toString() {
        return "Price{" +
                "productId='" + productId + '\'' +
                ", sizeName='" + sizeName + '\'' +
                ", discountedPrice='" + discountedPrice + '\'' +
                ", currentPrice='" + currentPrice + '\'' +
                '}';
    }
}
