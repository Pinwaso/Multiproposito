/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.william;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diurno
 */
public class Contador {
    public static void main(String[] args){
        int delay = Integer.parseInt(args[0]);
        int cantidad = Integer.parseInt(args[1]);
        for (int i = 0; i <= cantidad; i++) {
            System.out.println("Contador: " + i);
            try {
                sleep(delay);
            } catch (InterruptedException ex) {
                Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
