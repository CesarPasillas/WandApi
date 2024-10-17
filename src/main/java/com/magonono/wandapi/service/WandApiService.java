package com.magonono.wandapi.service;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

/**
 * Created for the WandApi project.
 *
 * @author Cesar "Aran" Pasillas
 */
@Service
public class WandApiService {

    public HttpResponse<String> callGet(String url, Map<String, String> headers){

        String responseBody;
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

        return null;
    }

    public HttpResponse<String> callPut(String url, Map<String, String> headers){
        return null;
    }

    public HttpResponse<String> callPost(String url, Map<String, String> headers){
        return null;
    }

    public HttpResponse<String> callDelete(String url, Map<String, String> headers){
        return null;
    }
}
