package com.go4me.prototype;

import com.go4me.prototype.model.Localization;
import com.go4me.prototype.model.User;
import com.go4me.prototype.model.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class ApplicationPrototype {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationPrototype.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserService userService){
       return args -> {
           Localization local = new Localization("calle generica", "ciudad genérica", "pais generico", 7);
           User jesuspa98 = new User(0.0,0,"jesuspa98","aa@gmail.com",new ArrayList<>(),
                   0,"@twitter", local, new ArrayList<>(), "aeaeeae");
           userService.add(jesuspa98);
        };
    }
}
