package Clase.InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextoFuente extends JFrame {
	String[] botones = {"negrita", "italic", "reiniciar", "cerrar"};
	JPanel pantalla;
	JTextField imagen;
	JPanel teclado;
	
	public TextoFuente() {
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 400);
		
		pantalla = new JPanel();
		imagen = new JTextField(30);
		pantalla.add(imagen);
		pantalla.setVisible(true);
		
		teclado = new JPanel();
		teclado.setLayout(new FlowLayout());
		for (int i = 0; i < botones.length; i++) {
			switch (botones[i]) {
			case "cerrar":
				JButton cerrar = new JButton(botones[i]);
				cerrar.addActionListener(new cerrar());
				teclado.add(cerrar);
				break;
			case "negrita":
				JButton negrita = new JButton(botones[i]);
				negrita.addActionListener(new negrita());
				teclado.add(negrita);
				break;
			case "italic":
				JButton italic = new JButton(botones[i]);
				italic.addActionListener(new italic());
				teclado.add(italic);
				break;
			case "reiniciar":
				JButton reiniciar = new JButton(botones[i]);
				reiniciar.addActionListener(new reiniciar());
				teclado.add(reiniciar);
				break;
			}
		}
		add(pantalla, BorderLayout.NORTH);
		add(teclado, BorderLayout.CENTER);
		setVisible(true);
	}
	
	class cerrar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			TextoFuente.this.dispose();	
		}	
	}
	
	class negrita implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			imagen.setFont(new Font("Arial", Font.BOLD, 20));
			imagen.setHorizontalAlignment(JTextField.RIGHT);
		}
	}
	
	class italic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			imagen.setFont(new Font("Arial", Font.ITALIC, 20));
			imagen.setHorizontalAlignment(JTextField.RIGHT);
		}
	}
	
	class reiniciar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			imagen.setFont(new Font("Arial", Font.PLAIN, 20));
			imagen.setText("");
			imagen.setHorizontalAlignment(JTextField.LEFT);
		}	
	}

	public static void main(String[] args) {
		TextoFuente t = new TextoFuente();
	}
}
