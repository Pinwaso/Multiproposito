/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.william;

/**
 *
 * @author Diurno
 */
public class SincronizacionContador {
    
    private int valor = 300;
    
    public static void main(String[] args) {
        SincronizacionContador contador = new SincronizacionContador();
        sincronizacionHiloIncrementar hilo1 = new sincronizacionHiloIncrementar(contador);
        sincronizacionHiloDecrementar hilo2 = new sincronizacionHiloDecrementar(contador);
        
        hilo1.start();
        hilo2.start();
    }
    
    public void incrementar() {
        valor++;
    }
    
    public void decrementar() {
        valor--;
    }
    
    public int getValor() {
        return valor;
    }
    
    static class sincronizacionHiloIncrementar extends Thread {
        
        SincronizacionContador contador;
        public sincronizacionHiloIncrementar(SincronizacionContador contador) {
            this.contador = contador;
        }
        
        public void run() {
            synchronized(contador) {
                for (int i = 0;i <= 500; i++) {
                    contador.incrementar();
                }
                System.out.println(getName() + " contador vale " + contador.getValor());
           }
        }
    }
    static class sincronizacionHiloDecrementar extends Thread {
        
        SincronizacionContador contador;
        public sincronizacionHiloDecrementar(SincronizacionContador contador) {
            this.contador = contador;
        }
        
        public void run() {
            synchronized(contador) {
                for (int i = 0;i <= 500; i++) {
                    contador.decrementar();
                }
                System.out.println(getName() + " contador vale " + contador.getValor());
            }
        }
    }
}
