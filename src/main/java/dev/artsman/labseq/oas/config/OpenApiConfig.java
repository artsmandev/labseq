package dev.artsman.labseq.oas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class OpenApiConfig {
	@Bean
	public OpenAPI openApi() {
		return new OpenAPI()
			.info(info())
			.servers(servers());
	}

	private Info info() {
		return new Info()
			.version("0.0.1-SNAPSHOT")
			.title("LabSeq API")
			.description("An API RESTfull, returning a value from the labseq sequence.")
			.contact(contact())
			.license(license());
	}

	private Contact contact() {
		return new Contact()
			.name("Bruno Andrade")
			.url("https://artsman.dev")
			.email("bruno@artsman.dev");
	}

	private License license() {
		return new License()
			.name("MIT License")
			.identifier("MIT")
			.url("https://www.mit.edu/~amini/LICENSE.md");
	}

	private List<Server> servers() {
		var development = new Server()
			.url("http://localhost:8080")
			.description("Development");
		return List.of(development);
	}
}
