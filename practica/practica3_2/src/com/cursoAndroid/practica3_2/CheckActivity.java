package com.cursoAndroid.practica3_2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CheckActivity extends Activity implements OnCheckedChangeListener, android.widget.RadioGroup.OnCheckedChangeListener 
{
	CheckBox mCheck;
	TextView mMensaje;
	RadioGroup mGroup;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.check_activity);
		addWidgets();
		addListeners();
   }
	
	public void onResume()
	{
		super.onResume();
		addWidgets();
		addListeners();
	}
	
	public void addWidgets()
	{
		mMensaje = (TextView) findViewById(R.id.check_activity_txtMensaje);
		mCheck = (CheckBox) findViewById(R.id.check_activity_checkBox1);
		mGroup = (RadioGroup) findViewById(R.id.check_activity_radioGroup1);
	}
	
	private void addListeners(){
		mCheck.setOnCheckedChangeListener(this);
		mGroup.setOnCheckedChangeListener(this);
	}
	
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isCheked){
		if(isCheked)
				mMensaje.setText("Checkbox marcado!");
			else
				mMensaje.setText("Checkbox desmarcado!");
		
	}
	
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId){
		mMensaje.setText("ID opción seleccionada:" + checkedId);
	}

}
