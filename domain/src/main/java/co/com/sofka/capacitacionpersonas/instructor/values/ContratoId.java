package co.com.sofka.capacitacionpersonas.instructor.values;

import co.com.sofka.domain.generic.Identity;

public class ContratoId extends Identity {
    public ContratoId(String valor) {
        super(valor);
    }

    public ContratoId() {
    }

    public static ContratoId of(String value) {
        return new ContratoId(value);
    }
}
