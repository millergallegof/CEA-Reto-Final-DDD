package co.com.sofka.capacitacionpersonas.instructor.events;

import co.com.sofka.capacitacionpersonas.instructor.values.RegistroDesempenoId;
import co.com.sofka.domain.generic.DomainEvent;

public class PuntuacionAgregada extends DomainEvent {
    private final RegistroDesempenoId registroDesempenoId;
    private final Integer valor;

    public PuntuacionAgregada(RegistroDesempenoId registroDesempenoId, Integer valor) {
        super("co.com.sofka.capacitacionpersonas.PuntuacionAgregada");
        this.registroDesempenoId = registroDesempenoId;
        this.valor = valor;
    }

    public RegistroDesempenoId registroDesempenoId() {
        return registroDesempenoId;
    }

    public Integer valor() {
        return valor;
    }
}
