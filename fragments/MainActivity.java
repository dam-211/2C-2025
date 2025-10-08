import android.os.Bundle;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //AL ininicar el activity, mostramos el fragment.

        if(savedInstanceState == null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, new BienvenidaFragment()) //"Transa" --> registrar los cambios en el fragment
                    .addToBackStack(null) //Permite volver atrás, y quita el fragment de la memoria
                    .commit();

        }

        setContentView(R.layout.activity_main);
        Button  btnMostrarFragment = findViewById(R.id.btnMostrarFragment);

        btnMostrarFragment.setOnClickListener(v-> {
            ContadorFragment f = ContadorFragment.newInstance("Chise");
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, f) //"Transa" --> registrar los cambios en el fragment
                    .addToBackStack(null) //Permite volver atrás, y quita el fragment de la memoria
                    .commit();
        });



    }
}
