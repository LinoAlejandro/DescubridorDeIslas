package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Controllers.ActionMalla;
import Controllers.Controller;

public class Principal extends JFrame {

	JMenuBar menuBar;
	JButton[][] malla;
	Controller controlador;
	
	public Principal(){
		super("Contador de Islas");
		controlador = new Controller();
		this.iniciarComponentes();
		this.setVisible(true);
	}

	private void iniciarComponentes() {
		this.setBounds(20, 20, 500, 500);
		this.setLayout(new BorderLayout());

		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new FlowLayout());
		
		JLabel cantidadDeIslas = new JLabel("Cantidad de islas:");
		JLabel numeroIslas = new JLabel();

		panelInfo.add(cantidadDeIslas);
		panelInfo.add(numeroIslas);
		
		JPanel panelMalla = new JPanel();
		panelMalla.setLayout(new GridLayout(8,8));
		
		malla = new JButton[8][8];
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				malla[i][j] = new JButton();
				malla[i][j].setBackground(Color.blue);
				malla[i][j].addActionListener(new ActionMalla(malla[i][j], malla, numeroIslas));
				panelMalla.add(malla[i][j]);
			}
		}
		
		menuBar = new JMenuBar();
		JMenu menu = new JMenu("Configurar");
		JMenuItem subMenu = new JMenuItem("Modificar...");
		subMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				numeroIslas.setText("");
				PanelConfiguracion configuracion = new PanelConfiguracion(malla, panelMalla, numeroIslas);
				panelMalla.repaint();
				panelMalla.revalidate();
				repaint();
				revalidate();
			}
		});
		
		menu.add(subMenu);
		menuBar.add(menu);
		
		this.add(panelMalla, BorderLayout.CENTER);		
		this.add(panelInfo, BorderLayout.SOUTH);
		this.setJMenuBar(menuBar);
	}
	
	public static void main(String[] args) {
		Principal ventanaPrincipal = new Principal();
	}
}
