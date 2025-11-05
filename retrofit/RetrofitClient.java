import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static Retrofit instancia;

    public static Retrofit getInstancia() {
        if (instancia == null) {

            instancia = new Retrofit.Builder()
                    .baseUrl(BASE_URL) // ¡Debe terminar en /
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instancia;
    }
}
