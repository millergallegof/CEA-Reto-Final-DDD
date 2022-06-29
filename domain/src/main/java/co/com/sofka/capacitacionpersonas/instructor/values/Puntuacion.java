package co.com.sofka.capacitacionpersonas.instructor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Puntuacion implements ValueObject<Integer> {

    private final Integer valor;

    public Puntuacion(Integer valor) {
        this.valor = Objects.requireNonNull(valor);

        if (valor < 0) {
            throw new IllegalArgumentException("EL valor no puede ser 0");
        }
    }

    @Override
    public Integer value() {
        return valor;
    }
}
