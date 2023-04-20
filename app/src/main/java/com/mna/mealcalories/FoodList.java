package com.mna.mealcalories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import java.util.List;

public class FoodList extends AppCompatActivity {



    TextView textView;
    ImageButton btn_addFood;
    ImageButton btn_home;
    ImageButton btn_delete;
    String today;
    String which_meal;
    TextView txt_food;
    TextView txt_cal;


//    ArrayList<String> today_food, today_calory;


    private RecyclerView recyclerView;
    private ArrayList<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        recyclerView = findViewById(R.id.recyclerView);
        foodList = new ArrayList<>();



        recyclerAdapter adapter = new recyclerAdapter(foodList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        textView = (TextView)findViewById(R.id.textView);
        txt_food = (TextView)findViewById(R.id.txt_food);
        txt_cal = (TextView)findViewById(R.id.txt_cal);
        btn_home = (ImageButton)findViewById(R.id.btn_home);
        btn_addFood = (ImageButton)findViewById(R.id.btn_addFood);
        btn_delete = (ImageButton)findViewById(R.id.btn_delete);

        Intent intent = getIntent();
        which_meal = intent.getStringExtra("which_meal");
        textView.setText(which_meal);

        today = intent.getStringExtra("today");

//        today_food = new ArrayList<>();
//        today_calory = new ArrayList<>();


        if(which_meal.equals("breakfast")) {
            Cursor cursor = ((DatabaseHelper) getApplication()).getAllData_today_breakfast();
            if (cursor.getCount() == 0) {
                txt_food.setText("No data");
            } else {
                while (cursor.moveToNext()) {
//                    today_food.add(cursor.getString(0));
//                    today_calory.add(Integer.toString(cursor.getInt(1)));
                    foodList.add(new Food(cursor.getString(0), cursor.getInt(1)));
                }
//                txt_food.setText(today_food.get(0));
//                txt_cal.setText(today_calory.get(0)+"cal");
            }
        }
        if(which_meal.equals("lunch")) {
            Cursor cursor = ((DatabaseHelper) getApplication()).getAllData_today_lunch();
            if (cursor.getCount() == 0) {
                txt_food.setText("No data");
            } else {
                while (cursor.moveToNext()) {
//                    today_food.add(cursor.getString(0));
//                    today_calory.add(Integer.toString(cursor.getInt(1)));
                    foodList.add(new Food(cursor.getString(0), cursor.getInt(1)));

                }
//                txt_food.setText(today_food.get(0));
//                txt_cal.setText(today_calory.get(0)+"cal");

            }
        }
        if(which_meal.equals("dinner")) {
            Cursor cursor = ((DatabaseHelper) getApplication()).getAllData_today_dinner();
            if (cursor.getCount() == 0) {
                txt_food.setText("No data");
            } else {
                while (cursor.moveToNext()) {
                    foodList.add(new Food(cursor.getString(0), cursor.getInt(1)));

//                    today_food.add(cursor.getString(0));
//                    today_calory.add(Integer.toString(cursor.getInt(1)));
                }
//                txt_food.setText(today_food.get(0));
//                txt_cal.setText(today_calory.get(0)+"cal");
            }
        }
        if(which_meal.equals("snack")) {
            Cursor cursor = ((DatabaseHelper) getApplication()).getAllData_today_snack();
            if (cursor.getCount() == 0) {
                txt_food.setText("No data");
            } else {
                while (cursor.moveToNext()) {
                    foodList.add(new Food(cursor.getString(0), cursor.getInt(1)));

//                    today_food.add(cursor.getString(0));
//                    today_calory.add(Integer.toString(cursor.getInt(1)));
                }
//                txt_food.setText(today_food.get(0));
//                txt_cal.setText(today_calory.get(0)+"cal");
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
            Intent mainActivityIntend = new Intent(this, MainActivity.class);
            startActivity(mainActivityIntend);
        }
    }

    public void click_deleteBtn(View v){
        if(v == btn_delete){
            if(which_meal.equals("breakfast")){
                ((DatabaseHelper) getApplication()).delete_today_breakfast_data();
                Intent mainActivityIntend = new Intent(this, MainActivity.class);
                startActivity(mainActivityIntend);
            }
            else if(which_meal.equals("lunch")){
                ((DatabaseHelper) getApplication()).delete_today_lunch_data();
                Intent mainActivityIntend = new Intent(this, MainActivity.class);
                startActivity(mainActivityIntend);
            }
            else if(which_meal.equals("dinner")){
                ((DatabaseHelper) getApplication()).delete_today_dinner_data();
                Intent mainActivityIntend = new Intent(this, MainActivity.class);
                startActivity(mainActivityIntend);
            }
            else if(which_meal.equals("snack")){
                ((DatabaseHelper) getApplication()).delete_today_snack_data();
                Intent mainActivityIntend = new Intent(this, MainActivity.class);
                startActivity(mainActivityIntend);
            }
        }
    }
}