package co.com.sofka.capacitacionpersonas.clase.events;

import co.com.sofka.capacitacionpersonas.clase.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class ClaseCreada extends DomainEvent {

    private final TemaId temaId;
    private final Nombre nombre;
    private final Duracion duracion;
    private final EvaluacionId evaluacionId;
    private final Calificacion calificacion;

    public ClaseCreada(TemaId temaId, Nombre nombre, Duracion duracion, EvaluacionId evaluacionId, Calificacion calificacion) {
        super("co.com.sofka.capacitacionpersonas.ClaseCreada");
        this.temaId = temaId;
        this.nombre = nombre;
        this.duracion = duracion;
        this.evaluacionId = evaluacionId;
        this.calificacion = calificacion;
    }

    public TemaId getTemaId() {
        return temaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Duracion getDuracion() {
        return duracion;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public EvaluacionId getEvaluacionId() {
        return evaluacionId;
    }
}
