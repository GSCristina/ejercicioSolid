package rrhh;

import java.util.UUID;

public class GeneradorPasswordSimple implements GeneradorPassword {
    @Override
    public String generar() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}