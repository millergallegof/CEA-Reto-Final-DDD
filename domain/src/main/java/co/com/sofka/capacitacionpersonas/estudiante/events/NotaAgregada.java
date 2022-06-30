package co.com.sofka.capacitacionpersonas.estudiante.events;

import co.com.sofka.capacitacionpersonas.estudiante.values.LibretaId;
import co.com.sofka.capacitacionpersonas.estudiante.values.Nota;
import co.com.sofka.domain.generic.DomainEvent;

public class NotaAgregada extends DomainEvent {
    private final LibretaId libretaId;
    private final Nota nota;

    public NotaAgregada(LibretaId libretaId, Nota nota) {
        super("co.com.sofka.capacitacionpersonas.NotaAgregada");
        this.libretaId = libretaId;
        this.nota = nota;
    }

    public LibretaId libretaId() {
        return libretaId;
    }

    public Nota nota() {
        return nota;
    }
}
