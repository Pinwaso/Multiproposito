package Clase.InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class HistorialCalculadora extends JFrame {
	JTextArea historial;
	
	public HistorialCalculadora() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		historial = new JTextArea();
		setLayout(new BorderLayout());
		add(historial, BorderLayout.CENTER);
		setSize(400, 400);
		historial.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 20));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		JButton miboton = new JButton();
		miboton.addMouseWheelListener(null);
	}
	
	public void operacion (String resultado) {
		historial.setText(historial.getText() + resultado);
	}
}