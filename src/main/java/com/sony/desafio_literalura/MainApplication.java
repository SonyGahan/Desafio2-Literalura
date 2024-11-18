package com.sony.desafio_literalura;

import com.sony.desafio_literalura.principal.Principal;
import com.sony.desafio_literalura.service.ApiService;
import com.sony.desafio_literalura.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    private final Principal principal;

    // Constructor que inyecta la clase Principal
    public MainApplication(@Lazy Principal principal) {
        this.principal = principal;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        principal.muestraElMenu();
    }

    @Bean
    public ApiService apiService() {
        return new ApiService();
    }

    @Bean
    public ConvierteDatos conversor() {
        return new ConvierteDatos();
    }

    public Principal getPrincipal() {
        return principal;
    }
}
