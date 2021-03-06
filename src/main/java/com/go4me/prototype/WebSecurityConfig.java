package com.go4me.prototype;

import com.go4me.prototype.model.Localization;
import com.go4me.prototype.model.User;
import com.go4me.prototype.model.UserRepository;
import com.go4me.prototype.model.UserRepositoryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // configura las urls que por defecto estan disponibles sin autenticacion
        http.authorizeRequests()
                // permitimos estas urls sin autenticacion
                // console se usa para poder acceder a la pagina de configuracion de la base de
                // datos
                .antMatchers("/", "/console/**", "/register", "/App.css", "/images/**").permitAll().anyRequest().authenticated()

                .and()

                .formLogin().loginPage("/login").permitAll()

                .and()

                .logout().logoutSuccessUrl("/").permitAll();

        // solo usar durante la fase de desarrollo para poder acceder a la pagina de
        // administracion de la base de datos
        // despues comentar estas lineas
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, UserRepositoryDetailsService userDetailsService,
                                UserRepository userRepository) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

        // Crear usuario por defecto
        Localization test = new Localization("Boulevar Pasteur S/N", "Málaga", "Spain", 29010);
        User testUser = new User(0.0, 0, "Ernesto", "director@uma.es", new ArrayList<>(), 0, "@Ernesto", test, new ArrayList<>(),
                "$2a$04$mhVuX7/zGzhPu7xKCrqY8e7M0RkORqZ4QB/4rCEgYQNddyt1mAKZK");
        Localization local = new Localization("calle generica", "ciudad genérica", "pais generico", 7);
        User user = new User(0.0,0,"paco","paco@gmail.com",new ArrayList<>(),
                0,"@paco", local, new ArrayList<>(),
                "$2a$04$mhVuX7/zGzhPu7xKCrqY8e7M0RkORqZ4QB/4rCEgYQNddyt1mAKZK");
        Localization local2 = new Localization("calle", "ciudad", "pais", 7);
        User user2 = new User(5.0, 0, "pepe", "pepe@uma.es", new ArrayList<>(),
                0, "@pepe", local2, new ArrayList<>(),
                "$2a$04$/p9SxKa0PtQjO3Oa649E9uPxLemqprhf05ak9lAX0kvd29znwEhhO");
        user2.setId(2L);
        // la contraseña es test (encriptada usando bcrypt)
        // https://www.dailycred.com/article/bcrypt-calculator
        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(testUser);
    }

    /*
     * @Bean
     *
     * @Override public UserDetailsService userDetailsService() { UserBuilder users
     * = User.withDefaultPasswordEncoder(); UserDetails user =
     * users.username("user").password("user").roles("USER") .build();
     *
     * return new InMemoryUserDetailsManager(user); }
     */

}
