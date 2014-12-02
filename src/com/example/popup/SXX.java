package com.example.popup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.traversingoceans.R;

public class SXX extends Activity {

	private Storage storage;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.sunxiaoxuan);
		storage = (Storage) getApplication();
		TextView user_name = (TextView) findViewById(R.id.textView1);
		user_name.setText(storage.get_user_name());

		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(SXX.this, Academicinfo.class);
				SXX.this.startActivity(intent);
			}

		});

		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(SXX.this, Rankvisitor.class);
				SXX.this.startActivity(intent);
			}

		});

		Button button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(SXX.this, Homepage.class);
				SXX.this.startActivity(intent);
			}

		});
	}

}