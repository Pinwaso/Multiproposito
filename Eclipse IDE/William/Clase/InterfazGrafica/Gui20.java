package Clase.InterfazGrafica;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Gui20 extends JFrame {
	public Gui20() {
		super("Título de la ventana");
		setLayout(new FlowLayout());
		// Cuando necesitamos el cuadro de diálogo...
		PanelDatos pd = new PanelDatos();
		if (JOptionPane.showConfirmDialog(this, pd, "Introduzca datos", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION) {
			// ... tratamiento
		}
	}

	public static void main(String[] args) {
		Gui20 f = new Gui20();
	}
}

class PanelDatos extends JPanel {
	public PanelDatos() {
		setLayout(new GridLayout(4, 2));
		JLabel etiquetaNombre = new JLabel("Nombre: ", JLabel.RIGHT);
		JTextField campoNombre = new JTextField();
		add(etiquetaNombre);
		add(campoNombre);
		JLabel etiquetaApellidos = new JLabel("Apellidos:", JLabel.RIGHT);
		JTextField campoApellidos = new JTextField();
		add(etiquetaApellidos);
		add(campoApellidos);
		JLabel etiquetaNP = new JLabel("Número Personal:", JLabel.RIGHT);
		JTextField campoNP = new JTextField();
		add(etiquetaNP);
		add(campoNP);
		ButtonGroup grupoBotones = new ButtonGroup();
		JRadioButton mañana = new JRadioButton("Grupo Mañana", true);
		JRadioButton tarde = new JRadioButton("Grupo Tarde");
		grupoBotones.add(mañana);
		grupoBotones.add(tarde);
		add(mañana);
		add(tarde);
	}
}

