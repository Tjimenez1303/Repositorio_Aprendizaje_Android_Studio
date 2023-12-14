package com.example.a9_scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    String pais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);

        // Creamos un número alteatorio entre 1 y 4
        int number = (int)(Math.random()*4);

        switch (number)
        {
            case 0: pais="argentina";break;
            case 1: pais="colombia";break;
            case 2: pais="espana";break;
            case 3: pais="mexico";break;
        }

        tv1 = findViewById(R.id.tv1);
        tv1 = setT
    }

    public void presion (View v)
    {

    }
}