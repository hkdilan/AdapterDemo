package com.hkdilan.android.adapterdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SimpleArrayAdapterWithSpinner extends Activity {
	
	private Spinner mSpinner;
	private ArrayAdapter<CharSequence> mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_array_adapter_with_spinner);
		
		mSpinner = (Spinner) findViewById(R.id.spinner1);
		
		//Create from resource array
		final Button btn1 = (Button) findViewById(R.id.button1);
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//show spinner as it hide begining
				mSpinner.setVisibility(View.VISIBLE);
				
				//create adapter from array, set each layout item in adapter view
				mAdapter = ArrayAdapter.createFromResource(SimpleArrayAdapterWithSpinner.this, 
						R.array.animals, android.R.layout.simple_spinner_item);
				
				//set dropdown list
				mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				
				//set adapter for the spinner
				mSpinner.setAdapter(mAdapter);
			}
		});
		
		//Create from string array
		final Button btn2 = (Button) findViewById(R.id.button2);
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//show spinner as it hide begining
				mSpinner.setVisibility(View.VISIBLE);
				
				//Values from array for adapter
				final String[] values = new String[]{"Android", "Apple", "Windows"};
				
				//create adapter from array, set each layout item in adapter view, String is implemented CharSequence
				mAdapter = new ArrayAdapter<CharSequence>(SimpleArrayAdapterWithSpinner.this, 
						android.R.layout.simple_spinner_item, values);
				
				//set dropdown list
				mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				
				//set adapter for the spinner
				mSpinner.setAdapter(mAdapter);
			}
		});
		
		//handling user selection
		mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
				//handle item selected
				Toast.makeText(getApplicationContext(), "selected: " + parent.getItemAtPosition(position), 
						Toast.LENGTH_LONG).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				//nothing selected
			}
		});
	}
}
