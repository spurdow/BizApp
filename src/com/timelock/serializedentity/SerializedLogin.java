package com.timelock.serializedentity;

import com.google.gson.annotations.SerializedName;

public class SerializedLogin {
	@SerializedName("data")
	public SerializedUser user;
	
	@SerializedName("status")
	public String status;
}
