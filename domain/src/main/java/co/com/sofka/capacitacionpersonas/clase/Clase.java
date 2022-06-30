package co.com.sofka.capacitacionpersonas.clase;

import co.com.sofka.capacitacionpersonas.clase.events.ClaseCreada;
import co.com.sofka.capacitacionpersonas.clase.events.EvalaucionCreada;
import co.com.sofka.capacitacionpersonas.clase.events.TemaCreado;
import co.com.sofka.capacitacionpersonas.clase.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Clase extends AggregateEvent<ClaseId> {

    protected Tema tema;
    protected Evaluacion evaluacion;
    protected List<Nota> notas;

    public Clase(ClaseId entityId, TemaId temaId, Nombre nombre, Duracion duracion, EvaluacionId evaluacionId, Calificacion calificacion) {
        super(entityId);
        appendChange(new ClaseCreada(temaId, nombre, duracion, evaluacionId, calificacion)).apply();
        subscribe(new ClaseEventChange(this));
    }

    public void crearTema(ClaseId claseId, Nombre nombre, Duracion duracion) {
        appendChange(new TemaCreado(claseId, nombre, duracion)).apply();
    }

    public void crearEvaluacion(ClaseId claseId, EvaluacionId evaluacionId, Calificacion calificacion) {
        appendChange(new EvalaucionCreada(claseId, evaluacionId, calificacion)).apply();
    }

    public void crearNota(EstudianteNota estudianteNota, FechaNota fechaNota, ValorNota valorNota) {
        var notaId = new NotaId();
        appendChange(new NotaCreada(notaId, estudianteNota, fechaNota, valorNota)).apply();
    }

    public Clase(ClaseId claseId) {
        super(claseId);
        subscribe(new ClaseEventChange(this));
    }

    public static Clase from(ClaseId claseId, List<DomainEvent> events){
        var clase = new Clase((claseId));
        events.forEach(clase::applyEvent);
        return clase;
    }
}
