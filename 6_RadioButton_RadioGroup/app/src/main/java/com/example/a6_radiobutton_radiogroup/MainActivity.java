package com.example.a6_radiobutton_radiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2;
    private RadioButton rb1, rb2;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        tv1 = findViewById(R.id.tv1);

    }

    public void operar (View v)
    {
        String s1 = et1.getText().toString();
        String s2 = et2.getText().toString();

        int v1 = Integer.parseInt(s1);
        int v2 = Integer.parseInt(s2);

        // Si el boton de radio 1 está checkeado
        if (rb1.isChecked())
        {
             int suma = v1+v2;

             tv1.setText("La suma es: "+suma);
        }

        // Si el boton de radio 2 está checkeado
        else if (rb2.isChecked())
        {
            int resta = v1-v2;

            tv1.setText("La suma es: "+resta);
        }
    }
}