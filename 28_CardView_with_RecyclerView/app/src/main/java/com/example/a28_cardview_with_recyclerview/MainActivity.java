package com.example.a28_cardview_with_recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv1;

    // Paso 1: Colocamos los strings
    String [] nombres = {"Fresas", "Limon", "Limones", "Mangos", "Manzana", "Peras", "Sandia", "Uva"};
    int [] edades = {1, 1, 20, 2, 1, 2, 2, 25};
    int [] fotos = {R.drawable.fresas, R.drawable.limon, R.drawable.limons, R.drawable.mangos, R.drawable.manzana, R.drawable.peras, R.drawable.sandia, R.drawable.uva};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv1 = findViewById(R.id.rv1);

        // Paso 2: Creamos el LinearLayoutManager y se lo asignamos
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv1.setLayoutManager(linearLayoutManager);

        // Paso 3: Asignamos el Adapter
        rv1.setAdapter(new AdaptadorPersona());
    }

    // Paso 4: Creamos el Adapter con su Holder
    private class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.AdaptadorPersonaHolder> {

        // Paso 8: Creamos los métodos necesarios para el Adaptador
        @NonNull
        @Override
        public AdaptadorPersonaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // Paso 10: Returnamos un adaptoder holder, por lo que debemos crear
            return new AdaptadorPersonaHolder(getLayoutInflater().inflate(R.layout.layout_tarjeta, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorPersonaHolder holder, int position) {
            // Paso 11: Ponemos a imprimir el holder en la posición actual y habría que implementar el método imprimir
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            // Paso 9: Returnamos el número de objetos
            return nombres.length;
        }

        class AdaptadorPersonaHolder extends RecyclerView.ViewHolder {

            // Paso 6: Inicializamos variables para los id del CardView
            ImageView iv1;
            TextView tv1, tv2;

            // Paso 5: Creamos el Holder
            public AdaptadorPersonaHolder(@NonNull View itemView) {
                super(itemView);

                // Paso 7: Obtenemos los id de los elementos del CardView
                iv1 = itemView.findViewById(R.id.imageView);
                tv1 = itemView.findViewById(R.id.tvedad);
                tv2 = itemView.findViewById(R.id.tvnombre);
            }

            // Paso 12: Implementamos el método imprimir
            public void imprimir(int position) {
                iv1.setImageResource(fotos[position]);
                tv1.setText(nombres[position]);
                tv2.setText(String.format(Locale.getDefault(),"Frutas:%d", edades[position]));
            }
        }
    }
}