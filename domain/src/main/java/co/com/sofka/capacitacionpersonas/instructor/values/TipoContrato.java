package co.com.sofka.capacitacionpersonas.instructor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoContrato implements ValueObject<String> {
    private final String tipoContrato;

    public TipoContrato(String tipoContrato) {
        this.tipoContrato = Objects.requireNonNull(tipoContrato);
    }

    @Override
    public String value() {
        return tipoContrato;
    }
}
