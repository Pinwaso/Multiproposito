package Clase.Ejemplos;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ejemploParametrosMultiples {
	static void mostrarEnteros(String... nums) {
		System.out.print("Hay " + nums.length + " enteros: ");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {		
		int[] cadena1= {1,4,8,68,8};
		int cadena2[]= {6,8,9};
		int resultado[]=new int[cadena1.length+cadena2.length];
		System.arraycopy(cadena1, 0, resultado, 0,cadena1.length);
		System.out.println(Arrays.toString(resultado));
		System.arraycopy(cadena2, 0, resultado,cadena1.length,cadena2.length);
        System.out.println(Arrays.toString(resultado));
        Arrays.sort(resultado);
        System.out.println(Arrays.toString(resultado));
	}
}