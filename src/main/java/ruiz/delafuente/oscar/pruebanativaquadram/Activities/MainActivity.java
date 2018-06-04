package ruiz.delafuente.oscar.pruebanativaquadram.Activities;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import ruiz.delafuente.oscar.pruebanativaquadram.Model.RetrofitAppModel.AppDetailFeed;
import ruiz.delafuente.oscar.pruebanativaquadram.Model.RetrofitAppModel.Entry;
import ruiz.delafuente.oscar.pruebanativaquadram.Model.RetrofitAppModel.Feed;
import ruiz.delafuente.oscar.pruebanativaquadram.Model.RetrofitAppModel.ImImage;
import ruiz.delafuente.oscar.pruebanativaquadram.RestClient;
import ruiz.delafuente.oscar.pruebanativaquadram.Utils.AppAdapter;
import ruiz.delafuente.oscar.pruebanativaquadram.CustomItemClickListener;
import ruiz.delafuente.oscar.pruebanativaquadram.Model.AppModel;
import ruiz.delafuente.oscar.pruebanativaquadram.R;
import ruiz.delafuente.oscar.pruebanativaquadram.Utils.DataHolder;
import ruiz.delafuente.oscar.pruebanativaquadram.Utils.SimpleDividerItemDecoration;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";


    private SharedPreferences spData;
    private RecyclerView recyclerView;
    private AppAdapter adapter;
    private List<Entry> entrys;
    private BottomNavigationView navigation;
    private Boolean blFirstTime = true;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_top_free:
                    retrofitGetTopApps("free");

                    return true;
                case R.id.navigation_top_paid:
                    retrofitGetTopApps("pay");
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spData = getApplicationContext().getSharedPreferences(getString(R.string.appDeletedBd), Context.MODE_PRIVATE);
        recyclerView = findViewById(R.id.RecyclerViewAppList);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (blFirstTime == true) {

            DataHolder.instance.appModelList = new ArrayList<>();
            DataHolder.instance.appModelDetailsList = new ArrayList<>();
            retrofitGetTopApps("free");


            navigation.setSelectedItemId(R.id.navigation_top_free);
            blFirstTime = false;


        } else {
            setAdapterToRecycleView(DataHolder.instance.appModelList);
            setNavigationItem();

        }


    }

    private void setNavigationItem() {
        for (AppModel appModel : DataHolder.instance.appModelList) {
            Log.d("Price Check", appModel.getAppPrice());
            if (appModel.getAppPrice().equals("Free")) {
                navigation.setSelectedItemId(R.id.navigation_top_free);
            } else {
                navigation.setSelectedItemId(R.id.navigation_top_paid);
            }
        }
    }

    private void retrofitGetTopApps(String type) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestClient client = retrofit.create(RestClient.class);
        Call<AppDetailFeed> requesApps;

        if (type.equals("free")) {
            requesApps = client.getFeed();

        } else {
            requesApps = client.getPaidFeed();
        }
        requesApps.enqueue(new Callback<AppDetailFeed>() {
            @Override
            public void onResponse(Call<AppDetailFeed> call, Response<AppDetailFeed> response) {
                if (!response.isSuccessful()) {
                    Log.i(TAG, "Error" + response.code());
                } else {
                    String id;
                    String name;
                    String img100 = null;
                    String price;
                    String artist;

                    DataHolder.instance.appModelList.clear();

                    //AppDetailFeed
                    AppDetailFeed appDetailFeed = response.body();

                    //Feed
                    Feed feed = appDetailFeed.getFeed();


                    //List<Entry>
                    entrys = feed.getEntry();

                    for (Entry entry : entrys) {
                        id = entry.getId().getAttributes().getImId();
                        if (checkAppRemove(id)) {
                            if (!entry.getImPrice().getAttributes().getAmount().equals("0.00000")) {
                                Log.d(TAG, "Price " + entry.getImPrice().getAttributes().getAmount());
                                price = String.valueOf(new DecimalFormat("##.##").format(Double.parseDouble(entry.getImPrice().getAttributes().getAmount())) + " €");

                            } else {
                                Log.d(TAG, "PriceFree " + entry.getImPrice().getAttributes().getAmount());
                                price = getString(R.string.free);
                            }

                            artist = entry.getImArtist().getLabel().toString();
                            name = entry.getTitle().getLabel();


                            for (ImImage imImage : entry.getImImage()) {
                                if (imImage.getAttributes().getHeight().equals("100")) {
                                    img100 = imImage.getLabel();
                                }

                            }
                            DataHolder.instance.appModelList.add(new AppModel(id, img100, name, artist, price));
                        }
                    }
                    setAdapterToRecycleView(DataHolder.instance.appModelList);
                }
            }

            @Override
            public void onFailure(Call<AppDetailFeed> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
                Toast toast = Toast.makeText(getApplicationContext(), R.string.retrofit_response_error, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }


    public void setAdapterToRecycleView(List appList) {
        adapter = new AppAdapter(getBaseContext(), appList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, String id) {
                DataHolder.instance.appSelectedId = id;
                Intent intent = new Intent(getBaseContext(), AppDetailActivity.class);
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getBaseContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getBaseContext()));


    }

    protected boolean checkAppRemove(String idApp) {
        if (!spData.getString(idApp, "").equals("deletedFromList")) {
            return true;
        }
        return false;
    }

    @Override
    public void onResume(){
        super.onResume();
        setAdapterToRecycleView(DataHolder.instance.appModelList);
        setNavigationItem();
        Log.v(TAG, "onPostRestoreInstanceS");


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        setAdapterToRecycleView(DataHolder.instance.appModelList);
        setNavigationItem();
        Log.v(TAG, "onPostRestoreInstanceS");
    }



    @Override
    protected void onPostResume() {
        super.onPostResume();
        setAdapterToRecycleView(DataHolder.instance.appModelList);
        setNavigationItem();
        Log.v(TAG, "onPostResume");

    }
}

