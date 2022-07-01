package co.com.sofka.capacitacionpersonas.estudiante.events;

import co.com.sofka.capacitacionpersonas.estudiante.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class EstudianteCreado extends DomainEvent {
    private final CuentaId cuentaId;
    private final TipoCuenta tipoCuenta;
    private final DatosUsuario datosUsuario;


    public EstudianteCreado(CuentaId cuentaId, TipoCuenta tipoCuenta, DatosUsuario datosUsuario) {
        super("co.com.sofka.capacitacionpersonas.EstudianteCreado");
        this.cuentaId = cuentaId;
        this.tipoCuenta = tipoCuenta;
        this.datosUsuario = datosUsuario;

    }


    public CuentaId cuentaId() {
        return cuentaId;
    }

    public TipoCuenta tipoCuenta() {
        return tipoCuenta;
    }

    public DatosUsuario datosUsuario() {
        return datosUsuario;
    }


}
