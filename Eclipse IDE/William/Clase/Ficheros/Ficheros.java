package Clase.Ficheros;

import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ficheros {

	public static void ejer1(String directorio) {
		File dir = new File(directorio);
		if (dir.exists()) {
			if (dir.isDirectory()) {
				String[] archivos = dir.list();
				if (archivos != null) {
					System.out.println("Archivos de texto encontrado en el directorio " + directorio);
					for (String archivo : archivos) {
						if (archivo.matches(".*\\.txt$")) {
							System.out.println(archivo);
						}
					}
				} else {
					System.out.println("El directorio esta vacio");
				}
			} else {
				System.out.println("No es directorio");
			}
		} else {
			System.out.println("El directorio no existe");
		}
	}

	public static void ejer2(int cantidad, String directorio) {
		try {
			File dir = new File(directorio);
			int cant = cantidad;
			if (dir.isDirectory() && dir.exists()) {
				for (int i = 1; i <= cantidad; i++) {
					File archivo = new File(dir.getPath() + "\\nombre(" + i + ").txt");
					archivo.createNewFile();
					BufferedWriter bf = new BufferedWriter(new FileWriter(archivo));
					bf.write("Este es el fichero nombre(" + i + ").txt");
					bf.flush();
					bf.close();
				}
			} else {
				System.out.println("No es directorio o no existe");
			}
		} catch (Exception ex) {
			ex.getCause();
		}
	}

	public static void ejer3(String archivo, String palabra) {
		try {
			File fichero = new File(archivo);
			int encontradas = 0;
			if (fichero.exists() && fichero.isFile()) {
				Scanner sc = new Scanner(fichero);
				while (sc.hasNext()) {
					if (palabra.contains(sc.next())) {
						encontradas++;
					}
				}
				System.out.println(
						palabra + " se encontro " + (encontradas == 1 ? encontradas + " vez" : encontradas + " veces"));
			} else {
				System.out.println("El archivo no existe, es un directorio o no es de texto");
			}
		} catch (Exception ex) {
			ex.getCause();
		}
	}

	public static void ejer4(String archivo, String palabra) {
		try {
			File ficheroEntrada = new File(archivo + "\\.txt");

			if (ficheroEntrada.exists() && ficheroEntrada.isFile()) {
				File ficheroSalida = new File(archivo + "_2\\.txt");
				BufferedReader lectura = new BufferedReader(new FileReader(ficheroEntrada));
				Scanner sc = new Scanner(lectura);
				BufferedWriter escritura = new BufferedWriter(new FileWriter(ficheroSalida, true));
				while (sc.hasNextLine()) {
					String linea = sc.nextLine();
					while (linea.indexOf(palabra) > -1) {
						int posicion = linea.indexOf(palabra);
						String cadena1 = linea.substring(0, posicion);
						String cadena2 = linea.substring(posicion + palabra.length());
						linea = cadena1 + cadena2;
					}
					escritura.write(linea);
					escritura.newLine();
					escritura.flush();
				}
				escritura.close();
				sc.close();
			} else {
				System.out.println("El fichero es un directorio o no existe");
			}
		} catch (Exception ex) {
			ex.getCause();
		}
	}

	private void encriptar(String archivo, int desplazamiento) {
		try {
			File entrada = new File(archivo + "\\.txt");
			if (entrada.exists() && entrada.isFile()) {
				File salida = new File(archivo + "_encriptado\\.txt");
				FileReader lectura = new FileReader(entrada);
				FileWriter escritura = new FileWriter(salida);

				int caracter = 0;
				while ((caracter = lectura.read()) > -1) {
					caracter += desplazamiento;
					escritura.write(caracter);
				}
				lectura.close();
				escritura.close();
			} else {
				System.out.println("Es directorio o no existe");
			}
		} catch (Exception ex) {
			ex.getCause();
		}
	}

	private void desencriptar(String archivo, int desplazamiento) {
		try {
			File entrada = new File(archivo);
			if (entrada.exists() && entrada.isFile()) {
				File salida = new File(archivo + "_desencriptado\\.txt");
				FileReader lectura = new FileReader(entrada);
				FileWriter escritura = new FileWriter(salida);

				int caracter = 0;
				while ((caracter = lectura.read()) > -1) {
					caracter -= desplazamiento;
					escritura.write(caracter);
				}
				lectura.close();
				escritura.close();
			} else {
				System.out.println("Es directorio o no existe");
			}
		} catch (Exception ex) {
			ex.getCause();
		}
	}

	public static void ejer6(String archivo) {
		try {
			File fichero = new File(archivo);
			if (fichero.exists() && fichero.isFile()) {
				String mensaje = "";
				Scanner sc = new Scanner(new BufferedReader(new FileReader(fichero)));
				while (sc.hasNext()) {
					String palabra = sc.next();
					String mayus = String.valueOf(palabra.charAt(0)).toUpperCase();
					mensaje += mayus + palabra.substring(1) + " ";
				}
				sc.close();
				// Al abrirlo sin true, borra todos los datos anteriores
				BufferedWriter escritura = new BufferedWriter(new FileWriter(fichero));
				escritura.write(mensaje);
				escritura.flush();
				escritura.close();
			} else {
				System.out.println("El archivo no existe o es directorio");
			}
		} catch (Exception ex) {
			ex.getCause();
		}
	}

	public static void ejer7(String fich1, String fich2) {
		try {
			File ar1 = new File(fich1);
			File ar2 = new File(fich2);
			if (ar1.exists() && ar1.isFile() && ar2.exists() && ar2.isFile()) {
				Scanner sc1 = new Scanner(new BufferedReader(new FileReader(ar1)));
				Scanner sc2 = new Scanner(new BufferedReader(new FileReader(ar2)));
				BufferedWriter escritura = new BufferedWriter(new FileWriter(new File("salida.txt")));
				boolean listo1 = false;
				boolean listo2 = false;
				while (listo1 && listo2) {
					if (!listo1) {
						if (sc1.hasNext()) {
							escritura.write(sc1.next() + " ");
						} else {
							listo1 = true;
						}
					}
					if (!listo2) {
						if (sc2.hasNext()) {
							escritura.write(sc2.next() + " ");
						} else {
							listo2 = true;
						}
					}
				}
				escritura.flush();
				escritura.close();
			} else {
				System.out.println("El fichero 1 es directorio o no existe, el fichero 2 es directorio o no existe");
			}
		} catch (Exception ex) {
			ex.getCause();
		}
	}

	public static void ejer7(String[] archivos) {
		try {
			Scanner[] escaneres = new Scanner[archivos.length];
			BufferedWriter escritura = new BufferedWriter(new FileWriter(new File("salida.txt")));
			for (int i = 0; i < archivos.length; i++) {
				escaneres[i] = new Scanner(new BufferedReader(new FileReader(new File(archivos[i]))));
			}
			boolean listo = false;
			while (!listo) {
				int auxiliar = 0;
				for (int i = 0; i < escaneres.length; i++) {
					Scanner sc = escaneres[i];
					if (sc.hasNext()) {
						escritura.write(sc.next() + " ");
					} else {
						auxiliar++;
					}
					sc.close();
				}
				if (auxiliar == escaneres.length) {
					listo = true;
				}
				escritura.flush();
				escritura.close();
			}

		} catch (Exception ex) {
			ex.getCause();
		}
	}

	public static String mayuscula(String palabra) {
		String salida = "";
		int i = 0;
		for (; i < palabra.length();) {
			char caracter = palabra.charAt(i);
			if (String.valueOf(caracter).matches("\\")) {
				i += 2;
			} else if (String.valueOf(caracter).matches("[a-zA-Z]")) {
				salida += palabra.substring(0, i) + String.valueOf(caracter).toUpperCase() + palabra.substring(i + 1);
				break;
			} else {
				i++;
			}
		}
		return palabra;
	}

	public static void main(String[] args) {
		/*
		String fichero = "ejemplo.dat";
		String nombre = "PRG";
		int conv = 1;
		double nota = 7.8;
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(fichero));
			out.writeUTF(nombre);
			out.writeInt(conv);
			out.writeDouble(nota);
			out.close();

			DataInputStream in = new DataInputStream(new FileInputStream(fichero));
			System.out.println("Valor leído de nombre: " + in.readUTF());
			System.out.println("Valor leído de convocatoria: " + in.readInt());
			System.out.println("Valor leído de nota: " + in.readDouble());
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("No encontrado");
		} catch (IOException e) {
			System.out.println("Problemas al escribir");
		}
		*/
	}
}