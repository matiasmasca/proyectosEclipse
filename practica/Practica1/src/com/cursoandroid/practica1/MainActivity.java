package com.cursoandroid.practica1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	private EditText mNombre;
	private Button mSaludar;
	private Button mSalir;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
	}
	
	public void onResume()
	{
		super.onResume();
		addWidgets();
		addListeners();
	}
	
	public void addWidgets()
	{
		mNombre = (EditText) findViewById(R.id.txtNombre);
		mSaludar = (Button) findViewById(R.id.main_activity_btnSaludar);
		mSalir = (Button) findViewById(R.id.main_activity_btnSalir);
	}
	
	private void addListeners(){
	  mSaludar.setOnClickListener(this);
	  mSalir.setOnClickListener(this);
	}
	
	
    @Override
	public void onClick(View v) {
    	String nombre = mNombre.getText().toString(); 
    	Intent intent = new Intent();
    	
    	switch(v.getId()){
		 case R.id.main_activity_btnSalir:
			 Toast.makeText(this, "Chau " + nombre, Toast.LENGTH_LONG).show();
			 finish();
			 break;
		 case R.id.main_activity_btnSaludar:
			 intent.putExtra(Respuesta.NOMBRE, "pepe");
			 intent.setClass(this, Respuesta.class);
			 startActivity(intent);
			 //Toast.makeText(this, "Hola " + nombre, Toast.LENGTH_LONG).show();
			 break;
	     }
    }
	  
	

}
