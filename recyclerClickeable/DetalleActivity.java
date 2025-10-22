package ar.edu.ifts18.recyclerclickeable;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Muestra el texto que se clickeó en la lista.
 */
public class DetalleActivity extends AppCompatActivity {

    public static final String EXTRA_TEXTO = "EXTRA_TEXTO";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        TextView txtDetalle = findViewById(R.id.txtDetalle);

        String texto = getIntent().getStringExtra(EXTRA_TEXTO);

        if (texto == null) {
            texto = "(sin datos)";
        }

        txtDetalle.setText("Clickeaste: " + texto);

        setTitle("Detalle"); // título simple
    }
}
