package com.mna.mealcalories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FoodSearch extends AppCompatActivity {

    LinearLayout egg_line;
    String today;
    String which_meal;
    TextView txt_foodSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_search);

        egg_line = (LinearLayout)findViewById(R.id.egg_line);
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


}