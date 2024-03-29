package co.com.sofka.capacitacionpersonas.estudiante.commands;


import co.com.sofka.capacitacionpersonas.clase.values.ClaseId;
import co.com.sofka.capacitacionpersonas.estudiante.values.*;
import co.com.sofka.capacitacionpersonas.instructor.values.InstructorId;
import co.com.sofka.domain.generic.Command;


public class CrearEstudianteCommand extends Command {
    private final EstudianteId estudianteId;
    private final ClaseId claseId;
    private final InstructorId instructorId;
    private final MatriculaId matriculaId;
    private final ValorMatricula valorMatricula;
    private final TipoMatricula tipoMatricula;
    private final CuentaId cuentaId;
    private final TipoCuenta tipoCuenta;
    private final DatosUsuario datosUsuario;
    private final LibretaId libretaId;
    private final Datos datos;

    public CrearEstudianteCommand(EstudianteId estudianteId, ClaseId claseId, InstructorId instructorId,
                                  MatriculaId matriculaId, ValorMatricula valorMatricula, TipoMatricula tipoMatricula,
                                  CuentaId cuentaId, TipoCuenta tipoCuenta, DatosUsuario datosUsuario,
                                  LibretaId libretaId, Datos datos) {
        this.estudianteId = estudianteId;
        this.claseId = claseId;
        this.instructorId = instructorId;
        this.matriculaId = matriculaId;
        this.valorMatricula = valorMatricula;
        this.tipoMatricula = tipoMatricula;
        this.cuentaId = cuentaId;
        this.tipoCuenta = tipoCuenta;
        this.datosUsuario = datosUsuario;
        this.libretaId = libretaId;
        this.datos = datos;
    }

    public EstudianteId estudianteId() {
        return estudianteId;
    }

    public ClaseId claseId() {
        return claseId;
    }

    public InstructorId instructorId() {
        return instructorId;
    }

    public MatriculaId matriculaId() {
        return matriculaId;
    }

    public ValorMatricula valorMatricula() {
        return valorMatricula;
    }

    public TipoMatricula tipoMatricula() {
        return tipoMatricula;
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
    public LibretaId libretaId() {
        return libretaId;
    }

    public Datos datos() {
        return datos;
    }
}
