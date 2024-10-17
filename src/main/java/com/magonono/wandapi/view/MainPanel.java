/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magonono.wandapi.view;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.*;

import static com.magonono.wandapi.view.config.ViewConfig.*;

/**
 *
 * @author Cesar "Aran" Pasillas
 */
public class MainPanel {
    
    private JPanel panel;
    private JComboBox httpMethodsComboBox;
    private JLabel requestLabel;
    private JLabel requestLabel1;
    private JLabel requestLabel2;
    private JLabel statusCodeLabel;
    private JLabel responseCodeLabel;
    private JScrollPane requestJScrollPane;
    private JScrollPane responseJScrollPane;
    private JScrollPane consoleJScrollPane;
    private JTextField urlTextInput;
    private JButton sendButton;
    private JTextPane requestTextPane;
    private JTextPane responseTextPane;
    private JTextPane consoleTextPane;
    
    private JToggleButton jToggleButton1;
    
    public MainPanel(){
        initComponents();
    }
    
    public void initComponents(){
        panel = new JPanel();
        httpMethodsComboBox = new JComboBox<>();
        requestLabel = new JLabel();
        requestLabel1 = new JLabel();
        requestLabel2 = new JLabel();
        statusCodeLabel = new JLabel();
        responseCodeLabel = new JLabel();
        jToggleButton1 = new JToggleButton();
        urlTextInput = new JTextField();
        sendButton = new JButton();
        requestTextPane = new JTextPane();
        responseTextPane = new JTextPane();
        consoleTextPane = new JTextPane();
        requestJScrollPane = new JScrollPane(requestTextPane);
        responseJScrollPane = new JScrollPane(responseTextPane);
        consoleJScrollPane = new JScrollPane(consoleTextPane);
        
        //adding elements
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel.setBackground(M_COLOR);
        
        
        JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, requestJScrollPane, responseJScrollPane);
        splitPane1.setDividerLocation(200); // Posición inicial del divisor

        // Crear el segundo JSplitPane para dividir splitPane1 y textPane3
        JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane1, consoleJScrollPane);
        splitPane2.setDividerLocation(400);
        
        GroupLayout mainLayout = new GroupLayout(panel);
        panel.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(mainLayout.createSequentialGroup()
                                .addComponent(requestLabel1)
                                .addGap(377, 377, 377)
                                .addComponent(jToggleButton1)
                                .addGap(11, 11, 11)
                                .addComponent(statusCodeLabel)
                                .addGap(4, 4, 4)
                                .addComponent(responseCodeLabel))
                            .addComponent(requestLabel2)
                            .addComponent(requestLabel))
                        .addGap(0, 49, Short.MAX_VALUE))
                    .addGroup(mainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(responseJScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(consoleJScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mainLayout.createSequentialGroup()
                                .addComponent(httpMethodsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(urlTextInput)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(requestJScrollPane))))
                .addContainerGap())
        );
        
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(httpMethodsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(urlTextInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(requestLabel1))
                    .addComponent(jToggleButton1)
                    .addComponent(statusCodeLabel)
                    .addComponent(responseCodeLabel))
                .addGap(3, 3, 3)
                .addComponent(responseJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(requestLabel2)
                .addGap(3, 3, 3)
                .addComponent(consoleJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(requestLabel)
                .addGap(3, 3, 3)
                .addComponent(requestJScrollPane)
                .addContainerGap())
        );
        
    }
    
    
    
}
