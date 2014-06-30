package com.cursoAndroid.practica5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	private Button mTab;
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
        setContentView(R.layout.activity_main);
	}

	private void addListeners() {
		mTab.setOnClickListener(this);
		mSalir.setOnClickListener(this);
	}

	private void addWidgets(){
		mTab = (Button) findViewById(R.id.activity_main_btnTabView);
		mSalir = (Button) findViewById(R.id.activity_main_btnSalir);
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
    	
    	switch(v.getId()){
		 case R.id.activity_main_btnSalir:
			 finish();
			 break;
		 case R.id.activity_main_btnTabView:
			 intent.setClass(this, TabViewActivity.class);
			 startActivity(intent);
			 break;
	     }

	}
	
	
}
