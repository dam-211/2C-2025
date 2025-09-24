package ar.edu.ifts18.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Es buena práctica definir las claves como constantes

    public static final String EXTRA_USERNAME = "ar.edu.ifts18.USERNAME";

    public static final String EXTRA_EDAD = "ar.edu.ifts18.EDAD";
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etUserNameInput = findViewById(R.id.etUserName);
        EditText etAgeInput = findViewById(R.id.etAge);
        Button profileButton = findViewById(R.id.btnPerfilBoton);
        Button btnGoogleDev = findViewById(R.id.btnAbrirGogleDev);

        profileButton.setOnClickListener(v-> {
            //Crear el intent explícito
            //Especificar el contexto con this y la clase de destino

            String userName = etUserNameInput.getText().toString();
            int edad = Integer.parseInt(etAgeInput.getText().toString());

            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);

            intent.putExtra(EXTRA_USERNAME, userName);
            intent.putExtra(EXTRA_EDAD, edad);

            //Iniciamos la nueva actividad
            startActivity(intent);
        });

        btnGoogleDev.setOnClickListener(v-> {

            //openWebPage("https://developer.android.com");
            Uri localizacion = Uri.parse("geo:-39.6037,-58.3816?z=14");
            //abriMapa(localizacion);
            dialPhoneNumber("55553277");
        });
    }

    public void openWebPage(String url){

        //Convertir de string a objeto Uri
        Uri paginaWeb = Uri.parse(url);

        //Creo el intent con la accion de ver y le paso los datos en objeto Uri.
        Intent intent = new Intent(Intent.ACTION_VIEW, paginaWeb);

        //Buena práctica, debemos verificar que efecitvamente exite un navegador o app capaz de manejar
        //Este intent. Esto previene que laa app se cierre.

        if(intent.resolveActivity(getPackageManager()) !=null) {
            //Si tengo una app, lanzo la activity
        }else {
            Toast.makeText(this, "No se encontró una aplicacion para abrir el enlace", Toast.LENGTH_LONG).show();
        }

    }

    public void abriMapa (Uri geoLocalizacion)  {

        Intent intentGeo = new Intent(Intent.ACTION_VIEW);
        intentGeo.setData(geoLocalizacion);

        if(intentGeo.resolveActivity(getPackageManager()) !=null) {

            startActivity(intentGeo);
        }
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intentCaller = new Intent (Intent.ACTION_DIAL);
        intentCaller.setData(Uri.parse("tel:"+phoneNumber));
        if(intentCaller.resolveActivity(getPackageManager()) !=null ) {
            startActivity(intentCaller);
        }

    }
}
