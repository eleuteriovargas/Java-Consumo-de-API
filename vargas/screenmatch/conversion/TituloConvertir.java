package com.vargas.screenmatch.conversion;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vargas.screenmatch.excecion.ErrorEnConversionDeDuracionEception;
import com.vargas.screenmatch.modelos.Titulo;
import com.vargas.screenmatch.modelos.TituloOmdb;

public class TituloConvertir {
    private Gson gson;

    public TituloConvertir() {
        this.gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
    }

    public TituloOmdb convertirDesdeJson(String json) {
        return gson.fromJson(json, TituloOmdb.class);
    }

    public Titulo convertirTitulo(TituloOmdb tituloOmdb)
            throws ErrorEnConversionDeDuracionEception {
        return new Titulo(tituloOmdb);
    }
}
