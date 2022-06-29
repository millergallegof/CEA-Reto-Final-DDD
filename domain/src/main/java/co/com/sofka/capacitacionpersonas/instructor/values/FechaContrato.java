package co.com.sofka.capacitacionpersonas.instructor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class FechaContrato implements ValueObject<FechaContrato.Props> {
    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;

    public FechaContrato(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = Objects.requireNonNull(fechaInicio);
        this.fechaFin = Objects.requireNonNull(fechaFin);

        if (fechaFin.compareTo(LocalDate.now()) < 0) {
            throw new IllegalArgumentException("La fecha no puede ser menor a al de hoy");
        }
        if (fechaInicio.compareTo(LocalDate.now()) < 0) {
            throw new IllegalArgumentException("La fecha no puede ser menor a al de hoy");
        }

    }

    @Override
    public FechaContrato.Props value() {
        return new Props() {
            @Override
            public LocalDate fechaInicio() {
                return fechaInicio;
            }

            @Override
            public LocalDate fechaFin() {
                return fechaFin;
            }
        };
    }


    public interface Props {
        LocalDate fechaInicio();
        LocalDate fechaFin();
    }
}
