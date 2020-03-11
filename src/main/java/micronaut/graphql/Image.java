package micronaut.graphql;

public class Image {
    private String productId;
    private String uri;

    public Image(String productId, String uri) {
        this.productId = productId;
        this.uri = uri;
    }

    public String getProductId() {
        return productId;
    }

    public String getUri() {
        return uri;
    }

    @Override
    public String toString() {
        return "Image{" +
                "productId='" + productId + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}

