package pumpkin.kr.hanbat;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import java.util.ArrayList;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;
import pumpkin.kr.hanbat.adapter.BasicPagerAdapter;
import pumpkin.kr.hanbat.base.BaseActivity;
import pumpkin.kr.hanbat.base.BaseFragment;
import pumpkin.kr.hanbat.common.Utils;
import pumpkin.kr.hanbat.view.ZoomOutPageTransformer;

public class MainActivity extends BaseActivity {
    private static final int PAGE_CALENDAR = 0;
    private static final int PAGE_MAP = 1;
    private static final int PAGE_NOTIFICATION = 2;

    private MaterialTabHost mTabHost;
    private ViewPager mViewPager;
    private BasicPagerAdapter mPagerAdapter;
    private ArrayList<BaseFragment> mFragments;
    private int mCurrPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTab();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        if(mCurrPage == PAGE_NOTIFICATION) {
            if(!mFragments.get(mCurrPage).onBackPressed()) {
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }

    private void initTab() {
        mFragments = new ArrayList<>();
        mFragments.add(CalendarFragment.create());
        mFragments.add(MapFragment.create());
        mFragments.add(NotificationFragment.create());

        mTabHost = (MaterialTabHost)findViewById(R.id.tab_host);
        mTabHost.setPrimaryColor(Color.WHITE);
        mTabHost.setTextColor(Color.argb(255, 0, 0, 0));
        mTabHost.setAccentColor(Color.argb(255, 236, 139, 12));

        mViewPager = (ViewPager)findViewById(R.id.view_pager);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mPagerAdapter = new BasicPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Utils.Log("onPageSelected() position: " + position);
                mTabHost.setSelectedNavigationItem(position);
                mCurrPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        for(int i=0; i<mPagerAdapter.getCount(); i++) {
            mTabHost.addTab(mTabHost.newTab().setText(mPagerAdapter.getPageTitle(i)).setTabListener(new MaterialTabListener() {
                @Override
                public void onTabSelected(MaterialTab tab) {
                    int pos = tab.getPosition();
                    Utils.Log("onTabSelected() tab.getPosition(): " + pos);
                    mViewPager.setCurrentItem(pos);
                }

                @Override
                public void onTabReselected(MaterialTab tab) {

                }

                @Override
                public void onTabUnselected(MaterialTab tab) {

                }
            }));
        }
    }
}
