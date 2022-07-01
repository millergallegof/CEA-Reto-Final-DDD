package co.com.sofka.capacitacionpersonas.clase.values;

import co.com.sofka.domain.generic.Identity;

public class ClaseId extends Identity {

    public ClaseId(String value) {
        super(value);
    }

    public ClaseId() {
    }

    public static ClaseId of(String value) {
        return new ClaseId(value);
    }
}
