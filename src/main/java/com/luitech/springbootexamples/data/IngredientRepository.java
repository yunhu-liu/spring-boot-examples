package com.luitech.springbootexamples.data;

import com.luitech.springbootexamples.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
