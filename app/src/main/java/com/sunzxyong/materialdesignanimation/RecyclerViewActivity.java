package com.sunzxyong.materialdesignanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 晓勇 on 2015/8/28 0028.
 */
public class RecyclerViewActivity extends AppCompatActivity implements RecyclerViewAdapter.OnItemClickListener {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(getDatas());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
    }

    private List<String> getDatas() {
        List<String> lists = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i == 2) {
                lists.add("Slide侧滑动画");
                continue;
            }
            if (i == 3) {
                lists.add("Explode展开动画");
                continue;
            }
            if (i == 4) {
                lists.add("Fade渐显渐隐动画");
                continue;
            }
            lists.add(i + "");
        }
        return lists;
    }

    @Override
    public void onItemClick(View view, int position) {
        switch (position) {
            case 2:
                Slide mSlide = new Slide();
                mSlide.setDuration(2000);

                getWindow().setExitTransition(mSlide);
                getWindow().setEnterTransition(mSlide);

                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(RecyclerViewActivity.this);
                Intent intent = new Intent(RecyclerViewActivity.this, SlideActivity.class);
                startActivity(intent, optionsCompat.toBundle());
                break;
            case 3:
                Explode mExplode = new Explode();
                mExplode.setDuration(2000);

                getWindow().setExitTransition(mExplode);
                getWindow().setEnterTransition(mExplode);

                ActivityOptionsCompat optionsCompat2 = ActivityOptionsCompat.makeSceneTransitionAnimation(RecyclerViewActivity.this);
                Intent intent2 = new Intent(RecyclerViewActivity.this, ExplodeActivity.class);
                startActivity(intent2, optionsCompat2.toBundle());
                break;
            case 4:
                Fade mFade = new Fade();
                mFade.setDuration(2000);

                getWindow().setExitTransition(mFade);
                getWindow().setEnterTransition(mFade);

                ActivityOptionsCompat optionsCompat3 = ActivityOptionsCompat.makeSceneTransitionAnimation(RecyclerViewActivity.this);
                Intent intent3 = new Intent(RecyclerViewActivity.this, FadeActivity.class);
                startActivity(intent3, optionsCompat3.toBundle());
                break;
        }
    }
}
