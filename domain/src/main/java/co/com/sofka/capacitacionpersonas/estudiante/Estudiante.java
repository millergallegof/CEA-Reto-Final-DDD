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

    //    crear el cliente y cambiar los estados
    public Estudiante(
            EstudianteId estudianteId, MatriculaId matriculaId, ValorMatricula valorMatricula, TipoMatricula tipoMatricula,
            CuentaId cuentaId, TipoCuenta tipoCuenta, DatosUsuario datosUsuario,
            LibretaId libretaId, Datos datos) {
        super(estudianteId);
        appendChange(new EstudianteCreado(matriculaId, valorMatricula, tipoMatricula, cuentaId, tipoCuenta, datosUsuario, libretaId, datos)).apply();
        subscribe(new EstudiantEventChange(this));
    }

    //    Cambiar el estado del estudiante segun los eventos creados
    private Estudiante(EstudianteId id) {
        super(id);
        subscribe(new EstudiantEventChange(this));
    }

    public void agregarMatricula(Matricula matricula) {
        appendChange(new MatriculaAgregada(matricula)).apply();
    }

    public void crearMatricula(EstudianteId estudianteId, MatriculaId matriculaId, ValorMatricula valorMatricula, TipoMatricula tipoMatricula) {
        appendChange((new MatriculaCreada(estudianteId, matriculaId, valorMatricula, tipoMatricula))).apply();
    }

    public void cambiarCategoriaLicencia(MatriculaId matriculaId, String categoria) {
        appendChange(new CategoriaLicenciaCambiada(matriculaId, categoria)).apply();
    }

    public void actualizarDatosusuario(CuentaId cuentaId, String email, String telefono) {
        appendChange(new DatosUsuActualizado(cuentaId, email, telefono)).apply();
    }

    //    recrear el cliente que ya se creo - Reconstruir Agregado ya creado
    public static Estudiante from(EstudianteId id, List<DomainEvent> events) {
//        es un cliente base para hacerle todos evetos
        var estudiante = new Estudiante(id);
        events.forEach(estudiante::applyEvent);
        return estudiante;
    }


}
