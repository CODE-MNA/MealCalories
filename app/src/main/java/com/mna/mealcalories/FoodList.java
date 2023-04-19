package com.mna.mealcalories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class FoodList extends AppCompatActivity {


    TextView textView;
    ImageButton btn_addFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        textView = (TextView)findViewById(R.id.textView);
        // 현재 Intent 객체 가져오기
        Intent intent = getIntent();

        // 데이터 추출
        String message = intent.getStringExtra("message_key");
        textView.setText(message);

        btn_addFood = (ImageButton)findViewById(R.id.btn_addFood);

    }


    public void click_addFoodBtn(View v){
        if(v == btn_addFood){
            Intent foodSearchIntent = new Intent(this, FoodSearch.class);
//            foodListIntent.putExtra("message_key", "breakfast");
            startActivity(foodSearchIntent);
        }
    }



}