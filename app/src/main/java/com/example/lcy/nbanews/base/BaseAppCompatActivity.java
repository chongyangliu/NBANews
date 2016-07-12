package com.example.lcy.nbanews.base;

import android.os.Bundle;

import butterknife.ButterKnife;
import lib.SwipeBackLayout;
import lib.app.SwipeBackActivity;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-7-12.
 */
public abstract class BaseAppCompatActivity extends SwipeBackActivity {
    private SwipeBackLayout mSwipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        mSwipeBackLayout = getSwipeBackLayout();
        setSwipeBackEnable(swipeBackEnable());
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        initViewsAndDatas(savedInstanceState);
    }

    protected abstract boolean swipeBackEnable();

    protected abstract void initViewsAndDatas(Bundle savedInstanceState);

    protected abstract int getContentViewId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
