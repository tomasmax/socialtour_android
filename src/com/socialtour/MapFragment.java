package com.socialtour;

import com.example.socialtour.R;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockMapFragment;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MapFragment extends SherlockFragment {
	private GoogleMap map;
	private LocationManager locManager;
	private LocationListener locListener;
	private double userLat;
	private double userLong;
	
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
	}
}
