package pumpkin.kr.hanbat.navermap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nhn.android.mapviewer.NMapFragment;

import pumpkin.kr.hanbat.R;

public class Fragment1 extends NMapFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment1, container, false);
	}
}