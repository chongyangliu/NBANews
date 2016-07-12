package com.example.lcy.nbanews.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-7-12.
 */
public class MyFragmentPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> mDatas;
    private List<String> mTitles;
    public MyFragmentPageAdapter(FragmentManager fm, List<Fragment> datas, List<String> titles) {
        super(fm);
        mDatas = datas;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
