package pumpkin.kr.hanbat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pumpkin.kr.hanbat.base.BaseFragment;
import pumpkin.kr.hanbat.common.Utils;

/**
 * Created by farid on 2016-04-25.
 */
public class CalendarFragment extends BaseFragment {
    public static CalendarFragment create() {
        CalendarFragment fragment = new CalendarFragment();
        Bundle args = new Bundle();

        args.putString("TITLE", "일정");
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calendar, container, false);
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}
