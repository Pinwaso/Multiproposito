package Clase.Ejemplos;

public class ConvertirNumeroABinario {

	public static String convertirNumero(int numero) {
		if ((numero / 2)!=0) {
			return convertirNumero(numero/2)+ (numero%2);
		}else {
			return String.valueOf(numero%2);
		}		
	}
	
	
	public static void main(String[] args) {
		System.out.println
		("el numero 34 en binario es: "+convertirNumero(34));
	}

}
