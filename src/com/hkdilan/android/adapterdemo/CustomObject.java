package com.hkdilan.android.adapterdemo;

public class CustomObject {
	private String mName;
	
	public CustomObject(String name){
		this.mName = name;
	}
	
	public void setName(String name){
		this.mName = name;
	}
	
	public String getName(){
		return this.mName;
	}
}
