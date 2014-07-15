package practica9;

import com.cursoAndroid.practica9.R;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MusicaActivity extends Activity implements OnClickListener  {
    private static int TIEMPO = 5000; //5 milisegundos, para poder hacer retroceder la musica.
	
	private ImageButton mPausa;
    private ImageButton mReproducir;
    private ImageButton mRetroceder;
    private ImageButton mAvanzar;
    private TextView mReproduciendo;
    private SeekBar mSeekBar; //en que parte de la musica esta.
    private MediaPlayer mPlayer;
    
    private final Handler mHandler = new Handler();



	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.musica_activity);
		addWidgets();
		addListeners();
		setPlayer();	
	}
	
	@Override
	public void onResume() {
		super.onResume();
		addWidgets();
		addListeners();
	}

	private void addListeners() {
		mPausa.setOnClickListener(this);
		mReproducir.setOnClickListener(this);
		mRetroceder.setOnClickListener(this);
		mAvanzar.setOnClickListener(this);
	}

	private void addWidgets() {
		
		mPausa = (ImageButton) findViewById(R.id.musica_activity_imbPausar);
		mReproducir= (ImageButton) findViewById(R.id.musica_activity_imbReproducir);
		mRetroceder= (ImageButton) findViewById(R.id.musica_activity_imbRetroceder);
		mAvanzar= (ImageButton) findViewById(R.id.musica_activity_imbAdelantar);

	}

	private void setPlayer() {
		mPlayer = MediaPlayer.create(this, R.raw.lake_of_fire);
		mSeekBar.setMax(mPlayer.getDuration());
		mReproduciendo.setText(R.string.reproduciendo);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.musica_activity_imbReproducir:
			reproducir();
			break;
		case R.id.musica_activity_imbPausar:
			pausar();
			break;
		case R.id.musica_activity_imbAdelantar:
			adelantar();
			break;
		case R.id.musica_activity_imbRetroceder:
			retroceder();
			break;
		default:
			finish();
			return;
		}
		mPlayer.start();
	}
	
	private void retroceder() {
		if((mPlayer.getCurrentPosition() - TIEMPO > 0 )){
			mPlayer.seekTo(mPlayer.getCurrentPosition() - TIEMPO);
		}
		else{
			Toast.makeText(getApplicationContext(), "No se pudo retroceder más.", Toast.LENGTH_SHORT).show();
		}
	}



	private void adelantar() {
		if((mPlayer.getCurrentPosition() + TIEMPO <= mPlayer.getDuration() )){
			mPlayer.seekTo(mPlayer.getCurrentPosition() + TIEMPO);
		}
		else{
			Toast.makeText(getApplicationContext(), "No se pudo avanzar más.", Toast.LENGTH_SHORT).show();
		}
		
	}



	private void pausar() {
		Toast.makeText(getApplicationContext(), "Pausado", Toast.LENGTH_SHORT).show();		
		mPlayer.pause();
		mPausa.setEnabled(false);
		mReproducir.setEnabled(true);
	}



	private void reproducir() {
		Toast.makeText(getApplicationContext(), "Reproduciendo MP3", Toast.LENGTH_SHORT).show();
		mPlayer.start();
		
		mSeekBar.setProgress(0);
		mHandler.postDelayed(UpdateSongTime, 100);
		mPausa.setEnabled(false);		
	}
	
	private Runnable UpdateSongTime = new Runnable()
			{
		public void run(){
			if(mPlayer != null){
				mSeekBar.setProgress(mPlayer.getCurrentPosition());
				mHandler.postDelayed(this , 100);
			}
		}
	};

	@Override
	protected void onDestroy(){
		if(mPlayer != null){
			mPlayer.release();
			mPlayer = null;
		}
		super.onDestroy();
		
	}


}
