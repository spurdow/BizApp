package com.timelock.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import com.timelock.bizapp.R;
import com.timelock.entity.Title;
import com.timelock.iface.IAdapterActions;
import com.timelock.iface.IHelperActions;

public class TitleAdapter extends AbstractListAdapter<Title> implements IAdapterActions<Title> {

	private LayoutInflater inflater;
	public TitleAdapter(Context context, List<Title> lists) {
		super(context, lists);
		// TODO Auto-generated constructor stub
		this.inflater = LayoutInflater.from(context);
	}
	

	@Override
	public void add(Title e) {
		// TODO Auto-generated method stub
		getList().add(e);
		this.notifyDataSetChanged();
	}

	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub
		getList().remove(index);
		this.notifyDataSetChanged();
	}

	@Override
	public void update(int pos, Title object) {
		// TODO Auto-generated method stub
		getList().set(pos, object);
		this.notifyDataSetChanged();
	}

	@Override
	public List<Title> getAll() {
		// TODO Auto-generated method stub
		return getList();
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
			child = inflater.inflate(R.layout.title_row, null);
			holder.title = (TextView) child.findViewById(R.id.txt_id_title);
			child.setTag(holder);
		}else{
			holder = (ViewHolder) child.getTag();
		}
		holder.title.setText(((Title)getItem(position)).getTitle().toString());
		
		return child;
	}
	
	private class ViewHolder{
		TextView title;
	}



}
