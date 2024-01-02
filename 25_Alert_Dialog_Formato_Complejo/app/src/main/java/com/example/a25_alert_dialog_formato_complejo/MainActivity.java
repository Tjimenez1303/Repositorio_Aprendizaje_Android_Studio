package com.example.a25_alert_dialog_formato_complejo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
    }


    public void seleccionarDia (View view)
    {
        // Paso 1: Creamos el builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Paso 2: Le ponemos el mensjae al diálogo
        builder.setTitle("Seleccione un día");

        // Paso 3: Implementamos cada uno de los items con Listener
        String [] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        builder.setItems(dias, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Mostramos el día seleccionado con la posiciónn del item (which)
                tv1.setText(String.format("Dia = %s", dias[which]));
            }
        });

        // Paso 4: Mostramos y creamos el diálogo
        builder.create().show();
    }

    public void seleccionarMeses (View view)
    {
        // Paso 1: Creamos el builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Paso 2: Implementamos el multichoice Items
        String []meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
                        "Octubre", "Noviembre", "Diciembre"};

        // Creamos un vector para los meses que han quedado seleccionados
        boolean[] checks = new boolean[12];

        builder.setMultiChoiceItems(meses, checks, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                // Inicializamos un string que va a contener el mensaje a mostrar en el tv2
                String todo = "";

                // Recorremos all los que están checkeados
                for ( int i = 0; i<checks.length; i++)
                {
                    if (checks[i])
                    {
                        // Concatenamos en el string a mostrar
                        todo = todo+meses[i]+"-";
                    }
                }
                tv2.setText(todo);
            }
        });

        // Paso 3: Añadimos un botón positivo para CONFIRMAR en el que no vamos a hacer nada solo cerrar el diálogo
        builder.setPositiveButton("Confirmar", null);

        // Paso 4: Creamos y mostramos el builder
        builder.create().show();
    }

    public void seleccionarHora (View view)
    {
        // Paso 1: Creamos el builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Paso 2: Le ponemos el mensjae al diálogo
        builder.setTitle("Seleccione una hora");

        // Paso 3: Implementamos cada uno de los items con checkBox
        String[] horas = {"8:00", "9:00", "10:00", "11:00"};
        builder.setSingleChoiceItems(horas, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv3.setText(horas[which]);

                // Cierra el diálogo apenas se selcciona una opción
                dialog.dismiss();
            }
        });

        // Paso 4: Añadimos un botón positivo para CONFIRMAR en el que no vamos a hacer nada solo cerrar el diálogo
        //builder.setPositiveButton("Confirmar", null);

        // Paso 5: Creamos y mostramos el builder
        builder.create().show();
    }
}