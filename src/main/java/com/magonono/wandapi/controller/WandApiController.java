/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magonono.wandapi.controller;

import com.magonono.wandapi.WandApiFrame;
import com.magonono.wandapi.log.LogManager;
import com.magonono.wandapi.service.WandApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

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
    
    
   public String sendApiRequest(String url, String httpMethod) {
        String responseBody = ""; // Inicializar la variable de respuesta

       switch (httpMethod){
           case "GET" : wandApiService.callGet(url, new HashMap<>());
                        break;
           case "PUT" : wandApiService.callPut(url, new HashMap<>());
                        break;
           case "POST" : wandApiService.callPost(url, new HashMap<>());
                        break;
           case "DELETE" : wandApiService.callDelete(url, new HashMap<>());
                        break;
           default: break;
       }

        try {
            // Crear cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET() // Cambia a .POST() si es necesario
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            responseBody = response.body(); // Almacenar el cuerpo de la respuesta

        } catch (Exception e) {
            responseBody = "Error: " + e.getMessage(); // Manejo de errores
        }

        // Agregar la URL y la respuesta al modelo para mostrar
        
        return responseBody; // Regresar a la misma vista
    }
    
}
