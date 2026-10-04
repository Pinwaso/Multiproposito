package Clase.InterfazGrafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class ejercicoRadioCheck extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejercicoRadioCheck frame = new ejercicoRadioCheck();
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
	public ejercicoRadioCheck() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		ButtonGroup grupo = new ButtonGroup();
		
		rdbtnNewRadioButton = new JRadioButton("Rojo");
		panel_1.add(rdbtnNewRadioButton);
		grupo.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				procesarBoton ();	
			}
		});
		rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		panel_1.add(rdbtnNewRadioButton_1);
		grupo.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				procesarBoton();
			}
		});
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		panel_1.add(chckbxNewCheckBox);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Font fuente = textField.getFont();
				int estilo = fuente.getStyle();
				
				if (chckbxNewCheckBox.isSelected()) {
					estilo += Font.BOLD;
				}
				else {
					estilo -= Font.BOLD;
				}
				textField.setFont(new Font(fuente.getName(), estilo, fuente.getSize()));
			}
		});
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		panel_1.add(chckbxNewCheckBox_1);
	}
	
	public void procesarBoton () {
		if (rdbtnNewRadioButton.isSelected()) {
			textField.setBackground(Color.RED);
		} else if (rdbtnNewRadioButton_1.isSelected()) {
			textField.setBackground(Color.BLUE);
		}
	}
}