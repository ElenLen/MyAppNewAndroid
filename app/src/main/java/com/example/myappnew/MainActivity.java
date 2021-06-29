package com.example.myappnew;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myappnew.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Неделя
    public void sendWeek(View view) {
        Intent intent = new Intent(this, Activity_week.class);
        startActivity(intent);
    }

    //Календарь
    public void sendCalendar(View view) {
        Intent intent = new Intent(this, Activity_calendar.class);
        startActivity(intent);
    }

    //Трекер
    public void sendTrek(View view) {
        Intent intent = new Intent(this, Activity_trek.class);
        startActivity(intent);
    }
}