package com.socialtour.parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;

import com.socialtour.MapFragment;
import com.example.socialtour.R;
import com.socialtour.adapters.DateFormatter;
import com.socialtour.models.Coordenates;
import com.socialtour.models.POI;
import com.socialtour.models.POIType;
import com.socialtour.models.Photo;


public class JSONParser {
	private JSONArray jArray;
	private JSONObject jObject;
	private Context con;
	private int method_num;
	private int page;
	private String method;
	public static HashMap<Integer,JSONObject> cache = new HashMap<Integer,JSONObject>();
	public static HashMap<Integer,JSONObject> cacheRoutes = new HashMap<Integer,JSONObject>();
/*	private static final String TO_SEE = "tosee";
	private static final String TO_DO = "todo";
	private static final String TO_EAT = "toeat";
	private static final String TO_SLEEP = "tosleep";*/

	public JSONParser(Context con,String method, int page) {	
		this.con = con;
		this.page = page;
		if(method.equals("tosee"))
			this.method_num = 1;
		else if(method.equals("todo"))
			this.method_num = 2;
		else if(method.equals("toeat"))
			this.method_num = 3;
		else if(method.equals("tosleep"))
			this.method_num = 4; 
		this.method = method;
		//System.out.println(page);
		//this.method_num = 3;
		try {
			this.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String readFeed(String path) {
		StringBuilder builder = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(path);
		try {
			HttpResponse response = client.execute(httpGet);
			System.out.println("PIDIENDOOOOOO");
			HttpEntity entity = response.getEntity();
			InputStream content = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(content));
			String line;
			
			while ((line = reader.readLine()) != null)
			{
				builder.append(line);
			}
			content.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	public void parse() throws Exception {
		String path = con.getString(R.string.socialtour_api_json)+"?page="+page;
		System.out.println(path);
		System.out.println(page);
	//	System.out.println(cache.containsKey(method_num));
	//	System.out.println(cache.get(method_num).containsKey(page));
		if(cache.containsKey(Integer.valueOf(page)))
		{
			jObject = cache.get(Integer.valueOf(page));
			System.out.println("CACHEANDOOOOOOOOOOOO");
		} else {
			jObject = new JSONObject(readFeed(path));
			cache.put(Integer.valueOf(page),jObject);
		}
		
		boolean isRoute = false;
		
		jArray = jObject.getJSONArray(method);

		// TODO change this. limit?
		for(int i=0; i< jArray.length() ; i++) {
			JSONObject poiJSONObject = jArray.getJSONObject(i);
			
			// JSON POI
			int id = poiJSONObject.getInt("id");
			String latitude = poiJSONObject.getString("latitude");
			String longitude = poiJSONObject.getString("longitude");
			String title = poiJSONObject.getString("title");
			String description = poiJSONObject.getString("description");
			String slug = poiJSONObject.getString("slug");
			if (description == "null")
				description = con.getString(R.string.no_info);
			int type = -1;
			try {
				type = poiJSONObject.getInt("category_id");
			} catch(Exception e) {
				continue;
			}
			String rating = poiJSONObject.getString("rating");
			int ratingsCount = poiJSONObject.getInt("ratings_count");
			
			// Check if type already exists
			boolean found = false;
			switch (method_num)
			{
				case 1: {
								for(POIType poiType: MapFragment.poiTypeArrayList)
								if(poiType.getId() == type)
									found = true;
								break;
							  }
				case 2: {
								for(POIType poiType: MapFragment.poiTypeArrayList)
								if(poiType.getId() == type)
									found = true;
								break;
							  }
				case 3: {
								for(POIType poiType: MapFragment.poiTypeArrayList)
								if(poiType.getId() == type)
									found = true;
								break;
							  }
				case 4: {
								for(POIType poiType: MapFragment.poiTypeArrayList)
								if(poiType.getId() == type)
									found = true;
								break;
							  }
			}
			
			if(!found) {
				// JSON POIType
				JSONObject poiTypeObject = poiJSONObject.getJSONObject("category");
				String name = poiTypeObject.getString("name");
				isRoute = poiTypeObject.getBoolean("is_route");
				Date startedAt = DateFormatter.getDate("2012-04-01T16:47:29Z"); //poiTypeObject.getString("created_at"));
				
				poiTypeObject = poiJSONObject.getJSONObject("supercategory");
				POIType poiType = new POIType(type, name, isRoute, startedAt);
				poiType.setImageBigFileName(poiTypeObject.getJSONObject("icon_urls").getString("big"));
				poiType.setImageMedFileName(poiTypeObject.getJSONObject("icon_urls").getString("med"));
				poiType.setImageSmallFileName(poiTypeObject.getJSONObject("icon_urls").getString("small"));
				switch (method_num)
				{
					case 1: {
						MapFragment.poiTypeArrayList.add(poiType);
									break;
								  }
					case 2: {
						MapFragment.poiTypeArrayList.add(poiType);
									break;
								  }
					case 3: {
						MapFragment.poiTypeArrayList.add(poiType);
									break;
								  }
					case 4: {
						MapFragment.poiTypeArrayList.add(poiType);
									break;
								  }
				}
			}	

			// comments
		/*	JSONArray commentsArray = poiJSONObject.getJSONArray("last_comments");
			try {
				for(int j=0; ;j++) {
					JSONObject commentObject = commentsArray.getJSONObject(j);
					String comment = commentObject.getString("comment");
					int commId = commentObject.getInt("id");
					int commUserId = -1;
					try {
						commUserId = commentObject.getInt("user_id");
					}
					catch(Exception e) {}
					// TODO retrieve more user data 
					Date startedAt = DateFormatter.getDate(commentObject.getString("created_at"));
					MontesdeHierroActivity.poiCommentsList.add(new Comment(commId, comment, startedAt, commUserId, id));
				}
			}
			catch(Exception e) {}
		*/	
			// photos
			JSONArray photosArray = poiJSONObject.getJSONArray("last_photos");
			try {
				for(int j=0; j<photosArray.length();j++) {
					JSONObject photoObject = photosArray.getJSONObject(j);
					int photoId = photoObject.getInt("id");
					int photoUserId = -1;
					try {
						photoUserId = photoObject.getInt("user_id");
					}
					catch(Exception e) {}
					
					JSONObject photoURLObject = photoObject.getJSONObject("image_urls");
					String icon = photoURLObject.getString("icon_2x");
					String full = photoURLObject.getString("full"); // full
					int imageSize = photoObject.getInt("image_file_size");
					if(imageSize > 1800000)
						continue;
					Date startedAt = DateFormatter.getDate(photoObject.getString("created_at"));
					
					// TODO retrieve more user data
					Photo p = new Photo(photoId, id, photoUserId, startedAt);
					p.setImageFileName(full);
					p.setImageContentType(icon);
					switch (method_num)
					{
						case 1: {
							MapFragment.poiPhotosList.add(p);
										break;
									  }
						case 2: {
							MapFragment.poiPhotosList.add(p);
										break;
									  }
						case 3: {
							MapFragment.poiPhotosList.add(p);
										break;
									  }
						case 4: {
							MapFragment.poiPhotosList.add(p);
										break;
									  }
					}
				}
			}
			catch(Exception e) {}
			
			// events
		/*	JSONArray eventsArray = poiJSONObject.getJSONArray("next_events");
			try {
				for(int j=0; ;j++) {
					JSONObject eventObject = eventsArray.getJSONObject(j);
					int eventId = eventObject.getInt("id");
					String eventDescription =  eventObject.getString("description");
					String eventSummary =  eventObject.getString("summary");
					Date createdAt = DateFormatter.getDate(eventObject.getString("created_at"));
					Date startsAt = DateFormatter.getDate(eventObject.getString("starts_at"));
					Date endsAt = DateFormatter.getDate(eventObject.getString("ends_at"));
					
					Event e = new Event(eventId, eventDescription, eventSummary, createdAt, startsAt, endsAt, id);
					switch (method_num)
					{
						case 1: {
										VerActivity.poiEventsList.add(e);
										break;
									  }
						case 2: {
										HacerActivity.poiEventsList.add(e);
										break;
									  }
						case 3: {
										ComerActivity.poiEventsList.add(e);
										break;
									  }
						case 4: {
										DormirActivity.poiEventsList.add(e);
										break;
									  }
					}
				}
			}
			catch(Exception e) {}
		*/	
			// routes7
			ArrayList<Coordenates> coords = null;
			if(isRoute)	
			{
				JSONObject pathObject;
				if(cacheRoutes.containsKey(Integer.valueOf(id)))
				{
						pathObject = cacheRoutes.get(id);
						System.out.println("Cachhhhheeee");
				} else {
							String routePath = con.getString(R.string.socialtour_url)+"/pois/"+slug+".json";
							pathObject = new JSONObject(readFeed(routePath));
							cacheRoutes.put(id,pathObject);
						}
				
				
				
				JSONArray routeArray = pathObject.getJSONArray("route_points_list");
				coords = new ArrayList<Coordenates>();
				try {
					for(int j=0; ;j++) {
						JSONObject poiOfRouteObject = routeArray.getJSONObject(j);
						String lat = poiOfRouteObject.getString("latitude");
						String lon = poiOfRouteObject.getString("longitude");
						
						Coordenates co = new Coordenates(Double.parseDouble(lat), Double.parseDouble(lon));
						coords.add(co);
					}
				}
				catch(Exception e) {}
			}
			Date startedAt = DateFormatter.getDate(poiJSONObject.getString("created_at"));
			if(latitude!="null" && longitude!="null") {
				POI poi = new POI(id, title, description, type, new Coordenates(Double.parseDouble(latitude), Double.parseDouble(longitude)), Float.parseFloat(rating), ratingsCount, startedAt, -1);
				if(isRoute)
					poi.setRoutePoints(coords);
				switch (method_num)
				{
					case 1: {
									MapFragment.poiArrayList.add(poi);
									break;
								  }
					case 2: {
						MapFragment.poiArrayList.add(poi);
									break;
								  }
					case 3: {
						MapFragment.poiArrayList.add(poi);
									break;
								  }
					case 4: {
						MapFragment.poiArrayList.add(poi);
									break;
								  }
				}
			}
		}
	}
}

