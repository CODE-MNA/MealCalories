package com.mna.mealcalories.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mna.mealcalories.DatabaseHelper;
import com.mna.mealcalories.FoodList;
import com.mna.mealcalories.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView txt_breakfast;
    TextView txt_cal_breakfast;
    TextView txt_lunch;
    TextView txt_cal_lunch;
    TextView txt_dinner;
    TextView txt_cal_dinner;
    TextView txt_snack;
    TextView txt_cal_snack;
    String today;

//    public String tempMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_breakfast = (TextView)findViewById(R.id.txt_breakfast);
        txt_cal_breakfast = (TextView)findViewById(R.id.txt_cal_breakfast);
        txt_lunch = (TextView)findViewById(R.id.txt_lunch);
        txt_cal_lunch = (TextView)findViewById(R.id.txt_cal_lunch);
        txt_dinner = (TextView)findViewById(R.id.txt_dinner);
        txt_cal_dinner = (TextView)findViewById(R.id.txt_cal_dinner);
        txt_snack = (TextView)findViewById(R.id.txt_snack);
        txt_cal_snack = (TextView)findViewById(R.id.txt_cal_snack);

        today = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        //txt_cal_breakfast.setText();
        //getAllData_today_breakfast

    }

    public void ClickBreakfast(View v){

        if(v == txt_breakfast || v == txt_cal_breakfast){
            Intent foodListIntent = new Intent(this, FoodList.class);
            foodListIntent.putExtra("which_meal", "breakfast");
            foodListIntent.putExtra("today", today);
            startActivity(foodListIntent);
        }

        if(v == txt_lunch || v == txt_cal_lunch){
            Intent foodListIntent = new Intent(this, FoodList.class);
            foodListIntent.putExtra("which_meal", "lunch");
            startActivity(foodListIntent);
        }

        if(v == txt_dinner || v == txt_cal_dinner){
            Intent foodListIntent = new Intent(this, FoodList.class);
            foodListIntent.putExtra("which_meal", "dinner");
            startActivity(foodListIntent);
        }

        if(v == txt_snack || v == txt_cal_snack){
            Intent foodListIntent = new Intent(this, FoodList.class);
            foodListIntent.putExtra("which_meal", "snack");
            startActivity(foodListIntent);
        }


    }

    public String ClickLunch(View v){

        return "Lunch";
    }



}