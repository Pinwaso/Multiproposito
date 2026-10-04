package Clase.Clase;

import java.util.ArrayList;
import java.util.Iterator;

//set sobrecargarlo con double, float, string
public class Televisor {
	private int canal;
	private int volumen;

	public Televisor() {
		canal = 1;
		volumen = 5;
	}
	public Televisor(int valorCanal) {
		setCanal(valorCanal);
	}
	public Televisor(float valorCanal) {
		setCanal(valorCanal);
	}
	public Televisor(double valorCanal) {
		setCanal(valorCanal);
	}
	public Televisor(String valorCanal) {
		setCanal(valorCanal);
	}
	public void subirCanal() {
		setCanal(canal + 1);
	}
	public void bajarCanal() {
		setCanal(canal - 1);
	}
	public int getCanal() {
		return this.canal;
	}
	public void subirVolumen() {
		setVolumen(volumen + 1);
	}
	public void bajarVolumen() {
		setVolumen(volumen - 1);
	}
	public int getVolumen() {
		return volumen;
	}
	public void setVolumen(int valor) {
		if (valor >= 0 && valor <= 100) {
			System.out.println("Cambiar Volumen: " + this);
			this.volumen = valor;
		}
	}
	public void setCanal(int valor) {
		if (valor < 1 || valor >= 100)
			this.canal = 1;
		else
			System.out.println("Cambiar Canal: " + this);
			this.canal = valor;
	}
	public void setCanal(float valor) {
		int valorCanal = (int) valor;
		if (valorCanal < 1 || valorCanal >= 100)
			this.canal = 1;
		else
			System.out.println("Cambiar Canal: " + this);
			this.canal = valorCanal;
	}
	public void setCanal(double valor) {
		int valorCanal = (int) valor;
		if (valorCanal < 1 || valorCanal >= 100)
			this.canal = 1;
		else
			System.out.println("Cambiar Canal: " + this);
			this.canal = valorCanal;
	}
	public void setCanal(String valor) {
		int valorCanal = Integer.valueOf(valor);
		if (valorCanal < 1 || valorCanal >= 100)
			this.canal = 1;
		else
			System.out.println("Cambiar Canal: " + this);
			this.canal = valorCanal;
	}  
	@Override
	public String toString() {
		return "Televisor [canal = " + canal + " volumen = " + volumen + "]";
	}
	public static void main(String[] args) {
		Televisor tv = new Televisor();
		tv.bajarVolumen();
		tv.subirCanal();
		
		ArrayList<String> listaPaises = new ArrayList<>();
		listaPaises.add("España");
		listaPaises.add("Francia");
		listaPaises.add("Portugal");
		listaPaises.add("Inglaterra");
		listaPaises.add("Holanda");
		listaPaises.add("Grecia");
		listaPaises.add("Andorra");
		listaPaises.add("China");
		listaPaises.add("Croacia");
		listaPaises.add("Rusia");
		listaPaises.add("Haiti");
		listaPaises.add("Bolivia");
		listaPaises.add("Mongolia");
		listaPaises.add("Santa Lucia");
		listaPaises.add("Paraguay");
		listaPaises.add("Peru");
		for(int i = 0; i < listaPaises.size(); i++) {
			 System.out.println(listaPaises.get(i));
		}
		for (String s : listaPaises) {
			 System.out.println(s);
		}
		System.out.println(listaPaises.toString());
		Iterator<String> iter = listaPaises.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}	
}