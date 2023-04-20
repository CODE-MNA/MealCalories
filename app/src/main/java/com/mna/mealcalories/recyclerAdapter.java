//package com.mna.mealcalories;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.ViewHolder> {
//    private final List<Food> mFoodList;
//    public recyclerAdapter(List<Food> foodList){
//        mFoodList = foodList;
//    }
//
//    @NonNull
//    @Override
//    public recyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_food_list, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        Food food = mFoodList.get(position);
//        holder.txt_food.setText(food.getFoodName());
//        holder.txt_cal.setText(food.getFoodCalories());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return mFoodList.size();
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder{
//        TextView txt_food;
//        TextView txt_cal;
//        public ViewHolder(View itemView) {
//            super(itemView);
//            txt_food = itemView.findViewById(R.id.txt_food_name);
//            txt_cal = itemView.findViewById(R.id.txt_food_cal);
//        }
//    }
//}

package com.mna.mealcalories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<Food> foodList;

    public recyclerAdapter(ArrayList<Food> foodList){
        this.foodList = foodList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView txt_food;
        private TextView txt_cal;

        public MyViewHolder(final View view){
            super(view);
            txt_food = view.findViewById(R.id.txt_food_name);
            txt_cal = view.findViewById(R.id.txt_food_cal);
        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String foodName = foodList.get(position).getFoodName();
        int foodCalories = foodList.get(position).getFoodCalories();

        holder.txt_food.setText(foodName);
        holder.txt_cal.setText(Integer.toString(foodCalories));
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
}
