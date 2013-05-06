package com.socialtour;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.SherlockMapActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.example.socialtour.R;
import com.slidingmenu.lib.SlidingMenu;


public class SocialTourFragmentContainer extends SherlockFragmentActivity {
	
	private ActionBar actionbar;
	private SlidingMenu leftSlMenu;
	private SlidingMenu rightSlMenu;
	
	//private SlideMenu leftSlideMenu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_container);
		
		actionbar = getSupportActionBar();
		actionbar.setIcon(getResources().getDrawable(R.drawable.left_sliding));
		actionbar.setHomeButtonEnabled(true);
		actionbar.setLogo(getResources().getDrawable(R.drawable.logo_edit1));
		actionbar.setDisplayUseLogoEnabled(true);
		//Drawable b=getResources().getDrawable(R.drawable.logo_edit1);
		//actionbar.setBackgroundDrawable(b);
		actionbar.setDisplayShowHomeEnabled(true);
		
		
		//formula to adjust sliding menu depending on screen size
		DisplayMetrics displayMetrics = new DisplayMetrics();
		WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE); // the results will be higher than using the activity context object or the getWindowManager() shortcut
		wm.getDefaultDisplay().getMetrics(displayMetrics);
		int screenWidth = displayMetrics.widthPixels;

		int offset = (int) (screenWidth - (screenWidth*0.7)); //percentage of sliding menu in the screen
		
		// configure the left SlidingMenu
		leftSlMenu = new SlidingMenu(getApplicationContext());
		leftSlMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		leftSlMenu.setMode(SlidingMenu.LEFT);
		leftSlMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		leftSlMenu.setShadowWidth(15);
		leftSlMenu.setShadowDrawable(R.drawable.shadow);
		leftSlMenu.setBehindOffset(offset);
		leftSlMenu.setFadeDegree(0.60f);
		leftSlMenu.setMenu(R.layout.left_sliding_menu);
		
		/* libSlideMenu
		// this is from code. no XML declaration necessary, but you won't get state restored after rotation.
//		slidemenu = new SlideMenu(this, R.menu.slide, this, 333);
		// this inflates the menu from XML. open/closed state will be restored after rotation, but you'll have to call init.
		leftSlideMenu = new SlideMenu(this);
		leftSlideMenu.setBackgroundColor(R.color.slideMenuBack);
		leftSlideMenu.init(this, R.menu.left_side_navigation_menu, this, 350);
		
		// this can set the menu to initially shown instead of hidden
//		slidemenu.setAsShown(); 
		
		// set optional header image
		leftSlideMenu.setHeaderImage(getResources().getDrawable(R.drawable.ic_launcher));
       	*/
		
		// configure the right SlidingMenu
		rightSlMenu = new SlidingMenu(getApplicationContext());
		rightSlMenu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
		rightSlMenu.setMode(SlidingMenu.RIGHT);
		rightSlMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		rightSlMenu.setShadowWidth(15);
		rightSlMenu.setShadowDrawable(R.drawable.shadow);
		rightSlMenu.setBehindOffset(offset);
		rightSlMenu.setFadeDegree(0.60f);
		rightSlMenu.setMenu(R.layout.right_sliding_menu);
		
		// Check that the activity is using the layout version with the fragment_container FrameLayout
        if(findViewById(R.id.fragment_container) != null)
        {
            // if we are being restored from a previous state, then we dont need to do anything and should
            // return or else we could end up with overlapping fragments.
            if(savedInstanceState != null)
                return;

            // Create an instance of mapFragment
            MapFragment firstFrag = new MapFragment();

            // add fragment to the fragment container layout
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFrag);
            ft.commit();
        }
		
		//Call home activity
		TextView textview = (TextView)leftSlMenu.findViewById(R.id.side_navigation_menu_item1);
		textview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				leftSlMenu.toggle();
				
			}
		});
		
		//Call profile activity
		textview = (TextView)leftSlMenu.findViewById(R.id.side_navigation_menu_item2);
		textview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				leftSlMenu.toggle();
				//Call new activity
				
				finish();
				
			}
		});
		
		//Call packages activity
		textview = (TextView)leftSlMenu.findViewById(R.id.side_navigation_menu_item3);
		textview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				leftSlMenu.toggle();
				//Call new activity
				
				finish();
				
			}
		});
		
		//Call recommendations activity
		textview = (TextView)leftSlMenu.findViewById(R.id.side_navigation_menu_item4);
		textview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				leftSlMenu.toggle();
				//Call new activity
				
				finish();
				
			}
		});
		
		//Call to_do_list activity
		textview = (TextView)leftSlMenu.findViewById(R.id.side_navigation_menu_item5);
		textview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				leftSlMenu.toggle();
				//Call new activity
				
				finish();
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.activity_map, menu);
		
        return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == android.R.id.home){
			leftSlMenu.toggle();
		}
		else if (item.getItemId() == R.id.right_sliding_button) {
			rightSlMenu.toggle();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/*
	@Override
	public void onSlideMenuItemClick(int itemId) {

		switch(itemId) {
		case R.id.side_navigation_menu_item1: //explorar
			Toast.makeText(this, "Item one selected", Toast.LENGTH_SHORT).show();
			break;
		case R.id.side_navigation_menu_item2: //recomendaciones
			Toast.makeText(this, "Item two selected", Toast.LENGTH_SHORT).show();
			break;
		case R.id.side_navigation_menu_item3: //paquetes
			Toast.makeText(this, "Item three selected", Toast.LENGTH_SHORT).show();
			break;
		case R.id.side_navigation_menu_item4: //listas
			Toast.makeText(this, "Item four selected", Toast.LENGTH_SHORT).show();
			break;
		case R.id.side_navigation_menu_item5: //perfil
			Toast.makeText(this, "Item five selected", Toast.LENGTH_SHORT).show();
			break;
		}
		
	}
	*/


}
