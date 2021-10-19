package com.example.vip;

import android.os.Bundle;
import android.os.PersistableBundle;

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
    }
}
