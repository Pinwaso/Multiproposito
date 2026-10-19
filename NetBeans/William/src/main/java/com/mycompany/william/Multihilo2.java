/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.william;

/**
 *
 * @author Diurno
 */
public class Multihilo2 {
    public static void main(String[] args) {
        Hilo3[] hilos = new Hilo3[4];
        //creacion y visualizacion de datos
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Hilo3();
            System.out.println(hilos[i].toString());
            hilos[i].setName("Hilo " + i);
            hilos[i].setPriority(i+3);
        }
        //ejecucicón de hilos
        for (int i = 0; i < hilos.length; i++) {
            hilos[i].run();
        }
    }
}

class Hilo extends Thread {
 
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Escribiendo la linea desde el Hilo");
        }
    }
}
