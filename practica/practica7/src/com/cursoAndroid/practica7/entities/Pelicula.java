package com.cursoAndroid.practica7.entities;

public class Pelicula {
	private int codigo;
	private String titulo;
	private int anio;
	private int ranking;
	
	public int getAnio() {
		return anio;
	}
	public void setAnio(int year) {
		this.anio = year;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String title) {
		this.titulo = title;
	}
	public int getCode() {
		return codigo;
	}
	public void setCode(int code) {
		this.codigo = code;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public void add(Pelicula peli) {
		// TODO Auto-generated method stub
		
	}
}
