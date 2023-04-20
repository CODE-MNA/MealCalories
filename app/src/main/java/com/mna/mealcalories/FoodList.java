package com.mna.mealcalories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.mna.mealcalories.main.MainActivity;

import java.util.ArrayList;

public class FoodList extends AppCompatActivity {


    TextView textView;
    ImageButton btn_addFood;
    ImageButton btn_home;
    String today;
    String which_meal;
    TextView txt_food1;
    TextView txt_cal1;
    DatabaseHelper databaseHelper;

    ArrayList<String> today_food, today_calory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        textView = (TextView)findViewById(R.id.textView);
        txt_food1 = (TextView)findViewById(R.id.txt_food1);
        txt_cal1 = (TextView)findViewById(R.id.txt_cal1);
        btn_home = (ImageButton)findViewById(R.id.btn_home);
        btn_addFood = (ImageButton)findViewById(R.id.btn_addFood);

        // 현재 Intent 객체 가져오기
        Intent intent = getIntent();

        // 데이터 추출
        which_meal = intent.getStringExtra("which_meal");



        textView.setText(which_meal);

        today = intent.getStringExtra("today");



        today_food = new ArrayList<>();
        today_calory = new ArrayList<>();



        if(which_meal.equals("breakfast")) {
            Cursor cursor = ((DatabaseHelper) getApplication()).getAllData_today_breakfast();
            if (cursor.getCount() == 0) {
                txt_food1.setText("No data");
            } else {
                while (cursor.moveToNext()) {
                    today_food.add(cursor.getString(0));
                    today_calory.add(Integer.toString(cursor.getInt(1)));
                }
                txt_food1.setText(today_food.get(0));
                txt_cal1.setText(today_calory.get(0));
            }
        }
        if(which_meal.equals("lunch")) {
            Cursor cursor = ((DatabaseHelper) getApplication()).getAllData_today_lunch();
            if (cursor.getCount() == 0) {
                txt_food1.setText("No data");
            } else {
                while (cursor.moveToNext()) {
                    today_food.add(cursor.getString(0));
                    today_calory.add(Integer.toString(cursor.getInt(1)));
                }
                txt_food1.setText(today_food.get(0));
                txt_cal1.setText(today_calory.get(0));
            }
        }
        if(which_meal.equals("dinner")) {
            Cursor cursor = ((DatabaseHelper) getApplication()).getAllData_today_dinner();
            if (cursor.getCount() == 0) {
                txt_food1.setText("No data");
            } else {
                while (cursor.moveToNext()) {
                    today_food.add(cursor.getString(0));
                    today_calory.add(Integer.toString(cursor.getInt(1)));
                }
                txt_food1.setText(today_food.get(0));
                txt_cal1.setText(today_calory.get(0));
            }
        }
        if(which_meal.equals("snack")) {
            Cursor cursor = ((DatabaseHelper) getApplication()).getAllData_today_snack();
            if (cursor.getCount() == 0) {
                txt_food1.setText("No data");
            } else {
                while (cursor.moveToNext()) {
                    today_food.add(cursor.getString(0));
                    today_calory.add(Integer.toString(cursor.getInt(1)));
                }
                txt_food1.setText(today_food.get(0));
                txt_cal1.setText(today_calory.get(0));
            }
        }
    }


   public void click_addFoodBtn(View v){
        if(v == btn_addFood){
            Intent foodSearchIntent = new Intent(this, FoodSearch.class);
            foodSearchIntent.putExtra("today", today);
            foodSearchIntent.putExtra("which_meal", which_meal);

            startActivity(foodSearchIntent);
        }
    }

    public void click_homeBtn(View v){
        if(v == btn_home){
            Intent foodSearchIntent = new Intent(this, MainActivity.class);

            startActivity(foodSearchIntent);
        }
    }

// 추출한 데이터를 사용하여 작업 수행

}