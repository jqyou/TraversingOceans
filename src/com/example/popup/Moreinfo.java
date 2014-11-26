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

public class Moreinfo extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moreinfo);
		
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(Moreinfo.this, Moreinfotwo.class);
				Moreinfo.this.startActivity(intent);
			}

		});

		String[] terrian = { "Plain", "Mountain" };
		String[] district = { "East", "West", "North", "South" };
		String[] tourism = { "Yes", "No" };
		Spinner spinner1, spinner2, spinner3;
		ArrayAdapter<String> adapter1, adapter2, adapter3;

		spinner1 = (Spinner) findViewById(R.id.Spinner01);
		spinner2 = (Spinner) findViewById(R.id.Spinner02);
		spinner3 = (Spinner) findViewById(R.id.Spinner03);

		// 将可选内容与ArrayAdapter连接起来
		adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, terrian);
		adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, district);
		adapter3 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, tourism);

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