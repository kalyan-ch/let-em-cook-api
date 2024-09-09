package com.letEmCook.letEmCookApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "recipes_master")
public class Recipe {

    @Id
    @Column(name = "id")
    private int id;
    private LocalDateTime created_at;
    private String name;
    private String description;
    private int prep_time;
    private int cook_time;
    private int servings;

    @Column(columnDefinition = "TEXT")
    private String method;

    @Column(columnDefinition = "TEXT")
    private String preparation;

}
