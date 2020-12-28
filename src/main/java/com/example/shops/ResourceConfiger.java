package com.example.shops;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfiger implements WebMvcConfigurer {
    @Value("${config.upload_folder}")
    public String UPLOAD_FOLDER;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("uploads/**")
                .addResourceLocations("file:"+UPLOAD_FOLDER);
    }
}
