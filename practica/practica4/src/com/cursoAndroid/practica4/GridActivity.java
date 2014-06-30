package com.cursoAndroid.practica4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class GridActivity extends Activity implements OnItemClickListener {
 private String[] datos = new String[25];
 private GridView mOpciones;
 private TextView mLabel;
 
 @Override
 public void onCreate(Bundle savedIntancesState){
	 super.onCreate(savedIntancesState);
	 setContentView(R.layout.gridview_activity);
	 addWidgets();
	 addAdapters();
	 addListeners();
 }
 
 private void addListeners() {
	mOpciones.setOnItemClickListener(this);	
}

private void addWidgets(){
	 mLabel = (TextView) findViewById(R.id.gridview_activity_tvLabel);
	 mOpciones = (GridView) findViewById(R.id.gridview_activity_grdOpciones);
 }
 
 private void addAdapters(){
	 for(int i=1; i<=25; i++)
		 datos[i-1] = "Dato" + i;
	 ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
	 mOpciones.setAdapter(adaptador);
 }

@Override
public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	mLabel.setText("Opci�n seleccionada: " + datos[position]);
} 
 
}
