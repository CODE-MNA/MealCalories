package com.mna.mealcalories;

import android.app.Application;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends Application {

    private static final String DB_NAME = "db_meal_calories";
    private static final int DB_VERSION = 1 ;

    private static SQLiteOpenHelper helper;


    @Override
    public void onCreate() {
        super.onCreate();

        helper = new SQLiteOpenHelper(this, DB_NAME, null, DB_VERSION) {

            @Override
            public void onCreate(SQLiteDatabase db) {
                db.execSQL("CREATE TABLE IF NOT EXISTS today_breakfast (food TEXT, calory INTEGER)");
                db.execSQL("CREATE TABLE IF NOT EXISTS today_lunch (food TEXT, calory INTEGER)");
                db.execSQL("CREATE TABLE IF NOT EXISTS today_dinner (food TEXT, calory INTEGER)");
                db.execSQL("CREATE TABLE IF NOT EXISTS today_snack (food TEXT, calory INTEGER)");
                db.execSQL("CREATE TABLE IF NOT EXISTS date_calories (Date TEXT, Breakfast_cal INTEGER, Lunch_cal INTEGER, Dinner_cal INTEGER, Snack_cal INTEGER)");
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            }
        };
    }


    public void addData_today_breakfast(String food, int calory){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("INSERT INTO today_breakfast(food, calory) VALUES('" + food + "','" + calory +"')");
    }

    public void addData_today_lunch(String food, int calory){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("INSERT INTO today_lunch(food, calory) VALUES('" + food + "','" + calory +"')");
    }

    public void addData_today_dinner(String food, int calory){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("INSERT INTO today_dinner(food, calory) VALUES('" + food + "','" + calory +"')");
    }

    public void addData_today_snack(String food, int calory){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("INSERT INTO today_snack(food, calory) VALUES('" + food + "','" + calory +"')");
    }

    public Cursor getAllData_today_breakfast(){
        String query = "SELECT * FROM today_breakfast";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = null;
        cursor = db.rawQuery(query, null);
        return cursor;
    }

    public Cursor getAllData_today_lunch(){
        String query = "SELECT * FROM today_lunch";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = null;
        cursor = db.rawQuery(query, null);
        return cursor;
    }

    public Cursor getAllData_today_dinner(){
        String query = "SELECT * FROM today_dinner";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = null;
        cursor = db.rawQuery(query, null);
        return cursor;
    }

    public Cursor getAllData_today_snack(){
        String query = "SELECT * FROM today_snack";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = null;
        cursor = db.rawQuery(query, null);
        return cursor;
    }

    public void deleteTodayData(){
        SQLiteDatabase database = helper.getWritableDatabase();
        database.execSQL("DELETE FROM today_breakfast");
        database.execSQL("DELETE FROM today_lunch");
        database.execSQL("DELETE FROM today_dinner");
        database.execSQL("DELETE FROM today_snack");

    }


    public void addData_calories(String date, int breakfast_cal, int lunch_cal, int dinner_cal, int snack_cal){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("INSERT INTO date_calories(Date, Breakfast_cal, Lunch_cal, Dinner_cal, Snack_cal) " +
                "VALUES(date+ ',' +breakfast_cal+ ',' +lunch_cal+ ',' +dinner_cal+ +snack_cal )");
//                "VALUES('" + date + "','" + breakfast_cal +"' , ' ')" );

    }

    public Cursor getAllData_calories(){
        String query = "SELECT * FROM date_calories";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = null;
        cursor = db.rawQuery(query, null);
        return cursor;
    }
}
