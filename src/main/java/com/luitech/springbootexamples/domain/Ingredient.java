package com.luitech.springbootexamples.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@AllArgsConstructor
public class Ingredient {

    @Id
    private String id;
    private String name;
    private IngredientType type;
}
