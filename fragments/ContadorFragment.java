import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

//fragment_contador.xml -->diseño del fragment

//Este es nuestro fragment puntualmente, maneja el contador y los clicks
//UI y el comportamiento del contador
public class ContadorFragment extends Fragment {

    private static final String ARG_NOMBRE = "arg_nombre";
    private static final String STATE_CONTADOR = "state_contador";

    private String nombre;
    private int contador = 0;

    //Factory Method, mejor que constructor público.


    //bundle --> "Bolsa de datos / paquete / bundle de datos en memoria temporal y efímera."
    //lo adhiero al fragment con el método setArguments(........)
    //Android puede recrear el fragment al rotal la pantalla sin pérdida de datos. Si usaramos variables
    //"sueltas", estas se pierden. Con argunments + bundle sabe como reconstruir y volver el fragment
    //a su estado original.
    public static ContadorFragment newInstance(String nombre) {

        ContadorFragment f = new ContadorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NOMBRE,nombre);
        f.setArguments(args);
        return f;
    }

    //SE EJECUTA ANTES DE CREAR LA VISTA
    //Lee los argumentos, en este caso, el nombre que le pasamos "Chise"
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Evitar un nulPointerExeption --> si por algun motivo, nadie le paso nada, obtendriamos un ANR.
        //
        if(getArguments() != null ) {
            //Buscar la clave ARG_NOMBRe y si existe, carga ese texto en nombre, si no invitado.
            //Arguments son los datos iniciales que vienen desde afuera del fragment, son considerados contantes para esta instancia.
            nombre = getArguments().getString(ARG_NOMBRE, "Invitado");
        }

        //restaura el estado en caso de rotación, stop o pause del activity
        //El bundle es del SISTEMA, es a nivel global.
        //Es nulo, cuando el fragment se está recreando luego de un cambio de configuración, por ejemplo al rotar la pantalla
        //o si por algún motivo se reinicializó la memoria RAM del dispósitivo.

        if(savedInstanceState != null){
            //Restaura, y si no encuentra el número, lo restaura a 0.
            contador = savedInstanceState.getInt(STATE_CONTADOR, 0);
        }
    }
    //savedInstanceState --> estádo volátil de la UI, es una memoria temporal para recuperar data tras
    //recreaciones de los ciclos de vida

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //inflate --> inflar la vista del fragment desde fragment_contador
        View v = inflater.inflate(R.layout.fragment_contador, container, false);

        //Obtengo las referencias
        TextView tvSaludo = v.findViewById(R.id.tvSaludo);
        TextView tvCuenta = v.findViewById(R.id.tvCuenta);
        Button btnSumar = v.findViewById(R.id.btnSumar);
        Button btnReiniciar = v.findViewById(R.id.btnReiniciar);

        tvSaludo.setText("Hola, " + nombre + "👋");
        tvCuenta.setText(String.valueOf(contador));

        //Defino que hacen los botones.
        btnSumar.setOnClickListener(view -> {
            contador++;
            tvCuenta.setText(String.valueOf(contador));
        });

        btnReiniciar.setOnClickListener(view -> {
            contador = 0;
            tvCuenta.setText(String.valueOf(contador));
        });

        return v;
    }

    //Guarda el ultimo valor obtenido del contador
    //Luego, android lo "devuelve" en el OnCreate()

    // OnCreate --> Prepara los datos/estado del fragment; --> onCreateView --> dibuja la UI
    //onSaveInstanceState --> guarda los datos que no se pueden perder ante una rotación de pantalla.
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_CONTADOR, contador);
    }
}

//Que es un fragment en la práctica:

//es una parte de una vista que vive dentro de un activity. tiene su propio ciclo de vida y su propia UI
//se puede reutilizar en diferentes activities o combinar varios en la misma pantalla (muy usado!) +
//Quien manda es el activity dado que es el que orquesta a los fragments en función de un flujo.
//El fragmen solo es capaz de ejecutar su lógica.


//Flujo completo: App inicializa en MainActivity y muestra su layout
//Hacemos click en Mostrar Fragment--> MainActivity CREA ContadorFragment con newInstance("Chise") y lo coloca en fragmentContainer
//Android llama a onCreate del fragment --> lee los argumentos y si aplica restaura todo a 0.
//Android llama a OncreateView --> inflar el layout del fragment, engancha los listeners y muestra el texto y el número, llama a los lamda de los btns.
//Al rotar el teléfono--> onSaveInstanceState guarda los datos valiosos, Android destruye y recrea por cada rotación el fragment.
//y asi no se pierde el numero
//

//TP para el 8 de Octubre:
//Número personalizado: Pasen por argumento al fragment el valor inicial del número
//Deshabiliten "Reiniciar contador" en caso de que este en 0 --> el botón debe ser grisado.
//Para investigar: Comunicación Activity-Fragment: Vean como hacer para que el fragment le avise al activity
//por cada vez que llegó a un múltiplo de 9. el toast lo lanza el MainActiviy NO el fragment....

//RESUMES SUMARISIMO: El activity decide cuando mostrar el fragment, el fragment decide que mostrar y
//adminisrtra su propio comportamiento púdiendo guardar su estado a fin de que la experiencia sea estable al rotar la pantalla.
