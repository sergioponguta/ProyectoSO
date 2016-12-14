package edu.uptc.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
	
	private JPanel panel;
	
	
	public MainWindow() {
		this.setTitle("PROCESOS PRIORIDAD");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(500,500);
		beginComponents();
		addComponents();
	
	}
	
	private void beginComponents() {

		panel = new JPanel();
		
	}
	
	private void addComponents() {
		
		add(panel);
		
	}



	public static void main(String[] args) {
		
		
		
	}

}
