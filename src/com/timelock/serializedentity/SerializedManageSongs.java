package com.timelock.serializedentity;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class SerializedManageSongs {
	
	@SerializedName("status")
	public String status;
	@SerializedName("data")
	public List<SerializedSong> songs;
}
