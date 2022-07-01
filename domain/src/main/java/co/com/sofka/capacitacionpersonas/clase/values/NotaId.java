package co.com.sofka.capacitacionpersonas.clase.values;

import co.com.sofka.domain.generic.Identity;

public class NotaId extends Identity {
    public NotaId(String value) {
        super(value);
    }

    public NotaId() {
    }

    public static NotaId of(String value) {
        return new NotaId(value);
    }
}
