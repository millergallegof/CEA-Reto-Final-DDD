package co.com.sofka.capacitacionpersonas.instructor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Observaciones implements ValueObject<String> {
    private final String detalle;

    public Observaciones(String detalle) {
        this.detalle = Objects.requireNonNull(detalle);
    }

    @Override
    public String value() {
        return detalle;
    }
}
