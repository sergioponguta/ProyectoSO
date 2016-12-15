package edu.uptc.logic;

public class Hilo implements Comparable<Hilo> {

	private int prioridad;
	private String nombre;
	private int duracion;
	private String estado;
	
	
	public Hilo(int prioridad, String nombre, int duracion, String estado) {
		super();
		this.prioridad = prioridad;
		this.nombre = nombre;
		this.duracion = duracion;
		this.estado = estado;
	}


	public int getPrioridad() {
		return prioridad;
	}


	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "Hilo [prioridad=" + prioridad + ", nombre=" + nombre
				+ ", duracion=" + duracion + ", estado=" + estado + "]";
	}


	@Override
	public int compareTo(Hilo o) {
		return this.getPrioridad()-o.getPrioridad();
	}
	
	
	
}


