package com.luitech.springbootexamples;

import com.luitech.springbootexamples.data.IngredientRepository;
import com.luitech.springbootexamples.data.UserRepository;
import com.luitech.springbootexamples.domain.Ingredient;
import com.luitech.springbootexamples.domain.IngredientType;
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
    public ApplicationRunner dataLoader(IngredientRepository ingredientRepo, UserRepository userRepo, PasswordEncoder passwordEncoder) {
        return args -> {
            // Existing ingredient data loading
            ingredientRepo.save(new Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP));
            ingredientRepo.save(new Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP));
            ingredientRepo.save(new Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN));
            ingredientRepo.save(new Ingredient("CARN", "Carnitas", IngredientType.PROTEIN));
            ingredientRepo.save(new Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES));
            ingredientRepo.save(new Ingredient("LETC", "Lettuce", IngredientType.VEGGIES));
            ingredientRepo.save(new Ingredient("CHED", "Cheddar", IngredientType.CHEESE));
            ingredientRepo.save(new Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE));
            ingredientRepo.save(new Ingredient("SLSA", "Salsa", IngredientType.SAUCE));
            ingredientRepo.save(new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE));

            // Adding a default user
            userRepo.save(new User(
                "admin",
                passwordEncoder.encode("password"),
                "Admin User",
                "123 Admin St",
                "Admin City",
                "AD",
                "12345",
                "123-456-7890"
            ));
        };
    }
}
