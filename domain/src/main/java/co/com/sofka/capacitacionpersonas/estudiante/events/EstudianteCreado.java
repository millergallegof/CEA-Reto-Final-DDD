package co.com.sofka.capacitacionpersonas.estudiante.events;

import co.com.sofka.capacitacionpersonas.estudiante.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class EstudianteCreado extends DomainEvent {
    private final MatriculaId matriculaId;
    private final ValorMatricula valorMatricula;
    private final TipoMatricula tipoMatricula;
    private final CuentaId cuentaId;
    private final TipoCuenta tipoCuenta;
    private final DatosUsuario datosUsuario;
    private final LibretaId libretaId;
    private final Datos datos;

    public EstudianteCreado(MatriculaId matriculaId, ValorMatricula valorMatricula, TipoMatricula tipoMatricula, CuentaId cuentaId, TipoCuenta tipoCuenta, DatosUsuario datosUsuario, LibretaId libretaId, Datos datos) {
        super("co.com.sofka.capacitacionpersonas.EstudianteCreado");
        this.matriculaId = matriculaId;
        this.valorMatricula = valorMatricula;
        this.tipoMatricula = tipoMatricula;
        this.cuentaId = cuentaId;
        this.tipoCuenta = tipoCuenta;
        this.datosUsuario = datosUsuario;
        this.libretaId = libretaId;
        this.datos = datos;
    }

    public MatriculaId getMatriculaId() {
        return matriculaId;
    }

    public ValorMatricula getValorMatricula() {
        return valorMatricula;
    }

    public TipoMatricula getTipoMatricula() {
        return tipoMatricula;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public DatosUsuario getDatosUsuario() {
        return datosUsuario;
    }

    public LibretaId getLibretaId() {
        return libretaId;
    }

    public Datos getDatos() {
        return datos;
    }
}
