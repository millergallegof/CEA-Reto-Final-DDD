package co.com.sofka.capacitacionpersonas.estudiante.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.generic.ValueObject;

public class LibretaId extends Identity {
    public LibretaId(String value) {
        super(value);
    }
    public LibretaId() {
    }

    public static LibretaId of(String id) {
        return new LibretaId(id);
    }
}
