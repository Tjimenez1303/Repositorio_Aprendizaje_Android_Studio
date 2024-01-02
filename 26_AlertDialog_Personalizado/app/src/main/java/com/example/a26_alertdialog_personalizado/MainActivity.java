package com.example.a26_alertdialog_personalizado;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void seleccionarColor (View view)
    {
        // Paso 1: Creamos un objeto de tipo builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Paso 2: Mostramos el mensaje inicial
        builder.setMessage("Seleccione un color:");

        // Paso 3: Leemos el archivo XML del diálogo personalizado
        View selector = getLayoutInflater().inflate(R.layout.selectorcolordialogo, null);

        // Paso 4: Establecemos la vista inflada en el diálogo
        builder.setView(selector);

        // Paso 5: Obtenemos la referencia de todos los objetos del layout personalizado

        // Vista del rectángulo que mostrará el color seleccionado
        View vistaColor = selector.findViewById(R.id.view);
        // Las barras de color
        SeekBar sb1 = selector.findViewById(R.id.seekBar1);
        SeekBar sb2 = selector.findViewById(R.id.seekBar2);
        SeekBar sb3 = selector.findViewById(R.id.seekBar3);
        // Los TextView
        TextView tv1 = selector.findViewById(R.id.tvrojo);
        TextView tv2 = selector.findViewById(R.id.tvverde);
        TextView tv3 = selector.findViewById(R.id.tvazul);

        // Asignamos los colores de los SeekBar a la vista
        vistaColor.setBackgroundColor(Color.rgb(sb1.getProgress(), sb2.getProgress(), sb3.getProgress()));

        // Cada que haya un cambio en el SeekBar se va a disparar la función onProgressChanged

        // ***************************** ROJO ****************************************************************
        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                vistaColor.setBackgroundColor(Color.rgb(sb1.getProgress(), sb2.getProgress(), sb3.getProgress()));
                tv1.setText("Rojo = " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // ***************************** VERDE ****************************************************************
        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                vistaColor.setBackgroundColor(Color.rgb(sb1.getProgress(), sb2.getProgress(), sb3.getProgress()));
                tv1.setText("Verde = " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

            // ***************************** AZUL ****************************************************************
        sb3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                vistaColor.setBackgroundColor(Color.rgb(sb1.getProgress(), sb2.getProgress(), sb3.getProgress()));
                tv1.setText("Azul = " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

        // Paso 6: Ponemos el boton de confiramar y lo ponemos del color seleccionado
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Button button = findViewById(R.id.button);
                button.setBackgroundColor(Color.rgb(sb1.getProgress(), sb2.getProgress(), sb3.getProgress()));
            }
        });

        // Paso 7: Creamos y mostramos el AlertDialog
        builder.create().show();

    }
}