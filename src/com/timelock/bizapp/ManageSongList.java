package com.timelock.bizapp;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;

import com.actionbarsherlock.app.SherlockListFragment;
import com.timelock.adapters.ManageSongsAdapter;
import com.timelock.iface.DisplaySongCallback;
import com.timelock.serializedentity.SerializedSong;
import com.timelock.serializedentity.SerializedUser;
import com.timelock.task.ManageSongTask;
import com.timelock.utils.Utils;

public class ManageSongList extends SherlockListFragment implements DisplaySongCallback , OnItemClickListener{
	
	private static final String TAG = "ManageSongList";
	private ManageSongsAdapter adapter;
	
	
	
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
		
		adapter = new ManageSongsAdapter(this.getActivity());
		
		setListAdapter(adapter);
		
		getListView().setOnItemClickListener(this);
		
        SerializedUser user = Utils.getUser(this.getActivity());
        ManageSongTask task = new ManageSongTask(this.getActivity() , this);
        task.execute("0" , user.user_type+"", user.artist_id + "" , Utils.HOST + Utils.ANDROID_FOLDER + "/manage_songs.php");
        
		
	}

	@Override
	public void displaySongs(List<SerializedSong> songs) {
		// TODO Auto-generated method stub
		for(SerializedSong song  : songs){
			adapter.add(song);
			Log.d(TAG, "adding song" + song.title);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent i = new Intent(ManageSongList.this.getActivity() , MediaBizPlayer.class);
		i.putParcelableArrayListExtra("songsList", (ArrayList<? extends Parcelable>) adapter.getList());
		i.putExtra("index", arg2);
		startActivity(i);
		
		Log.d(TAG, "clicked!");
	}
	
	
	

}
