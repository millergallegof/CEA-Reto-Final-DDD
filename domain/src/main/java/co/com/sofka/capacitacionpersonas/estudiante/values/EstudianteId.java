package co.com.sofka.capacitacionpersonas.estudiante.values;

import co.com.sofka.capacitacionpersonas.instructor.values.InstructorId;
import co.com.sofka.domain.generic.Identity;

public class EstudianteId extends Identity {
    public EstudianteId(InstructorId.Type tipo, String valor) {
        super(tipo + "-" + valor);
    }

    public EstudianteId(String valor) {
        super(valor);
    }

    public EstudianteId() {
    }

    public enum Type {
        PASAPORTE, CC, TI
    }
}
