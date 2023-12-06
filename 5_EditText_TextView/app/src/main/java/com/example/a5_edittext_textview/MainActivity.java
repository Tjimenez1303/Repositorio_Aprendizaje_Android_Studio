package com.example.a5_edittext_textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Buscamos por referencia
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv1 = findViewById(R.id.tv1);


    }

    public void sumar (View v)
    {
        // String s1 para obtener el texto de la suma
        String s1 = et1.getText().toString();
        // String s2 para obtener el texto de la suma
        String s2 = et2.getText().toString();

        // Convertimos los valores a enteros
        int v1 = Integer.parseInt(s1);
        int v2 = Integer.parseInt(s2);

        // Sumamos los números obtenidos
        int suma = v1+v2;

        // Actualizo el estado de tv1 concatenando la var suma
        tv1.setText("La suma es: "+suma);
    }
}