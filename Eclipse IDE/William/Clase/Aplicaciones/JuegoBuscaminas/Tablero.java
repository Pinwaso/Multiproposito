package Clase.Aplicaciones.JuegoBuscaminas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Tablero extends JFrame {
	private Juego juego;
	private int NumTrampas, vidas;
	private JPopupMenu menu;
	private Boton[][] botones = { 
			{ new Boton(), new Boton(), new Boton(), new Boton() },
			{ new Boton(), new Boton(), new Boton(), new Boton() },
			{ new Boton(), new Boton(), new Boton(), new Boton() },
			{ new Boton(), new Boton(), new Boton(), new Boton() } };

	Tablero(Juego juego) {
		super("Tablero de Búsqueda");
		this.juego = juego;
		NumTrampas = (juego.getCantidadHuevos() / 2) + 1;
		vidas = juego.getVidas();

		// Panel del tablero
		JPanel tablero = new JPanel();
		tablero.setLayout(new GridLayout(4, 4));
		menu = new JPopupMenu();
		JMenuItem bandera = new JMenuItem("Poner Bandera");
		bandera.addActionListener(new Bandera());
		menu.add(bandera);
		for (int i = 0; i < botones.length; i++) {
			for (int a = 0; a < botones[i].length; a++) {
				tablero.add(botones[i][a]);
				botones[i][a].addMouseListener(new click());
			}
		}
		rellenar();

		// Panel de pista
		JPanel pista = new JPanel();
		pista.addKeyListener(new radar());
		pista.setFocusable(true);
		pista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pista.requestFocusInWindow();
				super.mouseClicked(e);
			}
		});
		pista.add(new JLabel("Pulsa ESPACIO para pista (cuesta 1 vida)"));

		// Finales
		setLayout(new BorderLayout());
		add(tablero, BorderLayout.CENTER);
		add(pista, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
		pista.requestFocusInWindow();
	}

	private void rellenar() {
		for (int i = 0; i < NumTrampas;) {
			int x = random();
			int y = random();
			if (botones[y][x].getTipo().equals("")) {
				botones[y][x].setTipo("trampa");
				i++;
			}
		}
		for (int i = 0; i < juego.getCantidadHuevos();) {
			int x = random();
			int y = random();
			if (botones[y][x].getTipo().equals("")) {
				botones[y][x].setTipo("huevo");
				i++;
			}
		}
		for (Boton[] items : botones) {
			for (Boton item : items) {
				if (item.getTipo().equals("")) {
					item.setTipo("nada");
				}
			}
		}
	}

	private int random() {
		return (int) (Math.random() * 4);
	}

	// Funciones
	class click extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == e.BUTTON1) {
				Boton pulsado = (Boton) e.getSource();
				String tipo = pulsado.getTipo();
				switch (tipo) {
				case "trampa":
					if (vidas > 1) {
						if (pulsado.isEnabled()) {
							pulsado.setEnabled(false);
							pulsado.setBackground(Color.red);
							pulsado.setText(pulsado.getTipo());
							vidas--;
							juego.actualizarVidas();
						}
					} else {
						if (pulsado.isEnabled()) {
							pulsado.setEnabled(false);
							pulsado.setBackground(Color.red);
							pulsado.setText(pulsado.getTipo());
							vidas--;
							juego.actualizarVidas();
							JOptionPane.showMessageDialog(Tablero.this, "Perdiste");
							deshabilitar();
							juego.activar();
						}
					}
					break;
				case "huevo":
					if (pulsado.isEnabled()) {
						if (juego.getHuevosEncontrador() < juego.getCantidadHuevos()-1) {
							pulsado.setEnabled(false);
							pulsado.setBackground(Color.green);
							pulsado.setText(pulsado.getTipo());
							juego.actualizarHuevos();
						} else {
							pulsado.setEnabled(false);
							pulsado.setBackground(Color.green);
							pulsado.setText(pulsado.getTipo());
							juego.actualizarHuevos();
							JOptionPane.showMessageDialog(Tablero.this, "Ganaste");
							deshabilitar();
							juego.activar();
						}
					}
					break;
				case "nada":
					if (pulsado.isEnabled()) {
						pulsado.setEnabled(false);
						pulsado.setBackground(Color.gray);
						pulsado.setText(pulsado.getTipo());
					}
					break;
				}
			}
			super.mouseClicked(e);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.isPopupTrigger()) {
				menu.show(e.getComponent(), e.getX(), e.getY());
			}
			super.mousePressed(e);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.isPopupTrigger()) {
				menu.show(e.getComponent(), e.getX(), e.getY());
			}
			super.mouseReleased(e);
		}
	}

	class radar extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				if (vidas <= 1) {
					JOptionPane.showMessageDialog(Tablero.this, "No hay recursos suficientes");
				} else if (vidas > 1) {
					vidas--;
					juego.actualizarVidas();
					JOptionPane.showMessageDialog(Tablero.this, busqueda());
				}
			}
			super.keyPressed(e);
		}
	}
	
	class Bandera implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Boton pulsado = (Boton)menu.getInvoker();
			if (pulsado.isEnabled()) {
				pulsado.setBackground(Color.yellow);
				pulsado.setEnabled(false);
			}
		}	
	}
	
	public void deshabilitar() {
		for (Boton[] items: botones) {
			for (Boton item : items) {
				if (item.isEnabled()) {
					item.setEnabled(false);
				}
			}
		}
	}
	
	public String busqueda () {
		String resultado = "";
		int x = 0, y = 0;
		boolean encontrado = false;
		for (int i = 0; i < botones.length; i++) {
			for (int a = 0; a < botones[i].length; a++) {
				Boton boton = botones[i][a];
				if (boton.getTipo().equals("huevo") && boton.isEnabled()) {
					x = a;
					y = i;
					encontrado = true;
					break;
				}
			}
			if (encontrado) break;
		}
		int opcion = (int)(Math.random() * 2);
		switch (opcion) {
		case 0:
			resultado = "El radar detecta un huevo en la fila " + (y+1);
			break;
		case 1:
			resultado = "El radar detecta un huevo en la columna " + (x+1);
			break;
		}
		return resultado;
	}
	
	public int getVidas() {
		return vidas;
	}
}