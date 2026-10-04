package Clase.Ficheros;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

public class clases {

	private class Colegio implements Serializable{
		private TreeMap<String, Grupo> grupos = new TreeMap<>();
		/**
		 * Constructor de Colegio
		 * @param grupo
		 */
		public void agregarGrupo(Grupo grupo) {
			if (!grupos.containsKey(grupo.getId())) {
				grupos.put(grupo.getId(), grupo);
				System.out.println("Grupo agregado exitosamente");
			} else {
				System.out.println("El grupo ya existe");
			}
		}
		/**
		 * Método para eliminar grupo
		 * @param id se pasa el id del grupo como String para eliminarla
		 */
		public void eliminarGrupo(String id) {
			if (grupos.containsKey(id)) {
				grupos.remove(id);
				System.out.println("Grupo eliminado exitosamente");
			} else {
				System.out.println("El grupo no existe");
			}
		}
		/**
		 * Método para obtener un grupo
		 * @param id se pasa el id del grupo como String para obtener el grupo
		 * @return devuelve el objeto Grupo
		 */
		public Grupo obtenerGrupo(String id) {
			if (grupos.containsKey(id)) {
				return grupos.get(id);
			} else {
				return null;
			}
		}
		/**
		 * Método para listar todos los grupos
		 */
		public void listarGrupos() {
			for (Map.Entry<String, Grupo> grupo : grupos.entrySet()) {
				System.out.println(grupo.getKey());
				grupo.getValue().listarAlumnos();
			}
		}
		/**
		 * Método para guardar los datos de Colegio (texto binario)
		 */
		public void guardarColegio() {
			try {
				File fichero = new File("binario.dat");
				if (!fichero.exists()) {
					fichero.createNewFile();
				}
				if (fichero.exists() && fichero.isFile()) {
					DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)));
					dos.writeInt(this.grupos.size());
					for (Map.Entry<String, Grupo> grupo : this.grupos.entrySet()) {
						Grupo g = grupo.getValue();
						dos.writeUTF(g.getId());
						dos.writeUTF(g.getNombre());
						dos.writeInt(g.getAlumnos().size());
						for (Alumno alumno : g.getAlumnos()) {
							dos.writeUTF(alumno.getNombre());
							dos.writeUTF(alumno.getApellido());
							dos.writeUTF(alumno.getMatricula());
							dos.writeFloat(alumno.getNota());
							dos.writeUTF(alumno.getFechaNacimiento().toString());
						}	
					}
					dos.close();
				}
			} catch (Exception ex) {
				ex.getCause();
			}	
		}
		/**
		 * Método para guardar todos los datos de Colegio (como objeto binario)
		 * @param col se le pasa el objeto Colegio para guardarlo
		 */
		public void guardarColegio(Colegio col) {
			try {
				File fichero = new File("objeto.dat");
				if (!fichero.exists()) {
					fichero.createNewFile();
				}
				if (fichero.exists() && fichero.isFile()) {
					ObjectOutputStream ou = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)));
					ou.writeObject(col);
					ou.flush();
					ou.close();
				} else {
					System.out.println("Algo salio mal");
				}
			} catch (Exception ex) {
				ex.getCause();
			}
		}
		/**
		 * Método para guardar los datos de Colegio (bases de datos)
		 * @param c se pasa el objeto Colegio que se lo quiere guardar
		 */
		public void guardarcolegio(Colegio c ) {
			String user = "root";
			String pwd = "";
			String url = "jdbc:mariadb://localhost/colegio";
			try {
				Connection conex = DriverManager.getConnection(url, user, pwd);
				for (Map.Entry<String, Grupo> grupo: c.getGrupos().entrySet()) {
					Grupo g = grupo.getValue();
					String query = "insert into grupos (id, nombre) values ('" + g.getId() + "', '" + g.getNombre() + "')";
					Statement state = conex.createStatement();
					state.executeUpdate(query);
					state = conex.createStatement();
					query = "insert into alumnos (nombre, apellido, matricula, nota, nacimiento, grupo) values ";
					for (Alumno alumno : g.getAlumnos()) {
						query+= "('" + alumno.getNombre() + "', '" + alumno.getApellido() + "', '" + alumno.getMatricula()
						+ "', " + alumno.getNota() + ", '" + alumno.getFechaNacimiento() + "', '" + g.getId() + "'),";
					}
					query = query.substring(0, query.length());
					state.executeUpdate(query);
				}
				conex.close();
			} catch (Exception ex) {
				ex.getCause();
			}
		}
		/**
		 * Método para cargar Colegio (texto binario)
		 * @return devuelve un objeto Colegio
		 */
		public Colegio cargarColegio() {
			Colegio c = new Colegio();
			try {
				File fichero = new File("binario.dat");
				if (!fichero.exists()) {
					fichero.createNewFile();
				}
				if (fichero.exists() && fichero.isFile()) {
					DataInputStream di = new DataInputStream(new BufferedInputStream(new FileInputStream(fichero)));
					for (int i = 0; i < di.readInt(); i++) {
						Grupo grupo = new Grupo(di.readUTF(), di.readUTF());
						for (int a = 0; a < di.readInt(); a++) {
							Alumno alumno = new Alumno(di.readUTF(), di.readUTF(), di.readUTF(), di.readFloat(), LocalDate.parse(di.readUTF()));
							grupo.agregarAlumno(alumno);
						}
						c.agregarGrupo(grupo);
					}
					di.close();
				}
			} catch (Exception ex) {
				ex.getCause();
			} finally {
				return c;
			}
		}
		/**
		 * Método para cargar Colegio (objeto binario)
		 * @return Devuelve un objeto colegio
		 */
		public Colegio cargarColegiobinario() {
			Colegio c = null;
			try {
				File fichero = new File("objeto.dat");	
				if (fichero.exists() && fichero.isFile()) {
					ObjectInputStream oi = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichero)));
					return c = (Colegio)oi.readObject();
				}
			} catch (Exception ex) {
				ex.getCause();
			} finally {
				return c;
			}
		}
		/**
		 * Método para cargar Colegio (bases de datos)
		 * @return Devuelve un objeto Colegio
		 */
		public Colegio cargarcolegio() {
			String user = "root";
			String pwd = "";
			String url = "jdbc:mariadb://localhost/colegio";
			Colegio c = new Colegio();
			try {
				Connection conex = DriverManager.getConnection(url, user, pwd);
				String query = "select * from grupos";
				Statement state = conex.createStatement();
				ResultSet resultado = state.executeQuery(query);
				while (resultado.next()) {
					Grupo g = new Grupo(resultado.getString("id"), resultado.getString("nombre"));
					query = "select * from alumnos where grupo = '" + resultado.getString("id") + "'";
					Statement estate = conex.createStatement();
					ResultSet salida = estate.executeQuery(query);
					while (salida.next()) {
						Alumno a = new Alumno(salida.getString("nombre"), salida.getString("apellido"), 
						salida.getString("matricula"), salida.getFloat("nota"), LocalDate.parse(salida.getString("nacimiento")));
						g.agregarAlumno(a);
					}
					c.agregarGrupo(g);
				}
				conex.close();
			} catch (Exception ex) {
				ex.getCause();
			} finally {
				return c;
			}
		}
		/**
		 * Método para obtener los grupos
		 * @return Devuelve un TreeMap con todos los grupos donde la clave es id del grupo como String y el valor un objeto Grupo
		 */
		public TreeMap<String, Grupo> getGrupos() {
			return grupos;
		}
		/**
		 * Método para establecer los grupos
		 * @param grupos Se pasa como parámetro un TreeSet donde la clave es String y el valor es un objeto Grupo
		 */
		public void setGrupos(TreeMap<String, Grupo> grupos) {
			this.grupos = grupos;
		}
	}
	
	private class Grupo implements Serializable{
		private String nombre, id;
		private TreeSet<Alumno> alumnos = new TreeSet<>();
		/**
		 * Constructor de grupo
		 * @param id se le pasa el id del grupo como String
		 * @param nombre se le pasa el nombre del grupo como String
		 */
		public Grupo(String id, String nombre) {
			this.setId(id);
			this.setNombre(nombre);
		}
		/**
		 * Método para agregar un alumno
		 * @param alumno Se le pasa un objeto Alumno para agregarlo al grupo
		 */
		public void agregarAlumno(Alumno alumno) {
			if (alumnos.add(alumno)) {
				System.out.println("Alumno agregado correctamente");
			} else {
				System.out.println("Error al agregar alumno");
			}
		}
		/**
		 * Método para eliminar un alumno
		 * @param alumno se le pasa un objeto Alumno para eliminarlo del grupo
		 */
		public void eliminarAlumno(Alumno alumno) {
			if (alumnos.remove(alumno)) {
				System.out.println("Alumno eliminado correctamente");
			} else {
				System.out.println("Error al eliminar alumno");
			}
		}
		/**
		 * Método para listar todos los alumnos
		 */
		public void listarAlumnos() {
			System.out.println("En total hay " + alumnos.size());
			for (Alumno alumno : alumnos) {
				System.out.println(alumno.toString());
			}
		}
		/**
		 * Método para obtener el id del grupo
		 * @return devuelve el id del grupo como String
		 */
		public String getId() {
			return id;
		}
		/**
		 * Método para establecer el id del grupo
		 * @param id Se le pasa el id del grupo como String
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Método para obtener el nombre del grupo
		 * @return Devuelve el nombre del grupo como String
		 */
		public String getNombre() {
			return nombre;
		}
		/**
		 * Método para establecer el nombre del grupo
		 * @param nombre Se le pasa el nombre del grupo como String
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		/**
		 * Método para obtener todos los alumnos del grupo
		 * @return Devuelve un TreeSet de todos los alumnos
		 */
		public TreeSet<Alumno> getAlumnos() {
			return alumnos;
		}
		/**
		 * Método para establecer todos los alumnos del grupo
		 * @param alumnos Se le pasa un TreeSet de alumnos como parámetro
		 */
		public void setAlumnos(TreeSet<Alumno> alumnos) {
			this.alumnos = alumnos;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(alumnos, id, nombre);
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Grupo other = (Grupo) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return Objects.equals(alumnos, other.alumnos) && id == other.id && Objects.equals(nombre, other.nombre);
		}
		private clases getEnclosingInstance() {
			return clases.this;
		}	
		
	}
	
	private class Alumno implements Comparable<Alumno>, Serializable{
		private String nombre, apellido, matricula;
		private float nota;
		private LocalDate fechaNacimiento;
		/**
		 * Cosntructor de Alumno
		 * @param nombre Se le pasa el nombre como String
		 * @param apellido Se le pasa el apellido como String
		 * @param matricula Se le pasa la matricula del alumno como String
		 * @param nota Se le pasa la nota del alumno como float
		 * @param nac se le pasa la fecha de nacimiento como LocalDate
		 */
		public Alumno(String nombre, String apellido, String matricula, float nota, LocalDate nac) {
			this.setMatricula(matricula);
			this.setNombre(nombre);
			this.setApellido(apellido);
			this.setNota(nota);
			this.setFechaNacimiento(nac);
		}
		/**
		 * Método para calcular la edad
		 * @return Devuelve un int con la edad del alumno
		 */
		public int calcularEdad() {
			LocalDate hoy = LocalDate.now();
			Period diferencia = Period.between(this.fechaNacimiento, hoy);
			return diferencia.getYears();
		}
		/**
		 * Método para obtener la fecha de nacimiento del alumno
		 * @return Devuelve la fecha de nacimiento del alumno como LocalDate
		 */
		public LocalDate getFechaNacimiento() {
			return fechaNacimiento;
		}
		/**
		 * Método para establecer la fecha de nacimiento del alumno
		 * @param fechaNacimiento Se le pasa la fecha de nacimiento como LocalDate
		 */
		public void setFechaNacimiento(LocalDate fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}
		/**
		 * Método para obtener el nombre del alumno
		 * @return Se obtiene el nombre del alumno como String
		 */
		public String getNombre() {
			return nombre;
		}
		/**
		 * Método para establecer el nombre del alumno
		 * @param nombre Se le pasa el nombre del alumno como String
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		/**
		 * Método para obtener el apellido del alumno
		 * @return Se obtiene el apellido del alumno como String
		 */
		public String getApellido() {
			return apellido;
		}
		/**
		 * Método para establecer el apellido del alumno
		 * @param apellido Se le pasa el apellido del alumno como String
		 */
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		/**
		 * Método para obtener la matriula del alumno
		 * @return Devuelve la matricula del alumno como String
		 */
		public String getMatricula() {
			return matricula;
		}
		/**
		 * Método para establecer la matricula del alumno
		 * @param matricula Se le pasa la matricula del alumno como String
		 */
		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}
		/**
		 * Método para obtener la nota del alumno
		 * @return Devuelve la nota del alumno como float
		 */
		public float getNota() {
			return nota;
		}
		/**
		 * Método para establecer la nota del alumno
		 * @param nota Se le pasa la nota del alumno como float
		 */
		public void setNota(float nota) {
			this.nota = nota;
		}

		@Override
		public String toString() {
			return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", matricula=" + matricula + ", nota=" + nota
					+ "]";
		}

		@Override
		public int compareTo(Alumno o) {
			int comparacion = this.apellido.compareTo(o.getApellido());
			if (comparacion == 0) {
				comparacion = this.nombre.compareTo(o.getNombre());
			}
			if (comparacion == 0) {
				comparacion = this.matricula.compareTo(o.getMatricula());
			}
			return comparacion;
		}
	}
	
	public static void main(String[] args) {
	
	}
}