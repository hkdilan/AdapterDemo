package com.hkdilan.android.adapterdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CustomArrayAdapterWithCustomObjectActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_array_adapter_with_list);
		
		//get list view
		final ListView list = (ListView) findViewById(R.id.listView1);
		
		//create array list
		final ArrayList<CustomObject> values = new ArrayList<CustomObject>();
		values.add(new CustomObject("Window"));
		values.add(new CustomObject("Linux"));
		values.add(new CustomObject("Apple"));
		
		//create adapter from array, set each layout item in adapter view
		final ArrayAdapter<CustomObject> adapter = new CustomArrayWithCustomObjectAdapter(this, values);
		
		//set adapter to list(adapter view)
		list.setAdapter(adapter);
		
		//handle user selection
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,	long id) {
				//handle item selected
				Toast.makeText(getApplicationContext(), "clicked: " + 
				((CustomObject)parent.getItemAtPosition(position)).getName(), Toast.LENGTH_LONG).show();
			}
			
		});
	}
}
