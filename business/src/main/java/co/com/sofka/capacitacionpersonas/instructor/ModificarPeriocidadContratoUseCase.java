package co.com.sofka.capacitacionpersonas.instructor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.capacitacionpersonas.instructor.command.ModificarPeriocidadContratoCommand;

public class ModificarPeriocidadContratoUseCase extends UseCase<RequestCommand<ModificarPeriocidadContratoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarPeriocidadContratoCommand> modificarPeriocidadContratoCommandRequestCommand) {
        var command = modificarPeriocidadContratoCommandRequestCommand.getCommand();
        var instructor = Instructor.from(
                command.instructorId(), repository().getEventsBy(command.instructorId().value())
        );

        instructor.modificarPeriocidadContrato(command.contratoId(), command.nuevaPeriocidad());

        emit().onResponse(new ResponseEvents(instructor.getUncommittedChanges()));

    }
}
