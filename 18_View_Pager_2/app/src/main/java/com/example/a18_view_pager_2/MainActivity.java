package com.example.a18_view_pager_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    String []frutas = {"fresas","limon", "limones", "mangos", "manzana", "peras", "sandia", "uva"};
    int []fotos = {R.drawable.fresas, R.drawable.limon, R.drawable.limons, R.drawable.mangos, R.drawable.manzana, R.drawable.peras, R.drawable.sandia, R.drawable.uva};

    ViewPager2 vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = findViewById(R.id.vp);

        // Paso 1: Creamos un adaptador (nos va a salir un error y presionamos alt+enter para que se cree una clase dentro del MainActivity
        vp.setAdapter(new AdaptadorFrutas());

        // Paso Opcional: Para que  no sea horizontal el desplazamiento sino vertical
        //vp.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
    }

    // Creada en el paso 1 y agregamos el holder -> <AdaptadorFrutas.AdaptadorFrutasHolder>
    private class AdaptadorFrutas extends RecyclerView.Adapter<AdaptadorFrutas.AdaptadorFrutasHolder> {
        // Paso 5: Implementamos métodos que se requieren de esta clase presionando alt+enter y se crearán 3 métodos

        // Metodo que crea cada uno de los Holder
        @NonNull
        @Override
        public AdaptadorFrutasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorFrutasHolder(getLayoutInflater().inflate(R.layout.layoutfrutas, parent,false));
        }

        // Metodo que le llega el Holder AdaptadorFrutasHolder  y se encarga de imprimir cada uno
        @Override
        public void onBindViewHolder(@NonNull AdaptadorFrutasHolder holder, int position) {
            holder.imprimir(position);
        }

        // Método que devuelve la cantidad de elementos que va a tener nuestro ViewPagerII
        @Override
        public int getItemCount() {
            return frutas.length;
        }

        // Paso 2: Creamos la clase para el Holder
        class AdaptadorFrutasHolder extends  RecyclerView.ViewHolder{

            // Paso 4: Inicializamos a los elementos que se crean en el layoutfrutas
            ImageView iv1;
            TextView tv1;


            // Paso 3: Implementamos el constructor (lo debe hacer Android Studio al presionar alt+enter al crear la clase)
            public AdaptadorFrutasHolder(@NonNull View itemView) {
                super(itemView);

                // Paso 5: Obtenemos los elementos inicializados en el paso 4
                iv1 = itemView.findViewById(R.id.ivpais);
                tv1 = itemView.findViewById(R.id.tvpais);
            }

            // Paso 6: Implementamos el  métodos que se encargará de mostrar por pantalla las cosas
            public void imprimir(int position) {
                iv1.setImageResource(fotos[position]);
                tv1.setText(frutas[position]);
            }
        }
    }
}