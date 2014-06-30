package com.cursoAndroid.practica4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	private Button mSpiner;
	private Button mListView;
	private Button mGridView;
	private Button mSalir;
	
	@Override
	public void onCreate(Bundle savedInstanceState ){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
		addWidgets();
		addListeners();
	}

	private void addListeners() {
		mSpiner.setOnClickListener(this);
		mListView.setOnClickListener(this);
		mGridView.setOnClickListener(this);
		mSalir.setOnClickListener(this);
	}

	private void addWidgets(){
		mSpiner = (Button) findViewById(R.id.main_activity_btnSpiner);
		mListView = (Button) findViewById(R.id.main_activity_btnListView);
		mGridView = (Button) findViewById(R.id.main_activity_btnGridView);
		mSalir = (Button) findViewById(R.id.main_activity_btnSalir);
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
    	
    	switch(v.getId()){
		 case R.id.main_activity_btnSalir:
			 finish();
			 break;
		 case R.id.main_activity_btnSpiner:
			 intent.setClass(this, SpinnerActivity.class);
			 startActivity(intent);
			 break;
		 case R.id.main_activity_btnListView:
			 intent.setClass(this, ListviewActivity.class);
			 startActivity(intent);
			 break;
		 case R.id.main_activity_btnGridView:
		 	intent.setClass(this, GridActivity.class);
	     }
		
	}
	
	
}
