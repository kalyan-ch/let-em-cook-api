package com.letEmCook.letEmCookApi.service;

import com.letEmCook.letEmCookApi.dao.RecipeRepository;
import com.letEmCook.letEmCookApi.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;
    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getRecipesByName(String name){
        if(name == null || name.isEmpty()) {
            return (List<Recipe>) recipeRepository.findAll();
        }
        return recipeRepository.findByName(name);
    }
}
