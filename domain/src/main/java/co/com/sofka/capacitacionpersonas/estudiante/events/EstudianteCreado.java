package co.com.sofka.capacitacionpersonas.estudiante.events;

import co.com.sofka.capacitacionpersonas.clase.values.ClaseId;
import co.com.sofka.capacitacionpersonas.estudiante.values.*;
import co.com.sofka.capacitacionpersonas.instructor.values.InstructorId;
import co.com.sofka.domain.generic.DomainEvent;

public class EstudianteCreado extends DomainEvent {
    private final ClaseId claseId;
    private final InstructorId instructorId;
    private final CuentaId cuentaId;
    private final TipoCuenta tipoCuenta;
    private final DatosUsuario datosUsuario;


    public EstudianteCreado(ClaseId claseId, InstructorId instructorId, CuentaId cuentaId, TipoCuenta tipoCuenta, DatosUsuario datosUsuario) {
        super("co.com.sofka.capacitacionpersonas.EstudianteCreado");
        this.claseId = claseId;
        this.instructorId = instructorId;
        this.cuentaId = cuentaId;
        this.tipoCuenta = tipoCuenta;
        this.datosUsuario = datosUsuario;

    }


    public ClaseId claseId() {
        return claseId;
    }

    public InstructorId instructorId() {
        return instructorId;
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
