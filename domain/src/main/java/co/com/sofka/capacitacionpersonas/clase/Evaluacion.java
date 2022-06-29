package co.com.sofka.capacitacionpersonas.clase;

import co.com.sofka.capacitacionpersonas.clase.values.Calificacion;
import co.com.sofka.capacitacionpersonas.clase.values.EvaluacionId;
import co.com.sofka.domain.generic.Entity;

public class Evaluacion extends Entity<EvaluacionId> {
    private Calificacion calificacion;

    public Evaluacion(EvaluacionId entityId, Calificacion calificacion) {
        super(entityId);
        this.calificacion = calificacion;
    }

}
