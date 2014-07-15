package com.cursoAndroid.practica8;


import com.cursoAndroid.practica8.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener{

	private Button mArchivosMemoria;
	private Button mArchivosRaw;
	private Button mArchivosSD;
	private Button mSalir;
	
	@Override
	public void onResume(){
		super.onResume();
		addWidgets();
		addListeners();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState ){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
	}

	private void addListeners() {
		mArchivosMemoria.setOnClickListener(this);
		mArchivosRaw.setOnClickListener(this);
		mArchivosSD.setOnClickListener(this);
		mSalir.setOnClickListener(this);
	}

	private void addWidgets(){
		mArchivosMemoria = (Button) findViewById(R.id.main_activity_btnArchivoMemoria);
		mArchivosRaw = (Button) findViewById(R.id.main_activity_btnArchivosRaw);
		mArchivosSD = (Button) findViewById(R.id.main_activity_btnArchivosSD);
		mSalir = (Button) findViewById(R.id.main_activity_btnSalir);
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
    	
    	switch(v.getId()){
		 case R.id.main_activity_btnSalir:
			 finish();
			 break;
		 case R.id.main_activity_btnArchivoMemoria:
			 intent.setClass(this, InternaActivity.class);
			 startActivity(intent);
			 break;
		case R.id.main_activity_btnArchivosRaw:
			intent.setClass(this, RawActivity.class);
			startActivity(intent);
			break;
		case R.id.main_activity_btnArchivosSD:
			intent.setClass(this, SDActivity.class);
			startActivity(intent);
			break;
		}

	}
	
	
}
