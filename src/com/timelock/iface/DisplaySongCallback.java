package com.timelock.iface;

import java.util.List;

import com.timelock.serializedentity.SerializedSong;

public interface DisplaySongCallback {
	/**
	 * call back for displaying of songs from a executable task 
	 * @param songs
	 */
	void displaySongs(List<SerializedSong> songs);
}
