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

import ruiz.delafuente.oscar.pruebanativaquadram.Utils.AppAdapter;
import ruiz.delafuente.oscar.pruebanativaquadram.CustomItemClickListener;
import ruiz.delafuente.oscar.pruebanativaquadram.Model.AppModel;
import ruiz.delafuente.oscar.pruebanativaquadram.R;
import ruiz.delafuente.oscar.pruebanativaquadram.Utils.SimpleDividerItemDecoration;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity" ;
    private RecyclerView recyclerView;
    private AppAdapter adapter;
    private List<AppModel> appModelList;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

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

        //Dummy Data
        appModelList.add(new AppModel("1", "https://is1-ssl.mzstatic.com/image/thumb/Purple125/v4/05/6e/c0/056ec02d-310e-d1ba-c888-3534578d9ed8/Prod-1x_U007emarketing-85-220-0-5.png/100x100bb-85.png","Facebook asfjkbsdalkbfalskdjfhvljkafdgakjedg","Mark",9.99));
        appModelList.add(new AppModel("2","https://is1-ssl.mzstatic.com/image/thumb/Purple125/v4/05/6e/c0/056ec02d-310e-d1ba-c888-3534578d9ed8/Prod-1x_U007emarketing-85-220-0-5.png/100x100bb-85.png","Facebook","Mark",9.99));
        appModelList.add(new AppModel("3","https://is1-ssl.mzstatic.com/image/thumb/Purple125/v4/05/6e/c0/056ec02d-310e-d1ba-c888-3534578d9ed8/Prod-1x_U007emarketing-85-220-0-5.png/100x100bb-85.png","Facebook","Mark",9.99));
        appModelList.add(new AppModel("4","https://is1-ssl.mzstatic.com/image/thumb/Purple125/v4/05/6e/c0/056ec02d-310e-d1ba-c888-3534578d9ed8/Prod-1x_U007emarketing-85-220-0-5.png/100x100bb-85.png","Facebook","Mark",9.99));
        appModelList.add(new AppModel("5","https://is1-ssl.mzstatic.com/image/thumb/Purple125/v4/05/6e/c0/056ec02d-310e-d1ba-c888-3534578d9ed8/Prod-1x_U007emarketing-85-220-0-5.png/100x100bb-85.png","Facebook","Mark",9.99));
        appModelList.add(new AppModel("6","https://is1-ssl.mzstatic.com/image/thumb/Purple125/v4/05/6e/c0/056ec02d-310e-d1ba-c888-3534578d9ed8/Prod-1x_U007emarketing-85-220-0-5.png/100x100bb-85.png","Facebook","Mark",9.99));

        adapter = new AppAdapter(this, appModelList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, String id) {

              for (int i = 0; i < appModelList.size();i ++){
                  if(appModelList.get(i).getAppId() == id){

                  }
                }
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}

