package com.example.a29_web_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActividadWeb_View extends AppCompatActivity {

    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_web_view);

        wv1 = findViewById(R.id.wv1);

        // Obtenemos la dirección desde el otro Activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String direction = extras.getString("direccion");

            // Verificamos que direction no sea null antes de cargar la URL
            if (direction != null) {
                // Paso 1: Le cargamos la URL al WebView
                wv1.loadUrl(direction);

                // Paso 2 (Opcional): Ponemos para que si hace click en algun link de la pagina web se quede dentro del project
                wv1.setWebViewClient(new WebViewClient());
            }
        }
    }

    // Paso 3 (opcional): Si queremos que cuando se presione hacia atrás no se salga del WebView sino que apile las páginas en las que he entrado
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && wv1.canGoBack()){
            wv1.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}