package com.hkdilan.android.adapterdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CustomArrayAdapterActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_array_adapter_with_list);
		
		//get list view
		final ListView list = (ListView) findViewById(R.id.listView1);
		
		//get array from resource
		final String[] values = getResources().getStringArray(R.array.animals);
		
		//create adapter from array, set each layout item in adapter view
		final ArrayAdapter<String> adapter = new CustomArrayAdapter(this, values);
		
		//set adapter to list(adapter view)
		list.setAdapter(adapter);
		
		//handle user selection
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,	long id) {
				//handle item selected
				Toast.makeText(getApplicationContext(), "clicked: " + parent.getItemAtPosition(position), 
						Toast.LENGTH_LONG).show();
			}
			
		});
	}
}
