package com.cursoAndroid.practica6;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MenuConextualActivity extends Activity {
	private TextView mSeleccion;
	private ListView mPeliculas;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.context_menu_activity);
		
		addWidgets();
		addAdapters();
		
		registerForContextMenu(mPeliculas); //recibe el evento de creacion del menu contextual.
	}
	
	private void addAdapters() {
		// TODO Auto-generated method stub
		ArrayAdapter<CharSequence> adtPelis = ArrayAdapter.createFromResource(this, R.array.peliculas, android.R.layout.simple_list_item_1);
		mPeliculas.setAdapter(adtPelis);
	}

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo){
		super.onCreateContextMenu(menu, v, menuInfo);
		
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.context_menu_activity, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item){
		switch (item.getItemId()) {
		case R.id.CtxLstOpc1:
			mSeleccion.setText("Etiqueta: Opcion 1 pulsada!");
			return true;
		case R.id.CtxLstOpc2:
			mSeleccion.setText("Etiqueta: Opcion 2 pulsada!");
			return true;
		default:
			return super.onContextItemSelected(item);
		}
	}
    
    public void onResume(){
		super.onResume();
		addWidgets();
	}

	private void addWidgets(){
		mSeleccion = (TextView) findViewById(R.id.context_menu_activity_tvSeleccion);
		mPeliculas = (ListView) findViewById(R.id.context_menu_activity_lvPeliculas);
	}
	
		
}
