package com.example.a21_menu_contextual_flotante;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);

        // Paso 1: Le decimos que el EditText va a tener un menú contextual
        registerForContextMenu(et1);
    }

    // Paso 2: Overwrite del método para el menú contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // Paso 3: Inflamos el menú que se creó previamente
        getMenuInflater().inflate(R.menu.menuflotante, menu);
    }

    // Paso 4: Overwrite del método para obtener la opción seleccionada
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        // Paso 5: Obtenemos la opción
        int nro = item.getItemId();

        // Paso 6: Acciones con la opcion seleccionada
        if (nro == R.id.mayusculas){
            et1.setText(et1.getText().toString().toUpperCase());
            return true;
        } else if (nro == R.id.minusculas) {
            et1.setText(et1.getText().toString().toLowerCase());
            return true;
        }

        return super.onContextItemSelected(item);
    }
}