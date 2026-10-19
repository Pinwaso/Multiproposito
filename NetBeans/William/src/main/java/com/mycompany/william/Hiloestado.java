/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.william;

import static java.lang.Thread.sleep;

/**
 *
 * @author Diurno
 */
public class Hiloestado {
    public static void main(String[] args) {
        //creacion del hilo1
        Hilo3 hilo1 = new Hilo3();
        Hilo3 hilo2 = new Hilo3();
        Hilo3 hilo3 = new Hilo3();
        Hilo3 hilo4 = new Hilo3();
        
        hilo1.setPriority(1);
        hilo2.setPriority(3);
        hilo3.setPriority(5);
        
        //ejecucion del hilo1
        hilo1.start();
        
        try {
            sleep(9000);
            hilo1.setStop();
            hilo2.setStop();
            hilo3.setStop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("hilo1: " + hilo1.getContador());
        System.out.println("hilo2: " + hilo2.getContador());
        System.out.println("hilo3: " + hilo3.getContador());
    }
}

class Hilo3 extends Thread {
    
    //atributos
    private boolean stop = false;
    private int i = 0;
    
    //metodo principal
    public void run() {
            do {
                //System.out.println("hilo1, contador " + i);
                try {
                    i++;
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (!stop);
    }
    
    //metodo para parar el hilo1
    public void setStop() {
        stop = true;
    }
    
    //metodo para obtener el contador
    public int getContador() {
        return i;
    }
}