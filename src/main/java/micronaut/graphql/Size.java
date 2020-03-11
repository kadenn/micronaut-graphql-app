package micronaut.graphql;

public class Size {
    private String productId;
    private String sizeName;
    private boolean onSale;
    private boolean inStock;

    public Size(String productId, String sizeName, boolean onSale, boolean inStock) {
        this.productId = productId;
        this.sizeName = sizeName;
        this.onSale = onSale;
        this.inStock = inStock;
    }

    public String getProductId() {
        return productId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public boolean isInStock() {
        return inStock;
    }

    @Override
    public String toString() {
        return "Size{" +
                "productId='" + productId + '\'' +
                ", sizeName='" + sizeName + '\'' +
                ", onSale=" + onSale +
                ", inStock=" + inStock +
                '}';
    }
}
