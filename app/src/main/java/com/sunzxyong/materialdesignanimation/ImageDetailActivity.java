package com.sunzxyong.materialdesignanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

/**
 * Created by 晓勇 on 2015/8/27 0027.
 */
public class ImageDetailActivity extends AppCompatActivity {
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_iamge_detail);
        mImageView = (ImageView) findViewById(R.id.imageView);
        getWindow().setEnterTransition(new Slide());
    }
    public void click(View view){
        finishAfterTransition();
    }

}
