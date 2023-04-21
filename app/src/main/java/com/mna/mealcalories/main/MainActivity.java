package com.mna.mealcalories.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.mna.mealcalories.CameraActivity;
import com.mna.mealcalories.DatabaseHelper;
import com.mna.mealcalories.FoodList;
import com.mna.mealcalories.R;
import com.mna.mealcalories.SettingsActivity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    TextView calculated_cal_;
    Button calculated_cal;
    String today;
    int breakfast_cal_sum = 0;
    int lunch_cal_sum = 0;
    int dinner_cal_sum = 0;
    int snack_cal_sum = 0;


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
        calculated_cal = (Button) findViewById(R.id.calculated_cal);

        calculated_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(findViewById(R.id.main_act),"These are your total calories",Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });


        today = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        Cursor cursor_b = ((DatabaseHelper) getApplication()).getAllData_today_breakfast();
        if (cursor_b.getCount() == 0) {
            txt_cal_breakfast.setText("0");
        } else {
            while (cursor_b.moveToNext()) {
                breakfast_cal_sum += cursor_b.getInt(1);
            }
            txt_cal_breakfast.setText(String.valueOf(breakfast_cal_sum));
        }

        Cursor cursor_l = ((DatabaseHelper) getApplication()).getAllData_today_lunch();
        if (cursor_l.getCount() == 0) {
            txt_cal_lunch.setText("0");
        } else {
            while (cursor_l.moveToNext()) {
                lunch_cal_sum += cursor_l.getInt(1);
            }
            txt_cal_lunch.setText(String.valueOf(lunch_cal_sum));
        }

        Cursor cursor_d = ((DatabaseHelper) getApplication()).getAllData_today_dinner();
        if (cursor_d.getCount() == 0) {
            txt_cal_dinner.setText("0");
        } else {
            while (cursor_d.moveToNext()) {
                dinner_cal_sum += cursor_d.getInt(1);
            }
            txt_cal_dinner.setText(String.valueOf(dinner_cal_sum));
        }

        Cursor cursor_s = ((DatabaseHelper) getApplication()).getAllData_today_snack();
        if (cursor_s.getCount() == 0) {
            txt_cal_snack.setText("0");
        } else {
            while (cursor_s.moveToNext()) {
                snack_cal_sum += cursor_s.getInt(1);
            }
            txt_cal_snack.setText(String.valueOf(snack_cal_sum));
        }

        calculated_cal.setText(String.valueOf(breakfast_cal_sum + lunch_cal_sum + dinner_cal_sum +snack_cal_sum));

        // every 12am delete the today's database
        Intent intent2 = new Intent(this, MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent2, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Calendar every12am = Calendar.getInstance();
        every12am.setTimeInMillis(System.currentTimeMillis());
        every12am.set(Calendar.HOUR_OF_DAY, 0);
        every12am.set(Calendar.MINUTE, 0);
        every12am.set(Calendar.SECOND, 0);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, every12am.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String currentTime = dateFormat.format(calendar.getTime());
        Log.d("Current Time", currentTime);
        //calculated_cal.setText(currentTime);
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

    // menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.calrory_menu, menu);
        return true;
    }

    // menu _ item selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_camera:
                Toast.makeText(this, "Check your body by camera", Toast.LENGTH_SHORT).show();
//                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                Intent cameraIntend = new Intent(this, CameraActivity.class);
                startActivity(cameraIntend);
                return true;
            case R.id.item_setting:
                Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
                Intent settingIntent = new Intent(this, SettingsActivity.class);
                startActivity(settingIntent);
                return true;
            case R.id.item3:
                Toast.makeText(this, "Item3 is selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    static class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Delete today's code
//            ((DatabaseHelper) getApplication()).deleteTodayData();

        }
    }

}