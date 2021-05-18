package com.example.countapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String COUNT = "COUNT";
    private int count = 0;
    private TextView showCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCount = findViewById(R.id.show_count);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        if(savedInstanceState != null){
            count = savedInstanceState.getInt(COUNT);
            showCount.setText(Integer.toString(count));
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(count != 0){ //se contador diferente de zero
            outState.putInt(COUNT, count); //armazena no state
        }
    }

    public void countUp(View view) {
        count++;
        if (showCount != null) {
            showCount.setText(Integer.toString(count));
        }
    }

    public void countDown(View view) {
        count--;
        if (showCount != null) {
            showCount.setText(Integer.toString(count));
        }
    }
}