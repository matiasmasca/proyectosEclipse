package com.cursoAndroid.practica7;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HelperActivity extends Activity implements OnClickListener {
	TextView mMensaje;
	Button mCrear;

	@Override
	public void onResume(){
		super.onResume();
		addWidgets();
		addListeners();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState ){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.helper_activity);
	}

	private void addListeners() {
		mCrear.setOnClickListener(this);

	}

	private void addWidgets(){
		mCrear = (Button) findViewById(R.id.helper_activity_btnCrear);
		mMensaje = (TextView) findViewById(R.id.helper_activity_tvMensaje);
	}
	@Override
	public void onClick(View v) {	
		crearDB();
	}

	private void crearDB() {
		PeliculasSQLiteHelper pelisHelper = new PeliculasSQLiteHelper(this, "DBPeliculas", null , 1);
		SQLiteDatabase db = pelisHelper.getWritableDatabase();
		

		if(db != null){
			mMensaje.setText("Base de datos creada!");
			db.close();
		}
		else
			mMensaje.setText("No se pudo crear la base de datos... =(");
		}
		
	}

