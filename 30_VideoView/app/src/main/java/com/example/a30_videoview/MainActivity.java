package com.example.a30_videoview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private VideoView vv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vv1 = findViewById(R.id.vv1);

        // Paso opcional: Podemos obtener la orientación para ocultar o no la barra
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE){
            // Ocultamos la barra
            //getSupportActionBar().hide();
        }
        else{
            // Mostramos la barra
            //getSupportActionBar().show();
        }

        //  Paso 1: Cargamos el video desde la URI
        vv1.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sample));

        // Paso 2: Creamos el objeto MediaController para los controles del video
        MediaController mc = new MediaController(this);

        // Paso 3: Le asignamos el media controler al video
        vv1.setMediaController(mc);

        // Paso 4: Le asignamos el ancho al MediaController acorde al video
        mc.setAnchorView(vv1);

        // Paso 5: Empezamos a reproducir el video
        vv1.start();
    }
}