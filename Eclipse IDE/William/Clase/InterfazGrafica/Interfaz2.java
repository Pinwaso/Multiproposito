package Clase.InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Interfaz2 extends JFrame {
	
	JTextArea historial;
	public Interfaz2() {
		historial = new JTextArea();
		setLayout(new BorderLayout());
		add(historial, BorderLayout.CENTER);
		setSize(400, 400);
		int estilo = Font.PLAIN;
		estilo += Font.BOLD;
		estilo += Font.ITALIC;
		historial.setFont(new Font("Arail", Font.BOLD + Font.ITALIC, 20));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
	} 
	
	public void operacion (String resultado) {
		historial.setText(historial.getText() + resultado);
	}
	
	public static void main(String[] args) {
		new Interfaz2();
	}

}
