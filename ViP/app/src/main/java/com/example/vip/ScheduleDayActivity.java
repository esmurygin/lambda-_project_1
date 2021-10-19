package com.example.vip;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;

public class ScheduleDayActivity extends ComponentActivity {
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
        // TODO check value
        String day = getIntent().getExtras().getString("day");
        setContentView(R.layout.schedule_day_layout);
        TextView textView = (TextView)(findViewById(R.id.day_of_week));
        textView.setText(day);
    }
}
