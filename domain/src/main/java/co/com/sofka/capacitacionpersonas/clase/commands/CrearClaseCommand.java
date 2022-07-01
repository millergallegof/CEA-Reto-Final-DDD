package co.com.sofka.capacitacionpersonas.clase.commands;

import co.com.sofka.capacitacionpersonas.clase.values.*;
import co.com.sofka.domain.generic.Command;

public class CrearClaseCommand extends Command {
    private final EstudianteId entityId;
    private final TemaId temaId;
    private final Nombre nombre;
    private final Duracion duracion;
    private final EvaluacionId evaluacionId;
    private final Calificacion calificacion;

    public CrearClaseCommand(EstudianteId entityId, TemaId temaId, Nombre nombre, Duracion duracion, EvaluacionId evaluacionId, Calificacion calificacion) {
        this.entityId = entityId;
        this.temaId = temaId;
        this.nombre = nombre;
        this.duracion = duracion;
        this.evaluacionId = evaluacionId;
        this.calificacion = calificacion;
    }

    public EstudianteId entityId() {
        return entityId;
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
