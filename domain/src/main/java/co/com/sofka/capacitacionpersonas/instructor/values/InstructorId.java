package co.com.sofka.capacitacionpersonas.instructor.values;

import co.com.sofka.domain.generic.Identity;

public class InstructorId extends Identity {
    public InstructorId(Type tipo, String valor) {
        super(tipo + "-" + valor);
    }

    public InstructorId(String valor) {
        super(valor);
    }

    public InstructorId() {
    }

    public enum Type {
        PASAPORTE, CC, TI
    }

}
