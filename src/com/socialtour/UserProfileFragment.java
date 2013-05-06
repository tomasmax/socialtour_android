package com.socialtour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.example.socialtour.R;


public class UserProfileFragment extends SherlockFragment {


	@Override
	public void onCreate(Bundle savedInstanceState) {
		

	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_user_profile, container, false);
        
        
		// Inflate the layout for this fragment
        return root;
    }


	

}
