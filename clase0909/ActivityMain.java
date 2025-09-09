package ar.edu.ifts18.practica;


import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Spinner;
import android.os.Bundle;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextInputLayout tilMonto = findViewById(R.id.tilMonto);
        TextInputEditText etMonto = findViewById(R.id.etMonto);
        Spinner spMoneda = findViewById(R.id.spMoneda);
        MaterialButton btnGuardar = findViewById(R.id.btnGuardar);
        //Button btnStd = findViewById(R.id.btnBotonStd);

        //Configuramos el spinner de monedas
        //Lista de Java

        List<String> monedas = Arrays.asList("ARS", "USD", "EUR");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, monedas);
        spMoneda.setAdapter(adapter);

        btnGuardar.setOnClickListener(v-> {
            String montoTxt;

            //String montoTxt = etMonto.getText() != null ? etMonto.getText().toString().trim() : "";

            if(etMonto.getText() != null) {
                montoTxt = etMonto.getText().toString().trim();
            } else {
                montoTxt = "";
            }

            double monto;

            try{
                monto = Double.parseDouble(montoTxt);
            } catch (NumberFormatException e) {
                monto = -1.0;
            }

            if(monto <= 0.0 ) {
                tilMonto.setError("Ingresa un monto valido!");
                etMonto.requestFocus();
                return;
            }
            tilMonto.setError(null);
            Snackbar.make(btnGuardar,"Gasto guardado!" + montoTxt, Snackbar.LENGTH_SHORT).show();

        });

    }
}
