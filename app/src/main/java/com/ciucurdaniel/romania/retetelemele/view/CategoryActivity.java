package com.ciucurdaniel.romania.retetelemele.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ciucurdaniel.romania.retetelemele.R;
/*
Intermediary Activity between MainActivity (User tapped on "Vezi retetele mele")
and the Recipe list. With this screen we will do a filter so that the user will find his/hers recipe faster

Here will be 8 buttons each representing a category of recipes the user can have
clicking on a category will display all the recipes the user has on that category until now
 */
public class CategoryActivity extends AppCompatActivity {

    Button desertButton;
    Button pizzaButton;
    Button startersButton;
    Button soupButton;
    Button postButton;
    Button saladButton;
    Button fishButton;
    Button othersButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        //assign button to their view;
        desertButton = findViewById(R.id.desertButton);
        pizzaButton = findViewById(R.id.pizzaButton);
        startersButton = findViewById(R.id.startersButton);
        soupButton = findViewById(R.id.soupButton);
        postButton = findViewById(R.id.postButton);
        saladButton = findViewById(R.id.saladButton);
        fishButton = findViewById(R.id.fishButton);
        othersButton = findViewById(R.id.othersButton);

        //Categories
        //Hard coded values to match values from the Category Spinner

        String desert = "Prajituri/Desert";
        String pizza = "Pizza/Paste";
        String starters = "Aperitive";
        String soup = "Supe/Ciorbe";
        String salad = "Salate";
        String de_post = "De post";
        String fish = "Peste";
        String others = "Altele";


        //Listeners to redirect to proper recipes list from recycler view
        pizzaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, com.ciucurdaniel.romania.retetelemele.model.RecipeListRecyclerView.class);
                intent.putExtra("categoryToBeDisplayed", pizza);
                startActivity(intent);
            }
        });


        desertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, com.ciucurdaniel.romania.retetelemele.model.RecipeListRecyclerView.class);
                intent.putExtra("categoryToBeDisplayed", desert);
                startActivity(intent);
            }
        });


        startersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, com.ciucurdaniel.romania.retetelemele.model.RecipeListRecyclerView.class);
                intent.putExtra("categoryToBeDisplayed", starters);
                startActivity(intent);
            }
        });


        soupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, com.ciucurdaniel.romania.retetelemele.model.RecipeListRecyclerView.class);
                intent.putExtra("categoryToBeDisplayed", soup);
                startActivity(intent);
            }
        });


        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, com.ciucurdaniel.romania.retetelemele.model.RecipeListRecyclerView.class);
                intent.putExtra("categoryToBeDisplayed", de_post);
                startActivity(intent);
            }
        });


        saladButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, com.ciucurdaniel.romania.retetelemele.model.RecipeListRecyclerView.class);
                intent.putExtra("categoryToBeDisplayed", salad);
                startActivity(intent);
            }
        });


        fishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, com.ciucurdaniel.romania.retetelemele.model.RecipeListRecyclerView.class);
                intent.putExtra("categoryToBeDisplayed", fish);
                startActivity(intent);
            }
        });


        othersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, com.ciucurdaniel.romania.retetelemele.model.RecipeListRecyclerView.class);
                intent.putExtra("categoryToBeDisplayed", others);
                startActivity(intent);
            }
        });

    }
}
