package com.example.a14_second_activity_recuperar_datos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
    }

    public void login(View view)
    {
        // Lanzamos el nuevo Activity
        Intent intent1 = new Intent(this, Activity.class);

        // Pso 1: Detetcte cuando se inició un Activity
        startActivityForResult(intent1, 100);
    }
}