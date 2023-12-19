package com.example.a15_creacion_lectura_archivos_memoria_interna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
    }

    public void grabar(View view)
    {
        // Obtenemos el nombre del archivo y el contennido a grbar
        String nombreArchivo = et1.getText().toString();
        String contenido = et2.getText().toString();

        try {
            // Se crea un objeto para poder escribir en el archivo || openFileOutput es un método que abre un archivo de salida privado asociado con este contexto.
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(nombreArchivo, Context.MODE_PRIVATE));

            // Escribe el contenido en el archivo
            archivo.write(contenido);

            // Limpia el OutputStreamWriter -> Esto significa que cualquier dato que aún no se haya escrito se escribe inmediatamente.
            archivo.flush();

            // Cierra el OutputStreamWriter -> Siempre es importante cerrar los flujos de datos cuando se haya terminado con ellos para evitar fugas de memoria.
            archivo.close();

            // Limpia los campos de entrada
            et1.setText("");
            et2.setText("");

            // Muestra un mensaje
            Toast.makeText(this, "Los datos fueron grabados", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            // Si ocurre un error se muestra que no se pudo guardar
            Toast.makeText(this, "No se pudo crear el archivo", Toast.LENGTH_SHORT).show();
        }
    }

    public void recuperar(View view)
    {
        String nombreArchivo = et1.getText().toString();

        try {
            InputStreamReader archivo = new InputStreamReader(openFileInput(nombreArchivo));

            // Leemos el dato obtenido en el archivo
            BufferedReader br = new BufferedReader(archivo);

            // Se lee toda la primera línea
            String linea = br.readLine();

            // Variable para almacenar all el contenido
            StringBuilder contenido = new StringBuilder();

            // Leemos linea por linea el archivo hasta que ya no haya más
            while (linea != null)
            {
                // Concatenamos cada linea al contenido
                contenido.append(linea).append("\n");

                // Leemos una nueva linea
                linea = br.readLine();
            }

            // Cerramos el Buffer
            br.close();

            // Cerramos el archivo
            archivo.close();

            // Asignamos el contenido al EditText 2
            et2.setText(contenido);

        } catch (IOException e) {
            // Si ocurre un error se muestra que no se pudo guardar
            Toast.makeText(this, "No existe el archivo", Toast.LENGTH_SHORT).show();
        }
    }
}