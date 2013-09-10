package com.hkdilan.android.adapterdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomArrayAdapter extends ArrayAdapter<String> {

	private Context mContext;
	private String[] mValues;
	
	//constructor with context and values for adapter view(list)
	public CustomArrayAdapter(Context context, String[] values) {
		//should pass context, item layout, values for supper
		super(context, R.layout.custom_array_adapter_item_layout, values);
		
		this.mContext = context;
		this.mValues = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//should inflate item layout, assign data and return it
		
		ViewHolder viewHolder;
		if(convertView == null){
			//inflate item row layout
			final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.custom_array_adapter_item_layout, parent, false);
			
			//create view holder object and findViewById for each element
			viewHolder = new ViewHolder();
			viewHolder.text = (TextView) convertView.findViewById(R.id.textView1);
			
			//store viewholder with convertview
			convertView.setTag(viewHolder);
			
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		//set data to layout
		viewHolder.text.setText(mValues[position]);
		
		//should return item layout
		return convertView;
	}
	
	private static class ViewHolder{
		TextView text;
	}
}
