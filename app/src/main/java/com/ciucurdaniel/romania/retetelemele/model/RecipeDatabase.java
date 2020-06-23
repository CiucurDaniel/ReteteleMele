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
            Recipe reteta_1 = new Recipe("Spaghette miliagneze", 60, 2, "Pizza/Paste","1 rosie 1 paste pachet", "Punem la fiert spaghetele conform instructiunilor de pe pachet. Mezelurile le taiem julien si cascavalul il dam prin razatoare. Punem 3-4 picaturi de ulei intr-o tigaie si calim putin ciupercile. Doar pana se inmoaie dupa care adaugam si mezelurile. Lasam pe foc aproximativ 8-10 minute. Cele 6 linguri de bulion (rase) le dizolvam in aproximativ 400 ml de apa, sucul rezultat il turnam peste mezeluri (in loc de bulion + apa puteti folosi suc de rosii daca aveti). Lasam sa fiarba pana sosul scade si se ingroasa un pic (aproximativ 10 min).");
            recipeDAO.insert(reteta_1);

            Recipe reteta_2 = new Recipe("Spaghette bologneze", 40, 2, "Pizza/Paste", "1 rosie 1 paste pachet", "Punem la fiert spaghetele conform instructiunilor de pe pachet. Mezelurile le taiem julien si cascavalul il dam prin razatoare. Punem 3-4 picaturi de ulei intr-o tigaie si calim putin ciupercile. Doar pana se inmoaie dupa care adaugam si mezelurile. Lasam pe foc aproximativ 8-10 minute. Cele 6 linguri de bulion (rase) le dizolvam in aproximativ 400 ml de apa, sucul rezultat il turnam peste mezeluri (in loc de bulion + apa puteti folosi suc de rosii daca aveti). Lasam sa fiarba pana sosul scade si se ingroasa un pic (aproximativ 10 min).");
            recipeDAO.insert(reteta_2);
            return null;
        }
    }
} //-end Singleton
