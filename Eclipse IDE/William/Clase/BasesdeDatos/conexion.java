package Clase.BasesdeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexion {

	public static void main(String[] args) {
		try {
			String user = "root";
			String pwd = "";
			String url = "jdbc:mariadb://localhost/jardineria";
			Connection conex = DriverManager.getConnection(url, user, pwd);
			String query = "Select * from cliente";
			Statement state = conex.createStatement();
			ResultSet resultado = state.executeQuery(query);
			while (resultado.next()) {
				System.out.println(resultado.getString("nombre_cliente"));
			}
			state.close();
			
			query = "insert into cliente (codigo_cliente, telefono,  nombre_cliente) values(777, 4462773773, 'arubare')";
			state = conex.createStatement();
			resultado = state.executeQuery(query);
			/*para que el cambio se guarde en la base de datos, se ejecuta executeQuery
			 * executequery se usa para select ya que recupera datos de tablas devolviendo 
			 * un objeto ResulSet que es como una tabla virtual, si se usa executeupdate da error
			 * 
			 * executeupdate es para hacer todo tipos de consultas menos select ya que devuelve
			 * un int que representa la cantiad de filas afectadas por la operacion*/
			while (resultado.next()) {
				System.out.println(resultado.getString("nombre_cliente"));
			}
			state.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	/*mostrarcoleccion (recibe el treeset y recorre)
	 * en muchos metodos se pasa el treeset
	 * metodo fichero para guardar y cargar con treeset se le pasa, esos metodos tiene que lanzar excepciones*/
}