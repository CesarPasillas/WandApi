/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magonono.wandapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.magonono.wandapi.WandApiFrame;
import com.magonono.wandapi.log.LogManager;
import com.magonono.wandapi.model.WandApiModel;
import com.magonono.wandapi.service.WandApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.text.BadLocationException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author cesarpasillas
 */
@Controller
public class WandApiController {
    
    private LogManager<WandApiController> log;


    private WandApiService wandApiService;

    @Autowired
    public WandApiController(WandApiService wandApiService){
        this.wandApiService = wandApiService;
        this.log = new LogManager<>(WandApiController.class);
    }
    
    /*public WandApiController(){
        log = new LogManager<>(WandApiController.class);
    }*/
    
    public String sendRequest(String url, String httpMethod){

        System.out.println(httpMethod);
        System.out.println(url);

        return "{\n" +
"  \"string\": \"Hello, World!\",\n" +
"  \"number_integer\": 42,\n" +
"  \"number_float\": 3.14159,\n" +
"  \"boolean_true\": true,\n" +
"  \"boolean_false\": false,\n" +
"  \"null_value\": null,\n" +
"  \"array\": [1, \"two\", true, null, {\"nested_key\": \"nested_value\"}],\n" +
"  \"object\": {\n" +
"    \"key1\": \"value1\",\n" +
"    \"key2\": 123,\n" +
"    \"key3\": false,\n" +
"    \"nested_object\": {\n" +
"      \"nested_key1\": \"nested_value1\",\n" +
"      \"nested_key2\": [1, 2, 3]\n" +
"    }\n" +
"  }\n" +
"}";
    }
    
    
   public WandApiModel sendApiRequest(String url, String httpMethod, String body) {
        String responseBody = ""; // Inicializar la variable de respuesta

        HttpResponse<String> response = null;
        
        switch (httpMethod){
           case "GET" : response = wandApiService.callGet(url, new HashMap<>());
                        break;
           case "PUT" : response = wandApiService.callPut(url, body, new HashMap<>());
                        break;
           case "POST" : response = wandApiService.callPost(url, new HashMap<>());
                        break;
           case "DELETE" : response = wandApiService.callDelete(url, new HashMap<>());
                        break;
           default: 
               //return "Internal Error";
               break;
               
       }

        WandApiModel wandApiModel = new WandApiModel();

        try {
            wandApiModel.setBodyResponse(prettyJson(response.body()));
        } catch (JsonProcessingException ex){
            wandApiModel.setBodyResponse(ex.getMessage());
            wandApiModel.setCodeStatus("400");
            return wandApiModel;
        }

        wandApiModel.setHeaders(response.headers().map());
        wandApiModel.setCodeStatus(String.valueOf(response.statusCode()));

        // Agregar la URL y la respuesta al modelo para mostrar
        
        return wandApiModel; // Regresar a la misma vista
    }

    public static String prettyJson(String jsonString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonNode = mapper.readTree(jsonString);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper.writeValueAsString(jsonNode);
    }
}
