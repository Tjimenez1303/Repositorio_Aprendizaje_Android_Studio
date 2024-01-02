package com.example.a27_alertdialog_clase_reutilizandolo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoMensaje extends DialogFragment {

    private String mensaje;
    public DialogoMensaje(String mensaje)
    {
        this.mensaje = mensaje;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        // Paso 1: Creamos un objeto de tipo builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Paso 2: Mostramos el mensaje inicial
        builder.setMessage(mensaje);

        // Paso 3:  Ponemos el boton de confirmar
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Paso 9: Enviamos la respuesta a la interfaz
                respuesta.confirmar(DialogoMensaje.this);
            }
        });

        // Paso 4: Ponemos el botón de cancelar
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Paso 10: Enviamos la respuesta a la interfaz
                respuesta.cancelar(DialogoMensaje.this);
            }
        });

        // Paso 5: Returnamos un AlertDialog Builder
        return builder.create();
    }


    // Paso 6: Creamos un interfaz para poder comunicar las respuestas de los AlerttDialog || Una interfaz declara los métodos pero no los implementa
    public interface Respuestas
    {
        public void confirmar (DialogFragment confirmar);
        public void cancelar (DialogFragment dialog);
    }

    // Paso 7: Declaramos una variable de tipo respuesta de la interfaz
    Respuestas respuesta;

    // Paso 8: Declaramos un método para procesar la respuesta que recibe un atributo de tipo Respuesta
    public void procesarRespuesta(Respuestas r)
    {
        respuesta = r;
    }
}
