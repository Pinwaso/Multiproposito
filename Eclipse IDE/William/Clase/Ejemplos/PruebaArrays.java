package Clase.Ejemplos;

public class PruebaArrays {

	static String[] cadenaMasLarga(String[] lista) {
		int largo=-1;
		int repeticiones=0;
		for (int i=0;i<lista.length;i++) {
			if (lista[i]!=null && lista[i].length()>largo) {
				largo=lista[i].length();
				repeticiones=1;
			}else if (lista[i]!=null && lista[i].length()==largo) {
				repeticiones++;
			}
		}
		if (repeticiones==0) {
			String[] dev=null;
			return dev;
		}else {
		    int apariciones=0;
			String[] resultado=new String[repeticiones];
			for (int i=0;i<lista.length;i++) {
				if (lista[i]!=null && lista[i].length()==largo) {
					resultado[apariciones++]=lista[i];					
				}
				if (apariciones==repeticiones) {
					break;
				}
				
			} 
			return resultado;
		}
	}
	
	public static void main(String[] args) {
		String[] cad={"alvaro","alvara",null,"panaaaaaa",""};
		String[] cad1=cadenaMasLarga(cad);
		for (int i=0;i<cad1.length;i++) {
			System.out.println(cad1[i]);
		}
		
	/*
	 * 	
	 
		int[] pepe= {0,2,3};
		Object[] luis= new Object[3];
		luis[0]=0;
		luis[1]=2;
		luis[2]="alvaro";
		char[][] nombres=new char[3][5];
		char[] nombre0= {'a','l'};
		nombres[0]=nombre0;
		char[] nombre1= {'a','l','v'};
		nombres[1]=nombre1;
		
		
		String[] alvaro= {"alvaro","juan"};
		
		for (int i=0;i<luis.length;i++) { 
		System.out.print(luis[i]+" ");
		}
		pepe[2]=5;
		for (int i=0;i<pepe.length;i++) { 
			System.out.print(pepe[i]+" ");
			}
		System.out.println("la longitud es:"+pepe.length);
*/
	}

}
