package practica9;

import com.cursoAndroid.practica9.R;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SonidoActivity extends Activity implements OnClickListener {
	private Button mCampana;
	private Button mHechizo;
	private Button mMar;
	private Button mMonjes;
	private Button mOveja;
	private Button mRayo;
	private Button mSuegra;
	private Button mSuegro;
	private Button mLakeOfFire;
	private Button mVolver;
	
	private MediaPlayer mPlayer;

	@Override
	public void onResume() {
		super.onResume();
		addWidgets();
		addListeners();
	}

	private void addListeners() {
		mCampana.setOnClickListener(this);
		mHechizo.setOnClickListener(this);
		mMar.setOnClickListener(this);
		mMonjes.setOnClickListener(this);
		mOveja.setOnClickListener(this);
		mRayo.setOnClickListener(this);
		mSuegra.setOnClickListener(this);
		mSuegro.setOnClickListener(this);
		mLakeOfFire.setOnClickListener(this);
		mVolver.setOnClickListener(this);
	}

	private void addWidgets() {
		mCampana = (Button) findViewById(R.id.sonido_activity_btnCampana);
		mHechizo= (Button) findViewById(R.id.sonido_activity_btnHechizo);
		mMar= (Button) findViewById(R.id.sonido_activity_btnMar);
		mMonjes= (Button) findViewById(R.id.sonido_activity_btnMonjes);
		mOveja= (Button) findViewById(R.id.sonido_activity_btnOveja);
		mRayo= (Button) findViewById(R.id.sonido_activity_btnRayo);
		mSuegra= (Button) findViewById(R.id.sonido_activity_btnSuegra);
		mSuegro= (Button) findViewById(R.id.sonido_activity_btnSuegro);
		mLakeOfFire= (Button) findViewById(R.id.sonido_activity_btnLakeOfFire);
		mVolver= (Button) findViewById(R.id.sonido_activity_btnVolver);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sonido_activity);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.sonido_activity_btnCampana:
			mPlayer = MediaPlayer.create(this, R.raw.campana);
			break;
		case R.id.sonido_activity_btnHechizo:
			mPlayer = MediaPlayer.create(this, R.raw.hechizo);
			break;
		case R.id.sonido_activity_btnMar:
			mPlayer = MediaPlayer.create(this, R.raw.mar);
			break;
		case R.id.sonido_activity_btnMonjes:
			mPlayer = MediaPlayer.create(this, R.raw.monjes);
			break;
		case R.id.sonido_activity_btnOveja:
			mPlayer = MediaPlayer.create(this, R.raw.oveja);
			break;
		case R.id.sonido_activity_btnRayo:
			mPlayer = MediaPlayer.create(this, R.raw.rayo);
			break;
		case R.id.sonido_activity_btnSuegro:
			mPlayer = MediaPlayer.create(this, R.raw.suegro);
			break;
		case R.id.sonido_activity_btnSuegra:
			mPlayer = MediaPlayer.create(this, R.raw.suegra);
			break;
		case R.id.sonido_activity_btnLakeOfFire:
			mPlayer = MediaPlayer.create(this, R.raw.lake_of_fire);
			break;
		default:
			finish();
			return;
		}
		mPlayer.start();
	}
	
	@Override
	protected void onDestroy(){
		if(mPlayer != null){
			mPlayer.release();
			mPlayer = null;
		}
		super.onDestroy();
		
	}

}
