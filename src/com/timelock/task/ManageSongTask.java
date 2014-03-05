package com.timelock.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.timelock.serializedentity.SerializedManageSongs;
import com.timelock.utils.Utils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class ManageSongTask extends AsyncTask<String , String , String>{

	private static final String TAG = "ManageSongTask";
	private Context context;
	public ManageSongTask(Context context){
		this.context = context;
	}
	
	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("action" , arg0[0]));
		pairs.add(new BasicNameValuePair("user_type" , arg0[1]));
		pairs.add(new BasicNameValuePair("artist_id" , arg0[2]));
		
		return Utils.getResponse(arg0[3], pairs, "Manage Songs");
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		Log.d(TAG, result);
		if(result != null){
			Gson gson = new Gson();
			SerializedManageSongs mSongs = gson.fromJson(result, SerializedManageSongs.class);
			Log.d(TAG, mSongs.status);
			if(mSongs.status.equals("success")){
				Log.d(TAG, mSongs.songs.size() + " ");
			}
		}
		super.onPostExecute(result);
	}

	

}
