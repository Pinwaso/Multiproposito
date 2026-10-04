package Clase.Clase;
import java.util.Scanner;

public class concatenar_palabras {

	public static void main(String[] args) {
		try {
			String resultado1, resultado2, resultado3;
			System.out.println("Introduce lo que sea");
			Scanner entrada = new Scanner(System.in);
			resultado1 = entrada.next();
			resultado2 = entrada.next();
			resultado3 = entrada.next();
			System.out.println(resultado1 + " " + resultado2 + " " + resultado3);
			entrada.close();
		} catch (Exception ex) {
			System.out.println("ta mal");
		} finally {
			System.out.println("FIN");
		}

	}

}
