package com.example.a3_activity_context__ciclos_vida;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Le paso mi contexto de Main al método myToast que se encuentra en la clase Test
        Context context = this;
        Test.myToast(context);



    }
}