package com.timelock.adapters;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.timelock.bizapp.R;
import com.timelock.iface.IAdapterActions;
import com.timelock.serializedentity.SerializedSong;

public class ManageSongsAdapter extends AbstractListAdapter<SerializedSong> implements IAdapterActions<SerializedSong>{

	private LayoutInflater inflater;
	
	public ManageSongsAdapter(Context context, List<SerializedSong> lists) {
		super(context, lists);
		// TODO Auto-generated constructor stub
		inflater = LayoutInflater.from(context);
	}
	
	public ManageSongsAdapter(Context context){
		this(context , new ArrayList<SerializedSong>());
	}

	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View getOverridedView(int position, View child, ViewGroup root) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if(child == null){
			holder = new ViewHolder();
			child = inflater.inflate(R.layout.manage_songs_row, null);
			holder.title = (TextView) child.findViewById(R.id.title);
			holder.artist = (TextView) child.findViewById(R.id.artist);
			holder.duration = (TextView) child.findViewById(R.id.duration);
			holder.image = (ImageView) child.findViewById(R.id.list_image);
			child.setTag(holder);
		}else{
			holder = (ViewHolder) child.getTag();
		}
		
		holder.title.setText(getList().get(position).title + "");
		holder.artist.setText(getList().get(position).artist_name + "");
		holder.duration.setText(getList().get(position).duration +"");
		
		return child;
	}

	@Override
	public void add(SerializedSong e) {
		// TODO Auto-generated method stub
		getList().add(e);
		notifyDataSetChanged();
	}

	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub
		getList().remove(index);
		notifyDataSetChanged();
	}

	@Override
	public void update(int pos, SerializedSong object) {
		// TODO Auto-generated method stub
		getList().set(pos, object);
		notifyDataSetChanged();
	}

	@Override
	public List<SerializedSong> getAll() {
		// TODO Auto-generated method stub
		return getList();
	}

	private class ViewHolder{
		TextView title;
		TextView artist;
		TextView duration;
		ImageView image;
	}
}
