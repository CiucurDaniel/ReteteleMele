package com.ciucurdaniel.romania.retetelemele.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ciucurdaniel.romania.retetelemele.R;


public class AddNewRecipe extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_reteta_noua);


        //set-up spinner for Category
        //TOD
        Spinner categorySpinner = findViewById(R.id.categorie_spinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.categorie_spinner, R.layout.support_simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        categorySpinner.setAdapter(arrayAdapter);

        //SAVE RECIPE BUTTON
        Button saveNewRecipe = findViewById(R.id.saveNewRecipeButton);
        saveNewRecipe.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Reteta salvata", Toast.LENGTH_SHORT).show();
            //TODO: Add the new recipe to the database
        });
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
}
