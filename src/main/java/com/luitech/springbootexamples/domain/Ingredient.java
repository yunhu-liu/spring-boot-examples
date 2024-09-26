package com.luitech.springbootexamples.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    private String id;
    private String name;
    private IngredientType type;
}
