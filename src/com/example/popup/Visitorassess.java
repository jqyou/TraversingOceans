package com.example.popup;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.traversingoceans.R;

public class Visitorassess extends Activity {

	private String URL_PATH = "http://1.traversingoceans.sinaapp.com/index.php/api/search";
	private String GPA;
	private String TI;
	private String GRE;
	private String country;
	private String[] name;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.visitorassess);

		String[] target = { "USA", "UK", "HK&Macau", "Australia", "Singapore" };
		String[] master = { "Master", "PHD" };
		String[] major = { "Business", "Engineering", "Law", "Science",
				"Medical" };

		final Spinner spinner1, spinner2, spinner3;
		ArrayAdapter<String> adapter1, adapter2, adapter3;

		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		spinner3 = (Spinner) findViewById(R.id.spinner3);

		// ����ѡ������ArrayAdapter��������
		adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, target);
		adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, master);
		adapter3 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, major);

		// ���������б�ķ��
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// ��adapter ��ӵ�spinner��
		spinner1.setAdapter(adapter1);
		spinner2.setAdapter(adapter2);
		spinner3.setAdapter(adapter3);

		// ����Ĭ��ֵ
		spinner1.setVisibility(View.VISIBLE);
		spinner2.setVisibility(View.VISIBLE);
		spinner3.setVisibility(View.VISIBLE);

		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(Visitorassess.this, Homepage.class);
				Visitorassess.this.startActivity(intent);
			}

		});

		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				EditText gpa = (EditText) findViewById(R.id.editText1);
				GPA = gpa.getText().toString();
				EditText ti = (EditText) findViewById(R.id.editText2);
				TI = ti.getText().toString();
				EditText gre = (EditText) findViewById(R.id.editText3);
				GRE = gre.getText().toString();
				country = spinner1.getSelectedItem().toString();
				new UploadWebpageTask().execute(URL_PATH);
			}
		});
	}

	private class UploadWebpageTask extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... urls) {
			try {
				return downloadUrl(URL_PATH);
			} catch (IOException e) {
				e.printStackTrace();
				return "URL maybe invalid";
			}
		}

		// onPostExecute displays the results of the AsyncTask.
		@Override
		protected void onPostExecute(String result) {
			/*Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT)
					.show();*/
			
			 Intent intent = new Intent(); intent.setClass(Visitorassess.this,
			 Rankvisitor.class); Visitorassess.this.startActivity(intent);
			 
		}
	}

	private String downloadUrl(String myurl) throws IOException {
		InputStream is = null;

		int len = 5000;

		try {
			URL url = new URL(myurl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);//app到服务器
			conn.setDoInput(true);//服务器到app
			conn.setConnectTimeout(10000);//10秒中建立连接
			conn.setReadTimeout(10000);//读取数据
			conn.setUseCaches(false);
			conn.setInstanceFollowRedirects(true);
			conn.setRequestProperty("charset", "utf-8");
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");

			conn.connect();

			DataOutputStream out = new DataOutputStream(conn.getOutputStream());

			JSONObject content = new JSONObject();

			try {
				content.put("GPA", GPA);
				content.put("TI", TI);
				content.put("GRE", GRE);
				content.put("country", country);
			} catch (JSONException e) {
				e.printStackTrace();
			}

			out.write(content.toString().getBytes());
			out.flush();
			out.close();//在服务器端写上post函数，接收从app到服务器端的东西

			is = conn.getInputStream();
			String contentAsString = readIt(is, len);
			conn.disconnect();
			return contentAsString;

		} finally {
			if (is != null) {
				is.close();
			}
		}

	}

	public String readIt(InputStream stream, int len) throws IOException,
			UnsupportedEncodingException {
		Reader reader = null;
		reader = new InputStreamReader(stream, "UTF-8");
		char[] buffer = new char[len];
		reader.read(buffer);
		return new String(buffer);
	}
}