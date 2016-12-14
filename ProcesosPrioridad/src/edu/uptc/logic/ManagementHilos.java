package edu.uptc.logic;

import java.util.ArrayList;

public class ManagementHilos {

	private ArrayList<Hilo> hilos;
	
	public ManagementHilos() {
		hilos = new ArrayList<>();
	}

	
	
	public ArrayList<Hilo> getHilos() {
		return hilos;
	}

	
	@Override
	public String toString() {
		return "ManagementHilos [hilos=" + hilos + "]";
	}
	
	
}
