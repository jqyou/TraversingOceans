package com.example.popup;

import android.app.Application;

public class Storage extends Application{
	
	private String user_name = "HaHa";
	
	public String get_user_name(){
		return this.user_name;
	}
	
	public void set_user_name(String name){
		this.user_name = name;
	}

}
