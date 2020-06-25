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
            //Paste/Pizza
            Recipe reteta_1 = new Recipe("Spaghette miliagneze", 60, 2, "Pizza/Paste","1 rosie 1 paste pachet", "Punem la fiert spaghetele conform instructiunilor de pe pachet. Mezelurile le taiem julien si cascavalul il dam prin razatoare. Punem 3-4 picaturi de ulei intr-o tigaie si calim putin ciupercile. Doar pana se inmoaie dupa care adaugam si mezelurile. Lasam pe foc aproximativ 8-10 minute. Cele 6 linguri de bulion (rase) le dizolvam in aproximativ 400 ml de apa, sucul rezultat il turnam peste mezeluri (in loc de bulion + apa puteti folosi suc de rosii daca aveti). Lasam sa fiarba pana sosul scade si se ingroasa un pic (aproximativ 10 min).");
            recipeDAO.insert(reteta_1);

            Recipe reteta_2 = new Recipe("Spaghette bologneze", 40, 2, "Pizza/Paste", "1 rosie 1 paste pachet", "Punem la fiert spaghetele conform instructiunilor de pe pachet. Mezelurile le taiem julien si cascavalul il dam prin razatoare. Punem 3-4 picaturi de ulei intr-o tigaie si calim putin ciupercile. Doar pana se inmoaie dupa care adaugam si mezelurile. Lasam pe foc aproximativ 8-10 minute. Cele 6 linguri de bulion (rase) le dizolvam in aproximativ 400 ml de apa, sucul rezultat il turnam peste mezeluri (in loc de bulion + apa puteti folosi suc de rosii daca aveti). Lasam sa fiarba pana sosul scade si se ingroasa un pic (aproximativ 10 min).");
            recipeDAO.insert(reteta_2);

            //Salate
            Recipe reteta_3 = new Recipe("Salata cripsy", 30, 2, "Salate","1 rosie 1 paste pachet", "Punem la fiert spaghetele conform instructiunilor de pe pachet. Mezelurile le taiem julien si cascavalul il dam prin razatoare. Punem 3-4 picaturi de ulei intr-o tigaie si calim putin ciupercile. Doar pana se inmoaie dupa care adaugam si mezelurile. Lasam pe foc aproximativ 8-10 minute. Cele 6 linguri de bulion (rase) le dizolvam in aproximativ 400 ml de apa, sucul rezultat il turnam peste mezeluri (in loc de bulion + apa puteti folosi suc de rosii daca aveti). Lasam sa fiarba pana sosul scade si se ingroasa un pic (aproximativ 10 min).");
            recipeDAO.insert(reteta_3);

            Recipe reteta_4 = new Recipe("Salata cu rosii si castraveti", 10, 2, "Salate", "1 rosie 1 paste pachet", "Punem la fiert spaghetele conform instructiunilor de pe pachet. Mezelurile le taiem julien si cascavalul il dam prin razatoare. Punem 3-4 picaturi de ulei intr-o tigaie si calim putin ciupercile. Doar pana se inmoaie dupa care adaugam si mezelurile. Lasam pe foc aproximativ 8-10 minute. Cele 6 linguri de bulion (rase) le dizolvam in aproximativ 400 ml de apa, sucul rezultat il turnam peste mezeluri (in loc de bulion + apa puteti folosi suc de rosii daca aveti). Lasam sa fiarba pana sosul scade si se ingroasa un pic (aproximativ 10 min).");
            recipeDAO.insert(reteta_4);

            //Aperitive
            Recipe reteta_5 = new Recipe("Aperitiv tare", 50, 2, "Aperitive","1 rosie 1 paste pachet", "Punem la fiert spaghetele conform instructiunilor de pe pachet. Mezelurile le taiem julien si cascavalul il dam prin razatoare. Punem 3-4 picaturi de ulei intr-o tigaie si calim putin ciupercile. Doar pana se inmoaie dupa care adaugam si mezelurile. Lasam pe foc aproximativ 8-10 minute. Cele 6 linguri de bulion (rase) le dizolvam in aproximativ 400 ml de apa, sucul rezultat il turnam peste mezeluri (in loc de bulion + apa puteti folosi suc de rosii daca aveti). Lasam sa fiarba pana sosul scade si se ingroasa un pic (aproximativ 10 min).");
            recipeDAO.insert(reteta_5);

            Recipe reteta_6 = new Recipe("Aperitiv grecesc", 10, 2, "Aperitive", "1 rosie 1 paste pachet", "Punem la fiert spaghetele conform instructiunilor de pe pachet. Mezelurile le taiem julien si cascavalul il dam prin razatoare. Punem 3-4 picaturi de ulei intr-o tigaie si calim putin ciupercile. Doar pana se inmoaie dupa care adaugam si mezelurile. Lasam pe foc aproximativ 8-10 minute. Cele 6 linguri de bulion (rase) le dizolvam in aproximativ 400 ml de apa, sucul rezultat il turnam peste mezeluri (in loc de bulion + apa puteti folosi suc de rosii daca aveti). Lasam sa fiarba pana sosul scade si se ingroasa un pic (aproximativ 10 min).");
            recipeDAO.insert(reteta_6);

            //Peste
            Recipe reteta_7 = new Recipe("Somon afumat", 30, 2, "Peste","1 rosie 1 paste pachet", "Punem la fiert spaghetele conform instructiunilor de pe pachet. Mezelurile le taiem julien si cascavalul il dam prin razatoare. Punem 3-4 picaturi de ulei intr-o tigaie si calim putin ciupercile. Doar pana se inmoaie dupa care adaugam si mezelurile. Lasam pe foc aproximativ 8-10 minute. Cele 6 linguri de bulion (rase) le dizolvam in aproximativ 400 ml de apa, sucul rezultat il turnam peste mezeluri (in loc de bulion + apa puteti folosi suc de rosii daca aveti). Lasam sa fiarba pana sosul scade si se ingroasa un pic (aproximativ 10 min).");
            recipeDAO.insert(reteta_7);

            Recipe reteta_8 = new Recipe("Pastrav la gratar bun", 10, 2, "Peste", "1 rosie 1 paste pachet", "Punem la fiert spaghetele conform instructiunilor de pe pachet. Mezelurile le taiem julien si cascavalul il dam prin razatoare. Punem 3-4 picaturi de ulei intr-o tigaie si calim putin ciupercile. Doar pana se inmoaie dupa care adaugam si mezelurile. Lasam pe foc aproximativ 8-10 minute. Cele 6 linguri de bulion (rase) le dizolvam in aproximativ 400 ml de apa, sucul rezultat il turnam peste mezeluri (in loc de bulion + apa puteti folosi suc de rosii daca aveti). Lasam sa fiarba pana sosul scade si se ingroasa un pic (aproximativ 10 min).");
            recipeDAO.insert(reteta_8);

            //Prajituri/Desert
            Recipe reteta_9 = new Recipe("Salam de biscuiti", 30, 2, "Prajituri/Desert","1 rosie 1 paste pachet", "Punem la fiert spaghetele conform instructiunilor de pe pachet. Mezelurile le taiem julien si cascavalul il dam prin razatoare. Punem 3-4 picaturi de ulei intr-o tigaie si calim putin ciupercile. Doar pana se inmoaie dupa care adaugam si mezelurile. Lasam pe foc aproximativ 8-10 minute. Cele 6 linguri de bulion (rase) le dizolvam in aproximativ 400 ml de apa, sucul rezultat il turnam peste mezeluri (in loc de bulion + apa puteti folosi suc de rosii daca aveti). Lasam sa fiarba pana sosul scade si se ingroasa un pic (aproximativ 10 min).");
            recipeDAO.insert(reteta_9);

            Recipe reteta_10 = new Recipe("Cioco muffins", 40, 2, "Prajituri/Desert", "1 rosie 1 paste pachet", "Punem la fiert spaghetele conform instructiunilor de pe pachet. Mezelurile le taiem julien si cascavalul il dam prin razatoare. Punem 3-4 picaturi de ulei intr-o tigaie si calim putin ciupercile. Doar pana se inmoaie dupa care adaugam si mezelurile. Lasam pe foc aproximativ 8-10 minute. Cele 6 linguri de bulion (rase) le dizolvam in aproximativ 400 ml de apa, sucul rezultat il turnam peste mezeluri (in loc de bulion + apa puteti folosi suc de rosii daca aveti). Lasam sa fiarba pana sosul scade si se ingroasa un pic (aproximativ 10 min).");
            recipeDAO.insert(reteta_10);

            //De post
            Recipe reteta_11 = new Recipe("Mancare de post", 30, 2, "De post","1 rosie 1 paste pachet", "Punem la fiert spaghetele conform instructiunilor de pe pachet. Mezelurile le taiem julien si cascavalul il dam prin razatoare. Punem 3-4 picaturi de ulei intr-o tigaie si calim putin ciupercile. Doar pana se inmoaie dupa care adaugam si mezelurile. Lasam pe foc aproximativ 8-10 minute. Cele 6 linguri de bulion (rase) le dizolvam in aproximativ 400 ml de apa, sucul rezultat il turnam peste mezeluri (in loc de bulion + apa puteti folosi suc de rosii daca aveti). Lasam sa fiarba pana sosul scade si se ingroasa un pic (aproximativ 10 min).");
            recipeDAO.insert(reteta_11);

            Recipe reteta_12 = new Recipe("Ciorba de post", 30, 2, "De post", "1 rosie 1 paste pachet", "Punem la fiert spaghetele conform instructiunilor de pe pachet. Mezelurile le taiem julien si cascavalul il dam prin razatoare. Punem 3-4 picaturi de ulei intr-o tigaie si calim putin ciupercile. Doar pana se inmoaie dupa care adaugam si mezelurile. Lasam pe foc aproximativ 8-10 minute. Cele 6 linguri de bulion (rase) le dizolvam in aproximativ 400 ml de apa, sucul rezultat il turnam peste mezeluri (in loc de bulion + apa puteti folosi suc de rosii daca aveti). Lasam sa fiarba pana sosul scade si se ingroasa un pic (aproximativ 10 min).");
            recipeDAO.insert(reteta_12);

            //Supe/Ciorbe
            Recipe reteta_13 = new Recipe("Supa de taitei", 30, 2, "Supe/Ciorbe","1 rosie 1 paste pachet", "Punem la fiert spaghetele conform instructiunilor de pe pachet. Mezelurile le taiem julien si cascavalul il dam prin razatoare. Punem 3-4 picaturi de ulei intr-o tigaie si calim putin ciupercile. Doar pana se inmoaie dupa care adaugam si mezelurile. Lasam pe foc aproximativ 8-10 minute. Cele 6 linguri de bulion (rase) le dizolvam in aproximativ 400 ml de apa, sucul rezultat il turnam peste mezeluri (in loc de bulion + apa puteti folosi suc de rosii daca aveti). Lasam sa fiarba pana sosul scade si se ingroasa un pic (aproximativ 10 min).");
            recipeDAO.insert(reteta_13);

            Recipe reteta_14 = new Recipe("Ciorba de legume", 30, 2, "Supe/Ciorbe", "1 rosie 1 paste pachet", "Punem la fiert spaghetele conform instructiunilor de pe pachet. Mezelurile le taiem julien si cascavalul il dam prin razatoare. Punem 3-4 picaturi de ulei intr-o tigaie si calim putin ciupercile. Doar pana se inmoaie dupa care adaugam si mezelurile. Lasam pe foc aproximativ 8-10 minute. Cele 6 linguri de bulion (rase) le dizolvam in aproximativ 400 ml de apa, sucul rezultat il turnam peste mezeluri (in loc de bulion + apa puteti folosi suc de rosii daca aveti). Lasam sa fiarba pana sosul scade si se ingroasa un pic (aproximativ 10 min).");
            recipeDAO.insert(reteta_14);

            //Altele
            Recipe reteta_15 = new Recipe("Reteta secreta", 30, 2, "Altele","1 rosie 1 paste pachet", "Punem la fiert spaghetele conform instructiunilor de pe pachet. Mezelurile le taiem julien si cascavalul il dam prin razatoare. Punem 3-4 picaturi de ulei intr-o tigaie si calim putin ciupercile. Doar pana se inmoaie dupa care adaugam si mezelurile. Lasam pe foc aproximativ 8-10 minute. Cele 6 linguri de bulion (rase) le dizolvam in aproximativ 400 ml de apa, sucul rezultat il turnam peste mezeluri (in loc de bulion + apa puteti folosi suc de rosii daca aveti). Lasam sa fiarba pana sosul scade si se ingroasa un pic (aproximativ 10 min).");
            recipeDAO.insert(reteta_15);

            Recipe reteta_16 = new Recipe("Ciorba de legume", 30, 2, "Altele", "1 rosie 1 paste pachet", "Punem la fiert spaghetele conform instructiunilor de pe pachet. Mezelurile le taiem julien si cascavalul il dam prin razatoare. Punem 3-4 picaturi de ulei intr-o tigaie si calim putin ciupercile. Doar pana se inmoaie dupa care adaugam si mezelurile. Lasam pe foc aproximativ 8-10 minute. Cele 6 linguri de bulion (rase) le dizolvam in aproximativ 400 ml de apa, sucul rezultat il turnam peste mezeluri (in loc de bulion + apa puteti folosi suc de rosii daca aveti). Lasam sa fiarba pana sosul scade si se ingroasa un pic (aproximativ 10 min).");
            recipeDAO.insert(reteta_16);


            return null;
        }
    }
} //-end Singleton
