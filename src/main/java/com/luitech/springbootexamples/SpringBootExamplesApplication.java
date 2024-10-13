package com.luitech.springbootexamples;

import com.luitech.springbootexamples.data.UserRepository;
import com.luitech.springbootexamples.domain.User;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringBootExamplesApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExamplesApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login").setViewName("login");
    }

    @Bean
    ApplicationRunner dataLoader(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        return args -> {
            // Insert a new user into the database
            userRepo.save(new User(
                    null,  // ID is null because it's auto-generated
                    "admin",  // username
                    passwordEncoder.encode("password"),  // hashed password using bcrypt
                    "John Doe",  // fullname
                    "1234 Elm Street",  // street
                    "Springfield",  // city
                    "IL",  // state
                    "62704",  // zip
                    "555-123-4567"  // phone number
            ));
        };
    }
}
