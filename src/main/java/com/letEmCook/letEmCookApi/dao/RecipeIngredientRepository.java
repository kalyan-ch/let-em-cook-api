package com.letEmCook.letEmCookApi.dao;

import com.letEmCook.letEmCookApi.model.RecipeIngredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, Integer> {

    @Query(value = "select ri.id, ri.recipe_id, i.name, ri.quantity, ri.ingredient_type, ri.unit " +
            "from recipe_ingredients ri, ingredients i " +
            "where ri.ingredient_id  = i.id and ri.recipe_id = ?1", nativeQuery = true)
    List<RecipeIngredient> findByRecipeId(int recipeId);
}
