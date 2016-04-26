package pumpkin.kr.hanbat.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import pumpkin.kr.hanbat.base.BaseFragment;

/**
 * Created by farid on 2016-04-25.
 */
public class BasicPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> mFragments;

    public BasicPagerAdapter(FragmentManager fm, ArrayList<BaseFragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getArguments().get("TITLE") + "";
    }
}
