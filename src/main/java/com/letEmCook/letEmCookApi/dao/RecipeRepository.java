package com.letEmCook.letEmCookApi.dao;

import com.letEmCook.letEmCookApi.model.CompleteRecipe;
import com.letEmCook.letEmCookApi.model.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    List<Recipe> findByName(String name);

    @Query(
        value = "select * from recipes_master r where r.id in :ids",
        nativeQuery = true)
    List<Recipe> findByIds(List<Integer> ids);

    @Query(
            value = "select r.id as recipe_id, r.name as recipe, ing.id as ing_id, ing.name as ingredient, ri.ingredient_type, ri.quantity, ri.unit " +
                    "from recipe_ingredients ri, recipes_master r, ingredients ing " +
                    "where r.id = ri.recipe_id and ing.id = ri.ingredient_id and r.id = ?1",
            nativeQuery = true)
    CompleteRecipe getCompleteRecipeById(int id);


}
