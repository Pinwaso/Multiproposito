package Clase.Ejemplos;

public class ContarDigitos {

	private static boolean esBinario(int num) {
	
		
		
		
		
		if (num>0){
			return true;
		}else if ((num % 10)==1 ||(num % 10)==0) {
		//}else if ((num % 10)<2) {
			return esBinario(num % 10);						
		}else {
			return false;
		}
	}
	
	private static void invertir(int num) {
		if (num>0) {
			System.out.print (num % 10);
			invertir (num/10);			
		}
	}
	private static int invertir1(int num) {
		if (num>=9) {
			int resto=(num % 10);
		    int cociente =invertir1(num/10);
		    
		    
            return (((invertir1(num/10))*10)+(num % 10));			
		}else {
			return num;
		}
	}
	
	
	private static int calcularDigitos(int num) {
		if (num > 0 ) {
			return calcularDigitos(num/10)+1;
		}else {
			return 0;
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println( invertir1(8423));
		System.out.println();
		System.out.println ("el 5678 tiene "+calcularDigitos(5678)+" digitos");

	}

}
