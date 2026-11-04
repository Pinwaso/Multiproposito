/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.william;

/**
 *
 * @author Diurno
 */

public class KeyConsumer extends Thread{
     
    KeyCola cola;
    KeyFrame pantalla;
    char caracterLeido;
    
    public KeyConsumer(KeyCola cola, KeyFrame pantalla){
        this.cola = cola;
        this.pantalla = pantalla;
    }
    
    public void run(){
        
        while(true){
            caracterLeido=cola.get();
            pantalla.actualizarInfo(caracterLeido);
            System.out.println("Recibido caracter: "+caracterLeido);           
        }
    }
}
