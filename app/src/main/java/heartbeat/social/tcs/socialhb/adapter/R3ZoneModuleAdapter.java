package heartbeat.social.tcs.socialhb.adapter;

import android.content.Context;
import android.content.Intent;
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
import heartbeat.social.tcs.socialhb.activity.modules.sub_modules.CSRInitCategoryDescription;
import heartbeat.social.tcs.socialhb.bean.CSRInit;
import heartbeat.social.tcs.socialhb.bean.R3ZoneModule;

/**
 * Created by admin on 19/02/17.
 */

public class R3ZoneModuleAdapter extends RecyclerView.Adapter<R3ZoneModuleAdapter.ViewR3ZoneAdapter>
{

    private ArrayList<R3ZoneModule> r3_zone_modules;
    private Context context;


    public R3ZoneModuleAdapter(ArrayList<R3ZoneModule> c_r3_zone_modules, Context c_ctx){
        this.r3_zone_modules     = c_r3_zone_modules;
        this.context             = c_ctx;
    }

    @Override
    public R3ZoneModuleAdapter.ViewR3ZoneAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.csr_init_single_item, parent, false);
        R3ZoneModuleAdapter.ViewR3ZoneAdapter avh = new R3ZoneModuleAdapter.ViewR3ZoneAdapter(v, context, r3_zone_modules);
        return avh;
    }

    @Override
    public void onBindViewHolder(R3ZoneModuleAdapter.ViewR3ZoneAdapter holder, int position) {
        holder.v_txtView.setText(r3_zone_modules.get(position).getModule_name());


        Log.e("Module Image Path : ", r3_zone_modules.get(position).getModule_icon());
        //Picasso.with(context).load(Web_API_Config.root_image_url + modules.get(position).getImage()).error(R.drawable.image_loading_error).into(holder.v_imageView);

        //Picasso.with(context).load("http://"+modules.get(position).getImage()).into(holder.v_imageView);
        //holder.v_imageView.setImageResource(modules.get(position).getImageId());
        Picasso.with(context).load(r3_zone_modules.get(position).getModule_icon_id()).into(holder.v_imageView);


    }

    @Override
    public int getItemCount() {
        return r3_zone_modules.size();
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
        public ArrayList<R3ZoneModule> v_modules = new ArrayList<R3ZoneModule>();

        public ViewR3ZoneAdapter(View itemView, Context c_ctx, ArrayList<R3ZoneModule> c_r3_zone_modules) {
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


            this.v_ctx     = c_ctx;
            this.v_modules = c_r3_zone_modules;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

           /* int position = getAdapterPosition();

            int    module_id   = v_modules.get(position).getCsr_module_id();
            String module_name = v_modules.get(position).getCsr_module_name();
*/


          /*  ModuleSelector moduleSelector =  new ModuleSelector();
            String pack_name              =  "heartbeat.social.tcs.socialhb.activity.modules.";
            String main_module_name       =  moduleSelector.getClassNameByModuleId(module_id);

            String cmplt_module_name      = pack_name.concat(main_module_name);


            Intent intent = null;
            try {
                intent = new Intent(this.v_ctx, Class.forName(cmplt_module_name));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                this.v_ctx.startActivity(intent);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }*/

            /*Intent desc_intent = new Intent(context, CSRInitCategoryDescription.class);
            desc_intent.putExtra("module_id", String.valueOf(module_id));
            desc_intent.putExtra("module_name", module_name);
            desc_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.v_ctx.startActivity(desc_intent);*/
        }

    }
}


