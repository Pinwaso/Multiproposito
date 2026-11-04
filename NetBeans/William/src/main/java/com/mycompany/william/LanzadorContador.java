/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.william;

import java.io.IOException;

/**
 *
 * @author Diurno
 */
public class LanzadorContador {
    public static void main(String[] args) throws IOException {
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/k", "java", "-jar", "Contador.java", String.valueOf(n1), String.valueOf(n2));
        pb.start();
    }
}
