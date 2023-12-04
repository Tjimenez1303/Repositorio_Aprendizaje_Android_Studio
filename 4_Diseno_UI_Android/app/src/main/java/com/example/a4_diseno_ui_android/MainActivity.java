package com.example.a4_diseno_ui_android;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void presion(View v)
    {
        // Mostramos un mensaje al presionar un boton
        Toast.makeText(this, "Se presiono el boton", Toast.LENGTH_SHORT).show();
    }
}