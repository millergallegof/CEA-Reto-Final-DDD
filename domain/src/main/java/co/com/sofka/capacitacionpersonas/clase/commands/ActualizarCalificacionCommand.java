package co.com.sofka.capacitacionpersonas.clase.commands;

import co.com.sofka.capacitacionpersonas.clase.values.ClaseId;
import co.com.sofka.capacitacionpersonas.clase.values.EvaluacionId;
import co.com.sofka.domain.generic.Command;

public class ActualizarCalificacionCommand extends Command {
    private final ClaseId claseId;
    private final EvaluacionId evaluacionId;
    private final Integer nuevaCalificacion;

    public ActualizarCalificacionCommand(ClaseId claseId, EvaluacionId evaluacionId, Integer nuevaCalificacion) {
        this.claseId = claseId;
        this.evaluacionId = evaluacionId;
        this.nuevaCalificacion = nuevaCalificacion;
    }

    public ClaseId claseId() {
        return claseId;
    }

    public EvaluacionId evaluacionId() {
        return evaluacionId;
    }

    public Integer nuevaCalificacion() {
        return nuevaCalificacion;
    }
}
