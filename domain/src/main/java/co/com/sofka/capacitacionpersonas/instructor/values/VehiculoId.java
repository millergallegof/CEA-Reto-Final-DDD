package co.com.sofka.capacitacionpersonas.instructor.values;

import co.com.sofka.domain.generic.Identity;

public class VehiculoId extends Identity {
    public VehiculoId(String valor) {
        super(valor);
    }

    public VehiculoId() {
    }

    public static VehiculoId of(String value) {
        return new VehiculoId(value);
    }
}
