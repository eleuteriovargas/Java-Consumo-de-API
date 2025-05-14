package com.vargas.screenmatch.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vargas.screenmatch.modelos.Titulo;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TituloRepository {
    private Gson gson;
    private String archivoDestino;

    public TituloRepository(String archivoDestino) {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.archivoDestino = archivoDestino;
    }

    public void guardarTitulos(List<Titulo> titulos) throws IOException {
        try (FileWriter escritura = new FileWriter(archivoDestino)) {
            escritura.write(gson.toJson(titulos));
        }
    }
}