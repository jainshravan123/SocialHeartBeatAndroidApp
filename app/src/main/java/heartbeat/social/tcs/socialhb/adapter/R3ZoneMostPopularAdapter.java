package heartbeat.social.tcs.socialhb.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import heartbeat.social.tcs.socialhb.R;
import heartbeat.social.tcs.socialhb.bean.R3ZoneModule;
import heartbeat.social.tcs.socialhb.bean.R3ZoneMostPopularModule;

/**
 * Created by shravanjain on 29/03/17.
 */

public class R3ZoneMostPopularAdapter  extends RecyclerView.Adapter<R3ZoneMostPopularAdapter.ViewR3ZoneAdapter>
{

    private ArrayList<R3ZoneMostPopularModule> r3_zone_most_popular_modules;
    private Context context;


    public R3ZoneMostPopularAdapter(ArrayList<R3ZoneMostPopularModule> c_r3_zone_most_popular_modules, Context c_ctx){
        this.r3_zone_most_popular_modules     = c_r3_zone_most_popular_modules;
        this.context                          = c_ctx;
    }

    @Override
    public R3ZoneMostPopularAdapter.ViewR3ZoneAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.csr_init_single_item, parent, false);
        R3ZoneMostPopularAdapter.ViewR3ZoneAdapter avh = new R3ZoneMostPopularAdapter.ViewR3ZoneAdapter(v, context, r3_zone_most_popular_modules);
        return avh;
    }

    @Override
    public void onBindViewHolder(R3ZoneMostPopularAdapter.ViewR3ZoneAdapter holder, int position) {

        holder.v_txtView.setText(r3_zone_most_popular_modules.get(position).getModule_name());
        Picasso.with(context).load(r3_zone_most_popular_modules.get(position).getModule_icon_id()).into(holder.v_imageView);

    }

    @Override
    public int getItemCount() {
        return r3_zone_most_popular_modules.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    class ViewR3ZoneAdapter extends RecyclerView.ViewHolder implements View.OnClickListener{


        //  public TextView v_txtView;
        public ImageView v_imageView;
        public TextView v_txtView;
        public CardView v_cardView;
        public Context   v_ctx;
        public ArrayList<R3ZoneMostPopularModule> v_most_popular_modules = new ArrayList<R3ZoneMostPopularModule>();

        public ViewR3ZoneAdapter(View itemView, Context c_ctx, ArrayList<R3ZoneMostPopularModule> c_r3_zone_most_popular_modules) {
            super(itemView);
            v_txtView   = (TextView) itemView.findViewById(R.id.csrInitTxtView);
            v_imageView = (ImageView) itemView.findViewById(R.id.csrInitImageView);
            v_cardView  = (CardView) itemView.findViewById(R.id.csrInitCard);

            //Getting Screen Size
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowmanager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
            int deviceWidth = displayMetrics.widthPixels;
            int deviceHeight = displayMetrics.heightPixels;

            //setting cardsize
            v_cardView.getLayoutParams().height = (deviceHeight * 43)/100;

            v_imageView.setY((deviceHeight * 10)/100);
            v_imageView.setX((deviceHeight * 2) / 100);

            v_imageView.getLayoutParams().height = (deviceHeight * 120)/100;
            v_imageView.getLayoutParams().width  = (deviceHeight * 22)/100;

            v_txtView.setTextColor(context.getResources().getColor(R.color.colorPrimary));


            this.v_ctx                  = c_ctx;
            this.v_most_popular_modules = c_r3_zone_most_popular_modules;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {


        }

    }
}


