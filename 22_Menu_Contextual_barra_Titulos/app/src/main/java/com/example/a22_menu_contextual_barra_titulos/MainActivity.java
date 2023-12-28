package com.example.a22_menu_contextual_barra_titulos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1;

    // Paso 1: Definimos un objeto ActionMode
    ActionMode am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);

        // Paso 2: Implementamos y asignamos el método que se va disparar en el EditText al hacer un click largo
        et1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Paso 3: Preguntamos si ya está creado el ActionMode
                if(am != null){
                    return true;
                }

                // Paso 4: Si no entra al if pues entonces creamos el ActionMode con un Callback amc -> ActionMode Callback
                am = startSupportActionMode(amc);
                return true;
            }
        });
    }

    // Paso 5: Creamos un objeto ActionMode Callback y que al poner esto new ActionMode.Callback() se nos crean todos los métodos necesarios
    ActionMode.Callback amc = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // Paso 6: Inflamos el menú creado
            mode.getMenuInflater().inflate(R.menu.menucontextualbarra, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        // Este método se dispara cuando yo selecciono una opción
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

            // Paso 7: Hacemos las acciones necesarias de cada opción
            if(item.getItemId() == R.id.mayusculas){
                et1.setText(et1.getText().toString().toUpperCase());
                // Paso 8: Cerramos el menú contextual de barra
                mode.finish();
                // Retornamos un true porque se ha procesado correctamente la opción seleccionada
                return true;
            } else if (item.getItemId() == R.id.minusculas) {
                et1.setText(et1.getText().toString().toLowerCase());
                mode.finish();
                // Retornamos un true porque se ha procesado correctamente la opción seleccionada
                return true;
            }
            // Si no procesa nada
            return false;
        }

        // Este método se dispara cuando se cierra el Menú contextual
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            am = null;
        }
    };
}