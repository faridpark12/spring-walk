package pumpkin.kr.hanbat.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import pumpkin.kr.hanbat.common.Utils;

/**
 * Created by farid on 2016-04-25.
 */
public abstract class BaseFragment extends Fragment {
    public BaseActivity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (BaseActivity)getActivity();
    }
    public abstract boolean onBackPressed();
}
