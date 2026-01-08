package gr.hua.dit.LibraryDirections.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI configuration.
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("LibraryDirections API")
                        .version("v1")
                        .description("REST API that provides directions to the university library via Google Maps"));
    }

    @Bean
    public GroupedOpenApi apiGroup() {
        return GroupedOpenApi.builder()
                .group("library-directions")
                .packagesToScan("gr.hua.dit.LibraryDirections.web.rest")
                .pathsToMatch("/api/**")
                .build();
    }
}
