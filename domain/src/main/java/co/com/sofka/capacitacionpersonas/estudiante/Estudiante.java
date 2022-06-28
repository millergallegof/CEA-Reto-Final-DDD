package co.com.sofka.capacitacionpersonas.estudiante;

import co.com.sofka.capacitacionpersonas.estudiante.events.CategoriaLicenciaCambiada;
import co.com.sofka.capacitacionpersonas.estudiante.events.DatosUsuActualizado;
import co.com.sofka.capacitacionpersonas.estudiante.events.EstudianteCreado;
import co.com.sofka.capacitacionpersonas.estudiante.events.MatriculaAgregada;
import co.com.sofka.capacitacionpersonas.estudiante.values.CuentaId;
import co.com.sofka.capacitacionpersonas.estudiante.values.EstudianteId;
import co.com.sofka.capacitacionpersonas.estudiante.values.MatriculaId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Estudiante extends AggregateEvent<EstudianteId> {

    protected Matricula matricula;
    protected Cuenta cuenta;

//    crear el cliente y cambiar los estados
    public Estudiante(EstudianteId entityId, Matricula matricula, Cuenta cuenta) {
        super(entityId);
        appendChange(new EstudianteCreado(matricula, cuenta)).apply();
        subscribe(new EstudiantEventChange(this));
    }

//    Cambiar el estado del estudiante segun los eventos creados
    private Estudiante(EstudianteId id) {
        super(id);
        subscribe(new EstudiantEventChange(this));
    }

//    recrear el cliente que ya se creo - Reconstruir Agregado ya creado
    public static Estudiante from(EstudianteId id, List<DomainEvent> events) {
//        es un cliente base para hacerle todos evetos
        var estudiante = new Estudiante(id);
        events.forEach(estudiante::applyEvent);
        return estudiante;
    }

    public void agregarMatricula(Matricula matricula) {
        appendChange(new MatriculaAgregada(matricula)).apply();
    }

    public void cambiarCategoriaLicencia(MatriculaId matriculaId, String categoria) {
        appendChange(new CategoriaLicenciaCambiada(matriculaId, categoria)).apply();
    }

    public void actualizarDatosusuario(CuentaId cuentaId,  String email, String telefono) {
        appendChange(new DatosUsuActualizado(cuentaId, email, telefono)).apply();
    }


}
