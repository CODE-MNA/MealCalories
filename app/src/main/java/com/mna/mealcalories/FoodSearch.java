package com.mna.mealcalories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FoodSearch extends AppCompatActivity {

    LinearLayout egg_line;
    LinearLayout milk_line;
    LinearLayout whiteBread_line;
    String today;
    String which_meal;
    TextView txt_foodSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_search);

        egg_line = (LinearLayout)findViewById(R.id.egg_line);
        milk_line = (LinearLayout)findViewById(R.id.milk_line);
        whiteBread_line = (LinearLayout)findViewById(R.id.whiteBread_line);
        txt_foodSearch = (TextView)findViewById(R.id.txt_foodSearch);
        Intent intent = getIntent();
        today = intent.getStringExtra("today");
        which_meal = intent.getStringExtra("which_meal");
    }

    public void click_egg_line(View v){
        if(v == egg_line){

            if(which_meal.equals("breakfast")){
                ((DatabaseHelper)getApplication()).addData_today_breakfast("egg", 70);
            }
            if(which_meal.equals("lunch")){
                ((DatabaseHelper)getApplication()).addData_today_lunch("egg", 70);
            }
            if(which_meal.equals("dinner")){
                ((DatabaseHelper)getApplication()).addData_today_dinner("egg", 70);
            }
            if(which_meal.equals("snack")){
                ((DatabaseHelper)getApplication()).addData_today_snack("egg", 70);
            }

            Intent foodListIntent = new Intent(this, FoodList.class);
            foodListIntent.putExtra("which_meal", which_meal);
            startActivity(foodListIntent);
        }
    }

    public void click_milk_line(View v){
        if(v == milk_line){

            if(which_meal.equals("breakfast")){
                ((DatabaseHelper)getApplication()).addData_today_breakfast("milk", 149);
            }
            if(which_meal.equals("lunch")){
                ((DatabaseHelper)getApplication()).addData_today_lunch("milk", 149);
            }
            if(which_meal.equals("dinner")){
                ((DatabaseHelper)getApplication()).addData_today_dinner("milk", 149);
            }
            if(which_meal.equals("snack")){
                ((DatabaseHelper)getApplication()).addData_today_snack("milk", 149);
            }

            Intent foodListIntent = new Intent(this, FoodList.class);
            foodListIntent.putExtra("which_meal", which_meal);
            startActivity(foodListIntent);
        }
    }

    public void click_whiteBread_line(View v){
        if(v == whiteBread_line){

            if(which_meal.equals("breakfast")){
                ((DatabaseHelper)getApplication()).addData_today_breakfast("whiteBread", 75);
            }
            if(which_meal.equals("lunch")){
                ((DatabaseHelper)getApplication()).addData_today_lunch("whiteBread", 75);
            }
            if(which_meal.equals("dinner")){
                ((DatabaseHelper)getApplication()).addData_today_dinner("whiteBread", 75);
            }
            if(which_meal.equals("snack")){
                ((DatabaseHelper)getApplication()).addData_today_snack("whiteBread", 75);
            }

            Intent foodListIntent = new Intent(this, FoodList.class);
            foodListIntent.putExtra("which_meal", which_meal);
            startActivity(foodListIntent);
        }
    }

}