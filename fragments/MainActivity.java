import android.os.Bundle;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;
//MainActivity.xml --> diseño principal de nuestra pantalla. Tiene un botón y un contenedor para poner un fragment.

//Lógica de nuestra paantalla principal. La que contiene y renderiza el botón y carga el fragment
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Carga el layout, pero aún no hay fragment, lo cartgamos con el botón.
        setContentView(R.layout.activity_main);
        Button  btnMostrarFragment = findViewById(R.id.btnMostrarFragment);

        //Al hacer click, lo coloca en el contenedor, "lo hace aparecer"
        btnMostrarFragment.setOnClickListener(v-> {

            //Crea el fragment pasándole como dato el nombre de usuario de forma prolija y con buenas prácticas.
            ContadorFragment f = ContadorFragment.newInstance("Chise");
            //Objeto que administra los fragments dentro del activity.
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, f) //"Transa" --> registrar los cambios en el fragment
                    .addToBackStack(null) //Permite volver atrás, y quita el fragment de la memoria
                    .commit();
        });

        // La activiy decide cuándo aparece un fragmen, qué fragment y bajo que condiciones. También
        //gestiona lo que se muestra y como se comporta.

    }
}
