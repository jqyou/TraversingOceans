package com.example.popup;

import com.example.traversingoceans.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Moreinfotwo extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moreinfotwo);

		
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(Moreinfotwo.this, Rankfinally.class);
				Moreinfotwo.this.startActivity(intent);
			}

		});
		
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(Moreinfotwo.this, Moreinfo.class);
				Moreinfotwo.this.startActivity(intent);
			}

		});
	
		String[] expense = { "<20000", "20000-40000",">40000" };
		String[] safety = { "<15", "15-30", "31-51"};
		String[] employment = { ">85%", ">80%",">70%",">60%" };
		String[] rainfall = { "middle", "low", "high", "vigh" };
		String[] hightem = { "<25", "25-30", ">30" };
		String[] lowtem = { ">5", "minus5-5", "<minus5" };
	

		Spinner spinner1, spinner2, spinner3, spinner4, spinner5, spinner6;
		ArrayAdapter<String> adapter1, adapter2, adapter3, adapter4, adapter5, adapter6;

		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		spinner3 = (Spinner) findViewById(R.id.spinner3);
		spinner4 = (Spinner) findViewById(R.id.spinner4);
		spinner5 = (Spinner) findViewById(R.id.spinner5);
		spinner6 = (Spinner) findViewById(R.id.spinner6);

		// 将可选内容与ArrayAdapter连接起来
		adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, expense);
		adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, safety);
		adapter3 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, employment);
		adapter4 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, rainfall);
		adapter5 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, hightem);
		adapter6 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, lowtem);

		// 设置下拉列表的风格
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// 将adapter 添加到spinner中
		spinner1.setAdapter(adapter1);
		spinner2.setAdapter(adapter2);
		spinner3.setAdapter(adapter3);
		spinner4.setAdapter(adapter3);
		spinner5.setAdapter(adapter3);
		spinner6.setAdapter(adapter3);

		// 设置默认值
		spinner1.setVisibility(View.VISIBLE);
		spinner2.setVisibility(View.VISIBLE);
		spinner3.setVisibility(View.VISIBLE);
		spinner4.setVisibility(View.VISIBLE);
		spinner5.setVisibility(View.VISIBLE);
		spinner6.setVisibility(View.VISIBLE);

	}
}