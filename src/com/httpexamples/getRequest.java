package com.httpexamples;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class getRequest {


    // public static  final String URL_GET = "https://jsonplaceholder.typicode.com/posts";
    public static  final String URL_GET = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) throws IOException, InterruptedIOException, InterruptedException {

        // cliente
        HttpClient client = HttpClient.newHttpClient();

        // requisição
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout( Duration.ofSeconds( 10 ) )
                .uri( URI.create( URL_GET ) )
                .build();

        // Enviar Solicitação

         HttpResponse<String> response = client.send ( request, HttpResponse.BodyHandlers.ofString() );

         //Imprimir Conteudo
        System.out.println(response.statusCode());
        System.out.println(response.body());



    }

}
