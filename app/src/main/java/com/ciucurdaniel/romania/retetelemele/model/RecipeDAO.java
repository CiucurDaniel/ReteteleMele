package com.ciucurdaniel.romania.retetelemele.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RecipeDAO {
    @Insert
    void insert(Recipe recipe);

    @Update
    void update(Recipe recipe);

    @Delete
    void delete(Recipe recipe);

    @Query("SELECT * FROM recipe_table")
    LiveData<List<Recipe>> getAllRecipes();

    //TODO: See if this really works

    @Query("SELECT * FROM recipe_table WHERE category =:category ")
    List<Recipe> getAllRecipesWithCategory(String category);
}
