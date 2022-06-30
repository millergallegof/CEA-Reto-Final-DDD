package co.com.sofka.capacitacionpersonas.instructor.events;

import co.com.sofka.capacitacionpersonas.instructor.values.ContratoId;
import co.com.sofka.domain.generic.DomainEvent;

public class PeriocidadSalarioModificada extends DomainEvent {
    private final ContratoId contratoId;
    private final String nuevaPeriocidad;

    public PeriocidadSalarioModificada(ContratoId contratoId, String nuevaPeriocidad) {
        super("co.com.sofka.capacitacionpersonas.PeriocidadSalarioModificada");
        this.contratoId = contratoId;
        this.nuevaPeriocidad = nuevaPeriocidad;
    }

    public ContratoId contratoId() {
        return contratoId;
    }

    public String nuevaPeriocidad() {
        return nuevaPeriocidad;
    }
}
