package co.com.sofka.capacitacionpersonas.clase.events;

import co.com.sofka.capacitacionpersonas.clase.values.ClaseId;
import co.com.sofka.capacitacionpersonas.clase.values.Duracion;
import co.com.sofka.capacitacionpersonas.clase.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class TemaCreado extends DomainEvent {

    private final ClaseId claseId;
    private final Nombre nombre;
    private final Duracion duracion;

    public TemaCreado(ClaseId claseId, Nombre nombre, Duracion duracion) {
        super("co.com.sofka.capacitacionpersonas.TemaCreado");
        this.claseId = claseId;
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public ClaseId getClaseId() {
        return claseId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
