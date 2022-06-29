package co.com.sofka.capacitacionpersonas.instructor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Kilometraje implements ValueObject<Long> {
    private final Long kilometraje;

    public Kilometraje(Long kilometraje) {
        this.kilometraje = Objects.requireNonNull(kilometraje);
        if (kilometraje < 0) {
            throw new IllegalArgumentException("el kilometraje debe ser mas de 0");
        }
    }

    @Override
    public Long value() {
        return kilometraje;
    }
}
