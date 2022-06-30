package co.com.sofka.capacitacionpersonas.instructor.events;

import co.com.sofka.capacitacionpersonas.instructor.values.VehiculoId;
import co.com.sofka.domain.generic.DomainEvent;

public class KilometrajeAgregado extends DomainEvent {
    private final VehiculoId vehiculoId;
    private final Long kilometraje;

    public KilometrajeAgregado(VehiculoId vehiculoId, Long kilometraje) {
        super("co.com.sofka.capacitacionpersonas.KilometrajeAgregado");
        this.vehiculoId = vehiculoId;
        this.kilometraje = kilometraje;
    }

    public VehiculoId vehiculoId() {
        return vehiculoId;
    }

    public Long kilometraje() {
        return kilometraje;
    }
}
