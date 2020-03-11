package micronaut.graphql;

import java.io.File;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.types.files.SystemFile;

@Controller("/products")
public class GetController {
	@Get
	@Produces(MediaType.TEXT_HTML)
	public SystemFile html() {
		File file = new File("/home/resources/index.html");
		return new SystemFile(file, MediaType.TEXT_HTML_TYPE);
	}

}