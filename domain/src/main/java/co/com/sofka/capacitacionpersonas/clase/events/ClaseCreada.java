package co.com.sofka.capacitacionpersonas.clase.events;

import co.com.sofka.capacitacionpersonas.clase.values.*;
import co.com.sofka.capacitacionpersonas.instructor.values.InstructorId;
import co.com.sofka.domain.generic.DomainEvent;

public class ClaseCreada extends DomainEvent {

    private final EvaluacionId evaluacionId;
    private final InstructorId instructorId;
    private final Calificacion calificacion;

    public ClaseCreada(InstructorId instructorId, EvaluacionId evaluacionId, Calificacion calificacion) {
        super("co.com.sofka.capacitacionpersonas.ClaseCreada");
        this.evaluacionId = evaluacionId;
        this.instructorId = instructorId;
        this.calificacion = calificacion;
    }

    public InstructorId instructorId() {
        return instructorId;
    }

    public Calificacion calificacion() {
        return calificacion;
    }

    public EvaluacionId evaluacionId() {
        return evaluacionId;
    }
}
