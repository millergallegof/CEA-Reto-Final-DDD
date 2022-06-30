package co.com.sofka.capacitacionpersonas.estudiante.events;

import co.com.sofka.capacitacionpersonas.estudiante.values.CuentaId;
import co.com.sofka.domain.generic.DomainEvent;

public class DatosUsuActualizado extends DomainEvent {
    private final CuentaId cuentaId;
    private final String email;
    private final String telefono;

    public DatosUsuActualizado(CuentaId cuentaId, String email, String telefono) {
        super("co.com.sofka.capacitacionpersonas.DatosUsuActualizado");
        this.cuentaId = cuentaId;
        this.email = email;
        this.telefono = telefono;
    }

    public CuentaId cuentaId() {
        return cuentaId;
    }

    public String email() {
        return email;
    }

    public String telefono() {
        return telefono;
    }
}
