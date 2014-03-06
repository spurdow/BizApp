package com.timelock.serializedentity;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.annotations.SerializedName;
import com.timelock.utils.Utils;

public class SerializedSong implements Parcelable{
	
	private SerializedSong(Parcel in){
		id = in.readLong();
		album_id = in.readLong();
		genre_id = in.readLong();
		title = in.readString();
		price = in.readDouble();
		lyrics = in.readString();
		duration = in.readInt();
		size = in.readLong();
		ext = in.readString();
		download_count = in.readInt();
		status = in.readString().charAt(0);
		artist_id = in.readInt();
		artist_name = in.readString();
		album_name = in.readString();
		album_released_date = in.readString();
		genre_name = in.readString();

	}
	
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
	
	private String songSDPath;
	
	public void setSongSDPath(String sdPath){
		songSDPath = sdPath;
	}
	
	public String getSongSDPath(){
		if(songSDPath == null){
			songSDPath = Utils.HOST + "/uploads/songs/" + id + "." + ext;
		}
		
		return songSDPath;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		// TODO Auto-generated method stub
		out.writeLong(id);
		out.writeLong(album_id);
		out.writeLong(genre_id);
		out.writeString(title);
		out.writeDouble(price);
		out.writeString(lyrics);
		out.writeInt(duration);
		out.writeLong(size);
		out.writeString(ext);
		out.writeInt(download_count);
		out.writeString(status+"");
		out.writeInt(artist_id);
		out.writeString(artist_name);
		out.writeString(album_name);
		out.writeString(album_released_date);
		out.writeString(genre_name);
	}
	
    public static final Parcelable.Creator<SerializedSong> CREATOR
    = new Parcelable.Creator<SerializedSong>() {
		public SerializedSong createFromParcel(Parcel in) {
		    return new SerializedSong(in);
		}
		
		public SerializedSong[] newArray(int size) {
		    return new SerializedSong[size];
		}
	};
	
	
	
}
