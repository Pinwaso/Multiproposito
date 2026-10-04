package Clase.Ejemplos;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Vector;

public class Cuenta {
	private long numero;
	private Cliente titular;
	private float saldo, interesAnual;
	private LinkedList movimientos; // Lista de movimientos


	class Movimiento {
		Date fecha;
		char tipo;
		float importe, saldoMov;

		public Movimiento (Date aFecha, char aTipo, float aImporte) {
			fecha = aFecha;
			tipo = aTipo;
			importe = aImporte;
			saldoMov = saldo; // Copiamos el saldo actual
		}
		public Movimiento (Date aFecha, char aTipo, float aImporte,float aSaldo) {
			fecha = aFecha;
			tipo = aTipo;
			importe = aImporte;
			saldoMov = aSaldo; // Copiamos el saldo actual
		}
	}
    
	public Cuenta (long aNumero, Cliente aTitular, float aInteresAnual) {
		numero = aNumero;
		titular = aTitular;
		saldo = 0;
		interesAnual = aInteresAnual;	
		movimientos=new LinkedList<Movimiento>();
	}
	
	Cliente leerTitular() { return titular; }

	public void ingreso (float cantidad) {
		movimientos.add(new Movimiento (new Date(), 'I', cantidad, saldo += cantidad)); }
	
	public void reintegro (float cantidad) { movimientos.add
		(new Movimiento (new Date(), 'R', cantidad, saldo -=cantidad));	}
	
	public void ingresoIntereses () { ingreso (interesAnual * saldo / 1200); }

	public static void main (String[] a) {
		
	}
}