package com.cursoAndroid.practica8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cursoAndroid.practica8.R;

public class InternaActivity extends Activity implements OnClickListener{

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
        setContentView(R.layout.interna_activity);
	}

	private void addListeners() {
		mLeerArchivo.setOnClickListener(this);
		mGuardar.setOnClickListener(this);
		mVolver.setOnClickListener(this);
	}

	private void addWidgets(){
		mLeerArchivo = (Button) findViewById(R.id.interna_activity_btnLeer);
		mGuardar = (Button) findViewById(R.id.interna_activity_btnGuardar);
		mVolver = (Button) findViewById(R.id.interna_activity_btnVolver);
		mNombreArchivo = (EditText) findViewById(R.id.interna_activity_etNombre);
		mContenido = (EditText) findViewById(R.id.interna_activity_etContenido);
		
	}
	
	@Override
	public void onClick(View v) {   	
    	switch(v.getId()){
		 case R.id.interna_activity_btnVolver:
			 finish();
			 break;
		 case R.id.interna_activity_btnLeer:
			 leerArchivo();
			 break;
		case R.id.interna_activity_btnGuardar:
			guardarArchivo();
			break;
		}

	}

	private void guardarArchivo() {
		//Se necesita un contexto para trabajar con archivos.
		String nombreArchivo = mNombreArchivo.getText().toString();
		String contenido = mContenido.getText().toString();
		
		try {
			OutputStreamWriter fout = new OutputStreamWriter(openFileOutput(nombreArchivo, Context.MODE_PRIVATE));
			fout.write(contenido);
			fout.close();
		
		} catch (Exception e) {
			Toast.makeText(this, "Error al escribir el archivo desde la memoria interna.", Toast.LENGTH_LONG).show();
		}
	}

	private void leerArchivo() {
		//las clases para leer heredan de contexto, se necesita ese contexto.
		//necesitaremos hacer dentro de una activity o hacerlo desde un contexto.
		//si no tengo contexto, debo obtenerlo como setContext, o con un constructor.
		String nombreArchivo = mNombreArchivo.getText().toString();
		
		try {
			BufferedReader fin = new BufferedReader(new InputStreamReader(openFileInput(nombreArchivo)));
			//No te olvides de cerrar el puntero FIN!
			String contenido = "";
			String linea ;
			
			while ((linea = fin.readLine()) != null) {
				contenido += linea + "\n"; 
			}
			
			mContenido.setText(contenido);
			fin.close();
		} catch (Exception ex) {
			Toast.makeText(this, "Error al leer el archivo desde la memoria interna.", Toast.LENGTH_LONG).show();
		}
		
	}
	
	
}

