package com.cursoandroid.practica3;

import com.cursoandroid.practica3.ButtonsActivity;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener
{
	Button mBotones;
	Button mTextoEImagenes;
	Button mChecksYOpciones;
	Button mSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.);
		addWidgets();
		addListeners();
    }

   private void addWidgets(){
	 mBotones = (Button) findViewById(R.id.main_activity_btnBotones);
  	 mTextoEImagenes =  (Button) findViewById(R.id.main_activity_btnTextosEImagenes);
	 mChecksYOpciones =  (Button) findViewById(R.id.main_activity_btnChecksYOpciones);
	 mSalir =  (Button) findViewById(R.id.main_activity_btnSalir);
   }   
   
	private void addListeners() {
		mBotones.setOnClickListener(this);
		mTextoEImagenes.setOnClickListener(this);
		mChecksYOpciones.setOnClickListener(this);
		mSalir.setOnClickListener(this);
	}

@Override
public void onClick(View v) {
	Intent intent = new Intent();
	switch (v.getId()) {
	case R.id.main_activity_btnBotones:
		intent.setClass(this, ButtonsActivity.class);
		startActivity(intent);
		break;
	case R.id.main_activity_btnTextosEImagenes:

		break;
	case R.id.main_activity_btnChecksYOpciones:

		break;
	case R.id.main_activity_btnSalir:
		finish();
		return;
	}
	
}


}
