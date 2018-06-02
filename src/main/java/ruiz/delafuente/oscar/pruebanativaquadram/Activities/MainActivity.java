package ruiz.delafuente.oscar.pruebanativaquadram.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ruiz.delafuente.oscar.pruebanativaquadram.Model.TopAppsRetrofit.AppDetailFeed;
import ruiz.delafuente.oscar.pruebanativaquadram.Model.TopAppsRetrofit.Entry;
import ruiz.delafuente.oscar.pruebanativaquadram.Model.TopAppsRetrofit.Feed;
import ruiz.delafuente.oscar.pruebanativaquadram.Model.TopAppsRetrofit.ImImage;
import ruiz.delafuente.oscar.pruebanativaquadram.RestClient;
import ruiz.delafuente.oscar.pruebanativaquadram.Utils.AppAdapter;
import ruiz.delafuente.oscar.pruebanativaquadram.CustomItemClickListener;
import ruiz.delafuente.oscar.pruebanativaquadram.Model.AppModel;
import ruiz.delafuente.oscar.pruebanativaquadram.R;
import ruiz.delafuente.oscar.pruebanativaquadram.Utils.SimpleDividerItemDecoration;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private AppAdapter adapter;
    private List<AppModel> appModelList;

    private List<Entry> entrys;
    private String id;
    private String name;
    private String img100 = null;
    private String price;
    private String artist;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    try {
                        loadJSON();
                    } catch (Exception ex) {
                        Log.e("Lod JSON", ex.getMessage());
                    }
                    return true;
                case R.id.navigation_dashboard:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerViewAppList);
        appModelList = new ArrayList<>();


        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestClient client = retrofit.create(RestClient.class);
        Call<AppDetailFeed> requesApps = client.getFeed();

        requesApps.enqueue(new Callback<AppDetailFeed>() {
            @Override
            public void onResponse(Call<AppDetailFeed> call, Response<AppDetailFeed> response) {
                if (!response.isSuccessful()) {
                    Log.i("TAG", "Error" + response.code());
                } else {

                    //Response
                    Log.v("Resp", "" + response.headers());
                    Log.v("Resp", "" + response.body().toString());
                    Log.v("Resp", "" + response.code());

                    //AppDetailFeed
                    AppDetailFeed appDetailFeed = response.body();
                    Log.v("Resp", "----->" + response.body().getFeed().getTitle().getLabel());


                    //Feed
                    Feed feed = appDetailFeed.getFeed();
                    Log.v("Entrys1", feed.getId().getLabel());
                    Log.v("datos", appDetailFeed.getFeed().toString());


                    //List<Entry>
                    entrys = feed.getEntry();

                    Log.v("Entrys2", "--------->" + entrys.get(0).getTitle().getLabel());


                    for (Entry entry : entrys) {
                        if (entry.getImPrice().getAttributes().getAmount().equals("0.00000")) {
                            price = getString(R.string.free);
                        } else {
                            Log.v("Price", entrys.get(1).getImPrice().getAttributes().getAmount());
                            price = entry.getImPrice().getAttributes().getAmount();
                        }

                        artist = entry.getImArtist().getLabel().toString();
                        name = entry.getTitle().getLabel();
                        id = entry.getId().getLabel();
                        for (ImImage imImage : entry.getImImage()) {
                            if (imImage.getAttributes().getHeight().equals("100")) {
                                img100 = imImage.getLabel();
                            }
                        }


                        appModelList.add(new AppModel(id, img100, name, artist, price));
                    }


                    adapter = new AppAdapter(getBaseContext(), appModelList, new CustomItemClickListener() {
                        @Override
                        public void onItemClick(View v, String id) {

                            for (int i = 0; i < appModelList.size(); i++) {
                                if (appModelList.get(i).getAppId() == id) {

                                }
                            }
                        }
                    });


                    RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getBaseContext(), 1);
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(adapter);
                    recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getBaseContext()));
                }
            }

            @Override
            public void onFailure(Call<AppDetailFeed> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
            }
        });
    }


}

