package Clase.Aplicaciones.JuegoBuscaminas;
import java.awt.*;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
//La peor rotura de cabeza que tuve hasta el momento
public class Juego extends JFrame{
	private int cantidadHuevos = 5, vidas = 3, huevosEncontrador = 0;
	private JLabel labelHuevos, huevos, contadorvidas = new JLabel("Vidas restantes: " + vidas);
	private JScrollBar scroll;
	private JComboBox<String> ch1;
	private Tablero tablero;
	private JButton generar;
	
	Juego() {
		super("Control - Jugador 1");
		setLayout(new GridLayout(7, 1));
		
		//Menu Juego
		JPanel paneljuego = new JPanel();
		paneljuego.setLayout(new BorderLayout());
		JMenuBar barra = new JMenuBar();
		JMenu menu = new JMenu("Juego");
		barra.add(menu);
		JMenuItem cambiarNombre = new JMenuItem("Cambiar nombre");
		cambiarNombre.addActionListener(new CambiarNombre());
		cambiarNombre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		menu.add(cambiarNombre);
		
		JMenuItem rendirse = new JMenuItem("Rendirse y salir");
		rendirse.addActionListener(new Rendirse());
		rendirse.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
		menu.add(rendirse);
		paneljuego.add(barra, BorderLayout.NORTH);
		add(paneljuego);
		
		//Label
		JPanel label = new JPanel();
		huevos = new JLabel("Esconder Huevos: " + cantidadHuevos);
		label.add(huevos);
		add(label);
		
		//Scroll bar
		JPanel bar = new JPanel();
		bar.setLayout(new BorderLayout());
		scroll = new JScrollBar(JScrollBar.HORIZONTAL, 5, 0, 1, 10);
		scroll.addAdjustmentListener(new BarraHuevo());
		bar.add(scroll, BorderLayout.NORTH);
		add(bar);
		
		//Dificultad
		JPanel dificultad = new JPanel();
		dificultad.add(new JLabel("Dificultad: "));
		ch1 = new JComboBox<String>();
		dificultad.add(ch1);
		ch1.addItem("Dificil (1 vida)");
		ch1.addItem("Normal (3 vidas)");
		ch1.addItem("Facil (5 vidas)");
		ch1.addActionListener(new vidas());
		ch1.setSelectedItem("Normal (3 vidas)");
		add(dificultad);
		
		//Generar tablero
		generar = new JButton("GENERAR TABLERO");
		generar.addActionListener(new generar());
		add(generar);
		
		//Huevos encontrados
		JPanel encontrado = new JPanel();
		labelHuevos = new JLabel("Huevos encontrados: " + huevosEncontrador + " / " + cantidadHuevos);
		encontrado.add(labelHuevos);
		add(encontrado);
		
		//Vidas restantes
		JPanel vidas = new JPanel();
		contadorvidas.setForeground(Color.red);
		vidas.add(contadorvidas);
		add(vidas);
		
		//Finales
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(300, 350);
	}
	
	//Funciones
	class generar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			scroll.setEnabled(false);
			ch1.setEnabled(false);
			generar.setEnabled(false);
			tablero = new Tablero(Juego.this);
		}
	}
	
	class BarraHuevo implements AdjustmentListener {
		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			cantidadHuevos = scroll.getValue();
			huevos.setText("Esconder Huevos: " + cantidadHuevos);
			labelHuevos.setText("Huevos encontrados: " + huevosEncontrador + " / " + cantidadHuevos);
		}
	}
	
	class Rendirse implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Juego.this.dispose();
		}
	}
	
	class CambiarNombre implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
			Juego.this.setTitle("Control - " + nombre);
		}	
	}
	
	class vidas implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String opcion = ch1.getSelectedItem().toString();
			switch (opcion) {
			case "Dificil (1 vida)":
				vidas = 1;
				break;
			case "Normal (3 vidas)":
				vidas = 3;
				break;
			case "Facil (5 vidas)":
				vidas = 5;
				break;
			}
			contadorvidas.setText("Vidas restantes: " + vidas);
		}	
	}
	
	public void activar() {
		scroll.setEnabled(true);
		ch1.setEnabled(true);
		generar.setEnabled(true);
		String opcion = ch1.getSelectedItem().toString();
		switch (opcion) {
		case "Dificil (1 vida)":
			vidas = 1;
			break;
		case "Normal (3 vidas)":
			vidas = 3;
			break;
		case "Facil (5 vidas)":
			vidas = 5;
			break;
		}
		contadorvidas.setText("Vidas restantes: " + vidas);
		huevosEncontrador = 0;
	}
	
	public int getCantidadHuevos() {
		return cantidadHuevos;
	}

	public int getVidas() {
		return vidas;
	}
	
	public void actualizarVidas() {
		vidas = tablero.getVidas();
		contadorvidas.setText("Vidas restantes: " + vidas);
	}
	
	public void actualizarHuevos() {
		huevosEncontrador++;
		labelHuevos.setText("Huevos encontrados: " + huevosEncontrador + " / " + cantidadHuevos);
	}

	public int getHuevosEncontrador() {
		return huevosEncontrador;
	}

	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}