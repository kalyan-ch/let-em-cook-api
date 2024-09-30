package com.letEmCook.letEmCookApi.dao;

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


}
