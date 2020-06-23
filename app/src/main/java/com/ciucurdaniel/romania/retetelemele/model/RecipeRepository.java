package com.ciucurdaniel.romania.retetelemele.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class RecipeRepository {

    private RecipeDAO recipeDAO;
    private LiveData<List<Recipe>> allRecipes;

    public RecipeRepository(Application application){
        RecipeDatabase database = RecipeDatabase.getInstance(application); //get Singleton instance, the database
        recipeDAO = database.recipeDAO();
        allRecipes = recipeDAO.getAllRecipes();
    }

    //We need to handle launching queries on other threads, because ROOM doesn't allow database operations on the main thread
    //so it's on us to take care of it

    //Basically this is the API for outside
    //and abstraction layer
    //So the ViewModel only needs to call insert, update, delete, select all, and select by category.

    public void insert(Recipe recipe){
        new InsertRecipesAsync(recipeDAO).execute(recipe);
    }

    public void update(Recipe recipe){
        new UpdateRecipesAsync(recipeDAO).execute(recipe);
    }

    public void delete(Recipe recipe){
        new DeleteRecipesAsync(recipeDAO).execute(recipe);
    }

    public LiveData<List<Recipe>> getAllRecipes(){
        return allRecipes;
    }

    //TODO: Does this really work?
    public List<Recipe> getAllRecipesWithCategoryEqual(String category) throws ExecutionException, InterruptedException {
        return new GetAllRecipesByCategoryAsync(recipeDAO).execute(category).get();
    }

    //Parameters for Asynch task are: Params, Progress, Result

    //Params, the type of the parameters sent to the task upon execution.
    //Progress, the type of the progress units published during the background computation.
    //Result, the type of the result of the background computation.



    private static class GetAllRecipesByCategoryAsync extends AsyncTask<String, Void, List<Recipe> > {
        //static class cannot access no-static members directly so we will use a constructor
        private RecipeDAO recipeDAO = null;

        private GetAllRecipesByCategoryAsync(RecipeDAO recipeDAO){
            this.recipeDAO = recipeDAO;
        }
        @Override
        protected List<Recipe> doInBackground(String... category) {
            return recipeDAO.getAllRecipesWithCategory(category[0]);
        }
    }

    //Insert asynch
    private static class InsertRecipesAsync extends AsyncTask<Recipe, Void, Void> {
        //static class cannot access no-static members directly so we will use a constructor
        private RecipeDAO recipeDAO = null;

        private InsertRecipesAsync(RecipeDAO recipeDAO){
            this.recipeDAO = recipeDAO;
        }
        @Override
        protected Void doInBackground(Recipe... recipes) {
            recipeDAO.insert(recipes[0]);
            return null;
        }
    }

    //UPDATE async
    private static class UpdateRecipesAsync extends AsyncTask<Recipe, Void, Void>{
        //static class cannot access no-static members directly so we will use a constructor
        private RecipeDAO recipeDAO = null;

        private UpdateRecipesAsync(RecipeDAO recipeDAO){
            this.recipeDAO = recipeDAO;
        }
        @Override
        protected Void doInBackground(Recipe... recipes) {
            recipeDAO.update(recipes[0]);
            return null;
        }
    }

    //DELETE asynch
    private static class DeleteRecipesAsync extends AsyncTask<Recipe, Void, Void>{
        //static class cannot access no-static members directly so we will use a constructor
        private RecipeDAO recipeDAO = null;

        private DeleteRecipesAsync(RecipeDAO recipeDAO){
            this.recipeDAO = recipeDAO;
        }
        @Override
        protected Void doInBackground(Recipe... recipes) {
            recipeDAO.delete(recipes[0]);
            return null;
        }
    }

}//end-class


/*

 */