package com.example.a19_tab_layout_viewpagerii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    String [] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
    String [] actividades = {"", "", "", "", "", "", ""};

    TabLayout tabLayout1;
    ViewPager2 vp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Paso 5 (Opcional): Leemos lo que se guardó en el SharedPreferences guardado en el paso 4
        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        // Obtenemos los datos
        for (int i = 0; i<dias.length; i++)
        {
            // Lo que hace es que va y busca si hay algo escrito en algun dia de la semana y si no hay nada me devuelve "" y si si hay lo reemplaza por lo que encuentra
            String acti = preferences.getString(dias[i], "");
            actividades[i] = acti;
        }

        vp2 = findViewById(R.id.vp2);
        tabLayout1 = findViewById(R.id.tablayout1);

        vp2.setAdapter(new AdaptadorAgenda());

        // Paso 1: Creamos un objeto de tipo TabLayout Mediator
        TabLayoutMediator tlm = new TabLayoutMediator(tabLayout1, vp2, new TabLayoutMediator.TabConfigurationStrategy() {

            // Este método se va a disparar por cada uno de los elementos que tenga el ViewPager 2
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                // Me va pintando cada día de la semana en el TabLayout
                tab.setText(dias[position]);
            }
        });

        // Paso 2: Hago el enlace entre el ViewPAger 2 y el TabLayout
        tlm.attach();
    }

    // Paso 4 (OPCONAL): Los datos no van a quedar almacenados cuando se cierre o minimice la App pero con esto si
    protected void onPause() {
        super.onPause();

        // Creamos un objeto de SharedPreferences
        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);

        // Se crea un objeto Editor para poder empezar a guardar datos
        SharedPreferences.Editor editor = preferences.edit();

        // Escribimos los datos
        for (int i = 0; i<dias.length; i++)
        {
            editor.putString(dias[i], actividades[i]);
        }

        // Confirmamos y guardamos los datos
        editor.apply();

    }

    private class AdaptadorAgenda extends RecyclerView.Adapter<AdaptadorAgenda.AdaptadorAgendaHolder> {
        @NonNull
        @Override
        public AdaptadorAgendaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorAgendaHolder(getLayoutInflater().inflate(R.layout.layoutdia, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorAgendaHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return dias.length;
        }

        class AdaptadorAgendaHolder extends RecyclerView.ViewHolder{
            EditText et1;

            public AdaptadorAgendaHolder(@NonNull View itemView) {
                super(itemView);
                et1 = itemView.findViewById(R.id.etactividades);

                // Paso 3: Debemos de guardar lo que se escribe en el EditText porque o sino se va borrando cuando deslizo
                et1.setOnKeyListener(new View.OnKeyListener() {
                    // Este método se dispara con cualquier caracter que yo escriba en el EditText
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        // Obtengo lo que se escribió en la posición actual
                        actividades[getLayoutPosition()] = et1.getText().toString();
                        return false;
                    }
                });
            }

            public void imprimir(int position) {
                et1.setText(actividades[position]);
            }
        }
    }
}