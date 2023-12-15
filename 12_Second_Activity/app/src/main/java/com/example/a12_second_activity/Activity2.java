package com.example.a12_second_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    public void retornar(View view)
    {
        // Lo que hago es finalizar la actividad 2 que lancé en la primer activity
        finish();
    }
}