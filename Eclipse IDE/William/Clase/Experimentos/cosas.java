package Clase.Experimentos;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class cosas {

	public static BlockingQueue<String> queueCustomers = new ArrayBlockingQueue<>(100);
	
	private class Cadena implements Comparable<Cadena>{
		private String valor;
		public Cadena(String valor) {
			this.valor=valor;
		}
		public String getValor() {
			return this.valor;
		}
		@Override
		public int compareTo(Cadena o) {
			int comparacion = this.valor.compareTo(o.getValor());
			return comparacion * -1;
		}
	}
	
	private static class ordenar implements Comparator<Cadena>{
		@Override
		public int compare(Cadena o1, Cadena o2) {
			int comparacion = o1.getValor().compareTo(o2.getValor());
			return comparacion * -1;
		}
	}
	
	public void crear() {
		queueCustomers.offer("Kathe");
		try {
			String nextCustomer = queueCustomers.take();
			System.out.println("texto de ejemplo");
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
	
	public static void main(String[] args) {
		/*TreeMap<Cadena, Integer> lista = new TreeMap<>(new ordenar());*/
		cosas a = new cosas();
		a.crear();
		a.crear();
	}
}