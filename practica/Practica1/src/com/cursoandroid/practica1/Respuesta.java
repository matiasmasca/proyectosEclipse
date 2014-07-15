package com.cursoandroid.practica1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Respuesta extends Activity implements OnClickListener {
	public static String NOMBRE = "nombre";
	
	private TextView mSaludo;
	private Button mVolver;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.respuesta);
	}
	
	public void onResume()
	{
		super.onResume();
		addWidgets();
		addListeners();
		setData();
	}
	
	private void setData()
	{
		Intent intent = getIntent();
		String nombre = intent.getStringExtra(Respuesta.NOMBRE);
		mSaludo.setText(nombre);
	}
	
	private void addWidgets()
	{
		mSaludo = (TextView) findViewById(R.id.respuesta_txtRespuesta);
		mVolver = (Button) findViewById(R.id.respuesta_btnVolver);
				
	}
	
	private void addListeners(){
		mVolver.setOnClickListener(this);
	}
	
	//TODO: falta crear el listener para el click del btn volver
	@Override
	public void onClick(View v)
	{
		finish();
	}
}
