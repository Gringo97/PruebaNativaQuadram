package ruiz.delafuente.oscar.pruebanativaquadram.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import ruiz.delafuente.oscar.pruebanativaquadram.R;

public class AppDetailActivity extends AppCompatActivity {

    ImageView imgApp;
    TextView  txtVAppName;
    TextView txtVDeveloperName;
    TextView txtVPrice;
    TextView txtVCategory;
    TextView txtVVersion;
    TextView txtVReleaseDate;
    TextView txtVCurrentVersionReleaseDate;
    TextView txtVDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_detail);

        imgApp = findViewById(R.id.imgApp);
        txtVAppName = findViewById(R.id.txtVAppName);
        txtVDeveloperName = findViewById(R.id.txtVDeveloperName);
        txtVPrice = findViewById(R.id.txtVPrice);
        txtVCategory = findViewById(R.id.txtVCategory);
        txtVVersion = findViewById(R.id.txtVVersion);
        txtVReleaseDate = findViewById(R.id.txtVReleaseDate);
        txtVCurrentVersionReleaseDate = findViewById(R.id.txtVCurrentVersion);
        txtVDescription = findViewById(R.id.txtVDescription);
    }
}
