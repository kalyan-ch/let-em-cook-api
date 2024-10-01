package com.letEmCook.letEmCookApi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompleteRecipe {
    private Recipe recipe;
    private List<RecipeIngredient> ingredients;
}
