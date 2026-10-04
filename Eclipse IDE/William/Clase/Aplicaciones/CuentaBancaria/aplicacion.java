package Clase.Aplicaciones.CuentaBancaria;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class aplicacion {
	static Scanner entrada = new Scanner (System.in);
	static ArrayList<cliente> clientes = new ArrayList<>();
	static ArrayList<cuenta> cuentas = new ArrayList<>();
	public enum tipoCuenta {
		CC(0.00, 300.00, 10.00),
		CV(1000.00, 500.00, 500.00),
		FI(5000.00, 500.00, 500.00);
		private final double saldo;
		private final double retiro;
		private final double ingreso;
		tipoCuenta(double saldo, double retiro, double ingreso) {
			this.saldo = saldo;
			this.retiro = retiro;
			this.ingreso = ingreso;
		}
		public double getSaldo() {
			return this.saldo;
		}
		
		public double getRetiro() {
			return this.retiro;
		}
		
		public double getIngreso() {
			return this.ingreso;
		}
		
		public static boolean existe(String texto) {
			boolean encontrado = false;
			for (tipoCuenta t : tipoCuenta.values()) {
				if (t.name().equalsIgnoreCase(texto)) {
					encontrado = true;;
				}
			}
			return encontrado;
		}
	}
////////////////////////////////////////////////////////////////////////
//                              MENUES                                //
////////////////////////////////////////////////////////////////////////
	static void menuPrincipal () {
		System.out.println("""
				1 - Mantenimiento de Clientes (Altas, Bajas, Modificaciones)
				2 - Mantenimiento de Cuentas
				0 - Salir
				""");
	}
////////////////////////////////////////////////////////////////////////
	static void menuClientes() {
		System.out.println("""
				1 - Altas
				2 - Bajas
				3 - Modificaciones
				4 - Listado
				5 - Atras
				""");
	}
////////////////////////////////////////////////////////////////////////	
	static void menuCuenta() {
		System.out.println("""
				1 - Ingresar (cantidad)
				2 - Hacer reintegro (cantidad)
				3 - Ingresar interés mensual
				4 - En rojos
				5 - Leer Saldo
				6 - Datos titular
				7 - Salvar
				8 - Listar movimientos
				9 - Atras
				""");
	}
////////////////////////////////////////////////////////////////////////	
	static void mostrarTipoCuenta() {
		System.out.println("""
				CC (Cuenta corriente con saldo de 0)
				CV (Cuenta Vivienda con saldo de 1000)
				FI (Fondo de Inversion con saldo de 5000)
				""");
	}
////////////////////////////////////////////////////////////////////////
//                            PEDIR VALORES                           //
////////////////////////////////////////////////////////////////////////
	static int pedirNumero (String mensaje) {
		int numero = 0;
		boolean correcto = false;
		do {
			try {
				System.out.println(mensaje);
				numero = entrada.nextInt();
				entrada.nextLine();
				if (numero >= 0) {
					correcto = true;
				}
			} catch (Exception ex) {
				System.out.println("Valor invalido");
				entrada.nextLine();
			}
		} while (!correcto);
		return numero;
	}
////////////////////////////////////////////////////////////////////////	
	static long pedirLongNumero (String mensaje) {
		long numero = 0;
		boolean correcto = false;
		do {
			try {
				System.out.println(mensaje);
				numero = entrada.nextLong();
				entrada.nextLine();
				if (numero >= 0) {
					correcto = true;
				}
			} catch (Exception ex) {
				System.out.println("Valor invalido");
				entrada.nextLine();
			}
		} while (!correcto);
		return numero;
	}
////////////////////////////////////////////////////////////////////////	
	static double pedirDoubleNumero (String mensaje) {
		double numero = 0.00;
		boolean correcto = false;
		do {
			try {
				System.out.println(mensaje);
				numero = entrada.nextDouble();
				entrada.nextLine();
				if (numero >= 0) {
					correcto = true;
				}
			} catch (Exception ex) {
				System.out.println("Valor invalido");
				entrada.nextLine();
			}
		} while (!correcto);
		return numero;
	}
////////////////////////////////////////////////////////////////////////	
	static String pedirCadena (String mensaje) {
		System.out.println(mensaje);
		return entrada.nextLine().trim();
	}
////////////////////////////////////////////////////////////////////////
//                          MÉTODOS CLIENTES                          //
////////////////////////////////////////////////////////////////////////
	static int buscarCliente(String nombre, String apellido) {
		int posicion = -1;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getNombre().equalsIgnoreCase(nombre) && 
				clientes.get(i).getApellido().equalsIgnoreCase(apellido)) {
				posicion = i;
			}
		}
		return posicion;
	}
////////////////////////////////////////////////////////////////////////	
	static void altaCliente() throws ErrorCliente{
		String nombre = pedirCadena("Ingrese el nombre");
		String apellido = pedirCadena("Ingrese el apellido");
		String localidad = pedirCadena("Ingrese la localidad");
		if (buscarCliente(nombre, apellido) < 0) {
			clientes.add(new cliente(nombre, apellido, localidad));
		} else {
			throw new ErrorCliente("El usuario ya existe");
		}
	}
////////////////////////////////////////////////////////////////////////
	static void operacionAltaCliente() {
		boolean correcto = false;
		do {
			try {
				altaCliente();
				correcto = true;
			} catch (ErrorCliente e) {
				System.out.println(e.getMessage());
			}
			 
		} while (!correcto);
	}
////////////////////////////////////////////////////////////////////////	
	static void bajaCliente() throws ErrorCliente {
		String nombre = pedirCadena("Ingrese el nombre");
		String apellido = pedirCadena("Ingrese el apellido");
		if (buscarCliente(nombre, apellido) > 0) {
			clientes.remove(buscarCliente(nombre, apellido));
			System.out.println("Cliente dado de baja exitosamente");
		} else {
			throw new ErrorCliente("Usuario no encontrado");
		}
	}
////////////////////////////////////////////////////////////////////////
	static void operacionBajaCliente() {
		boolean correcto = false;
		do {
			try {
				bajaCliente();
				correcto = true;
			} catch (ErrorCliente e) {
				System.out.println(e.getMessage());
			}
			 
		} while (!correcto);
	}
////////////////////////////////////////////////////////////////////////	
	static void modificarCliente() throws ErrorCliente {
		String nombre = pedirCadena("Ingrese el nombre");
		String apellido = pedirCadena("Ingrese el apellido");
		if (buscarCliente(nombre, apellido) > -1) {
			nombre = pedirCadena("Ingrese el nuevo nombre");
			apellido = pedirCadena("Ingrese el nuevo apellido");
			if (buscarCliente(nombre, apellido) < 0) {
				clientes.get(buscarCliente(nombre, apellido)).setNombre(nombre);
				clientes.get(buscarCliente(nombre, apellido)).setApellido(apellido);
				System.out.println("Usuario modificado exitosamente");
			} else {
				throw new ErrorCliente("El usuario ya existe");
			}
		} else {
			throw new ErrorCliente("Usuario no encontrado");
		}
	}
////////////////////////////////////////////////////////////////////////
	static void operacionModificarCliente() {
		boolean correcto = false;
		do {
			try {
				modificarCliente();
				correcto = true;
			} catch (ErrorCliente e) {
				System.out.println(e.getMessage());
			}
			 
		} while (!correcto);
	}
////////////////////////////////////////////////////////////////////////
	static void listarClientes() {
		if (clientes.size() == 0) {
			System.out.println("No hay clientes dados de alta");
		} else {
			for (int i = 0; i < clientes.size(); i++) {
				System.out.println(clientes.get(i).toString());
			}
		}
	}
////////////////////////////////////////////////////////////////////////
//                           MÉTODOS CUENTAS                          //
////////////////////////////////////////////////////////////////////////	
	static int buscarCuenta(String nombre, String apellido) {
		int posicion = -1;
		for (int i = 0; i < cuentas.size(); i++) {
			if (cuentas.get(i).getTitular().getNombre().equalsIgnoreCase(nombre) && 
				cuentas.get(i).getTitular().getApellido().equalsIgnoreCase(apellido)) {
				posicion = i;
			}
		}
		return posicion; 
	}
////////////////////////////////////////////////////////////////////////	
	static void ingresar(int posicionCuenta) throws ErrorCuenta {
		double cantidad = pedirDoubleNumero("Ingrese la cantidad a ingresar");
		cantidad = Math.abs(cantidad);
		String tipo = cuentas.get(posicionCuenta).getTipo();
		tipoCuenta cuenta = tipoCuenta.valueOf(tipo); 
		if (cantidad < cuenta.getIngreso()) {
			throw new ErrorCuenta("El ingreso minimo debe ser de: " + cuenta.getIngreso() + "$");
		}
		cuentas.get(posicionCuenta).movimiento(null, 'I', cantidad);
	}
////////////////////////////////////////////////////////////////////////
	static void operacionIngresar(int posicionCuenta) {
		boolean correcto = false;
		do {
			try {
				ingresar(posicionCuenta);
				correcto = true;
			} catch (ErrorCuenta e) {
				System.out.println(e.getMessage());
			}
		} while (!correcto);
	}
////////////////////////////////////////////////////////////////////////	
	static void retirar(int posicionCuenta) throws ErrorCuenta{
		double cantidad = pedirDoubleNumero("Ingrese la cantidad a retirar");
		cantidad = Math.abs(cantidad);
		cantidad *= -1;
		double saldo = cuentas.get(posicionCuenta).getSaldo() + cantidad;
		String tipo = cuentas.get(posicionCuenta).getTipo();
		tipoCuenta cuenta = tipoCuenta.valueOf(tipo);
		if (tipo == "FI") {
			if (saldo < 3000 || Math.abs(cantidad) < cuenta.retiro) {
				throw new ErrorCuenta("El retiro mínimo es de " + cuenta.getRetiro() + "$ o el saldo final es de 0$");
			} else {
				cuentas.get(posicionCuenta).movimiento(null, 'R', cantidad);
			}
		} else {
			if (saldo < 0 || Math.abs(cantidad) > cuenta.retiro) {
				throw new ErrorCuenta("El retiro máximo es de " + cuenta.getRetiro() + "$ o el saldo final es de 0$");
			} else {
				cuentas.get(posicionCuenta).movimiento(null, 'R', cantidad);
			}
		}
	}
////////////////////////////////////////////////////////////////////////
	static void operacionRetirar(int posicionCuenta) {
		boolean correcto = false;
		do {
			try {
				retirar(posicionCuenta);
				correcto = true;
			} catch (ErrorCuenta e) {
				System.out.println(e.getMessage());
			} 
		} while (!correcto);
	}
////////////////////////////////////////////////////////////////////////
	static void enRojo(int posicionCuenta) {
		if (cuentas.get(posicionCuenta).getSaldo() >= 0 ) {
			System.out.println("La cuenta no esta en numeros rojos");
		} else {
			System.out.println("La cuenta está en numeros rojos");
		}
	}
////////////////////////////////////////////////////////////////////////	
	static void saldo(int posicionCuenta) {
		System.out.println("El saldo de la cuenta es: " + cuentas.get(posicionCuenta).getSaldo());
	}
////////////////////////////////////////////////////////////////////////	
	static void titular(int posicionCuenta) {
		System.out.println("Datos del titular: " + cuentas.get(posicionCuenta).getTitular());
	}
////////////////////////////////////////////////////////////////////////	
	static void movimientos(int posicionCuenta) {
		System.out.println("Movimientos realizados: " + cuentas.get(posicionCuenta).getMovimientos());
	}
////////////////////////////////////////////////////////////////////////
	static String validarTipoCuenta() {
		String tipo = "";
		boolean correcto = false;
		do {
			mostrarTipoCuenta();
			tipo = pedirCadena("Ingrese el tipo de cuenta");
			if (tipoCuenta.existe(tipo)) {
				correcto = true;
			} else {
				System.out.println("tipo no válido");
			}
		} while (!correcto);
		return tipo;
	}
////////////////////////////////////////////////////////////////////////
	static void crearCuenta(String nombre, String apellido) {
		long numero = pedirLongNumero("Ingrese el numero de la cuenta");
		String tipo = validarTipoCuenta();
		tipoCuenta cuenta = tipoCuenta.valueOf(tipo); 
		double interesAnual = pedirDoubleNumero("Ingrese el interes anual");
		cuentas.add(new cuenta(numero, 
							   cuenta.name(), 
							   cuenta.getSaldo(), 
							   interesAnual, 
							   clientes.get(buscarCliente(nombre, apellido))));
	}
////////////////////////////////////////////////////////////////////////
	static void interesMensual(int posicionCuenta) {
		double interesMensual = ((cuentas.get(posicionCuenta).getSaldo()) / (100 * 12)) * cuentas.get(posicionCuenta).getInteresAnual();
		System.out.println("Interes mensual: " + cuentas.get(posicionCuenta).getSaldo()+interesMensual);
	}
////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {

		boolean correcto = false;
		do {
			menuPrincipal();
			int opcion = pedirNumero("Ingrese una opcion");
			switch (opcion) {
			case 0:
				correcto = true;
				break;
			case 1:
				boolean correcto2 = false;
				do {
					menuClientes();
					opcion = pedirNumero("Ingrese una opcion");
					switch (opcion) {
					case 1:
						operacionAltaCliente();
						break;
					case 2:
						operacionBajaCliente();
						break;
					case 3:
						operacionModificarCliente();
						break;
					case 4:
						listarClientes();
						break;
					case 5:
						correcto2 = true;
						break;
					}
				} while (!correcto2);
				break;
			case 2:
				String nombre = pedirCadena("Ingrese el nombre");
				String apellido = pedirCadena("Ingrese el apellido");
				if (buscarCliente(nombre, apellido) > -1) {
					boolean correcto3 = false;
					do {
						int posicionCuenta = buscarCuenta(nombre, apellido);
						if (posicionCuenta > -1) {
							boolean correcto4 = false;
							do {
								menuCuenta();
								opcion = pedirNumero("Ingrese una opcion");
								switch (opcion) {
								case 1:
									operacionIngresar(posicionCuenta);
									break;
								case 2:
									operacionRetirar(posicionCuenta);
									break;
								case 3:
									interesMensual(posicionCuenta);
									break;
								case 4:
									enRojo(posicionCuenta);
									break;
								case 5:
									saldo(posicionCuenta);
									break;
								case 6:
									titular(posicionCuenta);
									break;
								case 7:
									break;
								case 8:
									movimientos(posicionCuenta);
									break;
								case 9:
									correcto4 = true;
									break;
								}
							} while (!correcto4);
						} else {
							System.out.println("No hay una cuenta asociada a su cuenta, quiere crearla? [true / false]");
							if (entrada.nextBoolean()) {
								entrada.nextLine();			
								crearCuenta(nombre, apellido);
							} entrada.nextLine();
						}
					} while (!correcto3);
				} else {
					System.out.println("El usuario no existe");
				}
			break;
			} 
		} while(!correcto);	
	}
}