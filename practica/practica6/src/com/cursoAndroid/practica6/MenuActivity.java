/* Ejercicio para crear Menus y SubMenus 
 * con diferentes alternativas * 
 * */


package com.cursoAndroid.practica6;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MenuActivity extends Activity  {
//  Para alternativa 2 de menu.
//	private static final int MNU_OPC1 = 1;
//	private static final int MNU_OPC2 = 2;
//	private static final int MNU_OPC3 = 3;
  
	private TextView mMensaje;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_activity);
	}
	
	
	public void onResume(){
		super.onResume();
		addWidgets();
	}

	private void addWidgets(){
		mMensaje = (TextView) findViewById(R.id.menu_activity_tvMensaje);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		//Alternativa 1
		//getMenuInflater().inflate(R.menu.menumainactivity, menu);
		//return true;
		
		//Alternativa 2
//		menu.add(Menu.NONE, MNU_OPC1,Menu.NONE, "Opci�n 1").setIcon(android.R.drawable.ic_menu_preferences);
//		menu.add(Menu.NONE, MNU_OPC2,Menu.NONE, "Opci�n 1").setIcon(android.R.drawable.ic_menu_compass);
//		menu.add(Menu.NONE, MNU_OPC3,Menu.NONE, "Opci�n 1").setIcon(android.R.drawable.ic_menu_agenda);
//		return true;
		
		//Alternativa 3
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId())
		{
		case R.id.MnuOpc1:
			mMensaje.setText("Opcion 1 pulsada");
			return true;
		case R.id.MnuOpc2:
			mMensaje.setText("Opcion 2 pulsada");
			return true;
		case R.id.MnuOpc3:
			mMensaje.setText("Opcion 3 pulsada");
			return true;
		default:
			return super.onOptionsItemSelected(item);
			
		}
	}
	
	
// Opcion 1	
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item){
//		switch (item.getItemId())
//		{
//		case R.id.MnuOpc1:
//			mMensaje.setText("Opcion 1 pulsada");
//			return true;
//		case R.id.MnuOpc2:
//			mMensaje.setText("Opcion 1 pulsada");
//			return true;
//		case R.id.MnuOpc3:
//			mMensaje.setText("Opcion 1 pulsada");
//			return true;
//		default:
//			return super.onOptionsItemSelected(item);
//			
//		}
//	}
	
// OPCION 2. PARA MENUES
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item){
//		switch (item.getItemId())
//		{
//		case MNU_OPC1:
//			mMensaje.setText("Opcion 1 pulsada");
//			return true;
//		case MNU_OPC2:
//			mMensaje.setText("Opcion 2 pulsada");
//			return true;
//		case MNU_OPC3:
//			mMensaje.setText("Opcion 3 pulsada");
//			return true;
//		default:
//			return super.onOptionsItemSelected(item);
//			
//		}
//	}
	
}
