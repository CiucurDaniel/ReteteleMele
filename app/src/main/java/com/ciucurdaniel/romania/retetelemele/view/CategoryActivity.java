package com.ciucurdaniel.romania.retetelemele.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ciucurdaniel.romania.retetelemele.R;
/*
Intermediary Activity between MainActivity (User tapped on "Vezi retetele mele")
and the Recipe list. With this screen we will do a filter so that the user will find his/hers recipe faster
 */
public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
    }
}
