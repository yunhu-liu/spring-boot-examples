package com.luitech.springbootexamples.web

import com.luitech.springbootexamples.domain.Ingredient
import com.luitech.springbootexamples.domain.IngredientType
import com.luitech.springbootexamples.domain.Taco
import com.luitech.springbootexamples.domain.TacoOrder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.SessionAttributes
import java.util.*
import java.util.stream.Collectors

@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
class DesignTacoController {
    @ModelAttribute
    fun addIngredientsToModel(model: Model) {
        val ingredients = Arrays.asList(
            Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP),
            Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP),
            Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN),
            Ingredient("CARN", "Carnitas", IngredientType.PROTEIN),
            Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES),
            Ingredient("LETC", "Lettuce", IngredientType.VEGGIES),
            Ingredient("CHED", "Cheddar", IngredientType.CHEESE),
            Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE),
            Ingredient("SLSA", "Salsa", IngredientType.SAUCE),
            Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE)
        )

        val types = IngredientType.entries.toTypedArray()
        for (type in types) {
            model.addAttribute(
                type.toString().lowercase(Locale.getDefault()),
                filterByType(ingredients, type)
            )
        }
    }

    @ModelAttribute(name = "tacoOrder")
    fun order(): TacoOrder {
        return TacoOrder()
    }

    @ModelAttribute(name = "taco")
    fun taco(): Taco {
        return Taco()
    }

    @GetMapping
    fun showDesignForm(): String {
        return "design"
    }

    private fun filterByType(
        ingredients: List<Ingredient>, type: IngredientType
    ): Iterable<Ingredient> {
        return ingredients
            .stream()
            .filter { x: Ingredient -> x.type == type }
            .collect(Collectors.toList())
    }
}