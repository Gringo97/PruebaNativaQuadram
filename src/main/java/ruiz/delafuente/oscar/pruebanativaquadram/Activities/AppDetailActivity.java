package ruiz.delafuente.oscar.pruebanativaquadram.Activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import dmax.dialog.SpotsDialog;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ruiz.delafuente.oscar.pruebanativaquadram.Model.AppModel;
import ruiz.delafuente.oscar.pruebanativaquadram.Model.AppModelDetails;
import ruiz.delafuente.oscar.pruebanativaquadram.Model.RetrofitAppDetails.AppDetailFeed;
import ruiz.delafuente.oscar.pruebanativaquadram.Model.RetrofitAppDetails.Result;
import ruiz.delafuente.oscar.pruebanativaquadram.R;
import ruiz.delafuente.oscar.pruebanativaquadram.RestClient;
import ruiz.delafuente.oscar.pruebanativaquadram.Utils.DataHolder;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class AppDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences spData;
    private AppModelDetails appModelDetails;
    private static final String SEPARATOR = ", ";
    private static final String TAG = "AppDetailActivity";
    private AlertDialog alertDialog;


    private ImageView imgApp;
    private TextView txtVAppName;
    private TextView txtVDeveloperName;
    private TextView txtVPrice;
    private TextView txtVCategory;
    private TextView txtVVersion;
    private TextView txtVReleaseDate;
    private TextView txtVCurrentVersionReleaseDate;
    private TextView txtVDescription;
    private Button btnDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_detail);
        spData = getApplicationContext().getSharedPreferences(getString(R.string.appDeletedBd), Context.MODE_PRIVATE);

        //Toolbar SetUp

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        final Drawable backArrow = getResources().getDrawable(R.drawable.ic_back_arrow);
        backArrow.setColorFilter(getResources().getColor(R.color.colorOrange), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(backArrow);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }



        imgApp = findViewById(R.id.imgApp);
        txtVAppName = findViewById(R.id.txtVAppName);
        txtVDeveloperName = findViewById(R.id.txtVDeveloperName);
        txtVPrice = findViewById(R.id.txtVPrice);
        txtVCategory = findViewById(R.id.txtVCategory);
        txtVVersion = findViewById(R.id.txtVVersion);
        txtVReleaseDate = findViewById(R.id.txtVReleaseDate);
        txtVCurrentVersionReleaseDate = findViewById(R.id.txtVCurrentVersion);
        txtVDescription = findViewById(R.id.txtVDescription);
        btnDelete = findViewById(R.id.btnDeleteApp);
        btnDelete.setOnClickListener(this);
        alertDialog = new SpotsDialog(AppDetailActivity.this, R.style.Loading);
        alertDialog.show();


        retrofitGetAppDetails(DataHolder.instance.appSelectedId);

    }

    private void setData() {
        appModelDetails = DataHolder.instance.appModelDetailsList.get(0);
        Glide.with(getApplicationContext()).load(appModelDetails.getArtworkUrl100()).apply(bitmapTransform(new RoundedCornersTransformation(25, 3)))
                .into(imgApp);
        txtVAppName.setText(appModelDetails.getTrackName());
        txtVDeveloperName.setText(appModelDetails.getArtistName());
        txtVCategory.setText(appModelDetails.getGenresList());
        txtVPrice.setText(appModelDetails.getPrice());
        txtVVersion.setText(appModelDetails.getVersion());
        txtVReleaseDate.setText(appModelDetails.getReleaseDate());
        txtVCurrentVersionReleaseDate.setText(appModelDetails.getCurrentVersionReleaseDate());
        txtVDescription.setText(appModelDetails.getDescription());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnDeleteApp) {
            try {
                btnDelete.setOnClickListener(null);
                SharedPreferences.Editor editor = spData.edit();
                editor.putString(DataHolder.instance.appSelectedId, "deletedFromList");
                editor.commit();
                finish();
            } catch (Exception e) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, R.string.saveSharedPreferenceFailed, duration);
                toast.show();
            }

        }

    }

    private void retrofitGetAppDetails(final String name) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestClient client = retrofit.create(RestClient.class);
        Call<AppDetailFeed> requesApps;
        requesApps = client.getDetailsFeed(name);
        requesApps.enqueue(new Callback<AppDetailFeed>() {
            @Override
            public void onResponse(Call<ruiz.delafuente.oscar.pruebanativaquadram.Model.RetrofitAppDetails.AppDetailFeed> call, Response<AppDetailFeed> response) {
                if (!response.isSuccessful()) {
                    Log.i(TAG, "Error" + response.headers() + " " + response.body());
                } else {

                    DataHolder.instance.appModelDetailsList.clear();

                    String id;
                    String artwokr100;
                    String trackName;
                    String artisName;
                    String price;
                    String version;
                    String releaseDate;
                    String currentReleaseDate;
                    String description;
                    String genres;

                    //AppDetailFeed
                    ruiz.delafuente.oscar.pruebanativaquadram.Model.RetrofitAppDetails.AppDetailFeed appDetailFeed = response.body();


                    //List Result
                    List<Result> resultList = appDetailFeed.getResults();
                    Result result = resultList.get(0);
                    if (checkAppRemove(String.valueOf(result.getArtistId()))) {

                        id = String.valueOf(result.getArtistId());
                        artwokr100 = result.getArtworkUrl100();
                        trackName = result.getTrackName();
                        artisName = result.getArtistName();
                        version = result.getVersion();
                        description = result.getDescription();

                        releaseDate = dateFormatter(result.getCurrentVersionReleaseDate());
                        currentReleaseDate = dateFormatter(result.getCurrentVersionReleaseDate());

                        genres = listToStringFormatter(result.getGenres());

                        if (!result.getPrice().equals("0.00")) {
                            price = String.valueOf(new DecimalFormat("##.##").format(Double.parseDouble(result.getPrice())) + " €");
                        } else {
                            price = getString(R.string.free);
                        }
                        Log.d(TAG, "AppDetailPrice"+String.valueOf(price));

                        DataHolder.instance.appModelDetailsList.add(new AppModelDetails(id, artwokr100, trackName, artisName, price, genres, version, releaseDate, currentReleaseDate, description));
                        setData();

                        alertDialog.dismiss();
                    }
                }
            }

            @Override
            public void onFailure(Call<ruiz.delafuente.oscar.pruebanativaquadram.Model.RetrofitAppDetails.AppDetailFeed> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
                alertDialog.dismiss();
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    protected boolean checkAppRemove(String idApp) {
        Log.d(TAG, "SharedPreferences check app =" + spData.getString(idApp, ""));
        if (!spData.getString(idApp, "").equals("deletedFromList")) {
            return true;
        }
        return false;
    }

    private String dateFormatter(String date) {
        String dateFinal = "";
        try {
            //Data Input
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            Date newDate = format.parse(date);

            //Date Output
            format = new SimpleDateFormat("dd/MM/yyyy");
            dateFinal = format.format(newDate);

            Log.d(TAG, "Date Formatter result = " + dateFinal);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return dateFinal;
    }

    private String listToStringFormatter(List list){
        StringBuilder csvBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            csvBuilder.append(list.get(i));
            csvBuilder.append(SEPARATOR);
        }
        String string = csvBuilder.toString();
        string = string.substring(0, string.length() - SEPARATOR.length());
        Log.d(TAG, "AppDetailGenres"+string);
        return string;
    }


}
