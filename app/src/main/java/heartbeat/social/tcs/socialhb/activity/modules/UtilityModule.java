package heartbeat.social.tcs.socialhb.activity.modules;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
import heartbeat.social.tcs.socialhb.activity.modules.sub_modules.WasteToWealth;
import heartbeat.social.tcs.socialhb.adapter.CSRInitAdapter;
import heartbeat.social.tcs.socialhb.adapter.UtilityCatAdapter;
import heartbeat.social.tcs.socialhb.bean.CSRInit;
import heartbeat.social.tcs.socialhb.bean.UtilityCategory;
import heartbeat.social.tcs.socialhb.bean.Web_API_Config;
import heartbeat.social.tcs.socialhb.network.CheckInternetConnection;
import heartbeat.social.tcs.socialhb.utility.CSRInitModuleSelector;

import static heartbeat.social.tcs.socialhb.R.id.prgBar1;
import static heartbeat.social.tcs.socialhb.R.id.recyclerView1;
import static heartbeat.social.tcs.socialhb.R.id.start;

public class UtilityModule extends AppCompatActivity {



    private Toolbar toolbar;
    private Button  goToWasteToWealthBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utility_module);



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        goToWasteToWealthBtn = (Button) findViewById(R.id.goToWasteToWealthBtn);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("Utilities");


        goToWasteToWealthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WasteToWealth.class);
                startActivity(intent);
            }
        });

    }

}
