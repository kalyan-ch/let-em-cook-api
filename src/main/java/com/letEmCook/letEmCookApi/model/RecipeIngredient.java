package com.letEmCook.letEmCookApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="recipe_ingredients")
@Data
public class RecipeIngredient {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="recipe_id")
    private int recipeId;

    private String name;
    private Double quantity;
    private String ingredientType;
    private String unit;
}
