package com.ciucurdaniel.romania.retetelemele.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.os.Bundle;

import com.ciucurdaniel.romania.retetelemele.R;
import com.ciucurdaniel.romania.retetelemele.viewmodel.RecipeViewModel;

import java.util.List;


public class RecipeListRecyclerView extends AppCompatActivity {

    private RecipeViewModel recipeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list_recycler_view);

        //Create the RecyclerView

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        RecipeAdapter adapter = new RecipeAdapter();
        recyclerView.setAdapter(adapter);



        //recipeViewModel = new ViewModelProvider(this).get(RecipeViewModel.class);
        recipeViewModel = new RecipeViewModelFactory((Application) getApplicationContext()).create(RecipeViewModel.class);
        recipeViewModel.getAllRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                adapter.setRecipes(recipes);
            }
        });

    }//end-of OnCreate
}//end-class
