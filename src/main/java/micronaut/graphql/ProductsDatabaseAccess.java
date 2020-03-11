package micronaut.graphql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProductsDatabaseAccess {

    private static String url;
    private static String user;
    private static String password;
    private static Logger logger = LoggerFactory.getLogger(ProductsDatabaseAccess.class);

    public ProductsDatabaseAccess() {
    	ProductsDatabaseAccess.url = "jdbc:postgresql://db:5432/products";
        ProductsDatabaseAccess.user = "postgres";
        ProductsDatabaseAccess.password = "kagan123";
    }

    
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            //Connected to the PostgreSQL server successfully.
        } catch (SQLException e) {
        	logger.error("Connection to database failed, " , e);
            
        }

        return conn;
    }


    public List<Product> getProducts(String productId) {

        List<Product> products = new ArrayList<Product>();
        String SQL;

        if (productId == null) {
            SQL = "SELECT * FROM product";
        } else {
            SQL = "SELECT * FROM product WHERE productid=" + productId;
        }

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                Product tempProd = productCreator(rs);
                products.add(tempProd);
                logger.info(tempProd.toString());
            }
        } catch (SQLException ex) {
            logger.info(ex.getMessage());
        }
        return products;
    }

    public List<Size> getSizes(String productId) {

        List<Size> sizes = new ArrayList<Size>();
        String SQL;

        if (productId == null) {
            SQL = "SELECT * FROM size";
        } else {
            SQL = "SELECT * FROM size WHERE productid=" + productId;
        }

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                Size tempSize = sizeCreator(rs);
                sizes.add(tempSize);
                logger.info(tempSize.toString());
            }
        } catch (SQLException ex) {
            logger.info(ex.getMessage());
        }
        return sizes;
    }

    public List<Image> getImages(String productId) {

        List<Image> images = new ArrayList<Image>();
        String SQL;

        if (productId == null) {
            SQL = "SELECT * FROM image";
        } else {
            SQL = "SELECT * FROM image WHERE productid=" + productId;
        }

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                Image tempImage = imageCreator(rs);
                images.add(tempImage);
                logger.info(tempImage.toString());
            }
        } catch (SQLException ex) {
            logger.info(ex.getMessage());
        }
        return images;
    }

    public List<Price> getPrices(String productId) {

        List<Price> prices = new ArrayList<Price>();
        String SQL;

        if (productId == null) {
            SQL = "SELECT * FROM price";
        } else {
            SQL = "SELECT * FROM price WHERE productid=" + productId;
        }

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                Price tempPrice = priceCreator(rs);
                prices.add(tempPrice);
                logger.info(tempPrice.toString());
            }
        } catch (SQLException ex) {
            logger.info(ex.getMessage());
        }
        return prices;
    }


    public static Product productCreator(ResultSet rs) throws SQLException {
        String productid;
        String title;
        String description;
        String category;
        String colors;

        productid = rs.getArray(1).toString();
        title = rs.getArray(2).toString();
        description = rs.getArray(3).toString();
        category = rs.getArray(4).toString();
        colors = rs.getArray(5).toString();

        Product product = new Product(productid, title, description, category, colors);

        return product;
    }

    private Size sizeCreator(ResultSet rs) throws SQLException {
        String productid;
        String sizeName;
        boolean onSale;
        boolean inStock;

        productid = rs.getArray(1).toString();
        sizeName = rs.getArray(2).toString();
        onSale = rs.getBoolean(3);
        inStock = rs.getBoolean(4);

        Size size = new Size(productid, sizeName, onSale, inStock);

        return size;
    }

    private Image imageCreator(ResultSet rs) throws SQLException {
        String productid;
        String uri;

        productid = rs.getArray(1).toString();
        uri = rs.getArray(2).toString();

        Image image = new Image(productid, uri);

        return image;
    }

    private Price priceCreator(ResultSet rs) throws SQLException {
        String productid;
        String sizeName;
        String currentPrice;
        String discountedPrice;

        productid = rs.getArray(1).toString();
        sizeName = rs.getArray(2).toString();
        currentPrice = rs.getArray(3).toString();
        discountedPrice = rs.getArray(4).toString();

        Price price = new Price(productid, sizeName, currentPrice, discountedPrice);

        return price;
    }

    public static void main(String[] args) {
        ProductsDatabaseAccess app = new ProductsDatabaseAccess();
        System.out.println(app.getPrices("2"));
    }

}


