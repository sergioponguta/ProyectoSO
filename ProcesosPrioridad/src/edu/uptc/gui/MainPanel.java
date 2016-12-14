package edu.uptc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MainPanel extends JPanel implements ActionListener {

	private MainWindow mainWindow;
	private JTable tabla;
	private JScrollPane scrollpane;
	private DefaultTableModel modeloTabla;
	private JProgressBar progress;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JButton btnCrear;
	
	public MainPanel(MainWindow mainWindow) {
		
		this.mainWindow=mainWindow;
		this.setLayout(null);
		
		begin();
		addC();
	}

	private void begin() {

	modeloTabla = new DefaultTableModel(null, new String[] {"PRIORIDAD","NOMBRE","DURACION","ESTADO"});	
	
	tabla = new JTable(modeloTabla);
	
	scrollpane = new JScrollPane(tabla);
	scrollpane.setBounds(10, 200, 575, 200);
	
	progress = new JProgressBar();
	progress.setBounds(100, 110, 400, 30);
	
	lblNombre = new JLabel("NOMBRE:");
	lblNombre.setBounds(140, 20, 80, 30);
	
	txtNombre = new JTextField();
	txtNombre.setBounds(230, 20, 120, 30);
	
	btnCrear = new JButton("CREAR");
	btnCrear.setBounds(380, 20, 80, 30);
	btnCrear.addActionListener(this);
	
	}

	private void addC() {

		add(scrollpane);
		add(progress);
		add(lblNombre);
		add(txtNombre);
		add(btnCrear);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnCrear){
			
			
			
		}
		
		
	}
	
	
	
	
}
