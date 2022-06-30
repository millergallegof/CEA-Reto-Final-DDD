package co.com.sofka.capacitacionpersonas.estudiante.events;

import co.com.sofka.capacitacionpersonas.estudiante.values.LibretaId;
import co.com.sofka.domain.generic.DomainEvent;

public class ValorNotaLibretaModificada extends DomainEvent {
    private final LibretaId libretaId;
    private final Integer valorNotaNueva;

    public ValorNotaLibretaModificada(LibretaId libretaId, Integer valorNotaNueva) {
        super("co.com.sofka.capacitacionpersonas.ValorNotaLibretaModificada");
        this.libretaId = libretaId;
        this.valorNotaNueva = valorNotaNueva;
    }

    public LibretaId libretaId() {
        return libretaId;
    }

    public Integer valorNotaNueva() {
        return valorNotaNueva;
    }
}
