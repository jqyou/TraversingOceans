package com.example.popup;

import com.example.traversingoceans.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Academicrank extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.rankacademic);

		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(Academicrank.this, SXX.class);
				Academicrank.this.startActivity(intent);
			}

		});

		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(Academicrank.this, Moreinfo.class);
				Academicrank.this.startActivity(intent);
			}

		});
	}

}