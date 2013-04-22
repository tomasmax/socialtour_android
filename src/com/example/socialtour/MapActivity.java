package com.example.socialtour;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.slidingmenu.lib.SlidingMenu;

public class MapActivity extends SherlockActivity {
	
	public ActionBar actionbar;
	public SlidingMenu leftSlMenu;
	public SlidingMenu rightSlMenu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		actionbar = getSupportActionBar();
		actionbar.setIcon(getResources().getDrawable(R.drawable.logo_edit1));
		actionbar.setDisplayShowHomeEnabled(true);
		
		//formula to adjust sliding menu depending on screen size
		DisplayMetrics displayMetrics = new DisplayMetrics();
		WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE); // the results will be higher than using the activity context object or the getWindowManager() shortcut
		wm.getDefaultDisplay().getMetrics(displayMetrics);
		int screenWidth = displayMetrics.widthPixels;

		int offset = (int) (screenWidth - (screenWidth*0.7)); //percentage of sliding menu in the screen
		
		// configure the left SlidingMenu
		leftSlMenu = new SlidingMenu(getApplicationContext());
		leftSlMenu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
		leftSlMenu.setMode(SlidingMenu.LEFT);
		leftSlMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		leftSlMenu.setShadowWidth(15);
		leftSlMenu.setShadowDrawable(R.drawable.shadow);
		leftSlMenu.setBehindOffset(offset);
		leftSlMenu.setFadeDegree(0.60f);
		leftSlMenu.setMenu(R.layout.left_sliding_menu);
		
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
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.activity_map, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == android.R.id.home){
			leftSlMenu.toggle();
		}
		else if (item.getItemId() == R.id.right_sliding_button) {
			rightSlMenu.toggle();
		}
		return super.onOptionsItemSelected(item);
	}
	
	

}
