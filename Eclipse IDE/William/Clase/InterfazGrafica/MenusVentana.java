package Clase.InterfazGrafica;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenusVentana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenusVentana frame = new MenusVentana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenusVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JMenuBar barra = new JMenuBar();
		setJMenuBar(barra);
		
		JMenu menuArchivo = new JMenu("Archivo" );
		barra.add(menuArchivo);
		
		JMenuItem menuAbrir = new JMenuItem("Abrir");
		menuArchivo.add(menuAbrir);
		
		JCheckBoxMenuItem guardar = new JCheckBoxMenuItem("Guardar");
		menuArchivo.add(guardar);
		
		ButtonGroup grupo = new ButtonGroup();
		
		JRadioButtonMenuItem menuRadial1 = new JRadioButtonMenuItem("Boton 1");
		grupo.add(menuRadial1);
		menuArchivo.add(menuRadial1);
		
		JRadioButtonMenuItem menuRadial2 = new JRadioButtonMenuItem("Boton 2");
		grupo.add(menuRadial2);
		menuArchivo.add(menuRadial2);
		menuArchivo.add(new JSeparator());
		
		JMenu menu2 = new JMenu("Prueba");
		menu2.add(new JMenuItem("Prueba elemento"));
		menuArchivo.add(menu2);
	}
}