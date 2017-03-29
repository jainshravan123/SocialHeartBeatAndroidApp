package heartbeat.social.tcs.socialhb.activity.modules.quiz_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import heartbeat.social.tcs.socialhb.R;
import heartbeat.social.tcs.socialhb.activity.modules.GEOModule;
import heartbeat.social.tcs.socialhb.activity.modules.HeartBeatIndexModule;
import heartbeat.social.tcs.socialhb.activity.modules.sub_modules.CSRInitCategoryDescription;
import heartbeat.social.tcs.socialhb.activity.modules.sub_modules.FactsList;
import heartbeat.social.tcs.socialhb.bean.CSRInit;
import heartbeat.social.tcs.socialhb.bean.QuizScore;
import heartbeat.social.tcs.socialhb.bean.Web_API_Config;

public class QuizResultActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button button1, button2, button3;
    TextView txt_quiz_highest_score, txt_quiz_interest;
    ProgressBar progressBar;
    LinearLayout linearLayout2, linearLayout3;
    QuizScore quizScore;
    CSRInit csrInit;
    ImageView background_image_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        Intent intent1 = getIntent();
        String score = intent1.getStringExtra("score");
        String area_of_interest = intent1.getStringExtra("area_of_interest");

        quizScore = new QuizScore();
        quizScore.setScore(Integer.parseInt(score));
        quizScore.setArea_of_interest_cat_id(Integer.parseInt(area_of_interest));

        toolbar  = (Toolbar) findViewById(R.id.toolbar);
        button1  = (Button) findViewById(R.id.button1);
        button2  = (Button) findViewById(R.id.button2);
        button3  = (Button) findViewById(R.id.button3);
        txt_quiz_highest_score = (TextView) findViewById(R.id.txt_quiz_highest_score);
        txt_quiz_interest      = (TextView) findViewById(R.id.txt_quiz_interest);
        progressBar            = (ProgressBar) findViewById(R.id.prgBar);
        linearLayout2          = (LinearLayout) findViewById(R.id.linearLayout2);
        linearLayout3          = (LinearLayout) findViewById(R.id.linearLayout3);
        background_image_view  = (ImageView) findViewById(R.id.background_image_view);

        csrInit = new CSRInit();

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quizStartIntent = new Intent(getApplicationContext(), HeartBeatIndexModule.class);
                startActivity(quizStartIntent);
            }
        });
        getSupportActionBar().setTitle("Quiz Result");


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), HeartBeatIndexModule.class);
                startActivity(intent1);
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Intent intent2 = new Intent(getApplicationContext(), FactsList.class);
                intent2.putExtra("selected_city", String.valueOf(1));
                intent2.putExtra("selected_aoi",  String.valueOf(csrInit.getCsr_module_id()));
                startActivity(intent2);*/

                Intent intent1 = new Intent(getApplicationContext(), GEOModule.class);
                startActivity(intent1);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent desc_intent = new Intent(getApplicationContext(), CSRInitCategoryDescription.class);
                desc_intent.putExtra("module_id", String.valueOf(csrInit.getCsr_module_id()));
                desc_intent.putExtra("module_name", csrInit.getCsr_module_name());
                startActivity(desc_intent);
            }
        });

        getAreaOfInterest();
    }

    public void getAreaOfInterest(){

        String uri = Web_API_Config.csr_init_single_module+String.valueOf(quizScore.getArea_of_interest_cat_id());

        //Create JSONObjectRequest for Volley
        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, uri, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        // the response is already constructed as a JSONObject!
                        //sAlertDialog.dismiss();

                        try {
                            csrInit.setCsr_module_id(response.getInt("id"));
                            csrInit.setCsr_module_name(response.getString("cat"));
                            csrInit.setCsr_module_status(response.getInt("status"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        showViews();

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);



    }

    public void showViews(){
        linearLayout2.setVisibility(View.VISIBLE);
        linearLayout3.setVisibility(View.VISIBLE);
        background_image_view.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);

        txt_quiz_highest_score.setText(String.valueOf(quizScore.getScore()));
        txt_quiz_interest.setText(String.valueOf(csrInit.getCsr_module_name()));
    }
}
