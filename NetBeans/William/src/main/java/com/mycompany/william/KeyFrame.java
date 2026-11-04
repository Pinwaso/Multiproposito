/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.william;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Diurno
 */
public class KeyFrame extends JFrame {
    
    private JLabel etiqueta;
    
    //Creamos los objetos de la cola y el consumidor
    private KeyCola cola;
    private KeyConsumer consumer;
    private KeyProducer producer;
    
    public KeyFrame() {
        super("Detector de Teclas");
        //Instanciamos la cola y el consumidos y lo arrancamos.
        cola = new KeyCola();
        consumer = new KeyConsumer(cola, this);
        producer = new KeyProducer(cola);
        
        etiqueta = new JLabel("Presiona una tecla");
        etiqueta.setHorizontalAlignment(JLabel.CENTER);
        add(etiqueta);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Este método se llama cuando se presiona y se libera una tecla.
                producer.obtenerCaracter(e.getKeyChar());    
                //Añadimos el caracter leido a la cola
                //cola.put(tecla);
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        setFocusable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        requestFocusInWindow();
       
        producer.start();
        consumer.start();
    }
    
    public void actualizarInfo(char caracter) {
        // Swing solo debe tocarse desde el EDT
        SwingUtilities.invokeLater(() ->
            etiqueta.setText("Tecla presionada: " + caracter)
        );
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new KeyFrame());
    }
}



