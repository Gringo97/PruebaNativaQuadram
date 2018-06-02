package ruiz.delafuente.oscar.pruebanativaquadram.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import ruiz.delafuente.oscar.pruebanativaquadram.CustomItemClickListener;
import ruiz.delafuente.oscar.pruebanativaquadram.Model.AppModel;
import ruiz.delafuente.oscar.pruebanativaquadram.R;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;


public class AppAdapter extends RecyclerView.Adapter<AppAdapter.MyViewHolder> {

    private Context mContext;
    private List<AppModel> appModelList;
    private CustomItemClickListener listener;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtVAppNameCardView;
        public TextView txtVNumberApp;
        public TextView txtVAppPriceCardView;
        public TextView txtVAppArtistCardView;
        public ImageView imgAppCardView;


        public MyViewHolder(View view) {
            super(view);

            txtVAppNameCardView = view.findViewById(R.id.txtViewAppNameCardView);
            txtVAppArtistCardView = view.findViewById(R.id.txtVAppArtistCardView);
            txtVAppPriceCardView = view.findViewById(R.id.txtVAppPriceCardView);
            txtVNumberApp = view.findViewById(R.id.txtVNumberApp);
            imgAppCardView = view.findViewById(R.id.imgAppCardView);


        }


    }


    public AppAdapter(Context mContext, List<AppModel> appModelList, CustomItemClickListener listener) {
        this.mContext = mContext;
        this.appModelList = appModelList;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.app_model_card, parent, false);
        final MyViewHolder mViewHolder = new MyViewHolder(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, (String) mViewHolder.txtVAppNameCardView.getText());
            }
        });
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        AppModel appModel = appModelList.get(position);


        holder.txtVAppNameCardView.setText(appModel.getAppName());
        holder.txtVNumberApp.setText("1");
        holder.txtVAppArtistCardView.setText(appModel.getAppArtist());

        if (appModel.getAppPrice().equals(0.00)) {
            holder.txtVAppPriceCardView.setText(String.valueOf(appModel.getAppPrice()));
        } else {
            holder.txtVAppPriceCardView.setText(R.string.free);
        }
        Log.v(" IMG-vURL", appModel.getAppImage());
        try {
            //Glide.with(mContext).load(appModel.getAppImage()).into(holder.imgAppCardView);


            Glide.with(mContext).load(appModel.getAppImage()).apply(bitmapTransform(new RoundedCornersTransformation(25, 3)))
                    .into(holder.imgAppCardView);


        } catch (Exception e) {
            Log.v("Exception Glide", e.getMessage());
        }

    }

    @Override
    public int getItemCount() {
        return appModelList.size();
    }
}