package com.letEmCook.letEmCookApi.service;

import com.letEmCook.letEmCookApi.dao.RecipeIngredientRepository;
import com.letEmCook.letEmCookApi.dao.RecipeRepository;
import com.letEmCook.letEmCookApi.model.CompleteRecipe;
import com.letEmCook.letEmCookApi.model.Recipe;
import com.letEmCook.letEmCookApi.model.RecipeIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeIngredientRepository recipeIngredientRepository;

    @Autowired
    public RecipeService(
            RecipeRepository recipeRepository,
            RecipeIngredientRepository recipeIngredientRepository) {
        this.recipeRepository = recipeRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    public List<Recipe> getRecipesByName(String name){
        return recipeRepository.findByName(name);
    }

    public List<Recipe> getRecipesByIds(String[] ids) {
        List<Integer> intIds = Arrays.stream(ids).map(Integer::parseInt).toList();
        return recipeRepository.findByIds(intIds);
    }

    public CompleteRecipe getCompleteRecipeById(int id) {


        Recipe recipe = recipeRepository.findById(id).orElse(null);
        List<RecipeIngredient> recipeIngredients = recipeIngredientRepository.findByRecipeId(id);

        return CompleteRecipe.builder()
                .ingredients(recipeIngredients)
                .recipe(recipe)
                .build();
    }
}
