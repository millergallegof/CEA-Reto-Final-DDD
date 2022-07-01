package co.com.sofka.capacitacionpersonas.estudiante.values;

import co.com.sofka.domain.generic.Identity;

public class MatriculaId extends Identity {

    public MatriculaId(String value) {
        super(value);
    }

    public MatriculaId() {
    }

    public static MatriculaId of(String id) {
        return new MatriculaId(id);
    }
}
