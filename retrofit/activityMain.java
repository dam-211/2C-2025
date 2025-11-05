import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import ar.edu.uade.retrofit.api.JsonPlaceholderApi;
import ar.edu.uade.retrofit.api.RetrofitClient;
import ar.edu.uade.retrofit.model.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private TextView tvResultado;
    private Button btnCargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResultado = findViewById(R.id.tvResultado);
        btnCargar = findViewById(R.id.btnCargar);

        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarPosts();
            }
        });
    }

    private void cargarPosts() {
        tvResultado.setText("Cargando...\n");

        Retrofit retrofit = RetrofitClient.getInstancia();

        JsonPlaceholderApi api = retrofit.create(JsonPlaceholderApi.class);

        Call<List<Post>> llamada = api.getPosts();

        // IMPORTANTE: enqueue para no bloquear el hilo principal
        llamada.enqueue(new Callback<List<Post>>() {

            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    tvResultado.setText("Error HTTP: " + response.code());
                    return;
                }

                List<Post> posts = response.body();
                StringBuilder sb = new StringBuilder();

                for (Post p : posts) {
                    sb.append("ID: ").append(p.getId()).append("\n");
                    sb.append("User: ").append(p.getUserId()).append("\n");
                    sb.append("Título: ").append(p.getTitulo()).append("\n");
                    sb.append("Cuerpo: ").append(p.getCuerpo()).append("\n");
                    sb.append("------------------------\n");
                }

                tvResultado.setText(sb.toString());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                tvResultado.setText("Fallo: " + t.getMessage());
            }
        });
    }
}
