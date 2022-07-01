package co.com.sofka.capacitacionpersonas.instructor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.capacitacionpersonas.instructor.command.AgregarKilometrajeVehiculoCommand;

public class AgregarKilometrajeVehiculoUseCase extends UseCase<RequestCommand<AgregarKilometrajeVehiculoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarKilometrajeVehiculoCommand> agregarKilometrajeVehiculoCommandRequestCommand) {
        var command = agregarKilometrajeVehiculoCommandRequestCommand.getCommand();

        var instructor = Instructor.from(
                command.instructorId(), repository().getEventsBy(command.instructorId().value())
        );

        instructor.agregarKilometraje(command.vehiculoId(), command.kilometraje());

        emit().onResponse(new ResponseEvents(instructor.getUncommittedChanges()));
    }
}
