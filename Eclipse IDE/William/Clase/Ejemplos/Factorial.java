package Clase.Ejemplos;

public class Factorial {

   static double factorial(int n) {
	   System.out.println("estamos en n="+n);
	   if(n == 0) return 1;//caso base		
		else {		
			return n*factorial(n-1);//caso general
		}
	}
	
	
	public static void main(String[] args) {
		 System.out.println("el resultado de 5214 es "+factorial(100
				 ));

	}

}
/**
 * package segundo;

public class Factorial {

   static byte factorial(byte n) {
	   System.out.println("estamos en n="+n);
	   if(n == 0) return 1;//caso base		
		else {		
			return (byte)(n*factorial((byte) (n-1)));//caso general
		}
	}
	
	
	public static void main(String[] args) {
		 System.out.println("el resultado de -1! es "+factorial((byte)-1));

	}

}

 */
 
