/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.william;

import java.util.Scanner;

/**
 *
 * @author Diurno
 */
public class LanzadorHiloCronometro {
    
    public static void main(String[] args) {
        System.out.println("ingrese el tiempo en segundos");
        Scanner sc = new Scanner(System.in);
        int minuto = sc.nextInt();
        HiloCronometro hilo = new HiloCronometro(minuto);
        hilo.run();
    }
}
