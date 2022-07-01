package co.com.sofka.capacitacionpersonas.estudiante.values;


import co.com.sofka.domain.generic.Identity;

public class EstudianteId extends Identity {
    public EstudianteId(EstudianteId.Type tipo, String valor) {
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

    public static EstudianteId of(Type type, String value) {
        return new EstudianteId(type, value);
    }

    public static EstudianteId of(String id) {
        return new EstudianteId(id);
    }
}
