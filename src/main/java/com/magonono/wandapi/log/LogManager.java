/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magonono.wandapi.log;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 *
 * @author Cesar "Aran" Pasillas
 */
public class LogManager<T> {
    
    private final String logClass;
    
    public LogManager(Class<T> aClass){
        
        logClass = aClass.getName();
    }
    
    public LogManager(String appName){
        
        logClass = appName;
    }
    
    public String logInfo(String msg){
        
        return "[INFO] " + (LocalDateTime.now() + " " + logClass + msg);
    }
    
    public String logWarning(String msg){
        
        return "[WARN] " + (LocalDateTime.now() + " " + logClass + msg);
    }
    
    public String logError(String msg){
        
        return "[ERROR] " + (LocalDateTime.now() + " " + logClass + msg);
    }
}
