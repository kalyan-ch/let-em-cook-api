package com.letEmCook.letEmCookApi.controller;

import com.letEmCook.letEmCookApi.model.CompleteRecipe;
import com.letEmCook.letEmCookApi.model.Recipe;
import com.letEmCook.letEmCookApi.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("recipes")
    public List<Recipe> getRecipes(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value="ids", required = false) String[] ids) {

        List<Recipe> recipeList = null;
        if(name == null || name.isEmpty()) {
            recipeList = recipeService.getRecipesByIds(ids);
        } else {
            recipeList = recipeService.getRecipesByName(name);
        }

        log.info("number of recipes found : {}", (recipeList == null ? 0 : recipeList.size()));
        return recipeList;
    }

    @GetMapping("recipes/{id}")
    public CompleteRecipe getRecipeById(@PathVariable(value="id") String id) {

        CompleteRecipe recipe = recipeService.getCompleteRecipeById(Integer.parseInt(id));
        if(recipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no recipe with that ID found");
        }
        log.info("recipe with id: {} found", id);
        return recipe;
    }

}
