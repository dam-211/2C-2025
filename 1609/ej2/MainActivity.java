package ar.edu.views;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText etTitulo;
    private TextInputLayout tilTitulo;
    private RadioGroup rgPrioridad;
    private MaterialSwitch swRepetir;
    private MaterialButton btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tilTitulo = findViewById(R.id.tilTitulo);
        etTitulo = findViewById(R.id.etTitulo);
        rgPrioridad = findViewById(R.id.rgPrioridad);
        swRepetir = findViewById(R.id.swRepetir);
        btnGuardar = findViewById(R.id.btnGuardarar);

        btnGuardar.setOnClickListener(v-> {

            String titulo = etTitulo.getText() !=null ? etTitulo.getText().toString().trim() : "";

            if(titulo.isEmpty()){

                tilTitulo.setError("Ingresa un titulo válido");
                etTitulo.requestFocus();
                return;
            }else{

                tilTitulo.setError(null);
            }


            //Trabajar con RadioGroup/RadioButton

            int idSeleccionado = rgPrioridad.getCheckedRadioButtonId();
            RadioButton rbSeleccionado = findViewById(idSeleccionado);

            String prioridad = rbSeleccionado !=null ? rbSeleccionado.getText().toString() : "Baja";
            //Swich

            boolean repetir = swRepetir.isChecked();

            String mensajeSalida = "Recordatorio Guardado!! \n" +
                    "Titulo: " + titulo + "\n"+
                    "Prioridad: " + prioridad + "\n" +
                    "Repetir: " + (repetir ? "Si" : "No");

            Toast.makeText(this, mensajeSalida, Toast.LENGTH_LONG).show();
        });

    }
}
