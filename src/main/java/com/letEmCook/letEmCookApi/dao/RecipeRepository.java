package com.letEmCook.letEmCookApi.dao;

import com.letEmCook.letEmCookApi.model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    List<Recipe> findByName(String name);
    Recipe findById(int id);

}
