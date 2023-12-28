package com.example.a20_menu_opciones_barra_titulo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Paso 1: Borramos esta línea
        //return super.onCreateOptionsMenu(menu);

        // Paso 2: Leemos o inflamos el Menú
        getMenuInflater().inflate(R.menu.menudeopciones, menu);

        // Paso 3: Returnamos un True porque inflamos el menú
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Paso 4: Borramos esta línea
        //return super.onOptionsItemSelected(item);

        // Paso 5: Obtenemos el número de opción seleccionada
        int nro = item.getItemId();

        // Paso 6: Hacemos las acciones según la opción seleccionada
        float valor;

        // Toca hacerlo con ELSE-IF debido a que superior a Android Studio 4.2 utiliza el nuevo sistema de compilación 
        // llamado Android Gradle Plugin (AGP) 7.0.0. Este nuevo sistema de compilación utiliza una nueva forma de generar
        // los IDs de los recursos, que ya no son constantes estáticas finales.
        if (nro == R.id.agrandarfuente) {
            valor = tv1.getTextSize();
            valor += 20;
            tv1.setTextSize(TypedValue.COMPLEX_UNIT_PX, valor);
            return true;
        } else if (nro == R.id.reducirfuente) {
            valor = tv1.getTextSize();
            valor -= 20;
            tv1.setTextSize(TypedValue.COMPLEX_UNIT_PX, valor);
            return true;
        } else if (nro == R.id.salir) {
            finish();
            return true;
        } else if (nro == R.id.rojo) {
            tv1.setTextColor(Color.RED);
            return true;

        } else if (nro == R.id.verde) {
            tv1.setTextColor(Color.GREEN);
            return true;

        } else if (nro == R.id.azul) {
            tv1.setTextColor(Color.BLUE);
            return true;

        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}