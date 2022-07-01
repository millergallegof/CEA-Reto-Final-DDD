package co.com.sofka.capacitacionpersonas.clase.commands;

import co.com.sofka.capacitacionpersonas.clase.values.*;
import co.com.sofka.capacitacionpersonas.instructor.values.InstructorId;
import co.com.sofka.domain.generic.Command;

public class CrearClaseCommand extends Command {
    private final ClaseId entityId;
    private final InstructorId instructorId;
    private final TemaId temaId;
    private final Nombre nombre;
    private final Duracion duracion;
    private final EvaluacionId evaluacionId;
    private final Calificacion calificacion;

    public CrearClaseCommand(ClaseId entityId, InstructorId instructorId, TemaId temaId, Nombre nombre, Duracion duracion, EvaluacionId evaluacionId, Calificacion calificacion) {
        this.entityId = entityId;
        this.instructorId = instructorId;
        this.temaId = temaId;
        this.nombre = nombre;
        this.duracion = duracion;
        this.evaluacionId = evaluacionId;
        this.calificacion = calificacion;
    }

    public ClaseId entityId() {
        return entityId;
    }

    public InstructorId instructorId() {
        return instructorId;
    }

    public TemaId temaId() {
        return temaId;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Duracion duracion() {
        return duracion;
    }

    public EvaluacionId evaluacionId() {
        return evaluacionId;
    }

    public Calificacion calificacion() {
        return calificacion;
    }
}
