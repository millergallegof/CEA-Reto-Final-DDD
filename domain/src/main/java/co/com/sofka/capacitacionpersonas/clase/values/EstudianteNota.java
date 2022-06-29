package co.com.sofka.capacitacionpersonas.clase.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstudianteNota implements ValueObject<String> {

    private final String nombre;

    public EstudianteNota(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    @Override
    public String value() {
        return nombre;
    }
}
