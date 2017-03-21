package Controllers;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ActionMalla implements ActionListener{

	JButton boton;
	JButton[][] botones;
	JLabel numeroIslas;
	Controller controlador;
	
	public ActionMalla(JButton boton, JButton[][] botones, JLabel numeroIslas) {
		this.boton = boton;
		this.botones = botones;
		this.numeroIslas = numeroIslas;
		this.controlador = new Controller();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(boton.getBackground().equals(Color.BLUE)){
			boton.setBackground(Color.GREEN);
		} else {
			boton.setBackground(Color.BLUE);
		}
		
		int cantidadIslas = controlador.obtenerCantidadIslas(botones);
		numeroIslas.setText(String.valueOf(cantidadIslas));
	}
}