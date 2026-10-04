package Clase.Aplicaciones.CuentaBancaria;

import java.util.Date;
import java.util.LinkedList;

public class cuenta {
	private long numero;
	private cliente titular;
	private double saldo, interesAnual;
	private String tipo;
	private LinkedList <movimiento> movimientos = new LinkedList<>();
	
	public cuenta(long numero, String tipo, double saldo, double interesAnual, cliente titular) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.tipo = tipo;
		this.interesAnual = interesAnual;
	}
	
	private class movimiento {
		Date fecha;
		char tipo;
		double importe;
		
		public movimiento (Date fecha, char tipo, double importe) {
			this.fecha = fecha;
			this.tipo = tipo;
			this.importe = importe;
			saldo = saldo + importe;
		}
		@Override
		public String toString() {
			return "[Fecha= " + this.fecha + " tipo= " + this.tipo + " importe= " + this.importe + "]";
		}
	}
	
	public void movimiento (Date fecha, char tipo, double importe) {
		movimiento transaccion = new movimiento(fecha, tipo, importe);
		movimientos.add(transaccion);
	}

	@Override
	public String toString() {
		return "cuenta [numero=" + numero + ", tipo de cuenta=" + tipo + ", titular=" + titular + ", saldo=" + saldo + ", interesAnual="
				+ interesAnual + ", movimientos=" + movimientos + "]";
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public cliente getTitular() {
		return titular;
	}

	public void setTitular(cliente titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}

	public double getInteresAnual() {
		return interesAnual;
	}

	public void setInteresAnual(double interesAnual) {
		this.interesAnual = interesAnual;
	}

	public LinkedList<movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(LinkedList<movimiento> movimientos) {
		this.movimientos = movimientos;
	}
}