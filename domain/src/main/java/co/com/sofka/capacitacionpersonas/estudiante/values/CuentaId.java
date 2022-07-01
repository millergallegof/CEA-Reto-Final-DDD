package co.com.sofka.capacitacionpersonas.estudiante.values;

import co.com.sofka.domain.generic.Identity;

public class CuentaId extends Identity {
    public CuentaId(String value) {
        super(value);
    }
    public CuentaId() {
    }

    public static CuentaId of(String id) {
        return new CuentaId(id);
    }
}
