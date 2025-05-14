package com.vargas.screenmatch.excecion;

public class ErrorEnConversionDeDuracionEception extends RuntimeException {

    private String mensaje;

    public ErrorEnConversionDeDuracionEception(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
