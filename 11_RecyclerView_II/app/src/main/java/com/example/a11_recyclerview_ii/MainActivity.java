package com.example.a11_recyclerview_ii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Objeto persona que es el que va a administrar todas las personas
    ArrayList <Persona> personas;
    RecyclerView rv1;
    EditText et1, et2;
    AdaptadorPersona ap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv1 = findViewById(R.id.rv1);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        // Personas va a ser de la clase Persona
        personas = new ArrayList<Persona>();


        // Creamos varias personas de ejemplo
        personas.add(new Persona("Tomas", "311"));
        personas.add(new Persona("Sergio", "312"));
        personas.add(new Persona("Mateo", "313"));
        personas.add(new Persona("Jer", "314"));
        personas.add(new Persona("Jose", "315"));
        personas.add(new Persona("Nicolas", "316"));

        // Definimos el LinearLayoutManager
        LinearLayoutManager l = new LinearLayoutManager(this);

        // Le asignamos el LinearLayoutManager al RV
        rv1.setLayoutManager(l);

        // Creamos una clase para implementar
        ap = new AdaptadorPersona();

        // Le asignamos el adaptador
        rv1.setAdapter(ap);
    }


    public void agregar(View v)
    {
        // Creamos una nueva persona con los datos ingresados
        Persona new_person = new Persona(et1.getText().toString(), et2.getText().toString());

        // Añadimos esa persona al Array
        personas.add(new_person);

        // Borro los et
        et1.setText("");
        et2.setText("");

        // Le digo al adapatador persona que actualice la pantalla
        ap.notifyItemInserted(personas.size() - 1); // Le estoy diciendo que el array ha sido modificado y un nuevo ítem ha sido insertado en la última posición
        rv1.scrollToPosition(personas.size()-1); // Le digo que esa nueva persona me lo ponga en la ultima posicion

    }

    public void eliminate(View v)
    {
        // Numero de error, que no se ha encontrado ninguno
        int pos = -1;
        for (int i = 0; i<personas.size(); i++)
        {
            // Si el nombre en el que va es igual al ingresado en eliminar
            if(personas.get(i).getNombre().equals(et1.getText().toString()))
            {
                pos = i;
            }
            if(pos != -1)
            {
                // Quito la persona que selecciono
                personas.remove(pos);

                // Borro los et
                et1.setText("");
                et2.setText("");

                // Le digo al adaptador persona que un ítem ha sido eliminado
                ap.notifyItemRemoved(pos);
                Toast.makeText(this, "Se elimino la persona", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Esa persona no existe", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void show(int position)
    {
        // Ponemos en los et los que seleccione
        et1.setText(personas.get(position).getNombre());
        et2.setText(personas.get(position).getTelefono());
    }

    // Paso 6: Creamos clase de  Adapter en el RecyclerView que se encarga de crear cada uno de todos los elementos
    private class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.AdaptadorPersonaHolder>
    {
        @NonNull
        @Override
        // Me devuelve un objeto de clase AdaptadorFrutasHolder
        public AdaptadorPersonaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // Lo que hace esto es que guarda el xml del itemfruta y se lo manda como un holder
            return new AdaptadorPersonaHolder(getLayoutInflater().inflate(R.layout.itempersona, parent, false));
        }

        @Override
        // Es la que se encarga de imprimir todos los items
        public void onBindViewHolder(@NonNull AdaptadorPersonaHolder holder, int position) {
            holder.imprimir(position);

        }

        @Override
        // Debe devolver la cantidad de elementos que tiene nuestra estructura de datos
        public int getItemCount() {
            return personas.size(); // Acá puede ser cualquiera de los tres vectores
        }

        // Paso 7: Creamos el Holder que se encara de imprimir cada uno de los elementos el implements es opcional y lo que hace es implementarme para saber cuál se presiona
        private class AdaptadorPersonaHolder extends RecyclerView.ViewHolder implements View.OnClickListener
        {
            // Paso 8: Creamos los items que tenemos en la vista itemfruta
            TextView tv1, tv2;

            // Paso 9: Creamos el constructor del Holder
            public AdaptadorPersonaHolder(@NonNull View itemView) {
                super(itemView);

                // Paso 10: Obtenemos los items que se crearon en el paso 8 y el Paso 11 es crear cada uno de los 3 métodos
                tv1 = itemView.findViewById(R.id.tvnombre);
                tv2 = itemView.findViewById(R.id.tvtelefono);
                itemView.setOnClickListener(this); // Opcional: Para saber cuál se presionó
            }

            // Paso 12: Implementamos el método de Imprimir
            public void imprimir(int position) {
                tv1.setText(String.format("Nombre: %s", personas.get(position).getNombre()));
                // Lo hacemos con valueof porque es un float
                tv2.setText(String.format("Telefono: %s", personas.get(position).getTelefono()));
            }

            @Override
            // Metodo para implementar cual se presionó
            public void onClick(View v) {
                // Llamo al metodo mostrar cuando hago click sobre alguno, el metodo getLayoutPosition devuelve la posicion del item que se acaba de presionar
                show(getLayoutPosition());
            }
        }
    }
}