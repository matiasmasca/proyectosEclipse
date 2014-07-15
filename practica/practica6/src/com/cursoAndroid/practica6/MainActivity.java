package com.cursoAndroid.practica6;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	private Button mMenu;
	private Button mMenuContextuales;
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
		mMenu.setOnClickListener(this);
		mMenuContextuales.setOnClickListener(this);
		mSalir.setOnClickListener(this);
	}

	private void addWidgets(){
		mMenu = (Button) findViewById(R.id.main_activity_btnMenus);
		mMenuContextuales = (Button) findViewById(R.id.main_activity_btnMenuContextual);
		mSalir = (Button) findViewById(R.id.main_activity_btnSalir);
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
    	
    	switch(v.getId()){
		 case R.id.main_activity_btnSalir:
			 finish();
			 break;
		 case R.id.main_activity_btnMenus:
			 intent.setClass(this, MenuActivity.class);
			 startActivity(intent);
			 break;
		case R.id.main_activity_btnMenuContextual:
			intent.setClass(this, MenuConextualActivity.class);
			startActivity(intent);
			break;
		}

	}
	
	
}
