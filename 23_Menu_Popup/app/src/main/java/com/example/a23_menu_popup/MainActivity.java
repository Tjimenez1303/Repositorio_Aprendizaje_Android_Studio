package com.example.a23_menu_popup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Paso 1: Implementamos el método para mostar el menú Popup al presionar la imagen
    public void mostrarPopup (View view)
    {
        ImageView iv1 = findViewById(R.id.iv1);

        // Paso 2: Creamos un objeto de tipo Popup
        PopupMenu pm = new PopupMenu(this, iv1);

        // Paso 3: Inflamos el menú que se creó previamente
        pm.getMenuInflater().inflate(R.menu.menupopup, pm.getMenu());

        // Paso 4: Implementamos el método que se dispara al capturar el click o la opción seleccionada{
        pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Paso 5: Hacemos acciones con la opción seleccionada
                if(item.getItemId() == R.id.ayuda1){
                    Toast.makeText(MainActivity.this, "Ayuda 1", Toast.LENGTH_SHORT).show();
                    // Paso 6: Returnamos true ya que se procesó la opción seleccionada
                    return true;
                } else if (item.getItemId() == R.id.ayuda2) {
                    Toast.makeText(MainActivity.this, "Ayuda 2", Toast.LENGTH_SHORT).show();
                    return true;
                }
                // Paso 7: Returnamos false si no se procesó nada
                return false;
            }
        });

        // Paso 8: Tenemos que decirle que lo muestre
        pm.show();
    }
}