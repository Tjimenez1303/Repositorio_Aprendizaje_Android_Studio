package com.example.a27_alertdialog_clase_reutilizandolo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
    }


    // (Los pasos anteriores están en la clase DialogoMensaje) Paso 11: Implementamos el método para borrar al presionar el botón
    public void borrar (View view)
    {
        // Paso 12: Creamos el objeto con el diálogo que acabamos de crear y le pasamos el mensaje que queremos mostrar
        DialogoMensaje dialogo = new DialogoMensaje("Desea borrar el nombre ingresado?");

        // Paso 13: Mostramos el diálogo
        dialogo.show(getSupportFragmentManager(), "dialogo1");

        // Paso 14: Procesamos la respuesta que ingresó el usuario
        dialogo.procesarRespuesta(new DialogoMensaje.Respuestas() {
            @Override
            public void confirmar(DialogFragment confirmar) {
                et1.setText("");
            }

            @Override
            public void cancelar(DialogFragment dialog) {

            }
        });


    }

    public void salir (View view)
    {
        // Paso 12: Creamos el objeto con el diálogo que acabamos de crear y le pasamos el mensaje que queremos mostrar
        DialogoMensaje dialogo = new DialogoMensaje("Realmente quiere abandonar el programa?");

        // Paso 13: Mostramos el diálogo
        dialogo.show(getSupportFragmentManager(), "dialogo2");

        // Paso 14: Procesamos la respuesta que ingresó el usuario
        dialogo.procesarRespuesta(new DialogoMensaje.Respuestas() {
            @Override
            public void confirmar(DialogFragment confirmar) {
                finish();
            }

            @Override
            public void cancelar(DialogFragment dialog) {
                Toast.makeText(MainActivity.this, "Gracias por seguir utilizando el programa", Toast.LENGTH_SHORT).show();
            }
        });
    }
}