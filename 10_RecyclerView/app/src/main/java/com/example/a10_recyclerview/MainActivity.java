package com.example.a10_recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Paso 1: Definir las estructuras de datos que tendrá el RecyclerView
    String [] nombres = {"fresas", "limon", "limones", "uva", "mangos", "manzana", "pera", "sandia"};
    float [] precios = {170,180,190,200,210,220,230,240};
    int [] fotos = {R.drawable.fresas, R.drawable.limon, R.drawable.limons, R.drawable.uva,
                    R.drawable.mangos, R.drawable.manzana, R.drawable.peras, R.drawable.sandia};

    // Paso 2: Declaramos el RecyclerView
    RecyclerView rv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Paso 3: Obtenemos el RecyclerView por el id
        rv1 = findViewById(R.id.recyclerView2);

        // Paso 4: Creamos un LinearLayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        // Paso 5: Le asignamos el LinearLayoutManager al RecyclerView
        rv1.setLayoutManager(linearLayoutManager);


        rv1.setAdapter(new AdaptadorFrutas());
    }


    // Paso 6: Creamos clase de  Adapter en el RecyclerView que se encarga de crear cada uno de todos los elementos
    private class AdaptadorFrutas extends RecyclerView.Adapter<AdaptadorFrutas.AdaptadorFrutasHolder>
    {
        @NonNull
        @Override
        // Me devuelve un objeto de clase AdaptadorFrutasHolder
        public AdaptadorFrutasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // Lo que hace esto es que guarda el xml del itemfruta y se lo manda como un holder
            return new AdaptadorFrutasHolder(getLayoutInflater().inflate(R.layout.itemfruta, parent, false));
        }

        @Override
        // Es la que se encarga de imprimir todos los items
        public void onBindViewHolder(@NonNull AdaptadorFrutasHolder holder, int position) {
            holder.imprimir(position);

        }

        @Override
        // Debe devolver la cantidad de elementos que tiene nuestra estructura de datos
        public int getItemCount() {
            return nombres.length; // Acá puede ser cualquiera de los tres vectores
        }

        // Paso 7: Creamos el Holder que se encara de imprimir cada uno de los elementos el implements es opcional y lo que hace es implementarme para saber cuál se presiona
        private class AdaptadorFrutasHolder extends RecyclerView.ViewHolder implements View.OnClickListener
        {
            // Paso 8: Creamos los items que tenemos en la vista itemfruta
            TextView tv1, tv2;
            ImageView iv1;

            // Paso 9: Creamos el constructor del Holder
            public AdaptadorFrutasHolder(@NonNull View itemView) {
                super(itemView);

                // Paso 10: Obtenemos los items que se crearon en el paso 8 y el Paso 11 es crear cada uno de los 3 métodos
                tv1 = itemView.findViewById(R.id.tvnombre);
                tv2 = itemView.findViewById(R.id.tvprecio);
                iv1 = itemView.findViewById(R.id.imageView);
                itemView.setOnClickListener(this); // Opcional: Para saber cuál se presionó
            }

            // Paso 12: Implementamos el método de Imprimir
            public void imprimir(int position) {
                // Imprimimos cada uno de los elementos en la posición en el que va
                iv1.setImageResource(fotos[position]);
                tv1.setText(nombres[position]);
                // Lo hacemos con valueof porque es un float
                tv2.setText(String.valueOf(precios[position]));
            }

            @Override
            // Metodo para implementar cual se presionó
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, nombres[getLayoutPosition()], Toast.LENGTH_LONG).show();
            }
        }
    }
}