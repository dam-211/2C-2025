import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceholderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("postss/{id}")
    Call<Post> getPostPorId(@Path("id") int id);
}
