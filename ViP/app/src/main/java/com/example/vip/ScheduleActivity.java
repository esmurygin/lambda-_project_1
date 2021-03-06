package com.example.vip;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;

public class ScheduleActivity extends ComponentActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        show_activity();
    }

    @Override
    protected void onStart() {
        super.onStart();
        show_activity();
    }

    void show_activity(){
        setContentView(R.layout.schedule_layout);
        ImageButton btn = (ImageButton)(findViewById(R.id.monday_button));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                look_day("понедельник");
            }
        });
        btn = (ImageButton)(findViewById(R.id.tuesday_button));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                look_day("вторник");
            }
        });
        btn = (ImageButton)(findViewById(R.id.wednesday_button));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                look_day("среда");
            }
        });
        btn = (ImageButton)(findViewById(R.id.thursday_button));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                look_day("четверг");
            }
        });
        btn = (ImageButton)(findViewById(R.id.friday_button));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                look_day("пятница");
            }
        });
        btn = (ImageButton)(findViewById(R.id.saturday_button));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                look_day("суббота");
            }
        });
    }
    void look_day(String day){
        Intent intent = new Intent(this,ScheduleDayActivity.class);
        intent.putExtra("day",day);
        startActivity(intent);
    }
}
