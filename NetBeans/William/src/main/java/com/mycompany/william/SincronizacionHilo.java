/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.william;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Diurno
 */
public class SincronizacionHilo {
    
    private boolean lleno = false;
    private final Queue<String> cola = new ConcurrentLinkedQueue<>();
    
    public static void main(String[] args) {
        SincronizacionHilo intermediario = new SincronizacionHilo();
        hiloconsumidor consumidor = new hiloconsumidor(intermediario);
        hiloproveedor proveedor = new hiloproveedor(intermediario);
        
        proveedor.start();
        consumidor.start();
    }
    
    public void put(String dato) {
        cola.add(dato);
    }
    
    public String get() {
        return cola.poll();
    }
    
    static class hiloconsumidor extends Thread {
        private SincronizacionHilo intermediario;
        
        public hiloconsumidor(SincronizacionHilo intermediario) {
            this.intermediario = intermediario;
        }
        
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(getName() + " Consumio el dato " + intermediario.get());
            }
        }
    }
    
    static class hiloproveedor extends Thread {
        private SincronizacionHilo intermediario;
        
        public hiloproveedor(SincronizacionHilo intermediario) {
            this.intermediario = intermediario;
        }
        
        public void run() {
            for (int i = 1; i <= 5; i++) {
                intermediario.put(String.valueOf(i));
                System.out.println(getName() + " Produjo el dato " + i);
            }
        }
    }
}
