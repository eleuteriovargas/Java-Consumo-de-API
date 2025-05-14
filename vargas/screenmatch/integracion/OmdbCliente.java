package com.vargas.screenmatch.integracion;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OmdbCliente {
    private String API_KEY = "992CF187";
    private String BASE_URL = "http://www.omdbapi.com/";

    private HttpClient cliente;

    public OmdbCliente() {
        this.cliente = HttpClient.newHttpClient();
    }

    public String buscarPelicula(String titulo) throws IOException, InterruptedException {
        String url = String.format("%s?t=%s&apikey=%s",
                BASE_URL,
                titulo.replace(" ", "+"),
                API_KEY);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = cliente.send(
                request,
                HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
