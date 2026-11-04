/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.william;

/**
 *
 * @author Diurno
 */
public class KeyCola {

    private char caracter;
    private boolean disponible = false;//inicialmente cola vacia

    public synchronized char get() {
    	  while (!disponible) {
    	    try {
                  // DUERME EL HILO QUE HA LLAMADO AL MÉTODO (EN ESTE CASO EL CONSUMER)
    	          wait();
    	    } catch (InterruptedException e) { }
    	  }
          
    	  //Indica que ya no hay elemento disponible
    	  disponible = false;
          //Despierta al hilo dormido
    	  notifyAll();
          //Saca el valor de la cola
    	  return caracter;
    	}

    public synchronized void put(char valor) {
    	  while (disponible){
    	    try {
                // DUERME EL HILO QUE HA LLAMADO AL MÉTODO (EN ESTE CASO EL PRODUCER)
    	          wait();
    	    } catch (InterruptedException e) { }
    	  }
          //mete el elemento en la cola
    	  caracter = valor;
          //Indica que hay un elemento disponible
    	  disponible = true;
    	  //Despierta el hilo dormido
    	  notifyAll();
    	}
}
