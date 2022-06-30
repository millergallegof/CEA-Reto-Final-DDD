package co.com.sofka.capacitacionpersonas.clase.events;

import co.com.sofka.capacitacionpersonas.clase.values.NotaId;
import co.com.sofka.capacitacionpersonas.clase.values.ValorNota;
import co.com.sofka.domain.generic.DomainEvent;

public class ValorNotaActualizado extends DomainEvent {
    private final NotaId notaId;
    private final Integer valorNuevo;

    public ValorNotaActualizado(NotaId notaId, Integer valorNuevo) {
        super("co.com.sofka.capacitacionpersonas.ValorNotaActualizado");
        this.notaId = notaId;
        this.valorNuevo = valorNuevo;
    }

    public NotaId notaId() {
        return notaId;
    }

    public Integer valorNuevo() {
        return valorNuevo;
    }
}
