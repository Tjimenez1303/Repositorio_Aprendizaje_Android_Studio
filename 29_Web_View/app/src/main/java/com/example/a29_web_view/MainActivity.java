package com.example.a29_web_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ingresar (View view)
    {
        // Creamos un objeto de tipo Intent para saltar a otro Activity
        Intent intent = new Intent(this,ActividadWeb_View.class);

        // Le pasamos los parámetros necesarios
        EditText et1 = findViewById(R.id.et1);
        intent.putExtra("direccion",et1.getText().toString());

        // Al presionar el botón va a saltar al otro activity
        startActivity(intent);
    }
}