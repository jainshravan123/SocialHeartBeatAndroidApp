package heartbeat.social.tcs.socialhb.activity.modules.sub_modules.R3ZoneModule;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import heartbeat.social.tcs.socialhb.R;
import heartbeat.social.tcs.socialhb.adapter.R3ZoneModuleAdapter;
import heartbeat.social.tcs.socialhb.adapter.R3ZoneMostPopularAdapter;
import heartbeat.social.tcs.socialhb.bean.R3ZoneModule;
import heartbeat.social.tcs.socialhb.bean.R3ZoneMostPopularModule;
import heartbeat.social.tcs.socialhb.bean.Web_API_Config;
import heartbeat.social.tcs.socialhb.network.CheckInternetConnection;
import heartbeat.social.tcs.socialhb.utility.R3ZoneModuleSelector;
import heartbeat.social.tcs.socialhb.utility.R3ZoneMostPopularModuleSelector;

public class R3ZoneMostPopular extends AppCompatActivity {

    ProgressBar                prgBar1;
    RecyclerView               recyclerView1;
    Toolbar                    toolbar;
    DrawerLayout               mDrawerLayout;
    ArrayList<R3ZoneMostPopularModule>    r3ZoneMostPopularModules;
    StaggeredGridLayoutManager mStaggeredLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r3_zone_most_popular);

        mDrawerLayout        = (DrawerLayout) findViewById(R.id.drawer_layout);
        prgBar1              = (ProgressBar) findViewById(R.id.prgBar1);
        recyclerView1        = (RecyclerView) findViewById(R.id.recycleView1);
        toolbar              = (Toolbar) findViewById(R.id.toolbar);
        r3ZoneMostPopularModules        = new ArrayList<R3ZoneMostPopularModule>();
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getSupportActionBar().setTitle("R3 Zone Most Popular");

        //Checking Internet Connection
        CheckInternetConnection checkInternetConnection = new CheckInternetConnection();
        checkInternetConnection.showNetworkIdentifier(getApplicationContext(), R3ZoneMostPopular.this);

        if(checkInternetConnection.checkingInternetConnection(getApplicationContext())){
            //Getting Most Popular Modules by hitting REST Web Service
            getR3ZoneMostPopularModules();
        }
        else{
            prgBar1.setVisibility(View.GONE);
        }

    }


    private void getR3ZoneMostPopularModules(){


        prgBar1.setVisibility(View.VISIBLE);

        String url = Web_API_Config.r3_zone_most_popular_categories;


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        prgBar1.setVisibility(View.GONE);
                        recyclerView1.setVisibility(View.VISIBLE);

                        try {


                            for (int i = 0; i < response.length(); i++) {
                                JSONObject s_module  = (JSONObject) response.get(i);
                                int module_id        = s_module.getInt("id");
                                String module_name   = s_module.getString("name");
                                String module_icon   = s_module.getString("icon");
                                int module_status    = s_module.getInt("status");

                                R3ZoneMostPopularModuleSelector r3ZoneMostPopularModuleSelector = new R3ZoneMostPopularModuleSelector();
                                String imageName = r3ZoneMostPopularModuleSelector.getModuleNameByModuleId(module_id);
                                String uri = "@drawable/"+imageName.toLowerCase();
                                int imageResource = getApplicationContext().getResources().getIdentifier(uri, null, getApplicationContext().getPackageName());

                                R3ZoneMostPopularModule r3ZoneMostPopularModule = new R3ZoneMostPopularModule();
                                r3ZoneMostPopularModule.setId(module_id);
                                r3ZoneMostPopularModule.setModule_icon(module_icon);
                                r3ZoneMostPopularModule.setModule_name(module_name);
                                r3ZoneMostPopularModule.setModule_status(module_status);
                                r3ZoneMostPopularModule.setModule_icon_id(imageResource);

                                if(r3ZoneMostPopularModule.getModule_status() == 1){
                                    r3ZoneMostPopularModules.add(r3ZoneMostPopularModule);
                                }

                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });


        Volley.newRequestQueue(this).add(jsonArrayRequest);



        recyclerView1.setHasFixedSize(true);
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredLayoutManager.setSpanCount(2);
        recyclerView1.setLayoutManager(mStaggeredLayoutManager);

        R3ZoneMostPopularAdapter r3ZoneMostPopularAdapter = new R3ZoneMostPopularAdapter(r3ZoneMostPopularModules, getApplicationContext());

        recyclerView1.setAdapter(r3ZoneMostPopularAdapter);

    }
}
