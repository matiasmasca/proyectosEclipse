package com.cursoAndroid.practica8;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.cursoAndroid.practica8.R;

public class RawActivity extends Activity implements OnClickListener{

	private Button mLeerArchivo;
	private Button mVolver;
	private EditText mContenido;
	private Spinner mArchivos;
	
	private String[] mArchivosLyrics;
	
	@Override
	public void onResume(){
		super.onResume();
		addWidgets();
		addAdapters();
		addListeners();
	}
	
	private void addAdapters() {
		mArchivosLyrics = new String[]{"Even Flow", "Jermy", "Back in back", "Paranoid android"};
		
		ArrayAdapter<String> adtLetras = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mArchivosLyrics);
    	mArchivos.setAdapter(adtLetras);
		
	}

	@Override
	public void onCreate(Bundle savedInstanceState ){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.raw_activity);
	}

	private void addListeners() {
		mLeerArchivo.setOnClickListener(this);
		mVolver.setOnClickListener(this);
	}

	private void addWidgets(){
		mArchivos = (Spinner) findViewById(R.id.raw_activity_spinner);
		mLeerArchivo = (Button) findViewById(R.id.raw_activity_btnLeerArchivo);
		mVolver = (Button) findViewById(R.id.raw_activity_btnVolver);
		mContenido = (EditText) findViewById(R.id.raw_activity_etContenido);
		
	}
	
	@Override
	public void onClick(View v) {   	
    	switch(v.getId()){
		 case R.id.raw_activity_btnVolver:
			 finish();
			 break;
		 case R.id.raw_activity_btnLeerArchivo:
			 leerArchivo();
			 break;

		}

	}

	private void leerArchivo() {
		int archivoRaw = R.raw.even_flow; 
		
		try {
			switch (mArchivos.getSelectedItemPosition()) {
			case 0:
				archivoRaw = R.raw.even_flow;
				break;
			case 1:
				archivoRaw = R.raw.jeremy;	
				break;
			case 2:
				archivoRaw = R.raw.back_in_black;
				break;
			case 3:
				archivoRaw = R.raw.paranoid_android;
				break;
			}
			
			//Obtenemos el archivo desde lo recursos.
			InputStream fraw = getResources().openRawResource(archivoRaw);
			
			BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));
		
			String contenido = "";
			String linea;
			
			while ((linea = brin.readLine()) != null) {
				contenido += linea + "\n";
			}
		    
			fraw.close(); //cerramos el recurso.
			mContenido.setText(contenido);
			
		} catch (Exception ex) {
			Toast.makeText(this, "Error al leer el archivo desde la carpeta raw.", Toast.LENGTH_LONG).show();
		}
		
	}
	
	
}