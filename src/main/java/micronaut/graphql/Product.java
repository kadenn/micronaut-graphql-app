package micronaut.graphql;

public class Product {
    private String productId;
    private String title;
    private String description;
    private String category;
    private String colors;

    public Product(String productId, String title, String description, String category, String colors) {
        this.productId = productId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.colors = colors;
    }

    public String getProductId() {
        return productId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getColors() {
        return colors;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productid='" + productId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", colors=" + colors +
                '}';
    }
}
