package com.socialtour;


import java.util.ArrayList;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.example.socialtour.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.socialtour.models.Comment;
import com.socialtour.models.Event;
import com.socialtour.models.POI;
import com.socialtour.models.POIType;
import com.socialtour.models.Photo;

public class MapFragment extends SherlockFragment {
	private GoogleMap map;
	private LocationManager locManager;
	private LocationListener locListener;
	private double userLat;
	private double userLong;
	
	public static ArrayList<POI> poiArrayList;
	public static ArrayList<POIType> poiTypeArrayList;
	public static ArrayList<Comment> poiCommentsList;
	public static ArrayList<Photo> poiPhotosList;
	public static ArrayList<Event> poiEventsList;
	
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
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		/*
		// Obtiene referencia al LocationManager

				locManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);

				// Obtiene la ultima posicion conocida

				//Location loc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

				    //Nos registramos para recibir actualizaciones de la posicion

				    locListener = new LocationListener() {

				    public void onLocationChanged(Location location) {

				    userLat = location.getLatitude();

				    userLong = location.getLongitude();

				    CameraUpdate camUpdate = CameraUpdateFactory.newLatLng(new LatLng(userLat, userLong));

				    map.moveCamera(camUpdate);
				   

						Log.i("", String.valueOf(location.getLatitude() + " - " + String.valueOf(location.getLongitude())));

				    }

				    public void onProviderDisabled(String provider){}

				    public void onProviderEnabled(String provider){}

				    public void onStatusChanged(String provider, int status, Bundle extras){}

				    }; 

				locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locListener);

				locManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locListener);
		*/
		
	}
	
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        SupportMapFragment f = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.mapFragmentView);
        if (f != null) 
            getFragmentManager().beginTransaction().remove(f).commit();
    }
}
