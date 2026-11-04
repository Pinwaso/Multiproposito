/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Diurno
 */
public class AccesoArchivoConcurrente {
    public static void main(String[] args) {
        //Genera un numero aleatorio para diferenciar a los procesos
        Random random = new Random();
        //dar un numero entre 0 y 99
        int numero = random.nextInt(100);
        System.out.println("Numero aleatorio: " + numero);
        
        //ruta del archivo en el que va a escribir
        String archivo = "recurso.txt";
        
        //Va a escribir un numero muy alto de entradas para que generen problemas
        //Al haber procesos concurrentes sobre el mismo recurso
        try (FileWriter fw = new FileWriter(archivo, true)) {
            for (int i = 0; i < 100; i++) {
                fw.write("Proceso: " + numero + " escribe linea " + i + "\n");
                System.out.println("Proceso: " + numero + " escribe linea " + i);
            }
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}