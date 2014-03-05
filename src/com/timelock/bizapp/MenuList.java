package com.timelock.bizapp;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.actionbarsherlock.app.SherlockListFragment;
import com.timelock.adapters.TitleAdapter;
import com.timelock.entity.Title;

public class MenuList extends SherlockListFragment{

	private TitleAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return (LinearLayout)inflater.inflate(R.layout.menu_layout,container , false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		ArrayList<Title> titles = new ArrayList<Title>();
		titles.add(new Title("Manage Songs"));
		titles.add(new Title("Post Comment"));
		titles.add(new Title("Manage Download Song"));
		titles.add(new Title("Manage Cart"));
		adapter = new TitleAdapter(this.getActivity() ,titles );
		
		setListAdapter(adapter);
	}

	
	
}
