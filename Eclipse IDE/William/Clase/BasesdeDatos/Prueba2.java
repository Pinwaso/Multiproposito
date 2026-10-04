package Clase.BasesdeDatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Prueba2 {


	public static void main(String[] args) {
		String user = "root";
		String pwd = "root";
		String url = "jdbc:mariadb://localhost/";
		try {
		Connection conex=DriverManager.getConnection(url,user,pwd);
		try {
				conex.setAutoCommit(false);
				String query="create database colegio";
				PreparedStatement state=conex.prepareStatement(query);
				state.execute();
				state.close();
				
			} catch (SQLException e) {			
				conex.rollback();		
				e.printStackTrace();
			}finally {
				conex.commit();
				conex.close();
			}
		
		} catch (SQLException e) {
		}

	}

}
