package Clase.Aplicaciones.GestionEmpleados;

import java.util.ArrayList;
import java.util.Scanner;

public class Empresa {
	private static Scanner entrada = new Scanner (System.in);
	private ArrayList<Empleados> empleados = new ArrayList<>();
	
	public Empresa() {
	}
	
	private String pedirString(String mensaje) {
		System.out.println(mensaje);
		return entrada.nextLine().trim();
	}
	
	private double pedirDouble(String mensaje) {
		boolean correcto = false;
		double valor = 0;
		do {
			try {
				System.out.println(mensaje);
				valor = entrada.nextDouble();
				entrada.nextLine();
				correcto = true;
			} catch (Exception ex) {
				System.out.println("Valor invalido");
				entrada.nextLine();
			}
		} while (!correcto);
		return valor;
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
	
	private void menuEmpleado() {
		System.out.println("""
				1- Empleado por horas
				2- Empleado fijo
				""");
	}
	
	public void agregarEmpleado() {
		boolean correcto = false;
		int opcion = 0;
		do {
			menuEmpleado();
			opcion = pedirInt("Seleccione una opcion");
			if (opcion >= 1 && opcion <= 2) {
				correcto = true;
			}
		} while (!correcto);
		
		String dni = pedirString("Ingrese el dni");
		String nombre = pedirString("Ingrese el nombre");
		String apellidos = pedirString("Ingrese los apellidos");
		
		switch(opcion) {
		case 1:
			int horasTrabajadas = pedirInt("Ingrese la cantidad de horas trabajadas");
			double tarifaPorHora = pedirDouble("Ingrese la tarifa por hora");
			empleados.add(new EmpleadoPorHoras(nombre, apellidos, dni, horasTrabajadas, tarifaPorHora));
			break;
		case 2:
			double salarioMensual = pedirDouble("Ingrese el salario mensual");
			empleados.add(new EmpleadoFijo(nombre, apellidos, dni, salarioMensual));
			break;
		default:
			System.out.println("Error");
			break;
		}
	}
	
	public void eliminarEmpleado() {
		String dni = pedirString("Ingrese el dni del elmpleado a eliminar");
		try {
			operacionEliminarEmpleado(dni);
		} catch (EmpleadoNoEncontradoException ex) {
			ex.getMessage();
		}
	}
	
	private void operacionEliminarEmpleado(String dni) throws EmpleadoNoEncontradoException{
		boolean encontrado = false;
		for (int i = 0 ; i < empleados.size(); i++) {
			if (empleados.get(i).getDni().equals(dni)) {
				empleados.remove(i);
				encontrado = true;
			}
		}
		if (encontrado) {
			System.out.println("Empleado eliminado con exito");
		} else {
			throw new EmpleadoNoEncontradoException("Usuario no encontrado");
		}
	}
}