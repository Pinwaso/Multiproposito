/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.william;

/**
 *
 * @author Diurno
 */
public class CarreraHiloCorredor extends Thread {
    
    private boolean waitVal = false;
    private javax.swing.JLabel pantalla;
    private int meta = 800;
    private String nombre;
    private CarreraGUI juego;
    
    public CarreraHiloCorredor(javax.swing.JLabel etiqueta, String nombre, CarreraGUI juego) {
        this.pantalla = etiqueta;
        this.nombre = nombre;
        this.juego = juego;
    }
    
    public void run() {
        int xActual = pantalla.getX();
        int yActual = pantalla.getY();
        while (xActual + pantalla.getWidth() < meta) {
            try {
                sleep(50);
                int a = (int) (Math.random()*3) + 1;
                xActual = xActual + a;
                
                final int xNueva = xActual;
                final int yFija = yActual;
                
                java.awt.EventQueue.invokeLater(new Runnable() {
                   @Override
                   public void run() {
                       pantalla.setLocation(xNueva, yFija);
                   }
                });
                
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            if (waitVal){
                waitVal=false;
                //Inicio de bloque Monitor con Synchronized
                synchronized(this){
                    try{
                        this.wait();    //duerme el hilo hasta recibir notify()
                    }catch(InterruptedException e){}
                }//fin del bloque synchronized
            }
        }
        juego.reportarganador(nombre);
    }
    
    public void pausaHilo(){
        waitVal=true;
    }
    
    public void reanudaHilo(){
        synchronized(this){
            notifyAll();
        }
    }
}
