package co.com.sofka.capacitacionpersonas.clase.events;

import co.com.sofka.capacitacionpersonas.clase.values.Calificacion;
import co.com.sofka.capacitacionpersonas.clase.values.EstudianteId;
import co.com.sofka.capacitacionpersonas.clase.values.EvaluacionId;
import co.com.sofka.domain.generic.DomainEvent;

public class EvalaucionCreada extends DomainEvent {
    private final EstudianteId claseId;
    private final EvaluacionId evaluacionId;
    private final Calificacion calificacion;

    public EvalaucionCreada(EstudianteId claseId, EvaluacionId evaluacionId, Calificacion calificacion) {
        super("co.com.sofka.capacitacionpersonas.EvalaucionCreada");
        this.claseId = claseId;
        this.evaluacionId = evaluacionId;
        this.calificacion = calificacion;
    }

    public EstudianteId claseId() {
        return claseId;
    }

    public EvaluacionId evaluacionId() {
        return evaluacionId;
    }

    public Calificacion calificacion() {
        return calificacion;
    }
}
