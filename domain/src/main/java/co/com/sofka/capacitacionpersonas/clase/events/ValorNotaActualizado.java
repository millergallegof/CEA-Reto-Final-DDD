package co.com.sofka.capacitacionpersonas.clase.events;

import co.com.sofka.capacitacionpersonas.clase.values.ClaseId;
import co.com.sofka.capacitacionpersonas.clase.values.NotaId;
import co.com.sofka.domain.generic.DomainEvent;

public class ValorNotaActualizado extends DomainEvent {
    private final ClaseId claseId;
    private final NotaId notaId;
    private final Integer valorNuevo;

    public ValorNotaActualizado(ClaseId claseId1, NotaId notaId, Integer valorNuevo) {
        super("co.com.sofka.capacitacionpersonas.ValorNotaActualizado");
        this.claseId = claseId1;
        this.notaId = notaId;
        this.valorNuevo = valorNuevo;
    }

    public ClaseId claseId() {
        return claseId;
    }

    public NotaId notaId() {
        return notaId;
    }

    public Integer valorNuevo() {
        return valorNuevo;
    }
}
