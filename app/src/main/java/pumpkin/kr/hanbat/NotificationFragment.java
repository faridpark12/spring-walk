package pumpkin.kr.hanbat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import pumpkin.kr.hanbat.base.BaseFragment;

/**
 * Created by farid on 2016-04-25.
 */
public class NotificationFragment extends BaseFragment {
    private WebView mWebView;

    public static NotificationFragment create() {
        NotificationFragment fragment = new NotificationFragment();
        Bundle args = new Bundle();

        args.putString("TITLE", "공지");
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
        return inflater.inflate(R.layout.fragment_noti, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mWebView = (WebView)view.findViewById(R.id.web_view);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("http://m.hanbat.ac.kr/_prog/bbs_list/?code=bachelor");
    }

    @Override
    public boolean onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        } else {
            return false;
        }
    }
}
