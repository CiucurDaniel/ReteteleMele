package com.ciucurdaniel.romania.retetelemele.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ciucurdaniel.romania.retetelemele.R;

public class ViewRecipe extends AppCompatActivity {

    public static final int ADD_RECIPE_REQUEST = 1;
    public static final int EDIT_RECIPE_REQUEST = 2;

    //I use this for communications between   RecipeListRecyclerView and ViewRecipe  when i reive the information
    public static final String EXTRA_ID = "com.ciucurdaniel.romania.retetelemele.view.ID";
    public static final String EXTRA_NAME = "com.ciucurdaniel.romania.retetelemele.view.NAME";
    public static final String EXTRA_DURATION = "com.ciucurdaniel.romania.retetelemele.view.DURATION";
    public static final String EXTRA_SERVINGS = "com.ciucurdaniel.romania.retetelemele.view.SERVINGS";
    public static final String EXTRA_CATEGORY = "com.ciucurdaniel.romania.retetelemele.view.CATEGORY";
    public static final String EXTRA_INGREDIENTS = "com.ciucurdaniel.romania.retetelemele.view.INGREDIENTS";
    public static final String EXTRA_DESCRIPTION  = "com.ciucurdaniel.romania.retetelemele.view.DESCRIPTION";

    private TextView textViewName;
    private TextView textViewDuration;
    private TextView textViewServings;
    private TextView textViewIngredients;
    private TextView textViewDescription;

    private int id;
    private String category;

    private Button buttonEditRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);

        textViewName = findViewById(R.id.text_view_name_value);
        textViewDuration = findViewById(R.id.text_view_duration_value);
        textViewServings = findViewById(R.id.text_view_servings_value);
        textViewIngredients = findViewById(R.id.text_view_ingredients_value);
        textViewDescription = findViewById(R.id.text_view_description_value);

        buttonEditRecipe = findViewById(R.id.editRecipe);


        Intent intent = getIntent();
        //We received the recipe details from the Intent, now we need to assign the in their propper text views

        id = intent.getIntExtra(EXTRA_ID, -1); //ALSO GET THE ID FOR EDIT PURPOSE
        //id gave null pointer exception
        textViewName.setText(intent.getStringExtra(EXTRA_NAME));
        textViewDuration.setText(intent.getStringExtra(EXTRA_DURATION));
        textViewServings.setText(intent.getStringExtra(EXTRA_SERVINGS));
        category = intent.getStringExtra(EXTRA_CATEGORY); //GET CATEGORY FOR EDIT PURPOSE
        textViewIngredients.setText(intent.getStringExtra(EXTRA_INGREDIENTS));
        textViewDescription.setText(intent.getStringExtra(EXTRA_DESCRIPTION));



        buttonEditRecipe.setOnClickListener(v -> {
            Intent intent1 = new Intent(ViewRecipe.this, AddNewRecipe.class);
            intent1.putExtra(AddNewRecipe.EXTRA_ID, id);
            intent1.putExtra(AddNewRecipe.EXTRA_DURATION, textViewDuration.getText().toString()); //
            intent1.putExtra(AddNewRecipe.EXTRA_SERVINGS, textViewServings.getText().toString()); //TODO: CONVERT STRING TO INT 4 PORTTI -> 4
            intent1.putExtra(AddNewRecipe.EXTRA_INGREDIENTS, textViewIngredients.getText().toString());
            intent1.putExtra(AddNewRecipe.EXTRA_DESCRIPTION, textViewDescription.getText().toString());
            intent1.putExtra(AddNewRecipe.EXTRA_CATEGORY, category);
            intent1.putExtra(AddNewRecipe.EXTRA_NAME, textViewName.getText().toString());
            startActivity(intent1);
        });



    }//end-of OnCreate

}//end-class


/*
Recipe Entity

private int id;
    private String name;
    private int duration;
    private int servings;
    private String category;
    private String ingredients;
    private String description;
 */