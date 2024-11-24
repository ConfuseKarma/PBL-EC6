
package br.edu.fesa.TotalMedia.security;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Mapeia a URL /uploads/** para o diretório físico
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:/data/uploads/");
    }
}
