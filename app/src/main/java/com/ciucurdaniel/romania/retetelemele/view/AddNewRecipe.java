package com.ciucurdaniel.romania.retetelemele.view;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ciucurdaniel.romania.retetelemele.R;
import com.ciucurdaniel.romania.retetelemele.model.Recipe;
import com.ciucurdaniel.romania.retetelemele.model.RecipeViewModelFactory;
import com.ciucurdaniel.romania.retetelemele.viewmodel.RecipeViewModel;
import com.google.android.material.textfield.TextInputEditText;


public class AddNewRecipe extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    RecipeViewModel addRecipeViewModel;

    //I use this to communicate between AddNewRecipe and ViewRecipe when I receive information i need to edit
    public static final String EXTRA_ID = "AddNewRecipe.ID";
    public static final String EXTRA_NAME = "AddNewRecipe.NAME";
    public static final String EXTRA_DURATION = "AddNewRecipe.DURATION";
    public static final String EXTRA_SERVINGS = "AddNewRecipe.SERVINGS";
    public static final String EXTRA_CATEGORY = "AddNewRecipe.CATEGORY";
    public static final String EXTRA_INGREDIENTS = "AddNewRecipe.INGREDIENTS";
    public static final String EXTRA_DESCRIPTION  = "AddNewRecipe.DESCRIPTION";


    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextServings;
    private TextInputEditText textInputEditTextDuration;
    private Spinner categorySpinner;
    private EditText editTextIngredients;
    private EditText editTextDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_reteta_noua);
        Button saveNewRecipe = findViewById(R.id.saveNewRecipeButton);


        textInputEditTextName = findViewById(R.id.recipe_name);
        textInputEditTextServings = findViewById(R.id.servings_number);
        textInputEditTextDuration = findViewById(R.id.recipe_duration_time);
        editTextIngredients = findViewById(R.id.input_ingredients);
        editTextDescription = findViewById(R.id.input_description);

        //set-up spinner for Category

        categorySpinner = findViewById(R.id.categorie_spinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.categorie_spinner, R.layout.support_simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        categorySpinner.setAdapter(arrayAdapter);

        //we need the view model here to add a contact
        addRecipeViewModel = new RecipeViewModelFactory((Application) getApplicationContext()).create(RecipeViewModel.class);

        Intent intent = getIntent();

        //Click to save the new recipe or update an existing one
        if(intent.hasExtra(EXTRA_ID) && intent.getIntExtra(EXTRA_ID, -1) != -1) {

            //in the case of Edit recipe, we first set the fields with the information that we got
            //and also set the listener to the method that updates an already existing recipe

            textInputEditTextName.setText(intent.getStringExtra(EXTRA_NAME));
            textInputEditTextServings.setText(intent.getStringExtra(EXTRA_SERVINGS));
            textInputEditTextDuration.setText(intent.getStringExtra(EXTRA_DURATION));
            editTextIngredients.setText(intent.getStringExtra(EXTRA_INGREDIENTS));
            editTextDescription.setText(intent.getStringExtra(EXTRA_DESCRIPTION));

            saveNewRecipe.setText("Salveaza modificarile");
            saveNewRecipe.setOnClickListener(v -> {
                updateRecipeWithId(intent.getIntExtra(EXTRA_ID, -1));
            });
        } else {

            //in the case of new recipe we just set the listener to the method that adds a new recipe
            saveNewRecipe.setText("Adauga reteta noua");
            saveNewRecipe.setOnClickListener(v -> {
                saveRecipe();
            });
        }

    }//end-of-onCreate


    //implements AdapterView.OnItemSelectedListener
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String chosenCategory = parent.getItemAtPosition(position).toString();
        Toast.makeText(getBaseContext(), chosenCategory, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(getBaseContext(), "Alege o categorie!", Toast.LENGTH_SHORT).show();
    }


    //Function to save a recipe A NEW RECIPE
    public  void saveRecipe(){
        String name = textInputEditTextName.getText().toString();
        String servings = textInputEditTextServings.getText().toString();//int?
        String duration = textInputEditTextDuration.getText().toString();//int?
        String ingredients = editTextIngredients.getText().toString();
        String description = editTextDescription.getText().toString();
        String category = categorySpinner.getSelectedItem().toString();

        if( name.trim().isEmpty() || servings.trim().isEmpty() || duration.trim().isEmpty() || ingredients.trim().isEmpty() || description.trim().isEmpty() || category.trim().isEmpty()){
            Toast.makeText(this, "Introdu toate datele in campuri", Toast.LENGTH_SHORT).show();
           // return;
        } else {
            Recipe recipe = new Recipe(name, Integer.parseInt(duration), Integer.parseInt(servings), category, ingredients, description);
            addRecipeViewModel.insert(recipe);
            Intent intent = new Intent(AddNewRecipe.this, MainActivity.class);
            Toast.makeText(this, "Reteta introdusa", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }

        //TODO: Add extra id for EDIT_REQUEST or ADD_REQUEST
    }

    //Function to update a recipe AN ALREADY EXISTING RECIPE
    public  void updateRecipeWithId(int id){
        String name = textInputEditTextName.getText().toString();
        String servings = textInputEditTextServings.getText().toString();//int?
        String duration = textInputEditTextDuration.getText().toString();//int?
        String ingredients = editTextIngredients.getText().toString();
        String description = editTextDescription.getText().toString();
        String category = categorySpinner.getSelectedItem().toString();

        if( name.trim().isEmpty() || servings.trim().isEmpty() || duration.trim().isEmpty() || ingredients.trim().isEmpty() || description.trim().isEmpty() || category.trim().isEmpty()){
            Toast.makeText(this, "Introdu toate datele in campuri", Toast.LENGTH_SHORT).show();
            // return;
        } else if (id == -1) {

            Intent intent = new Intent(AddNewRecipe.this, MainActivity.class);
            Toast.makeText(this, "Reteta nu s-a putut edita", Toast.LENGTH_SHORT).show();
            startActivity(intent);

        } else {

            Recipe recipe = new Recipe(name, Integer.parseInt(duration), Integer.parseInt(servings), category, ingredients, description);
            recipe.setId(id);
            addRecipeViewModel.update(recipe);

            Intent intent = new Intent(AddNewRecipe.this, MainActivity.class);
            Toast.makeText(this, "Reteta editata cu succes", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
    }

}//end-class
