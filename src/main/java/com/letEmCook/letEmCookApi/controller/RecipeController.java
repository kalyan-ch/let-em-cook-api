package com.letEmCook.letEmCookApi.controller;

import com.letEmCook.letEmCookApi.model.Recipe;
import com.letEmCook.letEmCookApi.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("recipes")
    public List<Recipe> getRecipes(@RequestParam(value = "name", required = false) String name){
        List<Recipe> recipeList = recipeService.getRecipesByName(name);
        log.info("number of recipes found for search term: {} is : {}", name, recipeList.size());
        return recipeList;
    }
}
