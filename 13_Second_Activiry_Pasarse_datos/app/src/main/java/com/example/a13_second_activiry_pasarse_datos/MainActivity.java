package com.example.a13_second_activiry_pasarse_datos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    Spinner sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtenemos los objetos visuales
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        sp1 = findViewById(R.id.spinner1);

        // Organizamos el spinner
        String[] operations = {"sumar", "restar", "multiplicar", "dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,operations);
        sp1.setAdapter(adapter);
    }

    public void showResult(View view)
    {
        // Se crea el Intent para iniciar el activity2 (p1: contexto, p2: actividad que se quiere iniciar)
        Intent intent1 = new Intent(this, Actividad2.class);

        // Obtenemos los valores de los EditText
        int valor1 = Integer.parseInt(et1.getText().toString());
        int valor2 = Integer.parseInt(et2.getText().toString());

        // Obtenemos la operacion seleccionada
        String operacion = sp1.getSelectedItem().toString();

        // Enviamos estos valores a la Activity2
        intent1.putExtra("valor1", valor1);
        intent1.putExtra("valor2", valor2);
        intent1.putExtra("operacion", operacion);

        // Lanzamos el segundo Activity
        startActivity(intent1);

    }
}