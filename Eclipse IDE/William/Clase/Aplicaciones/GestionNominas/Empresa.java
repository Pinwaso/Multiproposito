package Clase.Aplicaciones.GestionNominas;

import java.util.ArrayList;
import java.util.Scanner;

public class Empresa {
	static Scanner entrada = new Scanner (System.in);
	private String CIF, nombre;
	private ArrayList<Trabajador> trabajadores = new ArrayList<>();
	
	public Empresa(String CIF, String nombre) {
		this.setCIF(CIF);
		this.setNombre(nombre);
	}

	private int pedirInt(String mensaje) {
		boolean correcto = false;
		int valor = 0;
		do {
			try {
				System.out.println(mensaje);
				valor = entrada.nextInt();
				entrada.nextLine();
				correcto = true;
			} catch (Exception ex) {
				System.out.println("Valor invalido");
				entrada.nextLine();
			}
		} while (!correcto);
		return valor;
	}
	
	private double pedirDouble(String mensaje) {
		boolean correcto = false;
		Double valor = 0D;
		do {
			try {
				System.out.println(mensaje);
				valor = entrada.nextDouble();
				entrada.nextLine();
				if (valor >= 0) {
					correcto = true;
				}
			} catch (Exception ex) {
				System.out.println("Valor invalido");
				entrada.nextLine();
			}
		} while (!correcto);
		return valor;
	}
	
	private String pedirString(String mensaje) {
		System.out.println(mensaje);
		return entrada.nextLine().trim();
	}
	
	private void tipoTrabajador() {
		System.out.println("""
				Seleccione el tipo de trabajador:
				1- Analista
				2- Programador
				3- Administrativo
				4- Auxiliares
				""");
	}
	
	public void agregarTrabajador() {
		boolean correcto = false;
		int opcion = 0;
		do {
			tipoTrabajador();
			opcion = pedirInt("Ingrese una opcion");
			if (opcion >= 1 && opcion <= 4) {
				correcto = true;
			}
		} while (!correcto);
		
		String dni = pedirString("Ingrese el dni");
		String nombre = pedirString("Ingrese el nombre");
		double salarioBase = pedirDouble("Ingrese el salario base");
		
		switch (opcion) {
			case 1: 
				String titulacion = pedirString("Ingrese la titulacion");
				trabajadores.add(new Analistas(dni, nombre, salarioBase, titulacion));
				break;
			case 2: 
				titulacion = pedirString("Ingrese la titulacion");
				trabajadores.add(new Programadores(dni, nombre, salarioBase, titulacion));
				break;
			case 3: 
				int antiguedad = pedirInt("Ingrese la antiguedad");
				trabajadores.add(new Administrativos(dni, nombre, salarioBase, antiguedad));
				break;
			case 4: 
				antiguedad = pedirInt("Ingrese la antiguedad");
				trabajadores.add(new Auxiliares(dni, nombre, salarioBase, antiguedad));
				break;
			default: System.out.println("Error");
		}
	}
	
	public String getCIF() {
		return CIF;
	}

	public void setCIF(String CIF) {
		CIF = CIF;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Trabajador> getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}
}
