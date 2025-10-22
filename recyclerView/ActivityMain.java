package ar.edu.ifts18.recyclerviewsimple;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewTextos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewTextos = findViewById(R.id.recyclerViewTextos);

        //1) Decirle al RV cómo acomodar los ítems (en este caso, lista vertical simple)

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewTextos.setLayoutManager(layoutManager);

        //Opcional

        recyclerViewTextos.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        );

        //Fuente de datos

        List<String> datos = obtenerDatosEjemplo();

        //3)Conectar el adaptador con el recyclerview

        AdaptadorTexto adpatador = new AdaptadorTexto(datos);
        recyclerViewTextos.setAdapter(adpatador);


    }

    private List<String> obtenerDatosEjemplo() {
        return new ArrayList<>(Arrays.asList(
                "Hola RecyclerView!",
                "Esto es un item de la lista",
                "Cada fila usa el layout item_texto_simple.xml",
                "El adapter bindea o pega los datos",
                "El view holder guarda las referencias a las visatas",
                "LinerarLayuoutManager = ListaVertical, solo eso",
                "Podés agregar clicks, imágnes, ect",
                "Esto es un item de la lista",
                "Cada fila usa el layout item_texto_simple.xml",
                "El adapter bindea o pega los datos",
                "El view holder guarda las referencias a las visatas",
                "LinerarLayuoutManager = ListaVertical, solo eso",
                "Podés agregar clicks, imágnes, ect",
                "Esto es un item de la lista",
                "Cada fila usa el layout item_texto_simple.xml",
                "El adapter bindea o pega los datos",
                "El view holder guarda las referencias a las visatas",
                "LinerarLayuoutManager = ListaVertical, solo eso",
                "Podés agregar clicks, imágnes, ect",
                "Esto es un item de la lista",
                "Cada fila usa el layout item_texto_simple.xml",
                "El adapter bindea o pega los datos",
                "El view holder guarda las referencias a las visatas",
                "LinerarLayuoutManager = ListaVertical, solo eso",
                "Podés agregar clicks, imágnes, ect",
                "Esto es un item de la lista",
                "Cada fila usa el layout item_texto_simple.xml",
                "El adapter bindea o pega los datos",
                "El view holder guarda las referencias a las visatas",
                "LinerarLayuoutManager = ListaVertical, solo eso",
                "Podés agregar clicks, imágnes, ect",
                "Esto es un item de la lista",
                "Cada fila usa el layout item_texto_simple.xml",
                "El adapter bindea o pega los datos",
                "El view holder guarda las referencias a las visatas",
                "LinerarLayuoutManager = ListaVertical, solo eso",
                "Podés agregar clicks, imágnes, ect",
                "Esto es un item de la lista",
                "Cada fila usa el layout item_texto_simple.xml",
                "El adapter bindea o pega los datos",
                "El view holder guarda las referencias a las visatas",
                "LinerarLayuoutManager = ListaVertical, solo eso",
                "Podés agregar clicks, imágnes, ect",
                "Ejemplo más básico no se consige"
        ));

    }
}
