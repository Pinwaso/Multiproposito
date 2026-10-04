package Clase.BasesdeDatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Prueba {

	public Prueba() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String user = "root";
		String pwd = "root";
		String url = "jdbc:mariadb://localhost";
		try {
			Connection conex = DriverManager.getConnection(url, user, pwd);
			try {
				conex.setAutoCommit(false);
				String query = "Select nombre,apellido,fecha from jardineria.alvaro";
				PreparedStatement state = conex.prepareStatement(query);
				ResultSet resultado = state.executeQuery();
				while (resultado.next()) {
					System.out.print(resultado.getString(1) + " - ");
					System.out.print(resultado.getString(2) + " - ");
					System.out.print(resultado.getString(3) + " ** ");
					System.out.print(resultado.getTime(3) + " ** ");
					System.out.print(resultado.getDate(3) + " ** ");
					System.out.println(resultado.getTimestamp(3));

					Timestamp ts = resultado.getTimestamp(3);
					LocalDateTime ldt = ts.toLocalDateTime();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
					String fechaFormateada = ldt.format(formatter);
					System.out.println(fechaFormateada);

				}
				resultado.close();
				state.close();
				query = "delete from jardineria.alvaro";
				state = conex.prepareStatement(query);
				System.out.println(state.executeUpdate());
				query = "INSERT INTO jardineria.alvaro (nombre, apellido,fecha) VALUES (?, ?, ?)";
				state = conex.prepareStatement(query);
				state.setString(1, "david");
				state.setString(2, "garcia");
				state.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
				state.addBatch();
				state.setString(1, "juan");
				state.setString(2, "ruiz");
				LocalDateTime fecha = LocalDateTime.of(2026, 2, 10, 14, 30);
				state.setTimestamp(3, Timestamp.valueOf(fecha));
				state.addBatch();
				for (int dato : state.executeBatch()) {
					System.out.println(dato);
				}
			} catch (SQLException e) {
				conex.rollback();
				e.printStackTrace();
			} finally {
				conex.commit();
				conex.close();
			}
		} catch (SQLException e) {
		}
	}
}