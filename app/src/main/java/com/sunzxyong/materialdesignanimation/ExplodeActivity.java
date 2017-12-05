package com.sunzxyong.materialdesignanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by 晓勇 on 2015/8/28 0028.
 */
public class ExplodeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explode);

        Explode mExplode = new Explode();
        mExplode.setDuration(2000);
        getWindow().setExitTransition(mExplode);
        getWindow().setEnterTransition(mExplode);

        TextView mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAfterTransition();
            }
        });
    }
}
