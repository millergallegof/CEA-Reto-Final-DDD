package co.com.sofka.capacitacionpersonas.clase.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class Fecha implements ValueObject<Fecha.Props> {

    private final LocalDate fechaFin;
    private final LocalDate fechaInicio;

    public Fecha(LocalDate fechaFin, LocalDate fechaInicio) {
        this.fechaFin = Objects.requireNonNull(fechaFin);
        this.fechaInicio = Objects.requireNonNull(fechaInicio);

        if (fechaFin.compareTo(LocalDate.now()) < 0) {
            throw new IllegalArgumentException("La fecha no puede ser menor a al de hoy");
        }
        if (fechaInicio.compareTo(LocalDate.now()) < 0) {
            throw new IllegalArgumentException("La fecha no puede ser menor a al de hoy");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public LocalDate fechaFin() {
                return fechaFin;
            }

            @Override
            public LocalDate fechaInicio() {
                return fechaInicio;
            }
        };
    }

    public interface Props {
        LocalDate fechaFin();

        LocalDate fechaInicio();
    }
}
