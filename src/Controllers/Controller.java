package Controllers;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Controller {

	public int obtenerCantidadIslas(JButton[][] botones){
		int[][] matriz = new int[botones.length][botones[0].length];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if(botones[i][j].getBackground().equals(Color.blue)){
					matriz[i][j] = 0;
				} else {
					matriz[i][j] = 1;
				}
			}
		}
		
		ProcesadorDeMapasImpl procesador = new ProcesadorDeMapasImpl();
		
		int cantidadDeIslas = procesador.nIslas(matriz);
		
		return cantidadDeIslas;
	}
}
