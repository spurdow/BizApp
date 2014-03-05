package com.timelock.serializedentity;

import com.google.gson.annotations.SerializedName;
import com.timelock.utils.Utils;
/**
 * Serialized User for gson from php json
 * @author Admin
 *
 */
public class SerializedUser {
	@SerializedName("user_id")
	public long user_id;
	@SerializedName("artist_id")
	public long artist_id;
	@SerializedName("user_type")
	public int user_type;
	@SerializedName("user_username")
	public String user_username;
	@SerializedName("user_email")
	public String user_email;
	@SerializedName("user_password")
	public String user_password;
	@SerializedName("user_fname")
	public String user_fname;
	@SerializedName("user_lname")
	public String user_lname;
	@SerializedName("user_gender")
	public String user_gender;
	@SerializedName("user_address")
	public String user_address;
	@SerializedName("user_contactno")
	public String user_contactno;
	@SerializedName("user_date_registered")
	public String user_date_registered;
	@SerializedName("user_image_ext")
	public String user_image_ext;
	@SerializedName("user_last_activity")
	public long user_last_activity;
	@SerializedName("user_status")
	public char user_status;
	
	public String getImagePath(){
		return Utils.HOST + "/uploads/images/user_avatar/" + user_id + "." + user_image_ext ;
	}
	
	public String toString(){
		return user_id + " " + artist_id + " " + user_type + " " + user_username + " " + user_email 
				+ " " + user_password ;
	}
}
