package co.com.sofka.capacitacionpersonas.estudiante;

import co.com.sofka.capacitacionpersonas.estudiante.events.*;
import co.com.sofka.capacitacionpersonas.estudiante.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Estudiante extends AggregateEvent<EstudianteId> {

    protected Matricula matricula;
    protected Cuenta cuenta;
    protected Libreta libreta;

    public Estudiante(
            EstudianteId estudianteId, MatriculaId matriculaId, ValorMatricula valorMatricula, TipoMatricula tipoMatricula,
            CuentaId cuentaId, TipoCuenta tipoCuenta, DatosUsuario datosUsuario,
            LibretaId libretaId, Datos datos) {
        super(estudianteId);
        appendChange(new EstudianteCreado(cuentaId, tipoCuenta, datosUsuario, libretaId, datos)).apply();
        appendChange(new MatriculaCreada(matriculaId, valorMatricula, tipoMatricula)).apply();
        subscribe(new EstudiantEventChange(this));
    }

    public void cambiarCategoriaLicencia(MatriculaId matriculaId, String categoria) {
        appendChange(new CategoriaLicenciaCambiada(matriculaId, categoria)).apply();
    }

    public void actualizarDatosusuario(CuentaId cuentaId, String email, String telefono) {
        appendChange(new DatosUsuActualizado(cuentaId, email, telefono)).apply();
    }

    public void agregarNota(LibretaId libretaId, Nota nota) {
        appendChange(new NotaAgregada(libretaId, nota)).apply();
    }

    public void modificarValorNotaLibreta(LibretaId libretaId, Integer valorNotaNueva) {
        appendChange(new ValorNotaLibretaModificada(libretaId, valorNotaNueva)).apply();
    }

    private Estudiante(EstudianteId id) {
        super(id);
        subscribe(new EstudiantEventChange(this));
    }

    public static Estudiante from(EstudianteId id, List<DomainEvent> events) {
        var estudiante = new Estudiante(id);
        events.forEach(estudiante::applyEvent);
        return estudiante;
    }


}
