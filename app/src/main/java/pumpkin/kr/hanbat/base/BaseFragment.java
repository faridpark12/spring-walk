package pumpkin.kr.hanbat.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import pumpkin.kr.hanbat.common.Utils;

/**
 * Created by farid on 2016-04-25.
 */
public abstract class BaseFragment extends Fragment {
    public abstract boolean onBackPressed();
}
