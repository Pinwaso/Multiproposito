package Clase.InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class calculadora extends JFrame {

	String[] bottons = { "+", "-", "*", "/", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "=", "cerrar", "borrar",
			"reiniciar" };
	JTextField texto;
	JRadioButton rojo;
	JRadioButton azul;
	ButtonGroup grupo;
	JPanel botones, pantalla;
	JScrollBar bar1;
	JLabel msg;

	public calculadora() {
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(360, 240);
		setBackground(Color.red);

		// Panel pantalla
		pantalla = new JPanel();
		texto = new JTextField(15);
		texto.setHorizontalAlignment(JTextField.RIGHT);
		texto.setEditable(false);
		pantalla.add(texto);

		// Panel botones
		botones = new JPanel();
		for (int i = 0; i < bottons.length; i++) {
			if (bottons[i].equals("cerrar")) {
				JButton cerrar = new JButton(bottons[i]);
				cerrar.addActionListener(new cerrar());
				botones.add(cerrar);
			} else if (bottons[i].equals("borrar")) {
				JButton borrar = new JButton(bottons[i]);
				borrar.addActionListener(new borrar());
				botones.add(borrar);
			} else if (bottons[i].equals("reiniciar")) {
				JButton reiniciar = new JButton(bottons[i]);
				reiniciar.addActionListener(new reiniciar());
				botones.add(reiniciar);
			} else {
				JButton boton = new JButton(bottons[i]);
				boton.addActionListener(new accion());
				botones.add(boton);
			}
		}
		// Panel de opciones
		JPanel opciones = new JPanel();
		rojo = new JRadioButton("Rojo");
		azul = new JRadioButton("Azul");
		JCheckBox negrita = new JCheckBox("Negrita");
		negrita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				texto.setFont(new Font("Arial", Font.BOLD, 20));
			}
		});
		JCheckBox italic = new JCheckBox("Italic");
		italic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				texto.setFont(new Font("Arial", Font.ITALIC, 20));
			}
		});
		JComboBox<String> eleccion = new JComboBox<String>();
		eleccion.addItem("Nada");
		eleccion.addItem("Rojo");
		eleccion.addItem("Azul");
		eleccion.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String valor = eleccion.getItemAt(eleccion.getSelectedIndex());
				switch (valor) {
				case "Rojo":
					texto.setBackground(Color.red);
					break;
				case "Azul":
					texto.setBackground(Color.blue);
					break;
				case "Nada":
					texto.setBackground(null);
					break;
				}
			}
		});

		grupo = new ButtonGroup();
		rojo.addActionListener(new color());
		azul.addActionListener(new color());
		grupo.add(azul);
		grupo.add(rojo);
		opciones.add(rojo);
		opciones.add(azul);
		opciones.add(italic);
		opciones.add(negrita);
		opciones.add(eleccion);
		msg = new JLabel();
		bar1 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 0, 0, 100);
		/* scroll de 0 a 100 */
		bar1.addAdjustmentListener(new oyentebarra());
		opciones.add(bar1);
		JMenuBar barra = new JMenuBar();
		JMenu menu = new JMenu("Configuracion");
		menu.setMnemonic(KeyEvent.VK_A);
		JMenuItem ita = new JMenuItem("Italic");
		ita.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Font fuente = texto.getFont();
				texto.setFont(new Font(fuente.getName(), Font.ITALIC, fuente.getSize()));
			}
		});
		JMenuItem neg = new JMenuItem("Negrita");
		neg.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Font fuente = texto.getFont();
				texto.setFont(new Font(fuente.getName(), Font.BOLD, fuente.getSize()));
			}
		});
		JMenuItem fondazul = new JMenuItem("Fondo azul");
		fondazul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				texto.setBackground(Color.BLUE);
			}
		});
		barra.add(menu);
		menu.add(ita);
		menu.add(neg);
		menu.add(new JSeparator());
		menu.add(fondazul);
		opciones.add(barra);
		
		
		// Finales
		add(pantalla, BorderLayout.NORTH);
		add(botones, BorderLayout.CENTER);
		add(opciones, BorderLayout.SOUTH);
		setVisible(true);
	}

	class color implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (rojo.isSelected()) {
				botones.setBackground(Color.red);
			} else if (azul.isSelected()) {
				botones.setBackground(Color.blue);
			}
		}
	}

	class cerrar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			calculadora.this.dispose();
		}
	}

	class accion implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String palabra = texto.getText();
			palabra += e.getActionCommand();
			texto.setText(palabra);
		}
	}

	class borrar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String palabra = texto.getText();
			texto.setText(palabra.substring(0, palabra.length() - 1));
		}
	}

	class reiniciar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			texto.setText("");
		}
	}
	
	class oyentebarra implements AdjustmentListener {
		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			int valor = bar1.getValue();
			String cad = "Valor : " + valor;
			msg.setText(cad);
		}
	}

	public static void main(String[] args) {
		calculadora Calculadora = new calculadora();
	}
}