package com.cursoAndroid.practica4;

import java.util.ArrayList;

import com.cursoAndroid.practica4.collection.Peliculas;
import com.cursoAndroid.practica4.entities.Pelicula;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListviewActivity extends Activity implements OnItemClickListener  {
	private TextView mSeleccion;
	private ListView mPeliculas;
	
	private PeliculasAdapter mAdpPelis;
	ArrayList<Pelicula> mPelis;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spiner_activity);
		
		addWidgets();
		//addAdapters();
		addAdapters2();
		addListeners();
	}

	private void addListeners() {
		mPeliculas.setOnItemClickListener(this);
		
	}

	//private void addAdapters() {
	//	ArrayAdapter<CharSequence> adtPeliculas = ArrayAdapter.createFromResource(this, R.array.peliculas, android.R.layout.simple_list_item_1);
	//	adtPeliculas.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line); //para que haga salto de linea automatico.
	//	mPeliculas.setAdapter(adtPeliculas);
	//}

	private void addAdapters2() {
		mPelis = Peliculas.getAll(this);
		mAdpPelis = new PeliculasAdapter(this, R.layout.listview_item, mPelis);
	
		mPeliculas.setAdapter(mAdpPelis);
	}
	
	private void addWidgets() {
		mSeleccion = (TextView) findViewById(R.id.listview_activity_tvSeleccion);
		mPeliculas = (ListView) findViewById(R.id.listview_activity_lvPeliculas);
	}


	@Override
	public void onItemClick(AdapterView<?> a, View v, int position, long id) {
		//String opcionSeleccionada = a.getAdapter().getItem(position).toString();
		//String opcionSeleccionada = ((Pelicula).a.getAdapter().getItem(position).getTitulo());	
		
		Pelicula peli = (Pelicula)a.getAdapter().getItem(position);
		String opcionSeleccionada = peli.getTitulo();
		
		mSeleccion.setText(opcionSeleccionada);
		
	}

	 class PeliculasAdapter extends ArrayAdapter<Pelicula> {
		protected ArrayList<Pelicula> items;
		
		public PeliculasAdapter(Context context, int textViewResourceId, ArrayList<Pelicula> items) {
			//Constructor
			super(context, textViewResourceId, items); 
			this.items = items;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			View v = convertView;
			if(v == null){
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.listview_item, null);
			}
			
			Pelicula peli = (Pelicula) items.get(position);
			if (peli != null)
			{
				TextView f1 = (TextView) v.findViewById(R.id.listview_item_tvRanking);
				TextView f2 = (TextView) v.findViewById(R.id.listview_item_tvTitulo);
				TextView f3 = (TextView) v.findViewById(R.id.listview_item_tvAnio);
				ImageView im = (ImageView) v.findViewById(R.id.listview_item_imPortada);
				
				if(f1 != null)
					f1.setText(String.valueOf(peli.getRanking())); //como tomo un entero, lo transformo a String.
				if(f2 != null)
					f2.setText(peli.getTitulo());
				if(f3 != null)
					f3.setText("Año " + String.valueOf(peli.getAnio()));
				if(im != null)
					im.setImageResource(R.drawable.pelicula);
			}
			return v;
		}
		
	}
  
}
