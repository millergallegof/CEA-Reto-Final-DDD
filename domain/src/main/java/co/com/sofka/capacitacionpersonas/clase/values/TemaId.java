package co.com.sofka.capacitacionpersonas.clase.values;

import co.com.sofka.domain.generic.Identity;

public class TemaId extends Identity {
    public TemaId(String value) {
        super(value);
    }

    public TemaId() {
    }

    public static TemaId of(String value) {
        return new TemaId(value);
    }
}
