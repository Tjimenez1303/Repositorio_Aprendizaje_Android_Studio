package com.example.a24_alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switch1 = findViewById(R.id.switch1);
    }

    public void activarDatosMoviles (View view)
    {
        // Miramos si el switch está presionado
        if (switch1.isChecked())
        {
            // Paso 1: Creamos un objeto de tipo AlertDialog Builder en el que le pasamos este contexto
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            // Paso 2: Le ponemos el mensaje que se va mostrar en la alerta
            builder.setMessage("Realmente quiere activar los datos móviles?");

            // Paso 3: Añadimos un botón POSITIVO de "Confirmar" y su listener
            builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Se activaron los datos móviles", Toast.LENGTH_SHORT).show();
                }
            });

            // Paso 4: Añadimos un botón NEGATIVO de "Cancelar" y su listener
            builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Ponemos en desactivado el switch
                    switch1.setChecked(false);
                    Toast.makeText(MainActivity.this, "NO se activaron los datos móviles", Toast.LENGTH_SHORT).show();
                }
            });

            // Paso 5: Creamos el objeto AlertDialog builder y lo mostramos en la pantalla
            builder.create().show();
        }
    }
}