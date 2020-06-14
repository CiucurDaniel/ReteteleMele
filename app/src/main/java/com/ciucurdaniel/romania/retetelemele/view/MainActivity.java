package com.ciucurdaniel.romania.retetelemele.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ciucurdaniel.romania.retetelemele.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

/*
Main activity has only two buttons and functionality for those
Add new recipe - BUTTON
View my recipes - BUTTON
 */
public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    private static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //start AddNewRecipe Activity
        Button addNewRecipeButton = findViewById(R.id.addNewRecipeButton);
        addNewRecipeButton.setOnClickListener( (v) -> {
            Intent intent = new Intent(MainActivity.this, com.ciucurdaniel.romania.retetelemele.view.AddNewRecipe.class);
            startActivity(intent);
        });

        //Display Interstitial Ad
        MobileAds.initialize(this);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(AD_UNIT_ID);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        Button seeRecipes = findViewById(R.id.seeRecipesButton);
        seeRecipes.setOnClickListener(v -> {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
                Toast.makeText(getApplicationContext(), "Ad not loaded", Toast.LENGTH_SHORT).show();
                //TODO: Even is ad is not showing, move the user to the next screen and maybe retry loading an ad for next time.
            }
        });

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
    } //end-OnCreate

} // end-class
