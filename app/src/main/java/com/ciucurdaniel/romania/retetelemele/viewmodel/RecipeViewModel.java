package com.ciucurdaniel.romania.retetelemele.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ciucurdaniel.romania.retetelemele.model.Recipe;
import com.ciucurdaniel.romania.retetelemele.model.RecipeRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

/*
This is the ViewModel
the intermediary between UI and DATABASE
 */

public class RecipeViewModel extends AndroidViewModel {

    private RecipeRepository repository;
    private LiveData<List<Recipe>> allRecipes;


    public RecipeViewModel(@NonNull Application application) {
        super(application);
        repository = new RecipeRepository(application);
        allRecipes = repository.getAllRecipes();
    }

    public void insert(Recipe recipe){
        repository.insert(recipe);
    }

    public void delete(Recipe recipe){
        repository.delete(recipe);
    }

    public void update(Recipe recipe){
        repository.update(recipe);
    }

    public List<Recipe> getAllRecipeWithCategory(String string) throws ExecutionException, InterruptedException {
        return repository.getAllRecipesWithCategoryEqual(string);
    }

    public void deleteById(int id) { repository.deleteWithId(id);  }

    public LiveData<List<Recipe>> getAllRecipes(){
        return allRecipes;
    }

}
