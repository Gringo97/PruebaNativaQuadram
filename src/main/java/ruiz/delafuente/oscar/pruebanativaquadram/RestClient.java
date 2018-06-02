package ruiz.delafuente.oscar.pruebanativaquadram;

import retrofit2.Call;
import retrofit2.http.GET;
import ruiz.delafuente.oscar.pruebanativaquadram.Model.TopAppsRetrofit.AppDetailFeed;

public interface RestClient {
    String BASE_URL = "https://itunes.apple.com/es/rss/";

    @GET("topfreeapplications/limit=10/json")
    Call<AppDetailFeed> getFeed();


}
