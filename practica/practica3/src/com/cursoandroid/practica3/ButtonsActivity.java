package com.cursoandroid.practica3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ButtonsActivity extends Activity implements OnClickListener {
	private TextView mMensaje;
	private Button mButton;
	private ImageButton mImageButton;
	private ToggleButton mToggleButton;
	private Button mButtonCI;
	private ToggleButton mToggleButtonCI;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttons_activity);
    }
	
	public void onResume()
	{
		super.onResume();
		addWidgets();
		addListeners();
	}
	
	private void addWidgets()
	{
		mMensaje = (TextView) findViewById(R.id.buttons_activity_tvMensaje);
		mButton = (Button) findViewById(R.id.buttons_activity_btnBoton);
		mImageButton = (ImageButton) findViewById(R.id.buttons_activity_ibtImagenButtonCI);
		mToggleButton = (ToggleButton) findViewById(R.id.buttons_activity_tglToggleButton1);
		mButtonCI = (Button) findViewById(R.id.buttons_activity_btnButtonCI);
		mToggleButtonCI = (ToggleButton) findViewById(R.id.buttons_activity_tglToggleButtonCI);		
	}
	
	private void addListeners(){
		mMensaje.setOnClickListener(this) ;
		mButton.setOnClickListener(this) ;
		mImageButton.setOnClickListener(this);
		mToggleButton.setOnClickListener(this) ;
		mButtonCI.setOnClickListener(this) ;
		mToggleButtonCI.setOnClickListener(this);
	}
	
	//TODO: falta crear el listener para el click del btn volver
	@Override
	public void onClick(View v)
	{
		//aca va el switch
		//indica en mMensaje el boton que presiono.
		//en toggle indicamos si se prendio o si se apago.
		
		switch (v.getId()) {
		case R.id.buttons_activity_btnBoton:
			mMensaje.setText("Se pulsó el button");
			break;
		case R.id.buttons_activity_ibtImagenButtonCI:
			mMensaje.setText("Se pulsó el ImageButton con Imagen");
			break;
		case R.id.buttons_activity_tglToggleButton1:
			if(mToggleButton.isChecked())
				mMensaje.setText("Se prendio el Toggle");
			else
				mMensaje.setText("Se apago el Toggle");
			break;
			
		case R.id.buttons_activity_btnButtonCI:
			mMensaje.setText("Se pulsó el button");
			break;
		case R.id.buttons_activity_tglToggleButtonCI:
			if(mToggleButton.isChecked())
				mMensaje.setText("Se prendio el Toggle");
			else
				mMensaje.setText("Se apago el Toggle");
			break;
		}
	}
	
}
