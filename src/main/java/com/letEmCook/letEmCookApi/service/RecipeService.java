package com.letEmCook.letEmCookApi.service;

import com.letEmCook.letEmCookApi.dao.RecipeRepository;
import com.letEmCook.letEmCookApi.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getRecipesByName(String name){
        return recipeRepository.findByName(name);
    }

    public List<Recipe> getRecipesByIds(String[] ids) {
        List<Integer> intIds = Arrays.stream(ids).map(Integer::parseInt).toList();
        return recipeRepository.findByIds(intIds);
    }

    public Recipe getRecipeById(int id) {
        return recipeRepository.findById(id).orElse(null);
    }
}
