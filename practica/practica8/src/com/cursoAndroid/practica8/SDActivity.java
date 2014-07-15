package com.cursoAndroid.practica8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SDActivity extends Activity implements OnClickListener{

	private Button mLeerArchivo;
	private Button mGuardar;
	private Button mVolver;
	private EditText mNombreArchivo;
	private EditText mContenido;
	
	@Override
	public void onResume(){
		super.onResume();
		addWidgets();
		addListeners();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState ){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.sd_activity);
	}

	private void addListeners() {
		mLeerArchivo.setOnClickListener(this);
		mGuardar.setOnClickListener(this);
		mVolver.setOnClickListener(this);
	}

	private void addWidgets(){
		mLeerArchivo = (Button) findViewById(R.id.sd_activity_btnLeer);
		mGuardar = (Button) findViewById(R.id.sd_activity_btnGuardar);
		mVolver = (Button) findViewById(R.id.sd_activity_btnVolver);
		mNombreArchivo = (EditText) findViewById(R.id.sd_activity_etNombre);
		mContenido = (EditText) findViewById(R.id.sd_activity_etContenido);
		
	}
	
	@Override
	public void onClick(View v) {   	
    	switch(v.getId()){
		 case R.id.sd_activity_btnVolver:
			 finish();
			 break;
		 case R.id.sd_activity_btnLeer:
			 leerArchivo();
			 break;
		case R.id.sd_activity_btnGuardar:
			guardarArchivo();
			break;
		}

	}

	private void guardarArchivo() {
		//Se necesita un contexto para trabajar con archivos.
		String nombreArchivo = mNombreArchivo.getText().toString();
		String contenido = mContenido.getText().toString();
		
		try {
			
			File ruta_sd = Environment.getExternalStorageDirectory() ;
			//
			File f = new File(ruta_sd.getAbsolutePath(), nombreArchivo);
			
			//Cambio del otro, en el new FileOutputStream con la ruta relativa a la SD.
			OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f));
			
			fout.write(contenido);
			fout.close();
		
		} catch (Exception e) {
			Toast.makeText(this, "Error al escribir el archivo desde la memoria sd.", Toast.LENGTH_LONG).show();
		}
	}

	private void leerArchivo() {

		String nombreArchivo = mNombreArchivo.getText().toString();
		
		// Cada dispositivo tiene su estructura de SD.
		// En el manifest, necesita cambiar los permisos de acceso. Se agregar un UserPermision y de ahi el Write External Storage.
		File ruta_sd = Environment.getExternalStorageDirectory() ;
		//
		File f = new File(ruta_sd.getAbsolutePath(), nombreArchivo);
		
		try {
			BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			String contenido = "";
			String linea ;
			
			while ((linea = fin.readLine()) != null) {
				contenido += linea + "\n"; 
			}
			
			mContenido.setText(contenido);
			fin.close();
		} catch (Exception ex) {
			Toast.makeText(this, "Error al leer el archivo desde la memoria SD.", Toast.LENGTH_LONG).show();
		}
		
	}
	
	
}