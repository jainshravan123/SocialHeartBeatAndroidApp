package heartbeat.social.tcs.socialhb.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import heartbeat.social.tcs.socialhb.R;
import heartbeat.social.tcs.socialhb.activity.modules.sub_modules.DonateItem;
import heartbeat.social.tcs.socialhb.activity.modules.sub_modules.ViewStatus;
import heartbeat.social.tcs.socialhb.adapter.WasteItemAdapter;
import heartbeat.social.tcs.socialhb.bean.TipCategory;
import heartbeat.social.tcs.socialhb.bean.TipDescription;
import heartbeat.social.tcs.socialhb.bean.Web_API_Config;

import android.support.v4.app.Fragment;
import android.widget.ProgressBar;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by admin on 21/01/17.
 */

public class WasteFoodFragment extends Fragment{

    private RecyclerView recyclerView1;
    private ProgressBar prgBar1;
    private CardView cv3;
    private ArrayList<TipDescription> tipDescriptionArrayList;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;


    public WasteFoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_waste_food, container, false);
        cv3 = (CardView) rootView.findViewById(R.id.cv3);
        recyclerView1 = (RecyclerView) rootView.findViewById(R.id.recyclerView1);
        prgBar1       = (ProgressBar) rootView.findViewById(R.id.prgBar1);

        tipDescriptionArrayList = new ArrayList<TipDescription>();

        getTipsData();
        return rootView;
    }


    private void getTipsData()
    {

        String url = Web_API_Config.tips_according_to_category+"7";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {


                            for (int i = 0; i < response.length(); i++) {
                                JSONObject s_module        = (JSONObject) response.get(i);
                                int id                     = s_module.getInt("id");
                                String data_item           = s_module.getString("data_item");
                                String data_item_heading   = s_module.getString("data_item_heading");
                                int cat_id                 = s_module.getInt("category_id");

                                TipDescription tipDescription = new TipDescription();
                                TipCategory tipCategory  = new TipCategory();
                                tipDescription.setId(id);
                                tipDescription.setTip_heading(data_item_heading);
                                tipDescription.setTip_description(data_item);
                                tipCategory.setId(cat_id);
                                tipDescription.setTipCategory(tipCategory);

                                tipDescriptionArrayList.add(tipDescription);

                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }

                        showData();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });


        Volley.newRequestQueue(getActivity()).add(jsonArrayRequest);

    }


    private void showData(){

        prgBar1.setVisibility(View.GONE);
        cv3.setVisibility(View.VISIBLE);
        recyclerView1.setVisibility(View.VISIBLE);

        recyclerView1.setHasFixedSize(true);
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredLayoutManager.setSpanCount(1);
        recyclerView1.setLayoutManager(mStaggeredLayoutManager);

        WasteItemAdapter wasteItemAdapter = new WasteItemAdapter(tipDescriptionArrayList, getActivity());

        recyclerView1.setAdapter(wasteItemAdapter);
    }
}
