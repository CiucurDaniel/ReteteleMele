package com.ciucurdaniel.romania.retetelemele.model;
/*
Recipe model class

A recipe contains the following information in it:

 */

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "recipe_table")
public class Recipe {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int duration;
    private int servings;
    private String category;
    private String description;

    public Recipe(String name, int duration, int servings, String category, String description) {
        this.name = name;
        this.duration = duration;
        this.servings = servings;
        this.category = category;
        this.description = description;
    }

    //GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
