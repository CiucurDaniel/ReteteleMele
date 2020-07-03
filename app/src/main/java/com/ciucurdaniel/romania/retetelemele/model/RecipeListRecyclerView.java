package com.ciucurdaniel.romania.retetelemele.model;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ciucurdaniel.romania.retetelemele.R;
import com.ciucurdaniel.romania.retetelemele.view.AddNewRecipe;
import com.ciucurdaniel.romania.retetelemele.view.ViewRecipe;
import com.ciucurdaniel.romania.retetelemele.viewmodel.RecipeViewModel;

import java.util.List;
import java.util.concurrent.ExecutionException;


public class RecipeListRecyclerView extends AppCompatActivity {


    private RecipeViewModel recipeViewModel;
    private String receivedCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list_recycler_view);

        //Take the category the user has tapped on from the intent
        //so we know which recipes from which category to display

        receivedCategory = getIntent().getStringExtra("categoryToBeDisplayed");

        //Create the RecyclerView

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        RecipeAdapter adapter = new RecipeAdapter();
        recyclerView.setAdapter(adapter);

        //Works only with factory

        //recipeViewModel = new ViewModelProvider(this).get(RecipeViewModel.class);
        recipeViewModel = new RecipeViewModelFactory((Application) getApplicationContext()).create(RecipeViewModel.class);
        //TODO: Change this method to getAllRecipesWithCategory and add string received from intent which represents the category
        try {
            //recipeViewModel.getAllRecipeWithCategory(receivedCategory);//.observe(this, adapter::setRecipes);
            adapter.setRecipes(    recipeViewModel.getAllRecipeWithCategory(receivedCategory)    );
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }


        //Now we need to set a listener so the user tap on a recipe to view it's full details
        adapter.setOnItemClickListener(new RecipeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Recipe recipe) {
                Intent intent = new Intent(RecipeListRecyclerView.this, ViewRecipe.class);
                intent.putExtra(ViewRecipe.EXTRA_ID, recipe.getId());
                intent.putExtra(ViewRecipe.EXTRA_NAME, recipe.getName());
                intent.putExtra(ViewRecipe.EXTRA_DURATION, String.valueOf(recipe.getDuration()));
                intent.putExtra(ViewRecipe.EXTRA_SERVINGS, String.valueOf(recipe.getServings()));
                /*
                intent.putExtra(ViewRecipe.EXTRA_DURATION, String.valueOf(recipe.getDuration()) + " minute");
                intent.putExtra(ViewRecipe.EXTRA_SERVINGS, String.valueOf(recipe.getServings()) + " portii");
                 */
                intent.putExtra(ViewRecipe.EXTRA_INGREDIENTS, recipe.getIngredients());
                intent.putExtra(ViewRecipe.EXTRA_DESCRIPTION, recipe.getDescription());
                intent.putExtra(ViewRecipe.EXTRA_CATEGORY, recipe.getCategory());

                startActivity(intent);
            }
        });



    }//end-of OnCreate

}//end-class
