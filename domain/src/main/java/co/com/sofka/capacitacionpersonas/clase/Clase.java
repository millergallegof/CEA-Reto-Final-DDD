package co.com.sofka.capacitacionpersonas.clase;

import co.com.sofka.capacitacionpersonas.clase.values.ClaseId;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.List;

public class Clase extends AggregateEvent<ClaseId> {

    protected Tema tema;
    protected Evaluacion evaluacion;
    protected List<Nota> notas;

    public Clase(ClaseId entityId, Tema tema, Evaluacion evaluacion) {
        super(entityId);

    }
}
