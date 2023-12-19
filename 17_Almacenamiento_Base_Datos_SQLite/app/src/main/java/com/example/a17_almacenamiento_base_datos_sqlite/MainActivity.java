package com.example.a17_almacenamiento_base_datos_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etPatente, etMarca, etModelo, etPrecio;

    // Previamente creada la clase AdminSQLite se sigue:
    // Paso 1: Inicializamos un objeto AdminSQLiteOpenHelper
    AdminSQLiteOpenHelper admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPatente = findViewById(R.id.etpatente);
        etMarca = findViewById(R.id.etmarca);
        etModelo = findViewById(R.id.etmodelo);
        etPrecio= findViewById(R.id.etprecio);

        // Paso 2: Creamos el objeto admin
        admin = new AdminSQLiteOpenHelper(this, "bd1", null, 1);
    }

    public void agregar(View view)
    {
        // Paso 3: Creamos un objeto de tipo SQLiteDatabase, en este punto tenemos abierta la base de datos
        SQLiteDatabase bd = admin.getWritableDatabase();

        // Paso 4: Ahora debemos insertar los datos a la BD pero se debe crear un objeto ContentValues que va a contener los campos de la tabla
        ContentValues registro = new ContentValues();

        // Paso 5: Le empezamos a insertar los datos al ContentValues con el formato clave/valor
        registro.put("patente", etPatente.getText().toString());
        registro.put("marca", etMarca.getText().toString());
        registro.put("modelo", etModelo.getText().toString());
        registro.put("precio", etPrecio.getText().toString());

        // Paso 6: Insertamos los datos en la base de datos
        bd.insert("vehiculos", null, registro);

        // Borramos los EditText
        etPatente.setText("");
        etModelo.setText("");
        etMarca.setText("");
        etPrecio.setText("");

        // Paso 7: Cerramos la inserción de datos en la BD
        bd.close();

        Toast.makeText(this, "Se almaceno el vehiculo", Toast.LENGTH_SHORT).show();
    }

    public void consultarPorPatente(View view)
    {
        // Paso 8: Creamos un objeto de tipo SQLiteDatabase, en este punto tenemos abierta la base de datos
        SQLiteDatabase bd = admin.getWritableDatabase();

        // Obtenemos la patente a consultar en la BD
        String patente = etPatente.getText().toString();

        // Paso 9: Creamos un objeto de tipo cursor en donde le vamos a mandar la consulta SQL
        @SuppressLint("Recycle") Cursor fila = bd.rawQuery("select marca,modelo,precio from vehiculos where patente='"+patente+"'", null);

        // Paso 10: Lo ponemos a que se posicione en el primero que encuentre
        if (fila.moveToFirst())
        {
            // Paso 11: Mostramos en los EditText los datos de la consulta que concuerda con lo ingresado por el usuario en la patente
            // Mostramos la marca en el EditText || La columna 0 es porque esa es la columna en donde se encuentra la marca
            etMarca.setText(fila.getString(0));

            // Mostramos el modelo en el EditText || La columna 1 es porque esa es la columna en donde se encuentra el modelo
            etModelo.setText(fila.getString(1));

            // Mostramos el precio en el EditText || La columna 2 es porque esa es la columna en donde se encuentra el precio
            etPrecio.setText(fila.getString(2));
        }
        else {
            Toast.makeText(this, "No existen modelos con estas patentes", Toast.LENGTH_SHORT).show();
            // Borramos los EditText
            etPatente.setText("");
            etModelo.setText("");
            etMarca.setText("");
            etPrecio.setText("");

        }

        // Paso 12: Cerramos la BD
        bd.close();
    }

    public void borrar(View view)
    {
        // Paso 13: Creamos un objeto de tipo SQLiteDatabase, en este punto tenemos abierta la base de datos
        SQLiteDatabase bd = admin.getWritableDatabase();

        // Obtenemos la patente a consultar en la BD
        String patente = etPatente.getText().toString();

        // Paso 14: Vamos a borrar de la tabla vehiculos en donde coincida con la patente ingresada
        // El metodo .delete() devuelve un entero -> Cantidad de filas que se eliminaron de la tabla vehiculos con esa condición
        int cant = bd.delete("vehiculos", "patente= '"+patente+"'",null);

        if (cant == 1){
            Toast.makeText(this, "Se eliminó el vehiculo", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "NO existe un vehiculo con dicha patente", Toast.LENGTH_SHORT).show();
        }

        // Paso 15: Cerramos la BD
        bd.close();
    }

    public void modificar(View view)
    {
        // Paso 16: Creamos un objeto de tipo SQLiteDatabase, en este punto tenemos abierta la base de datos
        SQLiteDatabase bd = admin.getWritableDatabase();

        // Obtenemos la patente a consultar en la BD
        String patente = etPatente.getText().toString();

        // Paso 17: Ahora debemos insertar los datos a la BD pero se debe crear un objeto ContentValues que va a contener los campos de la tabla
        ContentValues registro = new ContentValues();

        // Paso 18: Le empezamos a insertar los datos al ContentValues con el formato clave/valor
        registro.put("marca", etMarca.getText().toString());
        registro.put("modelo", etModelo.getText().toString());
        registro.put("precio", etPrecio.getText().toString());

        // Paso 19: Actualizamos en la BD
        // El metodo .update() devuelve un entero -> Cantidad de filas que se modificaron de la tabla vehiculos con esa condición
        int cant = bd.update("vehiculos", registro, "patente= '"+patente+"'", null);

        if (cant == 1){
            Toast.makeText(this, "Se modificaron los datos del vehiculo", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "NO existe un vehiculo con dicha patente", Toast.LENGTH_SHORT).show();
        }

        // Paso 20: Cerramos la BD
        bd.close();
    }
}