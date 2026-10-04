package Clase.Ejemplos;

import java.util.ArrayList;

public class ArrayListInteger {
	public static void main(String[] args) {
		ArrayList<Integer> listaNumeros=new ArrayList<>();
		int numeroMaximo=50;
		int numeroMinimo=10;
		int tamano=(int)(Math.random()*(numeroMaximo-numeroMinimo+1)+numeroMinimo);
		for (int indice=0;indice<tamano;indice++) {
			numeroMaximo=1000;
			numeroMinimo=0;
			int numero=(int)(Math.random()*(numeroMaximo-numeroMinimo+1)+numeroMinimo);
			listaNumeros.add(numero);
		}
		System.out.println(listaNumeros);
	}
}