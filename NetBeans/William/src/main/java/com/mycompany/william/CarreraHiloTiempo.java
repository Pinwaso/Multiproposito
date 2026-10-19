/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.william;

/**
 *
 * @author Diurno
 */
public class CarreraHiloTiempo extends Thread {
    
    private boolean waitVal = false;
    private int segundos = 0;
    private int minutos = 0;
    private javax.swing.JLabel pantalla;
    
    public CarreraHiloTiempo(javax.swing.JLabel etiqueta) {
        this.pantalla = etiqueta;
    }
    
    public void run() {
        
        while (true) {
            try {
                sleep(1000);
                segundos++;
                if (segundos == 60) {
                    minutos++;
                    segundos = 0;
                }
                pantalla.setText("Tiempo: " + minutos + ":" + segundos);
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
