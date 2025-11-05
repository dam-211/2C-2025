import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("userId")
    private int userId;

    private int id;

    @SerializedName("title")
    private String titulo;

    @SerializedName("body")
    private String cuerpo;

    // Getters y setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
}
