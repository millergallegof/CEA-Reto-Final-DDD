package co.com.sofka.capacitacionpersonas.clase.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Duracion implements ValueObject<Duracion.Props> {

    private final Integer tiempo;
    private final String detalle;

    public Duracion(Integer tiempo, String detalle) {
        this.tiempo = Objects.requireNonNull(tiempo);
        this.detalle = Objects.requireNonNull(detalle);

        if (tiempo < 0) {
           throw new IllegalArgumentException("El tiempo debe ser mayor a 0");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Integer tiempo() {
                return tiempo;
            }

            @Override
            public String detalle() {
                return detalle;
            }
        };
    }


    public interface Props {
        Integer tiempo();

        String detalle();
    }
}
