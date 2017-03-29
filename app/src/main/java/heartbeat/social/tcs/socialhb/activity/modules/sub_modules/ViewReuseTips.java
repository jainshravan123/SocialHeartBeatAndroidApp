package heartbeat.social.tcs.socialhb.activity.modules.sub_modules;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import heartbeat.social.tcs.socialhb.R;
import heartbeat.social.tcs.socialhb.adapter.ViewPagerAdapter;
import heartbeat.social.tcs.socialhb.fragment.DonateBooksFragment;
import heartbeat.social.tcs.socialhb.fragment.DonateClothFragment;
import heartbeat.social.tcs.socialhb.fragment.DonateEWasteFragment;
import heartbeat.social.tcs.socialhb.fragment.DonateFoodFragment;
import heartbeat.social.tcs.socialhb.fragment.WasteElectronicFragment;
import heartbeat.social.tcs.socialhb.fragment.WasteFoodFragment;
import heartbeat.social.tcs.socialhb.fragment.WasteMedicalFragment;
import heartbeat.social.tcs.socialhb.fragment.WastePlasticFragment;

public class ViewReuseTips extends AppCompatActivity {


    Toolbar          toolbar;
    TabLayout        tipsTabLayout;
    ViewPager        tipViewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reuse_tips);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("Reuse Tips");

        tipsTabLayout = (TabLayout)findViewById(R.id.tipsTabLayout);
        tipViewPager = (ViewPager)findViewById(R.id.tipViewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new WastePlasticFragment(), "Plastic");
        viewPagerAdapter.addFragments(new WasteElectronicFragment(), "E-waste");
        viewPagerAdapter.addFragments(new WasteFoodFragment(), "Food");
        viewPagerAdapter.addFragments(new WasteMedicalFragment(), "Medical");
        tipViewPager.setAdapter(viewPagerAdapter);
        tipsTabLayout.setupWithViewPager(tipViewPager);
    }
}
