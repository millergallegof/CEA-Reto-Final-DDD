package co.com.sofka.capacitacionpersonas.instructor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DatosRegistro implements ValueObject<String> {
    private final String nombreInstructor;

    public DatosRegistro(String nombreInstructor) {
        this.nombreInstructor = Objects.requireNonNull(nombreInstructor);
    }

    @Override
    public String value() {
        return nombreInstructor;
    }
}
