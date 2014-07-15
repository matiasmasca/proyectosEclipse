package com.cursoAndroid.practica7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	private Button mHelper;
	private Button mABM;
	private Button mSelect;
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
		mHelper.setOnClickListener(this);
		mABM.setOnClickListener(this);
		mSelect.setOnClickListener(this);
		mSalir.setOnClickListener(this);
	}

	private void addWidgets(){
		mHelper = (Button) findViewById(R.id.main_activity_btnHelper);
		mABM = (Button) findViewById(R.id.main_activity_btnABM);
		mSelect = (Button) findViewById(R.id.main_activity_btnSelect);
		mSalir = (Button) findViewById(R.id.main_activity_btnSalir);
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
    	
    	switch(v.getId()){
		 case R.id.main_activity_btnSalir:
			 finish();
			 break;
		 case R.id.main_activity_btnHelper:
			 intent.setClass(this, HelperActivity.class);
			 startActivity(intent);
			 break;
		case R.id.main_activity_btnABM:
			intent.setClass(this, ABMActivity.class);
			startActivity(intent);
			break;
		case R.id.main_activity_btnSelect:
			intent.setClass(this, SelectActivity.class);
			startActivity(intent);
			break;
		}

	}
	
	
}