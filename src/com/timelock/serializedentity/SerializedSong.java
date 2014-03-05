package com.timelock.serializedentity;

import com.google.gson.annotations.SerializedName;

public class SerializedSong {
	
	@SerializedName("Song2id")
	public long id;
	
	@SerializedName("Song2album_id")
	public long album_id;
	
	@SerializedName("Song2genre_id")
	public long genre_id;
	
	@SerializedName("Song2title")
	public String title;
	
	@SerializedName("Song2price")
	public double price;
	
	@SerializedName("Song2lyrics")
	public String lyrics;
	
	@SerializedName("Song2duration")
	public int duration;
	
	@SerializedName("Song2size")
	public long size;
	
	@SerializedName("Song2ext")
	public String ext;
	
	@SerializedName("Song2download_count")
	public int download_count;
	
	@SerializedName("Song2status")
	public char status;
	
	@SerializedName("Song2artist_id")
	public int artist_id;
	
	@SerializedName("Song2artist_name")
	public String artist_name;
	
	@SerializedName("Song2album_name")
	public String album_name;
	
	@SerializedName("Song2album_released_date")
	public String album_released_date;
	
	@SerializedName("Song2genre_name")
	public String genre_name;
	
	
	
	
	
}
