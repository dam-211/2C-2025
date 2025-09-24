package ar.edu.ifts18.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView tvBienvenida = findViewById(R.id.tvBienvenida);
        TextView tvEdad = findViewById(R.id.tvEdad);

        //Obtenemos el intent que inició la actividad

        Intent intent = getIntent();

        //Extraemos los datos usando las mismas claves definidas anteriormente.

        String username = intent.getStringExtra(MainActivity.EXTRA_USERNAME);
        int edad = intent.getIntExtra(MainActivity.EXTRA_EDAD, 0);

        //Usamos los atributos
        tvBienvenida.setText("Bienvenido!: " + username);
        tvEdad.setText("La edad es de: " + edad + " años!");

        //--------- LOGICA DE ACTIVITY IMPLICITO ----
        Button btnShareBtn = findViewById(R.id.btnShareBtn);

        btnShareBtn.setOnClickListener(v-> {

            //Preparar el contenido para compartir
            String mensajeACompartir = "¡Mirá mi pefil: " + username + " edad: " + edad + ".";

            //Creamos el intent implicito con el ACTION SEND
            //NO especificamos un destino, si no que dejamos que el usuario decida
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            //Definit el contenido que quiero compartir, esto es importante para saber que apps mosrtrara el sO
            shareIntent.setType("text/plain");
            //Ponemos el contenido dentro del extra
            shareIntent.putExtra(Intent.EXTRA_TEXT, mensajeACompartir);
            //iniciar la actividad mostrando al usuario las opcioones a compartir
            startActivity(Intent.createChooser(shareIntent, "Compartir mi perfil con..."));

        });

    }


}
