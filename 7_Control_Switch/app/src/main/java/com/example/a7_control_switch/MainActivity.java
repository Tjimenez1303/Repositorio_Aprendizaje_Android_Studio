package com.example.a7_control_switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SwitchCompat switch1, switch2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);
    }

    // Función para verificar en que estado se encuentra el Switch
    public void verificar (View v)
    {
        if (switch1.isChecked())
        {
            Toast.makeText(this,"Datos moviles activo",Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this,"Datos moviles inactivo",Toast.LENGTH_SHORT).show();
        }


        if (switch2.isChecked())
        {
            Toast.makeText(this,"WiFi activo",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"WiFi desactivo",Toast.LENGTH_SHORT).show();
        }

    }

    // Función para cuando cambia de estado el Switch
    public void verficarDatos(View v)
    {
        if (switch1.isChecked())
        {
            Toast.makeText(this,"Se activaron datos móviles",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Se desactivaron datos móviles",Toast.LENGTH_SHORT).show();
        }
    }
}