package micronaut.graphql;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.core.io.ResourceResolver;
import javax.inject.Singleton;
import micronaut.graphql.ProductWiring;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;
import java.io.File;

@Factory
public class GraphQLFactory {

	@Bean
	@Singleton
	public GraphQL graphQL(ResourceResolver resourceResolver) {

		// Parse the schema.
		File schema_file = new File("/home/resources/productsSchema.graphqls");
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schema_file);

		// Create the runtime wiring.
		RuntimeWiring wiring = RuntimeWiring.newRuntimeWiring()
				.type(newTypeWiring("Query").dataFetcher("products", ProductWiring.productsDataFetcher))
				.type(newTypeWiring("Product").dataFetcher("images", ProductWiring.imagesDataFetcher)
						.dataFetcher("sizes", ProductWiring.sizesDataFetcher)
						.dataFetcher("price", ProductWiring.priceDataFetcher))
				.build();

		// Create the executable schema.
		GraphQLSchema productsSchema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);

		// Return the GraphQL bean.
		return GraphQL.newGraphQL(productsSchema).build();
	}
}