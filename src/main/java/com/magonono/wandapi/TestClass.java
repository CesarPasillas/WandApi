/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magonono.wandapi;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;

/**
 *
 * @author cesarpasillas
 */
public class TestClass {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Resizable Three JTextPanes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);

        // Crear tres JTextPane
        JTextPane textPane1 = new JTextPane();
        JTextPane textPane2 = new JTextPane();
        JTextPane textPane3 = new JTextPane();

        // Añadir cada JTextPane dentro de un JScrollPane para permitir scroll
        JScrollPane scrollPane1 = new JScrollPane(textPane1);
        JScrollPane scrollPane2 = new JScrollPane(textPane2);
        JScrollPane scrollPane3 = new JScrollPane(textPane3);

        // Crear el primer JSplitPane para dividir el textPane1 y textPane2
        JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollPane1, scrollPane2);
        splitPane1.setDividerLocation(200); // Posición inicial del divisor

        // Crear el segundo JSplitPane para dividir splitPane1 y textPane3
        JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane1, scrollPane3);
        splitPane2.setDividerLocation(400); // Posición inicial del divisor

        // Añadir el JSplitPane principal al JFrame
        frame.add(splitPane2);
        frame.setVisible(true);
    }
    
}
