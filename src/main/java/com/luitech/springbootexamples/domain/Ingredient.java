package com.luitech.springbootexamples.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class Ingredient {
    @Id
    private final String id;
    private final String name;
    private final IngredientType type;
}
