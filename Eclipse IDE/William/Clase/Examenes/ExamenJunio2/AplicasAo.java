package Clase.Examenes.ExamenJunio2;

import java.beans.DefaultPersistenceDelegate;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;
import javax.swing.JFrame;

public class AplicasAo extends JFrame implements Serializable{
	/**
	 * 
	 */
	private JTextArea datos;
	private JLabel id, nombre, apellido, dni, notamedia, id2;
	private JButton insertar, eliminar;
	private static final long serialVersionUID = 1L;
	private TreeSet<Estudiante> estudiantes = new TreeSet<Estudiante>();
	private String user = "root", pwd = "";
	
	public AplicasAo() {
		super("AplicasAo");
		setLayout(new BorderLayout());
		datos = new JTextArea();
		estudiantes = cargarBasedeDatos();
		datos.setText(mostrarContenido());
		
		//panel de usuarios
		JPanel usuario = new JPanel();
		usuario.add(id = new JLabel("id"));
		usuario.add(nombre = new JLabel("Nombre"));
		usuario.add(apellido = new JLabel("Apellido"));
		usuario.add(dni = new JLabel("DNI"));
		usuario.add(notamedia = new JLabel("NotaMedia"));
		insertar = new JButton("Insertar");
		insertar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarEstudiante(Integer.parseInt(id.getText()), nombre.getText(), apellido.getText(), dni.getText(), Double.parseDouble(notamedia.getText()));
				id.setText("");
				nombre.setText("");
				apellido.setText("");
				dni.setText("");
				notamedia.setText("");
				guardarBasedeDatos();
				estudiantes = cargarBasedeDatos();
				mostrarContenido();
			}
		});
		usuario.add(insertar);
		usuario.add(id2 = new JLabel("ID"));
		eliminar = new JButton("Eliminar");
		eliminar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarEstudiante(Integer.parseInt(id2.getText()));
				id2.setText("");
				guardarBasedeDatos();
				estudiantes = cargarBasedeDatos();
				mostrarContenido();
			}
		});
		
		add(datos, BorderLayout.CENTER);
		add(usuario, BorderLayout.SOUTH);
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	private void agregarEstudiante(int id, String nombre, String apellido, String dni, double nota) {
		estudiantes.add(new Estudiante(id, nombre, apellido, dni, nota));
	}
	
	private void eliminarEstudiante(int id) {
		for (Estudiante e : estudiantes) {
			if (e.getId() == id) {
				estudiantes.remove(e);
				break;
			}
		}
	}
	
	private String mostrarContenido() {
		String salida = "";
		for (Estudiante e : estudiantes) {
			salida += e.toString() + "\n";
		}
		return salida;
	}

	public void crearBasedeDatos() {
		String url = "jdbc:mariadb://localhost";
		try {
			Connection conex = DriverManager.getConnection(url, user, pwd);
			try {
				String query = "CREATE DATABASE IF NOT EXIST 'main'";
				String query2 = "CREATE TABLE IF NOT EXIST `main`.`alumnos` " + "(`id` INT(10) NOT NULL , `nombre` VARCHAR(15) "
						+ "NOT NULL , `apellido` VARCHAR(15) NOT NULL , `dni` "
						+ "VARCHAR(15) NOT NULL , `notamedia` DOUBLE(2,2) NOT NULL )";
				Statement state = conex.createStatement();
				state.executeUpdate(query);

				state = conex.createStatement();
				state.executeUpdate(query2);
			} catch (Exception ex) {
				ex.getMessage();
			} finally {
				conex.close();
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
	
	public void guardarBasedeDatos() {		
		String url = "jdbc:mariadb://localhost/main";
		try {
			Connection conex = DriverManager.getConnection(url, user, pwd);
			try {
				Statement stat = conex.createStatement();
				String query = "DELETE * FROM alumnos";
				stat.executeUpdate(query);
				
				query = "INSERT INTO ALUMNOS VALUES(?, ? ,?, ?, ?)";
				PreparedStatement state = conex.prepareStatement(query);
				for (Estudiante e : this.getEstudiantes()) {
					state.setInt(1, e.getId());
					state.setString(2, e.getNombre());
					state.setString(3, e.getApellido());
					state.setString(4, e.getDni());
					state.setDouble(5, e.getNotaMedia());
					state.addBatch();
				}
				state.executeBatch();
			} catch (Exception ex) {
				ex.getMessage();
			} finally {
				conex.close();
			}
		} catch (Exception ex) {
			ex.getMessage();
			crearBasedeDatos();
		}
	}

	public void guardarArchivo(String archivo) {
		try {
			File fichero = new File(archivo);
			if (fichero.isFile() && fichero.exists()) {
				ObjectOutputStream ob = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)));
				ob.writeObject(this.getEstudiantes());
				ob.flush();
				ob.close();
			} else {
				System.out.println("El fichero no existe");
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
	
	public TreeSet<Estudiante> cargarBasedeDatos() {
		String url = "jdbc:mariadb://localhost/main";
		TreeSet<Estudiante> estudiantes = new TreeSet<>();
		try {
			Connection conex = DriverManager.getConnection(pwd, user, pwd);	
			try {
				String query = "SELECT * FROM alumnos";
				Statement state = conex.createStatement();
				ResultSet resultado = state.executeQuery(query);
				while (resultado.next()) {
					estudiantes.add(new Estudiante(resultado.getInt("id"), 
					resultado.getString("nombre"), resultado.getString("apellido"), 
					resultado.getString("dni"), resultado.getDouble("notamedia")));
				}
			} catch (Exception ex) {
				ex.getMessage();
			} finally {
				conex.close();
			}
		} catch (Exception ex) {
			ex.getMessage();
		} finally {
			return estudiantes;
		}
	}
	
	public TreeSet<Estudiante> cargarArchivo(String archivo) {
		TreeSet<Estudiante> estudiantes = null;
		try {
			File fic = new File(archivo);
			if (fic.exists() && fic.isFile()) {
				ObjectInputStream oi = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fic)));
				estudiantes = (TreeSet<Estudiante>) oi.readObject();
				oi.close();				
			} else {
				System.out.println("El fichero no existe");
			}
		} catch (Exception ex) {
			ex.getMessage();
		} finally {
			return estudiantes;
		}
	}
	
	public TreeSet<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	private void setEstudiantes(TreeSet<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	public static void main(String[] args) {
		AplicasAo a = new AplicasAo();
	}
}