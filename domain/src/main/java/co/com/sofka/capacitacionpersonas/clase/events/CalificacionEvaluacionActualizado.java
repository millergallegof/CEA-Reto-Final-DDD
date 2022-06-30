package co.com.sofka.capacitacionpersonas.clase.events;

import co.com.sofka.capacitacionpersonas.clase.values.EvaluacionId;
import co.com.sofka.domain.generic.DomainEvent;

public class CalificacionEvaluacionActualizado extends DomainEvent {
    private final EvaluacionId evaluacionId;
    private final Integer nuevaCalificacion;

    public CalificacionEvaluacionActualizado(EvaluacionId evaluacionId, Integer nuevaCalificacion) {
        super("co.com.sofka.capacitacionpersonas.CalificacionEvaluacionActualizado");

        this.evaluacionId = evaluacionId;
        this.nuevaCalificacion = nuevaCalificacion;
    }

    public EvaluacionId evaluacionId() {
        return evaluacionId;
    }

    public Integer calificacion() {
        return nuevaCalificacion;
    }
}
