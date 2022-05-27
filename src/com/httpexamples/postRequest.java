package com.httpexamples;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public class postRequest {

    public static  final String URL_GET = "http://httpbin.org/forms/post";
    public static  final String FILE_JSON = "C:/Users/julie.santos/Documents/Projetos/DIO/HTTPProject/pedido.json" ;

    public static void main(String[] args) throws IOException, InterruptedIOException, InterruptedException {

        // client HTTP
        HttpClient client = HttpClient.newHttpClient();



        // requisição
        HttpRequest request = HttpRequest.newBuilder()
                .POST( HttpRequest.BodyPublishers.ofFile( Path.of( FILE_JSON ) ) )
                .timeout( Duration.ofSeconds( 10 ) )
                .uri( URI.create( URL_GET ) )
                .build();

        client.sendAsync( request, HttpResponse.BodyHandlers.ofString() )
                .thenApply( HttpResponse::body )
                .thenAccept( System.out::println )
                .join();

    }

}
