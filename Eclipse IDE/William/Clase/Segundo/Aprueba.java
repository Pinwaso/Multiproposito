package Clase.Segundo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Aprueba {

	public static void main(String[] args) throws SQLException {
		Connection conex = DriverManager.getConnection("jdbc:mariadb://172.16.9.2/information_schema", "root", "root");
		String query = "Select * from ALL_PLUGINS";
		Statement state = conex.createStatement();
		ResultSet resultado = state.executeQuery(query);
		while (resultado.next()) {
			System.out.println(resultado.getString("PLUGIN_NAME"));
		}
		state.close();
		conex.close();
	}
}
