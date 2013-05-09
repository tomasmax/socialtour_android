package com.socialtour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.example.socialtour.R;
import com.google.android.gms.maps.SupportMapFragment;

public class PoiFragment extends SherlockFragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_user_profile, container,
				false);

		// Inflate the layout for this fragment
		return root;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		SupportMapFragment f = (SupportMapFragment) getFragmentManager()
				.findFragmentById(R.id.poiMapFragment);
		if (f != null)
			getFragmentManager().beginTransaction().remove(f).commit();
	}

}
