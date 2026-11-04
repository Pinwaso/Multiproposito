/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.william;

/**
 *
 * @author Diurno
 */
public class KeyProducer extends Thread {
    KeyCola cola;
    private boolean hayCaracter = false;
    private char caracterProducido;
    
    public KeyProducer(KeyCola cola) {
        this.cola = cola;
    }
    
    public void run() {
        while (true) {
            char caracter;
            synchronized(this) {
                while(!hayCaracter) {
                     try {
                        wait(); // espera a que llegue una tecla
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                caracter = caracterProducido;
                hayCaracter = false;
            }
            cola.put(caracterProducido);
        }
    }
    
    // Se llama desde el EDT cuando se pulsa una tecla
    public synchronized void obtenerCaracter(char caracter) {
        this.caracterProducido = caracter;
        this.hayCaracter = true;
        notifyAll();
    }
}
