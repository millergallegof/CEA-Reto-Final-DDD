package co.com.sofka.capacitacionpersonas.clase.events;

import co.com.sofka.capacitacionpersonas.clase.values.Duracion;
import co.com.sofka.capacitacionpersonas.clase.values.Nombre;
import co.com.sofka.capacitacionpersonas.clase.values.TemaId;
import co.com.sofka.domain.generic.DomainEvent;

public class TemaCreado extends DomainEvent {

    private final TemaId temaId;
    private final Nombre nombre;
    private final Duracion duracion;

    public TemaCreado(TemaId temaId, Nombre nombre, Duracion duracion) {
        super("co.com.sofka.capacitacionpersonas.TemaCreado");
        this.temaId = temaId;
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public TemaId temaId() {
        return temaId;
    }


    public Nombre nombre() {
        return nombre;
    }

    public Duracion duracion() {
        return duracion;
    }
}
