package Clase.InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class Barra extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container panel;
	JPanel p1, p2;
	JLabel l1, msg;
	JComboBox<String> ch1;
	String[] lista = {"Opción 1", "Opción 2", "Opción 3"};
	JScrollBar bar1;
	public Barra() {
		super("Controles");
		setLayout(new BorderLayout());
		p1 = new JPanel(new GridLayout(1, 3, 10, 10));
		p1.setBackground(Color.lightGray);
		l1 = new JLabel("Elegir:", Label.RIGHT);
		l1.setBackground(Color.yellow);
		p1.add(l1);
		ch1 = new JComboBox<>();
		for(int i = 0; i < lista.length; i++)
			ch1.addItem(lista[i]);
		ch1.addItemListener(new OyenteCombo());
		p1.add(ch1);
		bar1 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 0, 0, 100);
		/* scroll de 0 a 100*/
		bar1.addAdjustmentListener(new OyenteBarra());
		p1.add(bar1);
		p2 = new JPanel(new BorderLayout());
		p2.setBackground(Color.lightGray);
		msg = new JLabel("Msg:", Label.LEFT);
		msg.setForeground(Color.blue);
		p2.add("North", msg);
		add(p1, "North");
		add(p2, "South");
		setSize(300, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String args[]) {
		Barra ventana = new Barra();
	}
	class OyenteCombo implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			int ind = ch1.getSelectedIndex();
			msg.setText((String)ch1.getSelectedItem());
		}
	}
	class OyenteBarra implements AdjustmentListener {
		public void adjustmentValueChanged(AdjustmentEvent e) {
			int valor = bar1.getValue();
			String cad = "Valor : " + valor;
			msg.setText(cad);
		}
	}
}