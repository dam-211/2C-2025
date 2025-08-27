package ar.edu.ifts18.holamundo;


import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.graphics.Color;
import android.os.Bundle;

import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    public TextView tvResultado;
    public Button btnSumar, btnRestar;
    public EditText numero1, numero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Conecta la lógica con el layout
        setContentView(R.layout.activity_main);

        //Vinculamos los elementos de la UI
        tvResultado = findViewById(R.id.tvHola);
        btnSumar = findViewById(R.id.btnMostrar);
        btnRestar = findViewById(R.id.btnRestar);
        numero1 = findViewById(R.id.etNumero1);
        numero2 = findViewById(R.id.etNumero2);

        tvResultado.setText("---");

        btnSumar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               calcular( "suma" );
            }
        });


        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular( "resta"  );
            }
        });
    }

    public void calcular(String operacion) {

        //Obtener los valores de los EditText
        String numeroString1 = numero1.getText().toString();
        String numeroString2 = numero2.getText().toString();


        if (!numeroString1.isEmpty() && !numeroString2.isEmpty()) {

            double numero1 = Double.parseDouble(numeroString1);
            double numero2 = Double.parseDouble(numeroString2);
            double resultado = 0;

            if(operacion.equals("suma")){

                resultado = numero1 + numero2;
                tvResultado.setText("Resultado de la suma: " + resultado);

            } else if(operacion.equals("resta")){

                resultado = numero1 - numero2;
                tvResultado.setText("Resultado de la resta: " + resultado);
            }

        } else {

            tvResultado.setTextColor(Color.parseColor("#FF0000"));
            tvResultado.setText("Ingrese ambos numeros");
        }
    }
}
