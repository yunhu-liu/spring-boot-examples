package com.luitech.springbootexamples.domain;

public class TacoUDRUtils {

    public static IngredientUDT toIngredientUDT(Ingredient ingredient) {
        if(ingredient == null) {
            throw new IllegalArgumentException("Ingredient cannot be null");
        }
        return new IngredientUDT(ingredient.getName(), ingredient.getType());
    }

    public static TacoUDT toTacoUDT(Taco taco) {
        if(taco == null) {
            throw new IllegalArgumentException("Taco cannot be null");
        }
        return new TacoUDT(taco.getName(), taco.getIngredients());
    }
}
