package Clase.Aplicaciones.Practica;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class aplicasao {

	public static void main(String[] args) {
		//String n = "Marzo";
		//numeros numbre = numeros.valueOf(n);
		
		/*for (numeros p : numeros.values()) {
			System.out.println(p);
			System.out.println(p.getdias());
		}*/
		
		LocalDate fecha = LocalDate.of(2003, 8, 4);
		LocalDateTime fechatiempo = LocalDateTime.of(2003, 8, 4, 8, 0);
		LocalTime tiempo = LocalTime.of(4, 0);
		Period p = Period.between(fecha, LocalDate.now());
		Duration d = Duration.between(tiempo, LocalTime.now());
		System.out.println(d.toHoursPart());
	}
}