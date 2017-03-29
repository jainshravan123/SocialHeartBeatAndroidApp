package heartbeat.social.tcs.socialhb.activity.modules;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.ArrayList;

import heartbeat.social.tcs.socialhb.R;
import heartbeat.social.tcs.socialhb.activity.modules.sub_modules.R3ZoneModules;
import heartbeat.social.tcs.socialhb.bean.CSRInit;

import static heartbeat.social.tcs.socialhb.R.id.prgBar1;
import static heartbeat.social.tcs.socialhb.R.id.recyclerView1;
import static heartbeat.social.tcs.socialhb.R.id.toolbar;

public class R3Zone extends AppCompatActivity {




    private Toolbar toolbar;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r3_zone);

        toolbar  = (Toolbar) findViewById(R.id.toolbar);
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

        btn1 = (Button) findViewById(R.id.r3ZoneButton);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), R3ZoneModules.class);
                startActivity(intent);
            }
        });

    }
}
