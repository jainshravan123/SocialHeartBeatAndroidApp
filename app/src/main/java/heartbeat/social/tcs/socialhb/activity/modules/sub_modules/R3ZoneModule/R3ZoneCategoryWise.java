package heartbeat.social.tcs.socialhb.activity.modules.sub_modules.R3ZoneModule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import heartbeat.social.tcs.socialhb.R;

public class R3ZoneCategoryWise extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r3_zone_category_wise);

        toolbar              = (Toolbar) findViewById(R.id.toolbar);
        this.setToolBar(toolbar, "R3 Zone Categories");

    }

    private void setToolBar(Toolbar toolBar, String tool_bar_title) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle(tool_bar_title);
    }
}
