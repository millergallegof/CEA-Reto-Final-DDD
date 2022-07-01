package co.com.sofka.capacitacionpersonas.instructor.command;

import co.com.sofka.capacitacionpersonas.instructor.values.InstructorId;
import co.com.sofka.capacitacionpersonas.instructor.values.VehiculoId;
import co.com.sofka.domain.generic.Command;

public class AgregarKilometrajeVehiculoCommand extends Command {
    private final InstructorId instructorId;
    private final VehiculoId vehiculoId;
    private final Long kilometraje;

    public AgregarKilometrajeVehiculoCommand(InstructorId instructorId, VehiculoId vehiculoId, Long kilometraje) {
        this.instructorId = instructorId;
        this.vehiculoId = vehiculoId;
        this.kilometraje = kilometraje;
    }

    public InstructorId instructorId() {
        return instructorId;
    }

    public VehiculoId vehiculoId() {
        return vehiculoId;
    }

    public Long kilometraje() {
        return kilometraje;
    }
}
