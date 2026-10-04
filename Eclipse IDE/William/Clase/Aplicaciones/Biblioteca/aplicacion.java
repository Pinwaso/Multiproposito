package Clase.Aplicaciones.Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class aplicacion {
	static Scanner entrada = new Scanner(System.in);
	static ArrayList<recurso> recursos = new ArrayList<>();
//////////////////////////////////////////////////////////////////
////////////////////// LISTAS ENUMERADAS /////////////////////////
//////////////////////////////////////////////////////////////////
	public enum tipoLibro {
		NOVELA,
		COMIC,
		CIENCIA_FICCION;
	}
//////////////////////////////////////////////////////////////////
	public enum formatos {
		DVD,
		CDS;
	}
//////////////////////////////////////////////////////////////////
	public enum tipoRecurso{
		IMAGEN,
		PDF,
		VIDEO;
	}
//////////////////////////////////////////////////////////////////
///////////////////////////// MENUES /////////////////////////////
//////////////////////////////////////////////////////////////////
	static void menuPrincipal() {
		System.out.println("""
				=== MENU BIBLIOTECA ===
				1 - Añadir recurso
				2 - Modificar recurso
				3 - Eliminar recurso
				4 - Buscar recurso por ID
				0 - Salir
				""");
	}
//////////////////////////////////////////////////////////////////
//////////////////////////// FUNCIONES ///////////////////////////
//////////////////////////////////////////////////////////////////
	static int pedirInt(String mensaje, String error) {
		boolean correcto = false;
		int valor = 0;
		do {
			try {
				valor = entrada.nextInt();
				entrada.nextLine();
				correcto = true;
			} catch (Exception ex) {
				System.out.println(error);
				entrada.nextLine();
			}
		} while (!correcto);
		return valor;
	}
//////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////
	static void operacionAñadir() {
		String titulo = pedirString("Ingrese el titulo del recurso");
		int tipo;
		boolean correcto = false;
		do {
			tipo = pedirInt("Recurso digital(0) o Recurso libro(1)?", "Valor invalido");
			if (tipo >= 0 && tipo <= 1) correcto = true;
		} while (!correcto);
		if (tipo == 0) {
			recursoDigital digital = new recursoDigital(titulo);
			boolean seguir = false;
			do {
				String nombre = pedirString("Ingrese el nombre");
				String tipodigital = "";
				boolean correcto2 = false;
				do {
					try {
						tipoRecurso recurso[] = tipoRecurso.values();
						for (int i = 0; i < tipoRecurso.values().length; i++) {
							System.out.println("" + i + " - " + recurso[i]);
						}
						tipodigital = pedirString("Ingrese el tipo").toUpperCase();
						correcto2 = true;
					} catch (Exception ex) { System.out.println("Opcion invalida"); }
				} while(!correcto2);
				int tamano = -1;
				do {
					tamano = pedirInt("Ingrese el tamano", "Valor invalido");
				} while (tamano < 1);
				digital.setSoporte(nombre, tipodigital, tamano);
				System.out.println("Seguir agregando mas? (true)");
				if (!entrada.nextBoolean()) { seguir = true; }
			} while (!seguir);
			recursos.add(digital);
		} else {
			String isbn = pedirString("Ingrese el ISBN");
			int paginas = pedirInt("Ingrese el numero de paginas", "Valor invalido");
			String tipolibro = "";
			boolean correcto1 = true;
			do {
				try {
					tipoLibro libro[] = tipoLibro.values();
					for (int i = 0; i < tipoLibro.values().length; i++) {
						System.out.println("" + i + " - " + libro[i]);
					}
					tipolibro = pedirString("Ingrese el tipo").toUpperCase();
					tipoLibro opcion = tipoLibro.valueOf(tipolibro);
					correcto = true;
				} catch (Exception ex) { System.out.println("Opcion invalida"); }
			} while (!correcto1);
			recursos.add(new recursoLibro(titulo, isbn, paginas, tipolibro));
		}
	}
//////////////////////////////////////////////////////////////////
	static String pedirString(String mensaje) {
		System.out.println(mensaje);
		return entrada.nextLine().trim();
	}
//////////////////////////////////////////////////////////////////
/////////////////////////// APLICACION ///////////////////////////
//////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		boolean correcto = false;
		do {
			menuPrincipal();
			int valor;
			boolean correcto1 = false;
			do {
				valor = pedirInt("Elige una opcion", "Valor invalido");
				if (valor >= 0 && valor <= 4) correcto = true;
			} while (!correcto1);
			switch (valor) {
			case 0: correcto = true; break;
			case 1: operacionAñadir(); break;
			case 2: break;
			case 3: break;
			case 4: break;
			}
		} while (!correcto);
	}
}