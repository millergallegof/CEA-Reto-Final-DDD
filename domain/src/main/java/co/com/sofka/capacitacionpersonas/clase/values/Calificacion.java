package co.com.sofka.capacitacionpersonas.clase.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Calificacion implements ValueObject<Integer> {
    private final Integer valor;


    public Calificacion(Integer valor) {
        this.valor = Objects.requireNonNull(valor);

        if (valor < 0) {
            throw new IllegalArgumentException("el valor de la calificacion debe ser mayor a 0");
        }
    }
    @Override
    public Integer value() {
        return valor;
    }

    public Calificacion modificarCalificacion(Integer calificacionACambiar) {
        return new Calificacion(calificacionACambiar);
    }
}
