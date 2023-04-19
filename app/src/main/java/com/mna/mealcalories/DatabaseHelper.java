package com.mna.mealcalories;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends Application {

    private static final String DB_NAME = "db_meal_calories";
    private static final int DB_VERSION = 1 ;

    private static SQLiteOpenHelper helper;


    @Override
    public void onCreate() {
        super.onCreate();
    }
}
