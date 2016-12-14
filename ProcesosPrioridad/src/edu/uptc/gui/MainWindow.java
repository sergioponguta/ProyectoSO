package edu.uptc.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
	
	private MainPanel mainPanel;
	
	public MainWindow() {
		this.setTitle("PROCESOS PRIORIDAD");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600,435);
		this.setLocationRelativeTo(null);
		beginComponents();
		addComponents();
	
	}
	
	private void beginComponents() {

		mainPanel = new MainPanel(this);
		
	}
	
	private void addComponents() {
		
		add(mainPanel);
		
	}



	public static void main(String[] args) {
		
		MainWindow mw = new MainWindow();
		mw.setVisible(true);
		
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}
	
	

}
