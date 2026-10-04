package Clase.Clase;

import java.util.Scanner;

// Crear un menú con 5 opciones, una por cada tipo de figura, y una opción para salir. 
// Se deberá elegir una opción y realizar la acción correspondiente. El programa no 
// terminará hasta que seleccionemos la opción SALIR del menú principal.
public class metodo_menu {
	
	static void rectangulo(int base, int altura) {
		String salida = "";
		for (int i = 1; i <= altura; i++) {
			for (int x = 1; x <= base; x++) {
				salida += ("*");
			}
			System.out.println(salida);
			salida = "";
		}
	}
	
	static void cuadrado(int altura) {
		String salida = "";
		for (int i = 1; i <= altura; i++) {
			for (int x = 1; x <= altura; x++) {
				salida += ("*");
			}
			System.out.println(salida);
			salida = "";
		}
	}
	
	static void triangulo(int altura) {
		
	}
	
	static void pedir1parametro(int parametro) {
		
	}
	
	static void pedir2parametro(int parametro1, int parametro2) {
		
	}

	public static void main(String[] args) {
		boolean correcto = false;
		int opcion = 0;
		do {
			try {
				System.out.println("""
				*************************
				[menu para crear figuras]
				1 cuadrado				 
				2 rectangulo			 
				3 triangulo
				4 salir			     
				*************************
				""");
				Scanner entrada = new Scanner(System.in);
				opcion = entrada.nextInt();
		
				correcto = true;
			} catch (Exception ex){
				System.out.println("Opción inválida");
			}
		} while (!correcto);
		
		switch (opcion) {
		case 1:
			correcto = false;
			int base;
			do {
				try {
					System.out.println("ingrese base y altura del rectángulo");
					Scanner entrada = new Scanner(System.in);
					base = entrada.nextInt();
					correcto = true;
				} catch (Exception ex) {
				}
			} while (!correcto);
			
			
			break;
		case 2: 
			
			break;
		case 3: 
			
			break;
		case 4:
			break;
	}
	}
}