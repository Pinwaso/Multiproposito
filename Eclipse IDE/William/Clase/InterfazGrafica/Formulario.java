package Clase.InterfazGrafica;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Formulario extends JFrame{
	
	private ventana panel = new ventana();
	public Formulario() {
		super("ventana");
		JButton boton = new JButton("pulsame");
		boton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana panel = new ventana();
				int opcion = JOptionPane.showConfirmDialog(Formulario.this, panel, "Introduzca datos", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
				switch (opcion) {
				case JOptionPane.OK_OPTION:
					String mensaje = "";
					mensaje+= "Nombre: " + panel.getNombre() + " ";
					mensaje+= "Apellido: " + panel.getApellido() + " ";
					if (panel.getHombre().isSelected()) {
						mensaje+= "genero: " + panel.getHombre().getActionCommand();
					} else if (panel.getMujer().isSelected()) {
						mensaje+= "genero: " + panel.getMujer().getActionCommand();
					}
					JOptionPane.showMessageDialog(Formulario.this, mensaje);
					break;
				}
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(100, 100);
		add(boton);
		setVisible(true);
	}

	public static void main(String[] args) {
		Formulario form = new Formulario();
	}
}

class ventana extends JPanel {
	
	private JTextField nombre, apellido;
	private JRadioButton hombre, mujer;
	
	public ventana() {
		super();
		setLayout(new GridLayout(3, 1));
		
		
		JPanel uno = new JPanel();
		uno.add(new JLabel("Nombre"));
		uno.add(nombre = new JTextField(15));
		
		JPanel dos = new JPanel();
		dos.add(new JLabel("Apellido"));
		dos.add(apellido = new JTextField(15));
		
		JPanel radial = new JPanel();
		ButtonGroup grupo = new ButtonGroup();
		hombre = new JRadioButton("Hombre");
		mujer = new JRadioButton("Mujer");
		radial.add(hombre);
		radial.add(mujer);
		
		add(uno);
		add(dos);
		add(radial);
	}

	public String getNombre() {
		return nombre.getText();
	}

	public String getApellido() {
		return apellido.getText();
	}

	public JRadioButton getHombre() {
		return hombre;
	}

	public JRadioButton getMujer() {
		return mujer;
	}
}