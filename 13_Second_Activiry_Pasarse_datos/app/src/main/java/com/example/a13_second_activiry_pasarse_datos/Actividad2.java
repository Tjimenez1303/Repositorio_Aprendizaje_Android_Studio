package com.example.a13_second_activiry_pasarse_datos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class Actividad2 extends AppCompatActivity {

    TextView tv1;
    String op;
    int valor1;
    int valor2;
    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        tv1 = findViewById(R.id.tv1);

        // Obtenemos los datos que nos enviaron desde el activity_main
        Bundle datos = getIntent().getExtras();
        if (datos != null) {
            valor1 = datos.getInt("valor1");
            valor2 = datos.getInt("valor2");
           op = datos.getString("operacion");
        }

        switch (Objects.requireNonNull(op))
        {
            case "sumar":
                int sumar = valor1+valor2;
                tv1.setText(String.format("%d+%d=%d", valor1, valor2, sumar));
                break;

            case "restar":
                int restar = valor1-valor2;
                tv1.setText(String.format("%d-%d=%d", valor1, valor2, restar));
                break;

            case "multiplicar":
                int multiplicar = valor1*valor2;
                tv1.setText(String.format("%d*%d=%d", valor1, valor2, multiplicar));
                break;


            case "dividir":
                int dividir = valor1/valor2;
                tv1.setText(String.format("%d/%d=%d", valor1, valor2, dividir));
                break;
        }
    }

    public void retornar (View view)
    {
        finish();
    }
}