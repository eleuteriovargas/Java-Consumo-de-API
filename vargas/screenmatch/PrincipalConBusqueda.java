package com.vargas.screenmatch;

import com.vargas.screenmatch.conversion.TituloConvertir;
import com.vargas.screenmatch.integracion.OmdbCliente;
import com.vargas.screenmatch.modelos.Titulo;
import com.vargas.screenmatch.modelos.TituloOmdb;
import com.vargas.screenmatch.repository.TituloRepository;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class PrincipalConBusqueda {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();

        OmdbCliente omdbCliente = new OmdbCliente();
        TituloConvertir convertir = new TituloConvertir();
        TituloRepository repository = new TituloRepository("Pelicula.json");

        while (true) {
            System.out.println("Escriba el nombre de una película (o 'salir' para terminar):");
            var busqueda = teclado.nextLine();

            if (busqueda.equalsIgnoreCase("salir")) {
                break;
            }

            try {
                String json = omdbCliente.buscarPelicula(busqueda);
                TituloOmdb tituloOmdb = convertir.convertirDesdeJson(json);
                Titulo miTitulo = convertir.convertirTitulo(tituloOmdb);
                titulos.add(miTitulo);

                System.out.println("Título agregado: " + miTitulo);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        try {
            repository.guardarTitulos(titulos);
            System.out.println("Datos guardados exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }

        System.out.println("Programa finalizado.");
    }
}