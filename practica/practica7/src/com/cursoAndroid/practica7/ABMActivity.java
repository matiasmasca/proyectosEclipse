package com.cursoAndroid.practica7;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ABMActivity extends Activity implements OnClickListener  {
	private EditText mRanking; 
	private EditText mTitulo; 
	private EditText mAnio; 
	
	private Button mInsertar;
	private Button mActualizar;
	private Button mEliminar;
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
        setContentView(R.layout.abm_activity);
	}

	private void addListeners() {
		mInsertar.setOnClickListener(this);
		mActualizar.setOnClickListener(this);
		mEliminar.setOnClickListener(this);
		mSalir.setOnClickListener(this);
	}

	private void addWidgets(){
		mRanking = (EditText) findViewById(R.id.abm_activity_etRanking);
		mTitulo = (EditText) findViewById(R.id.abm_activity_etTitulo);
		mAnio = (EditText) findViewById(R.id.abm_activity_etAnio);
		
		mInsertar= (Button) findViewById(R.id.abm_activity_btnInsertar);
		mActualizar= (Button) findViewById(R.id.abm_activity_btnActualizar);
		mEliminar= (Button) findViewById(R.id.abm_activity_btnEliminar);
		mSalir = (Button) findViewById(R.id.abm_activity_btnSalir);
	}
	
	@Override
	public void onClick(View v) {
   	
    	switch(v.getId()){
		 case R.id.abm_activity_btnInsertar:
			alta();
			 break;
		 case R.id.abm_activity_btnActualizar:
			 modificacion();
			 break;
		case R.id.abm_activity_btnEliminar:
			baja();
			break;
		case R.id.abm_activity_btnSalir:
			 finish();
			 break;
		}

	}

	private void baja() {
		PeliculasSQLiteHelper pelisHelper = new PeliculasSQLiteHelper(this, "DBPeliculas", null , 1);
		SQLiteDatabase db = pelisHelper.getWritableDatabase();	
		if(db != null)
		{	
			String where = "ranking" + mRanking.getText().toString(); //Condici�n de la consulta.
			try
			{
				db.delete("Peliculas", where, null); //ejecuta de la consulta.
			}
			 catch(Exception e)
			 {
				 Toast.makeText(this, "No se pudo realizar la eliminaci�n", Toast.LENGTH_LONG).show();
			 }
			finally
			{
				db.close();
			}
			 Toast.makeText(this, "Eliminaci�n realizada con �xito", Toast.LENGTH_LONG).show();
			}
			else
				 Toast.makeText(this, "No se pudo realizar la eliminaci�n.", Toast.LENGTH_LONG).show();
	}

	private void modificacion() {
		PeliculasSQLiteHelper pelisHelper = new PeliculasSQLiteHelper(this, "DBPeliculas", null , 1);
		SQLiteDatabase db = pelisHelper.getWritableDatabase();	
		if(db != null)
		{
			ContentValues registroAEditar = new ContentValues();
			
			registroAEditar.put("titulo", mTitulo.getText().toString());
			registroAEditar.put("anio", mAnio.getText().toString());
			
			String where = "ranking" + mRanking.getText().toString();
			try
			{
				db.update("Peliculas", registroAEditar, where, null);
			}
			 catch(Exception e)
			 {
				 Toast.makeText(this, "No se pudo realizar la actualizaci�n", Toast.LENGTH_LONG).show();
			 }
			finally
			{
				db.close();
			}
			 Toast.makeText(this, "Actualizaci�n realizada con �xito", Toast.LENGTH_LONG).show();
			}
			else
				 Toast.makeText(this, "No se pudo realizar la actualizaci�n.", Toast.LENGTH_LONG).show();
		
	}

	private void alta() {
		PeliculasSQLiteHelper pelisHelper = new PeliculasSQLiteHelper(this, "DBPeliculas", null , 1);
		SQLiteDatabase db = pelisHelper.getWritableDatabase();
		
		if(db != null)
		{
		  ContentValues nuevoRegistro = new ContentValues();
		
		nuevoRegistro.put("ranking", mRanking.getText().toString());
		nuevoRegistro.put("titulo", mTitulo.getText().toString());
		nuevoRegistro.put("anio", mAnio.getText().toString());
		
		try
		{
			db.insert("Peliculas", null, nuevoRegistro);
		}
		 catch(Exception e)
		 {
			 Toast.makeText(this, "No se pudo realizar la inserci�n", Toast.LENGTH_LONG).show();
		 }
		finally
		{
			db.close();
		}
		 Toast.makeText(this, "Inserci�n realizada con �xito", Toast.LENGTH_LONG).show();
		}
		else
			 Toast.makeText(this, "No se pudo realizar la inserci�n", Toast.LENGTH_LONG).show();
	  
	}
}
