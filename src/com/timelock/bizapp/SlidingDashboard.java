package com.timelock.bizapp;

import android.os.Bundle;

import com.actionbarsherlock.view.MenuItem;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class SlidingDashboard extends SlidingFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("BizApp");
        // set the dummy front view
        setContentView(R.layout.content_frame);
        // set dummy back view
        setBehindContentView(R.layout.menu_frame);
        MenuList mList = new MenuList();
        // configure the back view which is the menu
		this.getSupportFragmentManager().beginTransaction()
		.replace(R.id.menu_frame, mList).commit();
		 // configure the SlidingMenu
        SlidingMenu menu = this.getSlidingMenu();
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
  
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case android.R.id.home : 
			getSlidingMenu().toggle();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
    
    

}
