package com.timelock.utils;

import java.io.InputStream;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.AndroidHttpClient;
import android.util.Log;

import com.google.gson.Gson;
import com.timelock.bizapp.MainActivity;
import com.timelock.serializedentity.SerializedUser;

public class Utils {

	public final static String HOST = "http://192.168.254.103";
	
	public final static String ANDROID_FOLDER = "/android";
	
	public final static String LOGIN_URL = HOST + ANDROID_FOLDER + "/login.php";
	
	public final static int USER = 0x01;
	
	public final static int ARTIST = 0x03;
	
	public final static int MANAGE_SONGS_ID = 0x00;
	public final static int POST_COMMENT_ID = 0x01;
	public final static int MANAGE_DOWNLOAD_SONG_ID = 0x02;
	public final static int MANAGE_CART_ID = 0x03;
	
	/**
	 * getting response thru url with pairs of keys and values for post and tag for
	 * error handling
	 * @param url
	 * @param pairs
	 * @param tag
	 * @return
	 */
	public static String getResponse(String url , List<NameValuePair> pairs , String tag){
	    final AndroidHttpClient client = AndroidHttpClient.newInstance("Android");
	    final HttpPost getPost = new HttpPost(url);
	    

	    try{
	    	getPost.setEntity(new UrlEncodedFormEntity(pairs));
	    	HttpResponse response = client.execute(getPost);
	    	
	        final int statusCode = response.getStatusLine().getStatusCode();
	        if (statusCode != HttpStatus.SC_OK) { 
	            Log.w(tag, "Error " + statusCode + " while retrieving data from " + url); 
	            return null;
	        }
	        
	        final HttpEntity entity = response.getEntity();
	        if (entity != null) {
	            try {
	                final String result = EntityUtils.toString(entity);
	                return result;
	            } finally {
	                entity.consumeContent();
	            }
	        }
	    	
	    }catch(Exception ex){
	    	  getPost.abort();
		      Log.w(tag, "Error while retrieving data from " + url + " " + ex.toString());
	    }finally{
	    	if(client != null){
	    		client.close();
	    	}
	    }
	    return null;
	}
	/** 
	 * static bitmap downloader
	 */
	public static Bitmap downloadBitmap(String url) {
	    final AndroidHttpClient client = AndroidHttpClient.newInstance("Android");
	    final HttpGet getRequest = new HttpGet(url);

	    try {
	        HttpResponse response = client.execute(getRequest);
	        final int statusCode = response.getStatusLine().getStatusCode();
	        if (statusCode != HttpStatus.SC_OK) { 
	            Log.w("ImageDownloader", "Error " + statusCode + " while retrieving bitmap from " + url); 
	            return null;
	        }
	        
	        final HttpEntity entity = response.getEntity();
	        if (entity != null) {
	            InputStream inputStream = null;
	            try {
	                inputStream = entity.getContent(); 
	                final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
	                return bitmap;
	            } finally {
	                if (inputStream != null) {
	                    inputStream.close();  
	                }
	                entity.consumeContent();
	            }
	        }
	    } catch (Exception e) {
	        // Could provide a more explicit error message for IOException or IllegalStateException
	        getRequest.abort();
	        Log.w("ImageDownloader", "Error while retrieving bitmap from " + url + " " + e.toString());
	    } finally {
	        if (client != null) {
	            client.close();
	        }
	    }
	    return null;
	}
	
	/**
	 * save user to shared prefernces
	 * @param context
	 * @param user
	 */
	public static void saveUser(Context context , SerializedUser user){
		SharedPreferences shared = getSharedPref(context);
		SharedPreferences.Editor editor = shared.edit();
		Gson gson = new Gson();
		String json = gson.toJson(user);
		editor.putString("User", json);
		editor.commit();
	}
	/**
	 * get user from shard prefernces storage
	 * @param context
	 * @return
	 */
	public static SerializedUser getUser(Context context){
		SharedPreferences shared = getSharedPref(context);
		Gson gson = new Gson();
		String json = shared.getString("User", "");
		SerializedUser user = gson.fromJson(json, SerializedUser.class);
		return user;
	}
	/**
	 * getting the default shared preferences
	 * @param context
	 * @return
	 */
	protected static SharedPreferences getSharedPref(Context context){
		return context.getSharedPreferences(MainActivity.class.getSimpleName(), Context.MODE_PRIVATE);
	}
		
}
