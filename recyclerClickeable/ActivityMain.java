package ar.edu.ifts18.recyclerclickeable;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewTextos = findViewById(R.id.recyclerViewTextos);

        recyclerViewTextos.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewTextos.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        );

        List<String> datos = obtenerDatosEjemplo();

        AdaptadorTexto adaptador = new AdaptadorTexto(datos, zarlanga -> {

            // Al clickear, abrimos DetalleActivity y le pasamos el texto

            Intent intent = new Intent(MainActivity.this, DetalleActivity.class);

            intent.putExtra("EXTRA_TEXTO", zarlanga);

            startActivity(intent);

        });

        recyclerViewTextos.setAdapter(adaptador);
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
