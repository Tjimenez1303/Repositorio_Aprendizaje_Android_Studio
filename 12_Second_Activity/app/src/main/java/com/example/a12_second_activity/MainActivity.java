package com.example.a12_second_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void acercaDe(View view)
    {
        // Se crea el Intent para iniciar el activity2 (p1: contexto, p2: actividad que se quiere iniciar)
        Intent intent = new Intent(this, Activity2.class);

        // Iniciar la actividad
        startActivity(intent);
    }
}