package com.timelock.bizapp;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.timelock.adapters.TitleAdapter;
import com.timelock.entity.Title;
import com.timelock.serializedentity.SerializedUser;
import com.timelock.task.BitmapDownloaderTask;
import com.timelock.utils.IImageDownload;
import com.timelock.utils.Utils;

public class MenuList extends SherlockListFragment implements IImageDownload{

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
		titles.add(new Title("Logout"));
		
		LayoutInflater inflater = getLayoutInflater(savedInstanceState);
		ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.profile_header, null);
		
		ImageView img = (ImageView) viewGroup.findViewById(R.id.im_id_profile);
		TextView fullname = (TextView) viewGroup.findViewById(R.id.txt_id_fullname);
		
		SerializedUser user = Utils.getUser(this.getActivity());
		download(user.getImagePath() , img);
		fullname.setText(user.user_fname + " " + user.user_lname);
		
		getListView().addHeaderView(viewGroup);
		
		adapter = new TitleAdapter(this.getActivity() ,titles );
		
		setListAdapter(adapter);
		
		
	}

	@Override
	public void download(String url,  ImageView view) {
		// TODO Auto-generated method stub
		new BitmapDownloaderTask(view).execute(url);
		
	}

	
	
}
