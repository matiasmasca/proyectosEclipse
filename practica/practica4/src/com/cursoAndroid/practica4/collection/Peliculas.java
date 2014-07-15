package com.cursoAndroid.practica4.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cursoAndroid.practica4.R;
import com.cursoAndroid.practica4.entities.Pelicula;

import android.content.Context;

public class Peliculas {
	public static ArrayList<Pelicula> getAll(Context c){
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		List<String> Lineas = Arrays.asList(c.getResources().getStringArray(R.array.peliculas));
		int ranking = 1;
		
		for(String s : Lineas){
			Pelicula peli = new Pelicula();
			
			peli.setRanking(ranking);
			peli.setTitulo(s.substring(0, s.indexOf('(')));
			
			int anio = Integer.parseInt(
							s.substring(
									s.indexOf('(') + 1, 
									s.indexOf(')')
							));
			peli.setAnio(anio);
			
			peliculas.add(peli);
		}
		return peliculas;
	}
}
