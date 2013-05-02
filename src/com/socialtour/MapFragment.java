package com.socialtour;

import com.example.socialtour.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockMapFragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

public class MapFragment extends SherlockMapFragment {
	private GoogleMap map;
	
    @Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.map_fragment, container, false);
        //map = getMap();
        //return root;
        
		//get layout map
		map = ((SupportMapFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.mapFragmentView)).getMap();
		
		// Inflate the layout for this fragment
        return root;
    }
}
