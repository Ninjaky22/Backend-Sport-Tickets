package org.example.sport_tickets; // Revisa que este sea tu paquete real

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry; // Ya no saldrá en gris
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SportTicketsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportTicketsApplication.class, args);
    }

    // Este bloque es el que permite que tus archivos HTML se comuniquen con Java
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) { // Aquí es donde se usa el CorsRegistry
                registry.addMapping("/**") // Permite el acceso a todas las rutas
                        .allowedOrigins("*") // Permite peticiones desde cualquier origen (tus archivos HTML)
                        .allowedMethods("GET", "POST", "PUT", "DELETE"); // Define qué acciones están permitidas
            }
        };
    }
}