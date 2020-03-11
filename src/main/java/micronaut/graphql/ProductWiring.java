package micronaut.graphql;


import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.dataloader.DataLoaderRegistry;

import java.util.List;

class ProductWiring {

    public static class Context {

        final DataLoaderRegistry dataLoaderRegistry;
        final ProductsDatabaseAccess productsDB;

        public Context() {
            this.productsDB = new ProductsDatabaseAccess();
            this.dataLoaderRegistry = new DataLoaderRegistry();
        }

        public DataLoaderRegistry getDataLoaderRegistry() {
            return dataLoaderRegistry;
        }

        public ProductsDatabaseAccess productsDB() {
            return productsDB;
        }
    }

    public static String productId;

    static DataFetcher<List<Product>> productsDataFetcher = new DataFetcher<List<Product>>() {
        @Override
        public List<Product> get(DataFetchingEnvironment environment) {

            productId = environment.getArgument("productId");

            Context context = new Context();
            ProductsDatabaseAccess productsDB = context.productsDB();

            return productsDB.getProducts(productId);

        }
    };


    static DataFetcher<List<Image>> imagesDataFetcher = new DataFetcher<List<Image>>() {
        @Override
        public List<Image> get(DataFetchingEnvironment environment) {

            Context context = new Context();
            ProductsDatabaseAccess productsDB = context.productsDB();

            return productsDB.getImages(productId);

        }
    };

    static DataFetcher<List<Size>> sizesDataFetcher = new DataFetcher<List<Size>>() {
        @Override
        public List<Size> get(DataFetchingEnvironment environment) {

            Context context = new Context();
            ProductsDatabaseAccess productsDB = context.productsDB();

            return productsDB.getSizes(productId);

        }
    };

    static DataFetcher<List<Price>> priceDataFetcher = new DataFetcher<List<Price>>() {
        @Override
        public List<Price> get(DataFetchingEnvironment environment) {

            Context context = new Context();
            ProductsDatabaseAccess productsDB = context.productsDB();

            return productsDB.getPrices(productId);

        }
    };


}