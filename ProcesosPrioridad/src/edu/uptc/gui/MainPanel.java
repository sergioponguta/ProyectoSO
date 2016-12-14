package edu.uptc.gui;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainPanel extends JPanel {

	private MainWindow mainWindow;
	private JTable tabla;
	private JScrollPane scrollpane;
	private DefaultTableModel modeloTabla;
	private JProgressBar progress;
	
	
	public MainPanel(MainWindow mainWindow) {
		
		this.mainWindow=mainWindow;
		this.setLayout(null);
		
		begin();
		addC();
	}

	private void begin() {

	modeloTabla = new DefaultTableModel(null, new String[] {"PRIORIDAD","NOMBRE","ESTADO"});	
	
	tabla = new JTable(modeloTabla);
	
	scrollpane = new JScrollPane(tabla);
	scrollpane.setBounds(10, 300, 575, 200);
	
	progress = new JProgressBar();
	progress.setBounds(100, 210, 400, 30);
	
	
	}

	private void addC() {

		add(scrollpane);
		add(progress);
		
		
	}
	
	
	
	
}
