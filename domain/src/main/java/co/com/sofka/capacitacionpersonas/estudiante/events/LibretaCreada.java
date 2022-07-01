package co.com.sofka.capacitacionpersonas.estudiante.events;

import co.com.sofka.capacitacionpersonas.estudiante.values.Datos;
import co.com.sofka.capacitacionpersonas.estudiante.values.LibretaId;
import co.com.sofka.domain.generic.DomainEvent;

public class LibretaCreada extends DomainEvent {
    private final LibretaId libretaId;
    private final Datos datos;

    public LibretaCreada(LibretaId libretaId, Datos datos) {
        super("co.com.sofka.capacitacionpersonas.LibretaCreada");
        this.libretaId = libretaId;
        this.datos = datos;
    }

    public LibretaId libretaId() {
        return libretaId;
    }

    public Datos datos() {
        return datos;
    }
}
