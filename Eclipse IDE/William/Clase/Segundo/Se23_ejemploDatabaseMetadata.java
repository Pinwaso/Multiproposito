package Clase.Segundo;

import java.sql.*;

public class Se23_ejemploDatabaseMetadata {

	public static void main(String[] args) throws SQLException {
		//se establece la conexion con la base de datos bd_empleado
		String conexion = "jdbc:mariadb://172.16.9.2/bd_departamento";
		Connection conex = DriverManager.getConnection(conexion, "root", "root");
		// se crea un objeto DatabaseMetaData
		DatabaseMetaData dbmb = conex.getMetaData();
		ResultSet resul = null;
		String nombre = dbmb.getDatabaseProductName();
		String driver = dbmb.getDriverName();
		String url = dbmb.getURL();
		String usuario = dbmb.getUserName();
		
		System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS:");
		System.out.println("===================================");
		System.out.printf("Nombre : %s %n", nombre );
		System.out.printf("Driver : %s %n", driver );
		System.out.printf("URL : %s %n", url );
		System.out.printf("Usuario: %s %n", usuario );
		
		//obtener informacion de las tablas y vistas que hay
		resul = dbmb.getTables(null, "ejemplo", null, null);
		
		while (resul.next()) {
			String catalogo = resul.getString(1);//columna 1
			String esquema = resul.getString(2); //columna 2
			String tabla = resul.getString(3); //columna 3
			String tipo = resul.getString(4); //columna 4
			System.out.printf("%s - Catalogo: %s, Esquema: %s, Nombre: %s %n",
			tipo, catalogo, esquema, tabla);
		}
		conex.close();
	}
}