package Clase.Ejemplos;

import java.util.Arrays;

public class Tablero {
    static int nFilas=6;
    static int nColumnas=6;
    static char[][] tablero;
    
	static void inicializarTablero(){
		tablero=new char[nFilas][nColumnas];
	}
	
	static void mostrarTablero() {
		for (char[] fila: tablero) {
			System.out.println(Arrays.toString(fila));
		}
	}
	
	static boolean comprobarPalabra(char[] palabra, char[] parteTablero) {		
		if (palabra.length!=parteTablero.length) {
			return false;
		}else {
			boolean resultado=true;
			for (int i=0; i<palabra.length;i++) {
				if (parteTablero[i]!=0 && parteTablero[i]!=palabra[i]) {
					resultado=false;
					break;					
				}
			}
			return resultado;
		}		
	}
	
	static int isPalabraTablero(char[] palabra) {
		//comprobar en horizontal
		int entra=0;
		for (int x=0;x<nFilas;x++) {
			for (int y=0;y<nColumnas-palabra.length;y++) {
				 if (isCorrectoHorizontal(palabra,x,y)) {
					 entra=1;
					 break; 
				 }
			}
		}
		//comprobar en vertical		
		for (int x=0;x<nFilas-palabra.length;x++) {
			for (int y=0;y<nColumnas;y++) {
				 if (isCorrectoVertical(palabra,x,y)) {
					 entra+=2;
					 break; 
				 }
			}
		}
		return entra;
	}

	//Insertar la palabra en la posicion del tablero. 
	public static void colocarPalabra(char[] palabra, int fila, int columna) {
		
	}
	//Comprobar si para la fila y columna entra la palabra.
	public static boolean isCorrectoHorizontal(char[] palabra, int fila, int columna) {
			char[] palabraTablero= new char[palabra.length];
			for (int z=0;z<palabra.length;z++) {
				palabraTablero[z]=tablero[fila+z][columna];
			}				
			return comprobarPalabra(palabra,palabraTablero);			
	}	
	
	public static boolean isCorrectoVertical(char[] palabra, int fila, int columna) {
		char[] palabraTablero= new char[palabra.length];
		for (int z=0;z<palabra.length;z++) {
			palabraTablero[z]=tablero[fila][columna+z];
		}				
		return comprobarPalabra(palabra,palabraTablero);			
}
	
	
	public static boolean colocarPalabraHorizontal(char[] palabra) {
		int fila=0;
		int columna=0;
		boolean correcto=false;
		do {
			// Inicializar fila columna con un ramdon valido
			fila=(int)(Math.random()*nFilas);
			columna=(int)(Math.random()*(nColumnas-palabra.length));
			correcto=isCorrectoHorizontal(palabra,fila,columna);
		}while (!correcto);
			colocarPalabra(palabra,fila,columna);
		    return correcto;
	}
	public static boolean colocarPalabra(char[] palabra) {
		int posicion= isPalabraTablero(palabra);
		if (posicion==0) {
			return false;
		}else if (posicion==3) {
			posicion=(int)(Math.random()*2+1);
		}
		//Colocar palabra en el tablero en horizontal
		if (posicion==1) {
			return colocarPalabraHorizontal(palabra);
		}else {
		//Colocar palabra en el tablero en vertical
			
		}
		return false;
		
		
		
	}
	
	
	public static void main(String[] args) {
		inicializarTablero();
		
	    char[] palabra3= {'p','e','r','r','o'};
	   // System.out.println("entra perro1 "+isPalabraTablero(palabra3));
		tablero[0][3]='Z';
		tablero[1][3]='Z';
		tablero[2][3]='Z';
		tablero[3][3]='Z';
		tablero[4][3]='Z';
		tablero[5][3]='Z';
		mostrarTablero();
		
	    System.out.println("entra perro2 "+isPalabraTablero(palabra3));
	    tablero[0][3]=0;
		tablero[1][3]=0;
		tablero[2][3]=0;
		tablero[3][3]=0;
		tablero[4][3]=0;
		tablero[5][3]=0;
		
		tablero[3][0]='Z';
		tablero[3][1]='Z';
		tablero[3][2]='Z';
		tablero[3][3]='Z';
		tablero[3][4]='Z';
		tablero[3][5]='Z';
		
		mostrarTablero();		
	    System.out.println("entra perro3 "+isPalabraTablero(palabra3));
	    tablero[0][3]='Z';
		tablero[1][3]='Z';
		tablero[2][3]='Z';
		tablero[3][3]='Z';
		tablero[4][3]='Z';
		tablero[5][3]='Z';
		mostrarTablero();		
	    System.out.println("entra perro3 "+isPalabraTablero(palabra3));
	    
	}

}
