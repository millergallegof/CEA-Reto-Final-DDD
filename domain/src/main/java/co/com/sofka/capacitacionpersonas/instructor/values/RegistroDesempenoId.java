package co.com.sofka.capacitacionpersonas.instructor.values;

import co.com.sofka.domain.generic.Identity;

public class RegistroDesempenoId extends Identity {
    public RegistroDesempenoId(String valor) {
        super(valor);
    }

    public RegistroDesempenoId() {
    }

    public static RegistroDesempenoId of(String value) {
        return new RegistroDesempenoId(value);
    }

}
