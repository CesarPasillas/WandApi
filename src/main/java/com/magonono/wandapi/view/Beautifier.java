/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magonono.wandapi.view;

import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Cesar Pasillas
 */
public class Beautifier {
    
    private JTextPane textPane;
    private Style keyStyle;
    private Style valueStyle;
    private Style bracesStyle;
    
    public Beautifier(JTextPane textPane){
        this.textPane = textPane;
        createStyles();
    }
    
    public StyledDocument beautifyText(String json){
        
        StyledDocument doc = textPane.getStyledDocument();
        
        var jsons = new ArrayList<>();
        
        /*for (int x = 0; x < json.length(); x++){
           char c = tmp.charAt(x);
           if (c == '{'){
               jsons.add("{\n");
               tmp = tmp.substring(x+1).trim();
               x = x -1;
           } else if (c == '"'){
               tmp = tmp.substring(x+1);
               tmp = tmp.substring(0, tmp.indexOf(""));
           }
        }*/
        
        String[] keyValuePairs = json.split(",");
        
        for (int x = 0; x < keyValuePairs.length; x++){
            if (keyValuePairs[x].startsWith("{")){
                jsons.add("{\n");
                String tmp[] = keyValuePairs[x].substring(x+1).trim().split(":");
                
                jsons.add(tmp[0]);
                jsons.add(":");
                if (tmp[1].startsWith("\"") && tmp[1].endsWith("\"")){
                    jsons.add(tmp[1]);
                }else{
                    
                    jsons.add(tmp[1]+", "+keyValuePairs[x+1].trim());
                    x++;
                }
            } else if (keyValuePairs[x].endsWith("}")){
                
            }else {
                String tmp[] = keyValuePairs[x].trim().split(":");
                 jsons.add(tmp[0]);
                 jsons.add(":");
                 jsons.add(tmp[1].trim());
                
            }
            jsons.add(", \n ");
        }
        
        textPane.setText(""); //Clear before send any response.
        // Example: Split the input as if it were a key-value pair (simplified)
        char prev = '{';
        try {
            for (int x = 0; x < json.length(); x++){
                char c = json.charAt(x);
                if (c == '{'){
                    doc.insertString(doc.getLength(),  "{\n", bracesStyle);
                } else if (c == '}'){
                    doc.insertString(doc.getLength(),  "}\n", bracesStyle);
                } else if (c == ','){
                    doc.insertString(doc.getLength(),  ",\n", bracesStyle);
                }
            }
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
        
        
        /*String[] keyValuePairs = json.split(",");
                System.out.println(Arrays.toString(keyValuePairs));
                for (String pair : keyValuePairs) {
                    String[] keyValue = pair.split(":");
                    System.out.println("Processing -> " + Arrays.toString(keyValue));
                    //if (keyValue.length == 2) {
                        // Append key
                        try {
                            
                            if (keyValue[1].trim().endsWith("}")){
                                System.out.println(keyValue[1].trim().substring(0, keyValue.length - 1));
                                doc.insertString(doc.getLength(), keyValue[1].trim().substring(0, keyValue.length - 1) + "\n", valueStyle);
                                doc.insertString(doc.getLength(),  "}", bracesStyle);
                            } else {
                                doc.insertString(doc.getLength(), keyValue[1].trim() + "\n", valueStyle);
                            }
                            
                            if (keyValue[0].trim().startsWith("{")){
                                doc.insertString(doc.getLength(), "{\n", bracesStyle);
                                keyValue[0] = keyValue[0].substring(1);
                            }
                            doc.insertString(doc.getLength(), keyValue[0].trim(), keyStyle);
                            doc.insertString(doc.getLength(), " : ", bracesStyle);
                            // Append value
                            
                            
                            
                        } catch (BadLocationException ex) {
                            ex.printStackTrace();
                        }
                    //}
                }*/
        
        return doc;
    }
    
    public static void processJson(String json) {
        int depth = 0; // Para rastrear la profundidad de las llaves y arrays
        boolean inQuotes = false; // Para manejar las comillas dobles
        StringBuilder currentValue = new StringBuilder(); // Para almacenar los valores o claves en proceso

        for (int i = 0; i < json.length(); i++) {
            char currentChar = json.charAt(i);

            // Detectar si estamos dentro de comillas dobles
            if (currentChar == '\"') {
                inQuotes = !inQuotes; // Cambiar el estado de dentro/fuera de comillas
                if (!inQuotes) {
                    // Al salir de comillas, significa que hemos encontrado un valor o clave completo
                    System.out.println("Found a string: " + currentValue.toString());
                    currentValue.setLength(0); // Limpiar el valor actual
                }
                continue;
            }

            // Si estamos dentro de comillas, agregar el carácter al valor actual
            if (inQuotes) {
                currentValue.append(currentChar);
                continue;
            }

            switch (currentChar) {
                case '{':
                    depth++;
                    System.out.println("Found an opening brace '{' at depth " + depth);
                    break;
                case '}':
                    System.out.println("Found a closing brace '}' at depth " + depth);
                    depth--;
                    break;
                case '[':
                    depth++;
                    System.out.println("Found an opening bracket '[' at depth " + depth);
                    break;
                case ']':
                    System.out.println("Found a closing bracket ']' at depth " + depth);
                    depth--;
                    break;
                case ':':
                    System.out.println("Found a colon ':' separating key and value");
                    break;
                case ',':
                    System.out.println("Found a comma ',' separating elements");
                    break;
                default:
                    // Detectar valores (esto es muy básico, solo muestra lo que no son símbolos)
                    if (!Character.isWhitespace(currentChar)) {
                        currentValue.append(currentChar);
                    }
                    break;
            }
        }
    }
    
    private void createStyles(){
        
        // Create key and value styles
        keyStyle = textPane.addStyle("KeyStyle", null);
          // Keys in red

        valueStyle = textPane.addStyle("ValueStyle", null);
        
        
        bracesStyle = textPane.addStyle("BracesStyle", null);
        
        StyleConstants.setForeground(keyStyle, Color.RED);
        StyleConstants.setForeground(valueStyle, new Color(0,153,51)); 
        StyleConstants.setForeground(bracesStyle, Color.BLACK); 
        
    }
    
    
    
}
