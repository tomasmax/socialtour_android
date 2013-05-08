package com.socialtour.adapters;

import java.util.ArrayList;

import com.socialtour.models.POI;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class POIListAdapter extends ArrayAdapter<POI> {
	private ArrayList<POI> POIArrayList;
	private int calling_activity;

	public POIListAdapter(Activity context, int textViewResourceId, ArrayList<POI> objects, int calling_activity) {
		super(context, textViewResourceId, objects);
		this.POIArrayList = objects;
		this.calling_activity = calling_activity;
	}
/*
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = inflater.inflate(R.layout.poi_list_row_layout, parent, false);

		ImageView poiImageView = (ImageView) convertView.findViewById(R.id.poiImage);
		TextView poiTitleTextView = (TextView) convertView.findViewById(R.id.poiTitle);
		TextView poiDescriptionTextView = (TextView) convertView.findViewById(R.id.poiDescription);

		poiTitleTextView.setText(POIArrayList.get(position).getTitle());
		poiDescriptionTextView.setText(Html.fromHtml(POIArrayList.get(position).getDescription()));
		
		int type = -1;
		switch (calling_activity)
		{
		case 1: {
					for(int i=0; i<VerActivity.poiTypeArrayList.size(); i++)
					
						if(VerActivity.poiTypeArrayList.get(i).getId() == POIArrayList.get(position).getType()) {
							type = i;
							break;
						}
					
					if(type!=-1)
						poiImageView.setImageDrawable(VerActivity.drawableList.get(type));
					break;
				}
		case 2: {
			for(int i=0; i<HacerActivity.poiTypeArrayList.size(); i++)
			
				if(HacerActivity.poiTypeArrayList.get(i).getId() == POIArrayList.get(position).getType()) {
					type = i;
					break;
				}
			
			if(type!=-1)
				poiImageView.setImageDrawable(HacerActivity.drawableList.get(type));
			break;
		}
		case 3: {
			for(int i=0; i<ComerActivity.poiTypeArrayList.size(); i++)
			
				if(ComerActivity.poiTypeArrayList.get(i).getId() == POIArrayList.get(position).getType()) {
					type = i;
					break;
				}
			
			if(type!=-1)
				poiImageView.setImageDrawable(ComerActivity.drawableList.get(type));
			break;
		}
		case 4: {
			for(int i=0; i<DormirActivity.poiTypeArrayList.size(); i++)
			
				if(DormirActivity.poiTypeArrayList.get(i).getId() == POIArrayList.get(position).getType()) {
					type = i;
					break;
				}
			
			if(type!=-1)
				poiImageView.setImageDrawable(DormirActivity.drawableList.get(type));
			break;
		}
		}
		return convertView;
	}
	*/
}

