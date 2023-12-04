package com.example.a3_activity_context__ciclos_vida;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class Test {
    
    public static void myToast(Context context)
    {
        // Esto no funciona porque esta clase no es Android Studio y por lo tanto no tiene un Activity
//        Activity activity = this;

        // Le voy a pasar un context desde el MainActivity
        Toast.makeText(context, "Hola amigos", Toast.LENGTH_SHORT).show();
    }
}
