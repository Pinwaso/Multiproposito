/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.william;

/**
 *
 * @author Diurno
 */
public class MultiHilo {
    public static void main(String[] args) {
        Hilo2 hs1 = new Hilo2(1);
        hs1.start();
        Hilo2 hs2 = new Hilo2(2);
        hs2.start();
        Hilo2 hs3 = new Hilo2(3);
        hs3.start();
        Hilo2 hs4 = new Hilo2(4);
        hs4.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("Escribiendo linea desde Principal");
        }
    }
}

class Hilo2 extends Thread {
    private int numero;
            
    public Hilo2(int numero) {
        this.numero = numero;
    }
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Escribiendo la linea desde el Hilo " + numero);
        }
    }
}