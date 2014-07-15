package com.cursoAndroid.practica2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener
{
	Button mFrame;
	Button mLinear;
	Button mTable;
	Button mRelative;
	Button mSalir;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);		
		addWidgets();
		addListeners();
	}
	
	private void addListeners(){
		mFrame.setOnClickListener(this);
		mLinear.setOnClickListener(this);;
		mTable.setOnClickListener(this);;
		mRelative.setOnClickListener(this);;
		mSalir.setOnClickListener(this);;
	}
	
	private void addWidgets(){
		mFrame = (Button) findViewById(R.id.main_activity_btnFrameLayout)  ;
		mLinear = (Button) findViewById(R.id.main_activity_btnLinearLayout);
		mTable = (Button) findViewById(R.id.main_activity_btnTableLayout);
		mRelative = (Button) findViewById(R.id.main_activity_btnRelativeLayout);
		mSalir = (Button) findViewById(R.id.main_activity_btnSalirLayout);
		
	}
	
	@Override
	protected void onResume(){
		
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		
		switch (v.getId()) {
		case R.id.main_activity_btnFrameLayout:
			intent.setClass(this, FrameLayoutActivity.class);
			break;
		case R.id.main_activity_btnLinearLayout:
			intent.setClass(this, LinearLayoutActivity.class);
			break;
		case R.id.main_activity_btnRelativeLayout:
			intent.setClass(this, RelativeLayoutActivity.class);
			break;
		case R.id.main_activity_btnTableLayout:
			intent.setClass(this, TableLayoutActivity.class);
			break;
		case R.id.main_activity_btnSalirLayout:
			finish();
			return;
		}
		startActivity(intent);
	}
	
}
