package co.com.sofka.capacitacionpersonas.clase.events;

import co.com.sofka.capacitacionpersonas.clase.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class ClaseCreada extends DomainEvent {

    private final EvaluacionId evaluacionId;
    private final Calificacion calificacion;

    public ClaseCreada(EvaluacionId evaluacionId, Calificacion calificacion) {
        super("co.com.sofka.capacitacionpersonas.ClaseCreada");
        this.evaluacionId = evaluacionId;
        this.calificacion = calificacion;
    }


    public Calificacion calificacion() {
        return calificacion;
    }

    public EvaluacionId evaluacionId() {
        return evaluacionId;
    }
}
