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
    LinearLayout orangeJuice_line;
    LinearLayout pepperoniPizza_line;
    LinearLayout whiteRice_line;
    LinearLayout spaghettiWithMeatballs_line;
    LinearLayout grilledSalmon_line;
    LinearLayout gardenSalad_line;

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
        orangeJuice_line = (LinearLayout)findViewById(R.id.orangeJuice_line);
        pepperoniPizza_line = (LinearLayout)findViewById(R.id.pepperoniPizza_line);
        whiteRice_line = (LinearLayout)findViewById(R.id.whiteRice_line);
        spaghettiWithMeatballs_line = (LinearLayout)findViewById(R.id.spaghettiWithMeatballs_line);
        grilledSalmon_line = (LinearLayout)findViewById(R.id.grilledSalmon_line);
        gardenSalad_line = (LinearLayout)findViewById(R.id.gardenSalad_line);


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
                ((DatabaseHelper)getApplication()).addData_today_breakfast("whiteBread", 73);
            }
            if(which_meal.equals("lunch")){
                ((DatabaseHelper)getApplication()).addData_today_lunch("whiteBread", 73);
            }
            if(which_meal.equals("dinner")){
                ((DatabaseHelper)getApplication()).addData_today_dinner("whiteBread", 73);
            }
            if(which_meal.equals("snack")){
                ((DatabaseHelper)getApplication()).addData_today_snack("whiteBread", 73);
            }

            Intent foodListIntent = new Intent(this, FoodList.class);
            foodListIntent.putExtra("which_meal", which_meal);
            startActivity(foodListIntent);
        }
    }

    public void click_orangeJuice_line(View v){
        if(v == orangeJuice_line){

            if(which_meal.equals("breakfast")){
                ((DatabaseHelper)getApplication()).addData_today_breakfast("orangeJuice", 112);
            }
            if(which_meal.equals("lunch")){
                ((DatabaseHelper)getApplication()).addData_today_lunch("orangeJuice", 112);
            }
            if(which_meal.equals("dinner")){
                ((DatabaseHelper)getApplication()).addData_today_dinner("orangeJuice", 112);
            }
            if(which_meal.equals("snack")){
                ((DatabaseHelper)getApplication()).addData_today_snack("orangeJuice", 112);
            }

            Intent foodListIntent = new Intent(this, FoodList.class);
            foodListIntent.putExtra("which_meal", which_meal);
            startActivity(foodListIntent);
        }
    }

    public void click_pepperoniPizza_line(View v){
        if(v == pepperoniPizza_line){

            if(which_meal.equals("breakfast")){
                ((DatabaseHelper)getApplication()).addData_today_breakfast("pepperoniPizza", 305);
            }
            if(which_meal.equals("lunch")){
                ((DatabaseHelper)getApplication()).addData_today_lunch("pepperoniPizza", 305);
            }
            if(which_meal.equals("dinner")){
                ((DatabaseHelper)getApplication()).addData_today_dinner("pepperoniPizza", 305);
            }
            if(which_meal.equals("snack")){
                ((DatabaseHelper)getApplication()).addData_today_snack("pepperoniPizza", 305);
            }

            Intent foodListIntent = new Intent(this, FoodList.class);
            foodListIntent.putExtra("which_meal", which_meal);
            startActivity(foodListIntent);
        }
    }

    public void click_whiteRice_line(View v){
        if(v == whiteRice_line){

            if(which_meal.equals("breakfast")){
                ((DatabaseHelper)getApplication()).addData_today_breakfast("whiteRice", 242);
            }
            if(which_meal.equals("lunch")){
                ((DatabaseHelper)getApplication()).addData_today_lunch("whiteRice", 242);
            }
            if(which_meal.equals("dinner")){
                ((DatabaseHelper)getApplication()).addData_today_dinner("whiteRice", 242);
            }
            if(which_meal.equals("snack")){
                ((DatabaseHelper)getApplication()).addData_today_snack("whiteRice", 242);
            }

            Intent foodListIntent = new Intent(this, FoodList.class);
            foodListIntent.putExtra("which_meal", which_meal);
            startActivity(foodListIntent);
        }
    }

    public void click_spaghettiWithMeatballs_line(View v){
        if(v == spaghettiWithMeatballs_line){

            if(which_meal.equals("breakfast")){
                ((DatabaseHelper)getApplication()).addData_today_breakfast("spaghettiWithMeatballs", 239);
            }
            if(which_meal.equals("lunch")){
                ((DatabaseHelper)getApplication()).addData_today_lunch("spaghettiWithMeatballs", 239);
            }
            if(which_meal.equals("dinner")){
                ((DatabaseHelper)getApplication()).addData_today_dinner("spaghettiWithMeatballs", 239);
            }
            if(which_meal.equals("snack")){
                ((DatabaseHelper)getApplication()).addData_today_snack("spaghettiWithMeatballs", 239);
            }

            Intent foodListIntent = new Intent(this, FoodList.class);
            foodListIntent.putExtra("which_meal", which_meal);
            startActivity(foodListIntent);
        }
    }

    public void click_grilledSalmon_line(View v){
        if(v == grilledSalmon_line){

            if(which_meal.equals("breakfast")){
                ((DatabaseHelper)getApplication()).addData_today_breakfast("grilledSalmon", 210);
            }
            if(which_meal.equals("lunch")){
                ((DatabaseHelper)getApplication()).addData_today_lunch("grilledSalmon", 210);
            }
            if(which_meal.equals("dinner")){
                ((DatabaseHelper)getApplication()).addData_today_dinner("grilledSalmon", 210);
            }
            if(which_meal.equals("snack")){
                ((DatabaseHelper)getApplication()).addData_today_snack("grilledSalmon", 210);
            }

            Intent foodListIntent = new Intent(this, FoodList.class);
            foodListIntent.putExtra("which_meal", which_meal);
            startActivity(foodListIntent);
        }
    }

    public void click_gardenSalad_line(View v){
        if(v == gardenSalad_line){

            if(which_meal.equals("breakfast")){
                ((DatabaseHelper)getApplication()).addData_today_breakfast("gardenSalad", 160);
            }
            if(which_meal.equals("lunch")){
                ((DatabaseHelper)getApplication()).addData_today_lunch("gardenSalad", 160);
            }
            if(which_meal.equals("dinner")){
                ((DatabaseHelper)getApplication()).addData_today_dinner("gardenSalad", 160);
            }
            if(which_meal.equals("snack")){
                ((DatabaseHelper)getApplication()).addData_today_snack("gardenSalad", 160);
            }

            Intent foodListIntent = new Intent(this, FoodList.class);
            foodListIntent.putExtra("which_meal", which_meal);
            startActivity(foodListIntent);
        }
    }
}