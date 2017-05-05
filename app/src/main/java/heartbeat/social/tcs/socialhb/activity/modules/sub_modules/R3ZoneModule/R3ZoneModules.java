package heartbeat.social.tcs.socialhb.activity.modules.sub_modules.R3ZoneModule;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
import heartbeat.social.tcs.socialhb.bean.R3ZoneModule;
import heartbeat.social.tcs.socialhb.bean.Web_API_Config;
import heartbeat.social.tcs.socialhb.network.CheckInternetConnection;
import heartbeat.social.tcs.socialhb.utility.R3ZoneModuleSelector;

public class R3ZoneModules extends AppCompatActivity {


    ProgressBar prgBar1;
    RecyclerView recyclerView1;
    Toolbar toolbar;
    DrawerLayout mDrawerLayout;
    ArrayList<R3ZoneModule> r3ZoneModules;
    StaggeredGridLayoutManager mStaggeredLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r3_zone_modules);


        mDrawerLayout        = (DrawerLayout) findViewById(R.id.drawer_layout);
        prgBar1              = (ProgressBar) findViewById(R.id.prgBar1);
        recyclerView1        = (RecyclerView) findViewById(R.id.recycleView1);
        toolbar              = (Toolbar) findViewById(R.id.toolbar);
        r3ZoneModules        = new ArrayList<R3ZoneModule>();
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getSupportActionBar().setTitle("R3 Zone");

        //Checking Internet Connection
        CheckInternetConnection checkInternetConnection = new CheckInternetConnection();
        checkInternetConnection.showNetworkIdentifier(getApplicationContext(), R3ZoneModules.this);

        if(checkInternetConnection.checkingInternetConnection(getApplicationContext())){
            //Getting Modules by hitting REST Web Service
            getR3ZoneModules();
        }
        else{
            prgBar1.setVisibility(View.GONE);
        }

    }


    public void getR3ZoneModules(){

        prgBar1.setVisibility(View.VISIBLE);

        String url = Web_API_Config.r3_zone_modules_api;
        Log.e("CSR Initiative URL", url);


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
                                String module_name   = s_module.getString("module_name");
                                String module_icon   = s_module.getString("module_icon");
                                int module_status    = s_module.getInt("status");

                                R3ZoneModuleSelector r3ZoneModuleSelector = new R3ZoneModuleSelector();
                                String imageName = r3ZoneModuleSelector.getModuleNameByModuleId(module_id);
                                String uri = "@drawable/"+imageName.toLowerCase();
                                int imageResource = getApplicationContext().getResources().getIdentifier(uri, null, getApplicationContext().getPackageName());

                                R3ZoneModule r3ZoneModule = new R3ZoneModule();
                                r3ZoneModule.setId(module_id);
                                r3ZoneModule.setModule_icon(module_icon);
                                r3ZoneModule.setModule_name(module_name);
                                r3ZoneModule.setModule_status(module_status);
                                r3ZoneModule.setModule_icon_id(imageResource);

                                if(r3ZoneModule.getModule_status() == 1){
                                    r3ZoneModules.add(r3ZoneModule);
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

        R3ZoneModuleAdapter r3ZoneModuleAdapter = new R3ZoneModuleAdapter(r3ZoneModules, getApplicationContext());

        recyclerView1.setAdapter(r3ZoneModuleAdapter);

    }

}
