package com.example.popup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.traversingoceans.R;


public class Academicinfo extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.academicinfo);

		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(Academicinfo.this, SXX.class);
				Academicinfo.this.startActivity(intent);
			}

		});

		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(Academicinfo.this, Academicrank.class);
				Academicinfo.this.startActivity(intent);
			}

		});
		
		String[] target = { "USA", "UK", "HK$Macau", "Singapore", "Australia" };
		String[] master = { "Master", "PHD" };
		String[] major = { "Business", "Engineering", "Law", "Science", "Medical" };
		Spinner spinner1, spinner2, spinner3;
		ArrayAdapter<String> adapter1, adapter2, adapter3;
		
		
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		spinner3 = (Spinner) findViewById(R.id.spinner3);
		
		// 将可选内容与ArrayAdapter连接起来
		adapter1 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, target);
		adapter2 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, master);
		adapter3 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, major);
		
		// 设置下拉列表的风格
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// 将adapter 添加到spinner中
		spinner1.setAdapter(adapter1);
		spinner2.setAdapter(adapter2);
		spinner3.setAdapter(adapter3);
	
		
		// 设置默认值
		spinner1.setVisibility(View.VISIBLE);
		spinner2.setVisibility(View.VISIBLE);
		spinner3.setVisibility(View.VISIBLE);
				
	}

}