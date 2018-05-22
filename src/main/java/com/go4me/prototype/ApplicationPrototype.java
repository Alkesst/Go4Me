package com.go4me.prototype;

import com.go4me.prototype.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class ApplicationPrototype {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationPrototype.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserService userService, OrderService orderService){
       return args -> {
           Localization local = new Localization("calle generica", "ciudad genérica", "pais generico", 7);
           User jesuspa98 = new User(0.0,0,"jesuspa98","aa@gmail.com",new ArrayList<>(),
                   0,"@twitter", local, new ArrayList<>(), "esta no es la contraseña");

           userService.register(jesuspa98);
           OrderRequest order = new OrderRequest(jesuspa98, "Esto es una prueba de puta madre socio",
                   15, 15, "May", "17:40");
           order.setId(1L);
           orderService.add(order);
        };
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }

}
