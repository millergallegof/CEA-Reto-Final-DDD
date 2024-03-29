package co.com.sofka.capacitacionpersonas.clase;

import co.com.sofka.capacitacionpersonas.clase.events.*;
import co.com.sofka.capacitacionpersonas.clase.values.*;
import co.com.sofka.capacitacionpersonas.instructor.values.InstructorId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;

public class Clase extends AggregateEvent<ClaseId> {

    protected InstructorId instructorId;
    protected Tema tema;
    protected Evaluacion evaluacion;
    protected Map<NotaId, Nota> notas;

    public Clase(ClaseId entityId, InstructorId instructorId, TemaId temaId, Nombre nombre, Duracion duracion, EvaluacionId evaluacionId, Calificacion calificacion) {
        super(entityId);
        appendChange(new ClaseCreada(instructorId, evaluacionId, calificacion)).apply();
        appendChange(new TemaCreado(temaId, nombre, duracion)).apply();
        subscribe(new ClaseEventChange(this));
    }

    public void asociarNota(EstudianteNota estudianteNota, FechaNota fechaNota, ValorNota valorNota) {
        var notaId = new NotaId();
        appendChange(new NotaAsociada(notaId, estudianteNota, fechaNota, valorNota)).apply();
    }

    public void modificarCalificacionEvaluacion(EvaluacionId evaluacionId, Integer nuevaCalificacion) {
        appendChange(new CalificacionEvaluacionActualizado(evaluacionId, nuevaCalificacion)).apply();
    }

    public void modificarValorNota(ClaseId claseId, NotaId notaId, Integer valorNuevo) {
        appendChange(new ValorNotaActualizado(claseId, notaId, valorNuevo)).apply();
    }


    public Clase(ClaseId claseId) {
        super(claseId);
        subscribe(new ClaseEventChange(this));
    }

    public static Clase from(ClaseId claseId, List<DomainEvent> events) {
        var clase = new Clase((claseId));
        events.forEach(clase::applyEvent);
        return clase;
    }
}
