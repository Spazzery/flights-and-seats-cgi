package com.summer.flightsandseats.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// used to enable requests for the frontend
// AI generated
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS requests from your frontend
        registry.addMapping("/**")  // Apply to all endpoints
                .allowedOrigins("http://localhost:3000")  // Allow the frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Methods you want to allow
                .allowedHeaders("*");  // Allow all headers
    }
}