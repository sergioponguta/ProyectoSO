package edu.uptc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import edu.uptc.logic.Hilo;

public class MainPanel extends JPanel implements ActionListener {

	private MainWindow mainWindow;
	private JTable tabla;
	private JScrollPane scrollpane;
	private DefaultTableModel modeloTabla;
	private JProgressBar progress;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JButton btnCrear;
	private ArrayList<Integer> listaPrioridades;

	public MainPanel(MainWindow mainWindow) {

		this.mainWindow=mainWindow;
		this.setLayout(null);

		begin();
		addC();
	}

	private void begin() {

		listaPrioridades = new ArrayList<>();

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

	private int numeroAleatorio(){ 
		return (int)(Math.random()*(20-1+1)+1); 
	}
	public int generar(){ 
		if(listaPrioridades.size() < (20 - 1) +1){ 
			//Aun no se han generado todos los numeros 
			int numero = numeroAleatorio();
			//genero un numero 
			if(listaPrioridades.isEmpty()){
				//si la lista esta vacia 
				listaPrioridades.add(numero); 
				return numero; 
			}else{
				//si no esta vacia 
				if(listaPrioridades.contains(numero)){
					//Si el numero que gener� esta contenido en la lista  recursivamente lo mando a generar otra vez 
					return generar();

				}else{
					//Si no esta contenido en la lista 
					listaPrioridades.add(numero); 
					return numero; 
				} 
			} 
		}else{// ya se generaron todos los numeros 
			return -1; 
		} 
	} 

	public void refrescarTabla(){

		modeloTabla.setRowCount(0);

		for (int i = 0; i < mainWindow.getMh().getHilos().size(); i++) {

			Hilo aux = mainWindow.getMh().getHilos().get(i);
			modeloTabla.addRow(new Object[] {aux.getPrioridad(), aux.getNombre(), aux.getDuracion(), aux.getEstado()});

		}

	}

	public void revisarPrioridad(){

		if(mainWindow.getMh().getHilos().size()==1){

			mainWindow.getMh().getHilos().get(0).setEstado("EN EJECUCION");

			ejecutarHilo(mainWindow.getMh().getHilos().get(0));
		}else{

			//			Hilo menor=null;
			//
			//			for (Hilo hilito : mainWindow.getMh().getHilos()) {
			//
			//				if(hilito.getEstado().equals("PENDIENTE")){
			//
			//					if(menor==null){
			//						menor=hilito;
			//					}else if(menor.getPrioridad()>hilito.getPrioridad()){
			//
			//						menor=hilito;
			//
			//					}
			//
			//				}
			//			}

			for(Hilo hilito : mainWindow.getMh().getHilos()){

				if(hilito.getEstado().equals("PENDIENTE")){

					ejecutarHilo(hilito);

				}


			}


		}


	}

	public void ejecutarHilo(Hilo aEjecutar){

		if(!aEjecutar.getEstado().equals("EN EJECUCION")){
			aEjecutar.setEstado("PENDIENTE.");
		}



		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {

				synchronized (btnCrear) {
					aEjecutar.setEstado("EN EJECUCION");
					for (int i = 1; i <= 100; i++) {

						try {
							//							System.out.println(i);
							Thread.sleep(aEjecutar.getDuracion()*10);
							progress.setValue(i);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}


					}

				}

				aEjecutar.setEstado("FINALIZADO");
				Collections.sort(mainWindow.getMh().getHilos());
				refrescarTabla();

			}

		},aEjecutar.getNombre());

		if(th.getName().equals("123")){
			th.setPriority(Thread.MAX_PRIORITY);
		}
	
		th.start();


	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnCrear){

			Hilo aux = new Hilo(generar(), txtNombre.getText(), numeroAleatorio(), "PENDIENTE");

			mainWindow.getMh().getHilos().add(aux);

			revisarPrioridad();
			refrescarTabla();

		}


	}




}
