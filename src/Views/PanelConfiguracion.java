package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.w3c.dom.stylesheets.LinkStyle;

import Controllers.ActionMalla;

public class PanelConfiguracion extends JFrame{
	
	JButton[][] mallaBotones;
	
	public PanelConfiguracion(JButton[][] botones, JPanel panelMalla, JLabel numeroIslas){
		super("Configurar");
		this.setBounds(25, 25, 280, 200);
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		JLabel filasLabel = new JLabel("Numero de Filas");
		JLabel columnasLabel = new JLabel("Numero de Columnas");
		
		String[] digitos = {"3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
		
		SpinnerListModel listColumnas = new SpinnerListModel(digitos);
		SpinnerListModel listFilas = new SpinnerListModel(digitos);
		
		JSpinner columnas = new JSpinner(listColumnas);
		JSpinner filas = new JSpinner(listFilas);

		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new FlowLayout());
		
		JButton enviar = new JButton("Enviar");
		enviar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int numeroColumnas = Integer.parseInt(String.valueOf(columnas.getValue()));
				int numeroFilas = Integer.parseInt(String.valueOf(filas.getValue()));
				
				mallaBotones = botones;
				mallaBotones = new JButton[numeroFilas][numeroColumnas];
				
				panelMalla.setLayout(new GridLayout(numeroFilas, numeroColumnas));
				panelMalla.removeAll();
				
				for (int i = 0; i < numeroFilas; i++) {
					for (int j = 0; j < numeroColumnas; j++) {
						mallaBotones[i][j] = new JButton();
						mallaBotones[i][j].setBackground(Color.blue);
						mallaBotones[i][j].addActionListener(new ActionMalla(mallaBotones[i][j], mallaBotones, numeroIslas));
						
						panelMalla.add(mallaBotones[i][j]);
						panelMalla.repaint();
						panelMalla.revalidate();
					}
				}
				dispose();
			}
		});
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		panelBotones.add(cancelar);
		panelBotones.add(enviar);
		
		JPanel panelColumnas = new JPanel();
		panelColumnas.setLayout(new FlowLayout());
		
		panelColumnas.add(columnasLabel);
		panelColumnas.add(columnas);
		
		JPanel panelFilas = new JPanel();
		panelFilas.setLayout(new FlowLayout());
		
		panelFilas.add(filasLabel);
		panelFilas.add(filas);
		
		
		this.add(panelColumnas);
		this.add(panelFilas);
		this.add(panelBotones);
		this.setVisible(true);
	}
}
