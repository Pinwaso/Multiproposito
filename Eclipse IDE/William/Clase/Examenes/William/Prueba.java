package Clase.Examenes.William;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Prueba {
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////// VARIABLES ///////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
	static Scanner entrada = new Scanner (System.in);
	ArrayList<Usuario> usuarios = new ArrayList<>();
	ArrayList<Alumno> alumnos = new ArrayList<>();
	ArrayList<Clase> clases = new ArrayList<>();
////////////////////////////////////////////////////////////////////////////////
///////////////////////////////// CONSTRUCTOR //////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
	/**
	 * Constructor de la clase Prueba
	 */
	public Prueba() {
		super();
	}
////////////////////////////////////////////////////////////////////////////////
//////////////////////////// METODOS PEDIR VARIABLE ////////////////////////////
////////////////////////////////////////////////////////////////////////////////	
	/**
	 * Método para pedir un valor int
	 * @param mensaje String para mostrar un mensaje personalizado
	 * @return Devuelve un valor int
	 */
	public int pedirInt(String mensaje) {
		boolean correcto = false;
		int numero = 0;
		do {
			try {
				System.out.println(mensaje);
				numero = entrada.nextInt();
				entrada.nextLine();
				correcto = true;
			} catch (Exception ex) {
				System.out.println("Valor invalido");
				entrada.nextLine();
			}
		} while (!correcto);
		return numero;
	}
////////////////////////////////////////////////////////////////////////////////
	/**
	 * Método para pedir un valor double
	 * @param mensaje String para mostrar un mensaje personalizado
	 * @return Devuelve un valor double
	 */
	public double pedirDouble(String mensaje) {
		boolean correcto = false;
		double numero = 0D;
		do {
			try {
				System.out.println(mensaje);
				numero = entrada.nextDouble();
				entrada.nextLine();
				correcto = true;
			} catch (Exception ex) {
				System.out.println("Valor invalido");
				entrada.nextLine();
			}
		} while (!correcto);
		return numero;
	}
////////////////////////////////////////////////////////////////////////////////
    /**
     * Método para pedir un valor String
     * @param mensaje String para mostrar un mensaje personalizado
     * @return Devuevle un valor String sin espacios adyacentes
     */
	public String pedirString (String mensaje) {
		System.out.println(mensaje);
		return entrada.nextLine().trim();
	}
////////////////////////////////////////////////////////////////////////////////  
	/**
	 * Método para validar la entrada del usuario para el menú de selección
	 * @param mensaje String para mostrar un mensaje personalizado
	 * @return Devuelve un valor int con la opción en un rango válido
	 */
	public int validarEntrada(String mensaje) {
		boolean correcto = false;
		int numero = 0;
		do {
			try {
				System.out.println(mensaje);
				numero = entrada.nextInt();
				entrada.nextLine();
				if (numero >= 1 && numero <= 11) {
					correcto = true;
				} else {
					throw new EntradaInvalidaException("El numero debe estar entre 1 y 7");
				}
			} catch (Exception ex) {
				ex.getMessage();
				entrada.nextLine();
			}
			return numero;
		} while (!correcto);
	}
////////////////////////////////////////////////////////////////////////////////
///////////////////////////// METODOS DE INSERCION /////////////////////////////
////////////////////////////////////////////////////////////////////////////////
	/**
	 * Método para crear un Alumno
	 */
	public void añadirAlumno() {
		String id = pedirString("ingrese el id");
		String nombre = pedirString("ingrese el nombre");
		int edad = pedirInt("Ingrese la edad");
		String dni = pedirString("Ingrese el dni");
		int codigoAlumno = pedirInt("Ingrese el codigo del alumno");
		try {
			boolean encontrado1 = false, encontrado2 = false;
			for (Usuario usuario : alumnos) {
				if (usuario.getId().equals(id) && ((Alumno)usuario).getCodigoAlumno() == codigoAlumno) {
					encontrado1 = true;
				}
			}
			for (Alumno alumno : alumnos) {
				if (alumno.getId() == id && alumno.getCodigoAlumno() == codigoAlumno) {
					encontrado2 = true;
				}
			}
			if (!encontrado1 && !encontrado2) {
				Alumno persona = new Alumno(id, nombre, edad, dni, codigoAlumno,0.1);
				usuarios.add(persona);
				alumnos.add(persona);
				System.out.println("Alumno añadido correctamente");
			} else {
				throw new UsuarioExistenteException("El alumno existe en la lista de Usuarios o Alumnos");
			}
		} catch (EdadInvalidaException e) {
			e.getMessage();
		} catch (NotaInvalidaException n) {
			n.getMessage();
		} catch (UsuarioExistenteException u) {
			u.getMessage();
		}
	}
////////////////////////////////////////////////////////////////////////////////
	/**
	 * Método para crear un profesor
	 */
	public void añadirProfesor() {
		String id = pedirString("Ingrese el id");
		String nombre = pedirString("Ingrese el nombre");
		int edad = pedirInt("Ingrese la edad");
		String dni = pedirString("Ingrese el dni");
		String especialidad = pedirString("Ingrese la especialidad");
		double salarioBase = pedirDouble("Ingrese el salario base (double)");
		try {
			if (buscarUsuario(id) >= 0) {
				throw new UsuarioExistenteException("El profesor ya existe");
			} else {
				Profesor profesor = new Profesor(id, nombre, edad, dni, especialidad, salarioBase);
				usuarios.add(profesor);
			}
		} catch (EdadInvalidaException e) {
			e.getMessage();
		} catch (UsuarioExistenteException u) {
			u.getMessage();
		}
	}
////////////////////////////////////////////////////////////////////////////////
	/**
	 * Método para crear una clase
	 */
	public void crearClase() {
		try {
			NombreClase nombreCurso = NombreClase.valueOf(pedirString("Ingrese el nombre de la clase").toUpperCase());
			int horas = pedirInt("Ingrese las horas de la asignatura");
			NivelCurso nivel = NivelCurso.valueOf(pedirString("Ingrese el nivel de curso").toUpperCase());
			String id = pedirString("Ingrese el id del profedor a impartir");
			if (buscarUsuario(id) < 0) {
				throw new UsuarioNoExistenteException("El profesor no existe");
			}
			if (!(usuarios.get(buscarUsuario(id)) instanceof Profesor)) {
				throw new UsuarioExistenteException("El usuario debe ser un profesor");
			}
			if (buscarClase(nombreCurso) >= 0) {
				throw new ClaseExistenteException("La clase ya existe");
			}
			clases.add(new Clase(nombreCurso, horas, nivel, (Profesor)usuarios.get(buscarUsuario(id))));
			System.out.println("Clase añadido correctamente");
		} catch (ClaseExistenteException c){
			c.getMessage();
		} catch (UsuarioNoExistenteException u) {
			u.getMessage();
		} catch (UsuarioExistenteException u) {
			u.getMessage();
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
////////////////////////////////////////////////////////////////////////////////
	/**
	 * Método para introducir un máximo de 5 notas en una asignatura especificada
	 * en un alumno especificado
	 */
	public void introducirNotasEnMatriz() {
		try {
			String id = pedirString("Ingrese el id del alumno");
			if (buscarAlumno(id) < 0) {
				throw new UsuarioNoExistenteException("El alumno no existe");
			}
			NombreClase clase = NombreClase.valueOf(pedirString("Ingrese el nombre de la asignatura"));
			if (!alumnos.get(buscarAlumno(id)).getAsignaturas().containsKey(clase)) {
				throw new ClaseNoExistenteException("El alumno no esta matriculado en esa asignatura");
			}
			ArrayList<Double> notas = new ArrayList<>();
			for (int i = 1; i <= 5; i++) {
				double nota = pedirDouble("Ingrese la nota " + i + " (-1 para omitir una nota)");
				notas.add(nota);
			}
			alumnos.get(buscarAlumno(id)).getAsignaturas().put(clase, notas);
		} catch (UsuarioNoExistenteException u) {
			u.getMessage();
		} catch (ClaseNoExistenteException c) {
			c.getMessage();
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
////////////////////////////////////////////////////////////////////////////////
//////////////////////////// METODOS DE ELIMINACIÓN ////////////////////////////
////////////////////////////////////////////////////////////////////////////////
	/**
	 * Método para eliminar un profesor
	 */
	public void eliminarProfesor() {
		try {
			String id = pedirString("Ingrese el id del profesor a eliminar");
			if (buscarUsuario(id) < 0) {
				throw new UsuarioNoExistenteException("El profesor no existe");
			}
			usuarios.remove(buscarUsuario(id));
			System.out.println("Profesor eliminado correctamente");
		} catch (UsuarioNoExistenteException u) {
			u.getMessage();
		}
	}
////////////////////////////////////////////////////////////////////////////////
	/**
	 * Método para eliminar un alumno
	 */
	public void eliminarAlumno() {
		try {
			String id = pedirString("Ingrese el id del alumno a eliminar");
			if (buscarAlumno(id) < 0) {
				throw new UsuarioNoExistenteException("El alumno no existe en alumnos");
			}
			if (buscarUsuario(id) < 0) {
				throw new UsuarioNoExistenteException("El alumno no existe en usuarios");
			}
			usuarios.remove(buscarUsuario(id));
			alumnos.remove(buscarAlumno(id));
			System.out.println("Alumno eliminado con exito");
		} catch (UsuarioNoExistenteException u) {
			u.getMessage();
		}
	}
////////////////////////////////////////////////////////////////////////////////
	/**
	 * Método para eliminar una clase, además, elimina todos los registro y notas
	 * de la clase eliminada de todos los alumnos
	 */
	public void eliminarClase() {
		try {
			NombreClase clase = NombreClase.valueOf(pedirString("Ingrese el nombre de la clase a eliminar"));
			if (buscarClase(clase) < 0) {
				throw new ClaseNoExistenteException("La clase no existe");
			}
			for (Alumno alumno : alumnos) {
				if (alumno.getAsignaturas().containsKey(clase)) {
					alumno.getAsignaturas().remove(clase);
				}	
			}
		} catch (ClaseNoExistenteException c) {
			c.getMessage();
		}
	}
////////////////////////////////////////////////////////////////////////////////
////////////////////////////// METODOS DE BUSQUEDA /////////////////////////////
////////////////////////////////////////////////////////////////////////////////
	/**
	 * Método para buscar un Alumno en el array de alumnos por el codigo del alumno
	 * @param codigoAlumno int como codigo del alumno
	 * @return devuelve el indice del array de alumno si lo encontro,
	 * caso contrario devuelve -1
	 */
	public int buscarAlumnoPorCodigo(int codigoAlumno) {
		int indice = -1;
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getCodigoAlumno() == codigoAlumno) {
				indice = i;
			}
		}
		return indice;
	}
////////////////////////////////////////////////////////////////////////////////	
	/**
	 * Método para buscar una clase en el array de clases por el nombre de la clase
	 * @param nombre valor del tipo enum NombreClase como nombre de la clase 
	 * @return devuelve el indice del array de clases si lo encontro,
	 * caso contrario devuelve -1
	 */
	public int buscarClase(NombreClase nombre) {
		int indice = -1;
		for (int i = 0; i < clases.size(); i++) {
			if (clases.get(i).getNombreCurso() == nombre) {
				indice = i;
			}
		}
		return indice;
	}
////////////////////////////////////////////////////////////////////////////////
	/**
	 * Método para buscar un usuario en el array de usuarios por ID
	 * @param id String como id del usuario
	 * @return devuelve el indice del array de usuarios si lo encontro,
	 * caso contrario devuelve -1
	 */
	public int buscarUsuario(String id) {
		int indice = -1;
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getId().equals(id)) {
				indice = i;
			}
		}
		return indice;
	}
////////////////////////////////////////////////////////////////////////////////
	/**
	 * Método para buscar un alumno en el array de alumnos por ID
	 * @param id String como id del alumno
	 * @return devuelve el indice del array de alumnos si lo encontro,
	 * caso contrario devuelve -1
	 */
	public int buscarAlumno(String id) {
		int indice = -1;
		for (int i = 0; i < alumnos.size() ; i++) {
			if (alumnos.get(indice).getId().equals(id)) {
				indice = i;
			}
		}
		return indice;
	}
////////////////////////////////////////////////////////////////////////////////
///////////////////////// METODOS DE MOSTRAR INFOMRACION ///////////////////////
////////////////////////////////////////////////////////////////////////////////
	/**
	 * Método para mostrar todos los usuarios en el array de usuarios
	 */
	public void mostrarUsuarios() {
		for (Usuario usuario : usuarios) {
			if (usuario instanceof Alumno) {
				((Alumno)usuario).mostrarIdentificacion();
			} else if (usuario instanceof Profesor) {
				((Profesor)usuario).mostrarIdentificacion();
			}
		}
	}
////////////////////////////////////////////////////////////////////////////////	
	public void mostrarMejorAlumno() {	
	}
////////////////////////////////////////////////////////////////////////////////
	/**
	 * Método para mostrar todos los cursos junto con su información
	 */
	public void mostrarCursos() {
		for (NivelCurso curso : NivelCurso.values()) {
			System.out.println(curso.name() + " " + curso.getDescripcion() + " " + curso.getFactorPrecio());
		}
	}
////////////////////////////////////////////////////////////////////////////////
	/**
	 * Método para mostrar todas las notas de un alumno
	 */
	public void mostrarNotas() {
		try {
			String id = pedirString("Ingrese el id del Alumno");
			if (buscarAlumno(id) < 0) {
				throw new UsuarioNoExistenteException("Alumno no encontrado");
			}
			for (Map.Entry<NombreClase, ArrayList<Double>> asignatura : alumnos.get(buscarAlumno(id)).getAsignaturas().entrySet()) {
				System.out.print("Asignatura: " + asignatura.getKey() + " Notas:");
				for (double nota : asignatura.getValue()) {
					if (nota >= 0 && nota <= 10) {
						System.out.print(" " + nota);
					}
				}
			}
		} catch (UsuarioNoExistenteException u) {
			u.getMessage();
		}
	}
////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////// OTROS ////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
	/**
	 * Método para calcular la nota media de una asignatura de un alumno específico
	 */
	public void calcularNotaMedia() {
		try {
			String id = pedirString("Ingrese el id del Alumno");
			if (buscarAlumno(id) < 0) {
				throw new UsuarioNoExistenteException("Alumno no encontrado");
			}
			NombreClase clase = NombreClase.valueOf(pedirString("Ingrese el nombre de la asignatura").toUpperCase());
			double notas = 0;
			int contador = 0;
			for (Double nota : alumnos.get(buscarAlumno(id)).getAsignaturas().getOrDefault(clase, null)) {
				if (nota == null) {
					System.out.println("No hay notas");
					break;
				}
				if (nota >= 0 && nota <= 10) {
					notas+=nota;
					contador++;
				}
			}
			System.out.println("La nota media de " + clase + " es: " + (notas/contador));
		} catch (UsuarioNoExistenteException u) {
			u.getMessage();
		} catch (Exception ex) {
			ex.getMessage();
		}
	} 
////////////////////////////////////////////////////////////////////////////////
	/**
	 * Método para calcular la nota media global de todas las asignaturas de un alumno
	 */
	public void calcularMediaGlobal() {
		try {
			String id = pedirString("Ingrese el Id del alumno");
			if (buscarUsuario(id) < 0) {
				throw new UsuarioNoExistenteException("El alumno no existe");
			}
			double notas = 0;
			int contador = 0;
			for (Map.Entry<NombreClase, ArrayList<Double>> asignatura : alumnos.get(buscarAlumno(id)).getAsignaturas().entrySet()) {
				for (Double nota : asignatura.getValue()) {
					if (nota >= 0 && nota <= 10) {
						notas+=nota;
						contador++;
					}
				}
			}
			System.out.println("La nota global del alumno " + alumnos.get(buscarAlumno(id)).getNombre() + " es: " + (notas/contador));
		} catch (UsuarioNoExistenteException u) {
			u.getMessage();
		}
	}
////////////////////////////////////////////////////////////////////////////////
	/**
	 * Método para mostrar el menú principal
	 */
	public void menu() {
		System.out.println("""
				 1. Añadir alumno
				 2. Eliminar alumno
				 3. Añadir profesor
				 4. Eliminar profesor
				 5. Mostrar usuarios
				 6. Introducir notas
				 7. Mostrar mejor alumno
				 8. Mostrar cursos
				 9. Crear Asignatura
				10. Eliminar Asignatura
				11. Salir
				""");
	}
////////////////////////////////////////////////////////////////////////////////
	/**
	 * Método principal para que funcione la aplicación
	 */
	public void aplicacion() {
		boolean salir = false;
		do {
			menu();
			int opcion = validarEntrada("Ingrese una opcion");
			switch(opcion) {
			case 1:
				añadirAlumno();
				break;
			case 2:
				eliminarAlumno();
				break;
			case 3: 
				añadirProfesor();
				break;
			case 4:
				eliminarProfesor();
				break;
			case 5:
				mostrarUsuarios();
				break;
			case 6:
				introducirNotasEnMatriz();
				break;
			case 7:
				mostrarMejorAlumno();
				break;
			case 8:
				mostrarCursos();
				break;
			case 9:
				crearClase();
				break;
			case 10:
				eliminarClase();
				break;
			case 11:
				salir = true;
				break;
			}
		} while (!salir);
	}
////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		Prueba prueba = new Prueba();
		prueba.aplicacion();
	}
}