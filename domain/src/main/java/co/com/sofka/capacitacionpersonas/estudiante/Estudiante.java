package co.com.sofka.capacitacionpersonas.estudiante;

import co.com.sofka.capacitacionpersonas.clase.values.ClaseId;
import co.com.sofka.capacitacionpersonas.estudiante.events.*;
import co.com.sofka.capacitacionpersonas.estudiante.values.*;
import co.com.sofka.capacitacionpersonas.instructor.values.InstructorId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Estudiante extends AggregateEvent<EstudianteId> {

    protected ClaseId claseId;
    protected InstructorId instructorId;
    protected Matricula matricula;
    protected Cuenta cuenta;
    protected Libreta libreta;

    public Estudiante(
            EstudianteId estudianteId, ClaseId claseId, InstructorId instructorId, MatriculaId matriculaId, ValorMatricula valorMatricula, TipoMatricula tipoMatricula,
            CuentaId cuentaId, TipoCuenta tipoCuenta, DatosUsuario datosUsuario,
            LibretaId libretaId, Datos datos) {
        super(estudianteId);
        appendChange(new EstudianteCreado(claseId, instructorId, cuentaId, tipoCuenta, datosUsuario)).apply();
        appendChange(new MatriculaCreada(matriculaId, valorMatricula, tipoMatricula)).apply();
        appendChange(new LibretaCreada(libretaId, datos)).apply();
        subscribe(new EstudiantEventChange(this));
    }

    public void cambiarCategoriaLicencia(MatriculaId matriculaId, String categoria) {
        appendChange(new CategoriaLicenciaCambiada(matriculaId, categoria)).apply();
    }

    public void actualizarDatosusuario(EstudianteId estudianteId, CuentaId cuentaId, String email, String telefono) {
        appendChange(new DatosUsuActualizado(claseId, cuentaId, email, telefono)).apply();
    }

    public void agregarNota(LibretaId libretaId, Nota nota) {
        appendChange(new NotaAgregada(libretaId, nota)).apply();
    }

    public void modificarValorNotaLibreta(LibretaId libretaId, Integer valorNotaNueva) {
        appendChange(new ValorNotaLibretaModificada(libretaId, valorNotaNueva)).apply();
    }

    private Estudiante(co.com.sofka.capacitacionpersonas.estudiante.values.EstudianteId id) {
        super(id);
        subscribe(new EstudiantEventChange(this));
    }

    public static Estudiante from(EstudianteId estudianteId, List<DomainEvent> events) {
        var estudiante = new Estudiante(estudianteId);
        events.forEach(estudiante::applyEvent);
        return estudiante;
    }


}
