package heartbeat.social.tcs.socialhb.activity.nav_drawer_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import heartbeat.social.tcs.socialhb.R;

public class Contribution extends AppCompatActivity {

    private CardView cv23;
    private TextView txt_heartbeat_index, txt_donation, txt_activities_participated;
    private ProgressBar prgBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contribution);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("Social Heartbeat Details");


        cv23 = (CardView) findViewById(R.id.cv23);
        txt_heartbeat_index = (TextView) findViewById(R.id.txt_heartbeat_index);
        txt_donation        = (TextView) findViewById(R.id.txt_donation);
        txt_activities_participated = (TextView) findViewById(R.id.txt_activities_participated);
        prgBar = (ProgressBar) findViewById(R.id.prgBar);

        showData();


    }

    private void showData(){
        prgBar.setVisibility(View.GONE);
        cv23.setVisibility(View.VISIBLE);
        txt_heartbeat_index.setText("11");
        txt_donation.setText("06");
        txt_activities_participated.setText("07");
    }
}
