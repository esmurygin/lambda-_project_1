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
        ImageButton btn = (ImageButton)(findViewById(R.id.monday));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                look_day("monday");
            }
        });
        btn = (ImageButton)(findViewById(R.id.tuesday));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                look_day("tuesday");
            }
        });
        btn = (ImageButton)(findViewById(R.id.wednesday));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                look_day("wednesday");
            }
        });
        btn = (ImageButton)(findViewById(R.id.thursday));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                look_day("thursday");
            }
        });
        btn = (ImageButton)(findViewById(R.id.friday));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                look_day("friday");
            }
        });
        btn = (ImageButton)(findViewById(R.id.saturday));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                look_day("saturday");
            }
        });
    }
    void look_day(String day){
        Intent intent = new Intent(this,ScheduleDayActivity.class);
        intent.putExtra("day",day);
        startActivity(intent);
    }
}
