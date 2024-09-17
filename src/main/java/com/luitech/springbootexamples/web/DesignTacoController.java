package com.luitech.springbootexamples.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.luitech.springbootexamples.domain.Taco;
import com.luitech.springbootexamples.domain.TacoOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.luitech.springbootexamples.domain.Ingredient;
import com.luitech.springbootexamples.domain.IngredientType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP),
                new Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP),
                new Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN),
                new Ingredient("CARN", "Carnitas", IngredientType.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES),
                new Ingredient("LETC", "Lettuce", IngredientType.VEGGIES),
                new Ingredient("CHED", "Cheddar", IngredientType.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE),
                new Ingredient("SLSA", "Salsa", IngredientType.SAUCE),
                new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE)
        );

        IngredientType[] types = IngredientType.values();
        for (IngredientType type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(Taco taco, @ModelAttribute TacoOrder tacoOrder) {
        tacoOrder.addTaco(taco);
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, IngredientType type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}