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
    
    public void run() {
        
        
        
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
    
    public void pausaHilo(){
        waitVal=true;
    }
    
    public void reanudaHilo(){
        synchronized(this){
            notifyAll();
        }
    }
}
