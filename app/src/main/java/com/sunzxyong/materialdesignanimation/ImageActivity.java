package com.sunzxyong.materialdesignanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

/**
 * Created by 晓勇 on 2015/8/27 0027.
 */
public class ImageActivity extends AppCompatActivity {
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laytout_image);
        Slide mSlide = new Slide();
        mSlide.setInterpolator(new AccelerateInterpolator());
        mSlide.setSlideEdge(Gravity.TOP);
        getWindow().setEnterTransition(mSlide);
        getWindow().setExitTransition(new Explode());
        mImageView = (ImageView) findViewById(R.id.imageView);
    }

    public void click(View view) {
//        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, mImageView, "sunzxyong");
//        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,Pair.create((View)mImageView, "s"), Pair.create((View)mImageView, "s"));
//        ActivityOptionsCompat options = ActivityOptionsCompat.makeScaleUpAnimation(mImageView,mImageView.getWidth()/2,mImageView.getHeight()/2,0,0);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, ImageDetailActivity.class);
        startActivity(intent,options.toBundle());
    }
}
