package com.timelock.bizapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.actionbarsherlock.app.SherlockListFragment;

public class ManageSongList extends SherlockListFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return (LinearLayout)inflater.inflate(R.layout.content_layout,container , false);
	}
	
	

}
