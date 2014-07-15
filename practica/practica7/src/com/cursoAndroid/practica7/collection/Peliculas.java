package com.cursoAndroid.practica7.collection;

import java.util.ArrayList;
import com.cursoAndroid.practica7.PeliculasSQLiteHelper;
import com.cursoAndroid.practica7.entities.Pelicula;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

//El cursor, hay que cerrarlo al igual que la base de datos; para ahorrar problemas.
// El cursor estructura conectada secuencial.


public class Peliculas {
	public static ArrayList<Pelicula> getAll(Context cntx, boolean verRanking, boolean verAnio )
	{
	   ArrayList<Pelicula> pelis = new ArrayList<Pelicula>(); //esto es lo que devolvemos
	   
		PeliculasSQLiteHelper pelisHelper = new PeliculasSQLiteHelper(cntx, "DBPeliculas", null , 1);
		SQLiteDatabase db = pelisHelper.getWritableDatabase();	
		Cursor c = null;
		
		if(db != null)
		{
			String[] campos;
			
			if(verRanking && verAnio)
				campos = new String[]{"ranking", "titulo", "anio"};
			else if(verRanking)
				campos = new String[]{"ranking", "titulo"};
			else if (verAnio)
				campos = new String[]{"titulo", "anio"};
			else 
				campos = new String[]{"titulo"};
			
			try{
				c = db.query("Peliculas", campos,  null,null,null,null,null);
				
				if(c.moveToFirst()){
					do{
						Pelicula peli = new Pelicula();
						
						if(verRanking && verAnio){
							peli.setRanking(c.getInt(0));
							peli.setTitulo(c.getString(1));
							peli.setAnio(c.getInt(2));
						}
						else if(verRanking){
							peli.setRanking(c.getInt(0));
							peli.setTitulo(c.getString(1));
						}
						else if(verAnio){
							peli.setTitulo(c.getString(0));
							peli.setAnio(c.getInt(1));
						}
						else
							peli.setTitulo(c.getString(0));
						peli.add(peli);
					} while(c.moveToNext());
				}
			}
			catch(Exception e){
			}
			finally{
				if(c != null)
					c.close();
			}
			
		}
		
		return pelis;
	}
	
	public static ArrayList<Pelicula> filter(Context cntx, String ranking, boolean verRanking, boolean verAnio){
		ArrayList<Pelicula> pelis = new ArrayList<Pelicula>();
		
		PeliculasSQLiteHelper pelisHelper = new PeliculasSQLiteHelper(cntx, "DBPeliculas", null , 1);
		SQLiteDatabase db = pelisHelper.getWritableDatabase();	
		Cursor c = null;
		
		if(db != null){
			String[] campos;
			
			if(verRanking && verAnio)
				campos = new String[]{"ranking", "titulo", "anio"};
			else if(verRanking)
				campos = new String[]{"ranking", "titulo"};
			else if (verAnio)
				campos = new String[]{"titulo", "anio"};
			else 
				campos = new String[]{"titulo"};
		
		String[] args = new String[] {ranking};
		try{
			
			c = db.query("Peliculas", campos,  "ranking=?", args, null,null,null);
			// Select Ranking, titulo FROM Peliculas WHERE rankgin in(1)
			
			if(c.moveToFirst()){
				do{
					Pelicula peli = new Pelicula();
					
					if(verRanking && verAnio){
						peli.setRanking(c.getInt(0));
						peli.setTitulo(c.getString(1));
						peli.setAnio(c.getInt(2));
					}
					else if(verRanking){
						peli.setRanking(c.getInt(0));
						peli.setTitulo(c.getString(1));
					}
					else if(verAnio){
						peli.setTitulo(c.getString(0));
						peli.setAnio(c.getInt(1));
					}
					else
						peli.setTitulo(c.getString(0));
					peli.add(peli);
				} while(c.moveToNext());
			}
		}
		catch(Exception e){
		}
		finally{
			if(c != null)
				c.close();
		}
		}
		return pelis;
		
		
	}
}
