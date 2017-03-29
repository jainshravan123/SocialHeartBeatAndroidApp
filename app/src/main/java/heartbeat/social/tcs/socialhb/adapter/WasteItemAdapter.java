package heartbeat.social.tcs.socialhb.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import heartbeat.social.tcs.socialhb.R;
import heartbeat.social.tcs.socialhb.bean.CSRInitCatData;
import heartbeat.social.tcs.socialhb.bean.TipDescription;

/**
 * Created by admin on 21/01/17.
 */

public class WasteItemAdapter  extends RecyclerView.Adapter<WasteItemAdapter.ViewWasteItemAdapter>{


    private ArrayList<TipDescription> tips_data_list;
    private Context context;


    public WasteItemAdapter(ArrayList<TipDescription> c_tips_data, Context c_ctx){
        this.tips_data_list   = c_tips_data;
        this.context          = c_ctx;
    }


    @Override
    public ViewWasteItemAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.waste_fragment_item, parent, false);
        WasteItemAdapter.ViewWasteItemAdapter avh = new WasteItemAdapter.ViewWasteItemAdapter(v, context, tips_data_list);
        return avh;
    }

    @Override
    public void onBindViewHolder(ViewWasteItemAdapter holder, int position) {

        holder.v_data_heading_txtView.setText(tips_data_list.get(position).getTip_heading());
        holder.v_data_desc_txtView.setText(tips_data_list.get(position).getTip_description());

    }

    @Override
    public int getItemCount() {
        return tips_data_list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    class ViewWasteItemAdapter extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView v_data_heading_txtView, v_data_desc_txtView;
        public CardView v_cardView;
        public Context  v_ctx;
        public ArrayList<TipDescription> v_tips_data = new ArrayList<TipDescription>();

        public ViewWasteItemAdapter(View itemView, Context c_ctx, ArrayList<TipDescription> c_tips_data) {
            super(itemView);
            v_data_heading_txtView    = (TextView) itemView.findViewById(R.id.catDataHeadingTxtView);
            v_data_desc_txtView       = (TextView) itemView.findViewById(R.id.catDataTxtView);
            v_cardView               = (CardView) itemView.findViewById(R.id.cv2);
            this.v_ctx               = c_ctx;
            this.v_tips_data         = c_tips_data;



            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {


        }

    }
}
