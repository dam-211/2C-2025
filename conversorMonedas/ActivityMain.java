package ar.edu.contraint;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //Constantes para SharedPreference
    public static final String SHARED_PREFS_FILE = "ConversorPrefs";
    public static final String LAST_CONVERSION_KEY = "ultimaConversion";

    //Llamada a las vistas de la UI

    private EditText editTextAmount;
    private Spinner spinnerFrom, spinnerTo;
    private Button buttonConvert;
    private TextView textViewResult, textViewLastConversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializamos las vistas

        editTextAmount = findViewById(R.id.editTextAmount);
        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);
        //textViewLastConversion = findViewById(R.id.)

        setupSpinners();

       // loadLastConversion();

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertCurrency();
            }
        });

    }

    private void setupSpinners() {

        //Crear un ArrayAdapter usando un array de string y un layout de spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currencies_array, android.R.layout.simple_spinner_item);
        //Especificar el layout a usar cuando la lista de opciones aparece
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Aplicamos el adaptador a los DOS spinners
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);
    }

    private void convertCurrency() {
        String amountString = editTextAmount.getText().toString();

        //Valdar que el campo monto no este vacio
        if (amountString.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese un monto valido", Toast.LENGTH_SHORT).show();
            return;
        }

        double amount = Double.parseDouble(amountString);
        String fromCurrency = spinnerFrom.getSelectedItem().toString();
        String toCurrency = spinnerTo.getSelectedItem().toString();

        //Logica de conversion

        double rate = getConversionRate(fromCurrency, toCurrency);
        double result = amount * rate;

        //Formatter para mostrar el reusltado

        String resultString = String.format(Locale.US, "%.2f %s = %.2f %s", amount, fromCurrency, result, toCurrency);

        //Muestro el resultado en el tV

        textViewResult.setText(resultString);


    }
    private double getConversionRate(String from, String to) {
        //Vamos a usar valores fijos para el TC

        if(from.equals(to)){
            return 1.0;
        }

        if(from.equals("USD") && to.equals("EUR")) return 0.89;
        if(from.equals("ARS") && to.equals("USD")) return 0.00068;

        return 0.0;
    }
}
