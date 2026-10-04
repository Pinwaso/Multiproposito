package Clase.InterfazGrafica;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends JFrame {
	JTextArea texto;
	JPanel opciones;
	JButton negrita, italic, pulsame;
	JFrame ventana;
	
	public Mouse() {
		super("MouseEvent");
		setLayout(new BorderLayout());
		setSize(500, 500);
		texto = new JTextArea();
		
		opciones = new JPanel();
		negrita = new JButton("Negrita");
		italic = new JButton("Italic");
		opciones.add(negrita);
		opciones.add(italic);
		pulsame = new JButton("pulsame");
		pulsame.addMouseListener(new MouseEscucha());
		opciones.add(pulsame);
		
		// Finales
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(texto, BorderLayout.CENTER);
		add(opciones, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	class MouseEscucha extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				ventana = new JFrame("boton izquierdo");
				ventana.setSize(300, 300);
				ventana.setVisible(true);
			} else if (e.getButton() == MouseEvent.BUTTON2) {
				ventana = new JFrame("boton central");
				ventana.setSize(300, 300);
				ventana.setVisible(true);
			} else if (e.getButton() == MouseEvent.BUTTON3) {
				ventana = new JFrame("boton derecho");
				ventana.setSize(300, 300);
				ventana.setVisible(true);
			}
			super.mouseClicked(e);
		}	
	}
	
	public static void main(String[] args) {
		Mouse maus = new Mouse();
	}
}