package com.example.a33_guardar_recuperar_datos_activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    EditText et1,et2;
    TextView tv1;
    int suma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv1 = findViewById(R.id.tv1);

    }


    public void sumar(View view)
    {
        suma = Integer.parseInt(et1.getText().toString()) + Integer.parseInt(et2.getText().toString());
        tv1.setText(String.format(Locale.getDefault(),"La suma: %d", suma));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // Paso 1: Guardamos en el outState para que no se pierda
        outState.putInt("valor", suma);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Paso 2: Recuperamos el valor de la suma y lo volvemos a poner en el TextView
        suma = savedInstanceState.getInt("valor");
        tv1.setText(String.format(Locale.getDefault(),"La suma: %d", suma));
    }
}