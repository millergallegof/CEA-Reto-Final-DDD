package co.com.sofka.capacitacionpersonas.clase.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class FechaNota implements ValueObject<LocalDate> {
    private final LocalDate fechaNota;

    public FechaNota(LocalDate fechaNota) {
        this.fechaNota = Objects.requireNonNull(fechaNota);

        if (fechaNota.compareTo(LocalDate.now()) < 0) {
            throw new IllegalArgumentException("La fecha no puede ser menor a la de hoy");
        }
    }

    @Override
    public LocalDate value() {
        return fechaNota;
    }
}
