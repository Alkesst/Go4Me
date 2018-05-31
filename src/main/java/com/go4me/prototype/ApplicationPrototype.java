package com.go4me.prototype;

import com.go4me.prototype.model.*;
import org.apache.tomcat.jni.Local;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;
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
    public CommandLineRunner demo(UserService userService, OrderService orderService) {
        return args -> {
            /**
             * Localizaciones
             */
            Localization localizationJesusPa = new Localization("Calle Charles Dickens", "Málaga", "España", 29010);
            Localization localizationMegias = new Localization("La Sierra", "Málaga", "España", 29200);
            Localization localizationAlkesst = new Localization("Magaluf", "Magaluf", "Alemania", 7181);
            Localization localizationRaul = new Localization("Calle la Cola", "Villaviciosa", "Córdoba", 14300);
            Localization localizationPedro = new Localization("Pisos Picados", "Fornite", "EggPanya", 14910);
            Localization localizationManu = new Localization("ToMordorLand", "ToMordorLand", "ToMordorLand", 65535);
            Localization a = new Localization("Boulevar Pasteur 35", "Málaga", "España", 29007);

            /**
             * Usuarios
             */
            User jesuspa98 = new User(12.0, 0, "JesusPa98", "jesuspa98@Go4Me.org", new ArrayList<>(),
                    0, "@JesusPa", localizationJesusPa, new ArrayList<>(), "Go4Me");
            jesuspa98.setNumberOfRatings(3);

            User alkesst = new User(13.0, 0, "Alkesst", "alkesst@Go4Me.org", new ArrayList<>(),
                    0, "@Alkesst", localizationAlkesst, new ArrayList<>(), "Go4Me");
            alkesst.setNumberOfRatings(3);

            User daXneX = new User(14.0, 0, "DaXneX", "daXneX@Go4Me.org", new ArrayList<>(),
                    0, "@DaXneX", localizationRaul, new ArrayList<>(), "Go4Me");
            daXneX.setNumberOfRatings(3);

            User erMegi = new User(12.0, 0, "ErMegi", "erMegi@Go4Me.org", new ArrayList<>(),
                    0, "@ErMegi", localizationMegias, new ArrayList<>(), "Go4Me");
            erMegi.setNumberOfRatings(3);

            User manu = new User(13.0, 0, "Alpargata17", "alpargata17@Go4Me.org", new ArrayList<>(),
                    0, "@Alpargata17", localizationManu, new ArrayList<>(), "Go4Me");
            manu.setNumberOfRatings(3);

            User gallego = new User(14.0, 0, "PulpoGallego", "pulpogallego@Go4Me.org", new ArrayList<>(),
                    0, "@PulpoGallego", localizationPedro, new ArrayList<>(), "Go4Me");
            gallego.setNumberOfRatings(3);

            User pirriPerro = new User(5.0, 0, "PirriElPerroPorro", "pirriElPerroPorro@porros.com", new ArrayList<>(),
                    0, "@roblopvi", a, new ArrayList<>(), "porros");
            pirriPerro.setNumberOfRatings(1);

            /**
             * Orders.
             */
            OrderRequest orderJesusPa = new OrderRequest(jesuspa98, "Alguien que pudiese ir al Ikea a por una estantería",
                    20, 8, "June", "12:30");
            orderJesusPa.setId(1L);

            OrderRequest orderAlkesst = new OrderRequest(jesuspa98, "Alguien que me pudiese traer unas palmeras de a Kiki",
                    15, 7, "June", "15:30");
            orderAlkesst.setId(2L);

            OrderRequest orderDaXneX = new OrderRequest(jesuspa98, "Alguien que fuese a la tienda de informatica y me traiga un disco duro",
                    25, 13, "June", "12:30");
            orderDaXneX.setId(3L);

            OrderRequest orderErMegi = new OrderRequest(jesuspa98, "Alguien que pudiese ir al Coviran a por leche, agua y pan",
                    30, 9, "June", "10:30");
            orderErMegi.setId(4L);

            OrderRequest orderManu = new OrderRequest(jesuspa98, "Alguien que fuese a una tienda de deportes a por unos balones de baloncesto",
                    20, 10, "June", "12:30");
            orderManu.setId(5L);

            OrderRequest orderGallego = new OrderRequest(jesuspa98, "Alguien que me trayese un poco de Monster",
                    15, 15, "June", "20:30");
            orderGallego.setId(6L);

            OrderRequest orderPirri = new OrderRequest(pirriPerro, "Que alguien se traiga yerba de Portada Alta anda",
                    75, 15, "June", "17:50");
            orderPirri.setId(7L);


            /**
             * Added Users
             */
            userService.register(jesuspa98);
            userService.register(alkesst);
            userService.register(daXneX);
            userService.register(erMegi);
            userService.register(manu);
            userService.register(gallego);
            userService.register(pirriPerro);

            /**
             * Added Orders
             */
            orderService.add(orderJesusPa, jesuspa98.getId());
            orderService.add(orderAlkesst, alkesst.getId());
            orderService.add(orderDaXneX, daXneX.getId());
            orderService.add(orderErMegi, erMegi.getId());
            orderService.add(orderGallego, gallego.getId());
            orderService.add(orderManu, manu.getId());
            orderService.add(orderPirri, pirriPerro.getId());

        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
