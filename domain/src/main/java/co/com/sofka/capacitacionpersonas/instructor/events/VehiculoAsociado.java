package co.com.sofka.capacitacionpersonas.instructor.events;

import co.com.sofka.capacitacionpersonas.instructor.values.InstructorId;
import co.com.sofka.capacitacionpersonas.instructor.values.TipoVehiculo;
import co.com.sofka.capacitacionpersonas.instructor.values.VehiculoId;
import co.com.sofka.domain.generic.DomainEvent;

public class VehiculoAsociado extends DomainEvent {
    private final InstructorId instructorId;
    private final VehiculoId vehiculoId;
    private final TipoVehiculo tipoVehiculo;

    public VehiculoAsociado(InstructorId instructorId, VehiculoId vehiculoId, TipoVehiculo tipoVehiculo) {
        super("co.com.sofka.capacitacionpersonas.Vehiculoasociado");
        this.instructorId = instructorId;
        this.vehiculoId = vehiculoId;
        this.tipoVehiculo = tipoVehiculo;
    }

    public InstructorId instructorId() {
        return instructorId;
    }

    public VehiculoId vehiculoId() {
        return vehiculoId;
    }

    public TipoVehiculo tipoVehiculo() {
        return tipoVehiculo;
    }
}
