package com.example.a32_ciclo_vida_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Runnable {

    // Ejemplo Paso 1: Inicializamos el tv1
    TextView tv1;

    // Ejemplo Paso 2: Implementamos el Runnable porque vamos a trabajr con hilos ->  Cambiamos esto public class MainActivity extends AppCompatActivity
    // por public class MainActivity extends AppCompatActivity implements Runnable e implementamos los métodos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Paso 1: Mostramos un mensaje cuando se crea el Activity
        Toast.makeText(this, "Ejecutnado el OnCreate", Toast.LENGTH_SHORT).show();

        tv1 = findViewById(R.id.tv1);

        // Ejemplo Paso 5: Se llama al método run() que se implementó para que se ejecute || Si se ejecuta acá
        // va a mantener gastando recursos y nunca va a parar (DESCOMENTAR)
        // run();
    }

    // Paso 2: Sobreescribimos el OnDestroy
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Ejecutando el OnDestroy", Toast.LENGTH_SHORT).show();
    }

    // Paso 3: Sobreescribimos el OnStart
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Ejecutando el OnStart", Toast.LENGTH_SHORT).show();

        // Ejemplo Paso 5: Se llama al método run() que se implementó para que se ejecute || Si se ejecuta acá
        // va a ejecutarse cuando se inicie la interacción y lo podemos parar en el OnStop
        run();
    }

    // Paso 4: Sobreescribimos el OnStop
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Ejecutando el OnStop", Toast.LENGTH_SHORT).show();

        // Ejemplo Paso 6: Detenemos las llamadas o Callbacks al método run()
        tv1.removeCallbacks(this);
    }

    // Paso 5: Sobreescribimos el OnResume
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Ejecutando el OnResume", Toast.LENGTH_SHORT).show();
    }

    // Paso 6: Sobreescribimos el OnPause
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Ejecutando el OnPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void run() {
        // Ejemplo Paso 3: Obtenemos el valor y le sumamos 1 y se lo mandamos al TextView
       int x = Integer.parseInt(tv1.getText().toString())+1;
       tv1.setText(String.valueOf(x));

       // Ejemplo Paso 4: Hacemos que se ejecute cada 1 segundo
        tv1.postDelayed(this, 1000);

    }
}