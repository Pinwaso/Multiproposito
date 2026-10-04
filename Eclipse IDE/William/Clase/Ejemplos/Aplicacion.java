package Clase.Ejemplos;

import java.util.Vector;

public class Aplicacion {
	Cuenta cActiva;
	Cliente[] clientes;
	Vector<Cuenta> cuentas;
	
	public Aplicacion() {
		clientes=new Cliente[5];
		cuentas=new Vector<Cuenta>(10);
		int numeroCuenta=3;
		for (int i=0;i<10;i++) {
			Cuenta cuenta=new Cuenta(numeroCuenta++, (Cliente)null,1);
			cuentas.add(cuenta);
		}
		cActiva=cuentas.get(0);
	}
	
    public static void main(String ar) {
    	
    }
}
