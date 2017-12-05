package com.sunzxyong.materialdesignanimation;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton3 = (Button) findViewById(R.id.button3);
        mButton4 = (Button) findViewById(R.id.button4);
        mButton5 = (Button) findViewById(R.id.button5);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
            }
        });

        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator mAnimator = ViewAnimationUtils.createCircularReveal(mButton4, mButton4.getWidth() / 2, mButton4.getHeight() / 2, 0, mButton4.getHeight());
                mAnimator.setDuration(2000);
                mAnimator.setInterpolator(new AccelerateInterpolator());
                mAnimator.start();
            }
        });
        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float endRadius = (float) Math.hypot(mButton5.getWidth(), mButton5.getHeight());//勾股定理得到斜边长度
                Animator mAnimator = ViewAnimationUtils.createCircularReveal(mButton5, mButton5.getWidth(), 0, 0, endRadius);
                mAnimator.setDuration(2000);
                mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                mAnimator.start();
            }
        });

    }


}
