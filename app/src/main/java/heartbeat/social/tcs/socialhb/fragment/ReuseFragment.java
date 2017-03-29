package heartbeat.social.tcs.socialhb.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import heartbeat.social.tcs.socialhb.R;
import heartbeat.social.tcs.socialhb.activity.modules.sub_modules.ViewReuseTips;

/**
 * Created by admin on 27/07/16.
 */
public class ReuseFragment extends Fragment
{

    Button btnViewReuseTips;

    public ReuseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_reuse, container, false);

        btnViewReuseTips = (Button) rootView.findViewById(R.id.viewReuseTips);

        btnViewReuseTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), ViewReuseTips.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
