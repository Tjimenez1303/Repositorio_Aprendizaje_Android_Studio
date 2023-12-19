package com.example.a16_almacenamiento_datos_shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
    }

    @SuppressLint("ApplySharedPref")
    public void guardar(View view)
    {
        // Creamos un objeto de SharedPreferences,que nos sirve paa indicar que cree un archivo de preferncias y en este caso va a ser de modo privado
        SharedPreferences sp = getSharedPreferences("agenda", Context.MODE_PRIVATE);

        // Para empezar a guardar datos en este archivo se crea este objeto editor
        SharedPreferences.Editor editor = sp.edit();

        // Obtenemos los datos a guardar
        String fecha = et1.getText().toString();
        String actividades = et2.getText().toString();

        // Le mando al editor en formato clave/valor -> Donde la clase es fecha y el valor es actividades
        editor.putString(fecha,actividades);

        // Confirme y modifique el arhivo XML
        editor.commit();

        // Borramos el contenido de los et
        et1.setText("");
        et2.setText("");

        // Mostramos que se
        Toast.makeText(this, "Las actividades fueron registradas", Toast.LENGTH_SHORT).show();


    }

    public void recuperar(View view)
    {
        // Creamos un objeto de SharedPreferences,que nos sirve paa indicar que cree un archivo de preferncias y en este caso va a ser de modo privado
        SharedPreferences sp = getSharedPreferences("agenda", Context.MODE_PRIVATE);

        // Le pasamos el valor que va a buscar en el archivo agenda, en este caso le pasamos una fecha y en caso de no encontrarla nos devuelve un String vacío
        String dato = sp.getString(et1.getText().toString(), "");

        // Si la fecha no la encuentra significa que dato va a ser vacío
        if(dato.equals(""))
        {
            et2.setText("");
            Toast.makeText(this, "No hay actividades para esa fecha", Toast.LENGTH_SHORT).show();
        }
        else
        {
            et2.setText(dato);
        }

    }
}