package com.ciucurdaniel.romania.retetelemele.model;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Recipe.class}, version = 1)
public abstract class RecipeDatabase extends RoomDatabase {

    private static RecipeDatabase INSTANCE;

    public abstract RecipeDAO recipeDAO(); //ROOM takes care of things here

    public static synchronized RecipeDatabase getInstance(Context context) {
        if( INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), RecipeDatabase.class, "recipes")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }

        return INSTANCE;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
            new PopulateDbAsynch(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsynch extends AsyncTask<Void, Void, Void>{

        private RecipeDAO recipeDAO;

        public PopulateDbAsynch(RecipeDatabase recipeDatabase){
            this.recipeDAO = recipeDatabase.recipeDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            //TODO: Create some sample recipes
            return null;
        }
    }
} //-end Singleton
