package Clase.Examenes.ExamenJunio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		try {
			//1
			Camion cam = new Camion("Ford", "F-100", 1990, LocalDate.now(), 250, "CAM-9458");
			Auto au = new Auto("Ferrari", "365 GTS/4", 1969, LocalDate.now(), "Gasolina", "AUT-AAA-34");
			Moto mot = new Moto("Panhead", "F-2", 1989, LocalDate.now(), 250, "MOT-654639");
			
			//2
			ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
			vehiculos.add(new Camion("Ford", "F-100", 1990, LocalDate.now(), 250, "CAM-9458"));
			vehiculos.add(new Auto("Ferrari", "365 GTS/4", 1969, LocalDate.now(), "Gasolina", "AUT-ABC-78"));
			vehiculos.add(new Moto("Panhead", "F-2", 1989, LocalDate.now(), 250, "MOT-654639"));
			
			//3
			for (Vehiculo v : vehiculos) {
				System.out.println(v.mostrarInformacion());
			}
			
			//4
			System.out.println(au.mostrarInformacion());
			System.out.println(au.mostrarInformacion(true));
			
			//5
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			System.out.println(au.getFechaIngreso().format(formato));
		} catch (DocumentoInvalidoException e) {
			e.getMessage();
		}
	}
}