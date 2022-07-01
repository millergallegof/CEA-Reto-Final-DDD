package co.com.sofka.capacitacionpersonas.clase.values;

import co.com.sofka.domain.generic.Identity;

public class EstudianteId extends Identity {

    public EstudianteId(String value) {
        super(value);
    }

    public EstudianteId() {
    }

    public static EstudianteId of(String value) {
        return new EstudianteId(value);
    }
}
