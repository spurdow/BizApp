package com.timelock.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.timelock.bizapp.SlidingDashboard;
import com.timelock.serializedentity.SerializedLogin;
import com.timelock.serializedentity.SerializedUser;
import com.timelock.utils.Utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public class LoginTask extends AsyncTask<String , String , String>{

	private static final String TAG = "LoginTask";
	private Context context;
	private ProgressDialog dialog;
	
	
	
	public LoginTask(Context context) {
		super();
		this.context = context;
	}
	


	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		
		if(result != null){
			Gson gson = new Gson();
			SerializedLogin sLogin = gson.fromJson(result, SerializedLogin.class);
			if(sLogin.status.equals("success")){
				
				Utils.saveUser(context, sLogin.user);
				
				SerializedUser user = Utils.getUser(context);
				
				Log.d(TAG, user.toString());
				
				Intent i = new Intent(context , SlidingDashboard.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(i);
			}
			
		}
		
		dialog.dismiss();
		super.onPostExecute(result);
		
	}




	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		dialog = new ProgressDialog(context);
		dialog.setIndeterminate(true);
		dialog.show();
		super.onPreExecute();
	}




	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		
	
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("login" , arg0[0]));
		pairs.add(new BasicNameValuePair("username" , arg0[1]));
		pairs.add(new BasicNameValuePair("password" , arg0[2]));
		
		
		
		return Utils.getResponse(arg0[3], pairs, "login");
	}

}
