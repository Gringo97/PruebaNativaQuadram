package ruiz.delafuente.oscar.pruebanativaquadram;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ruiz.delafuente.oscar.pruebanativaquadram.Model.RetrofitAppModel.AppDetailFeed;



public interface RestClient {
    String BASE_URL = "https://itunes.apple.com/";


    @GET("es/rss/topfreeapplications/limit=10/json")
    Call<AppDetailFeed> getFeed();


    @GET("es/rss/toppaidapplications/limit=10/json")
    Call<AppDetailFeed> getPaidFeed();


    @GET("lookup")
    Call<ruiz.delafuente.oscar.pruebanativaquadram.Model.RetrofitAppDetails.AppDetailFeed>  getDetailsFeed(@Query("id") String id);


}
