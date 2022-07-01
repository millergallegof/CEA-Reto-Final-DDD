package co.com.sofka.capacitacionpersonas.instructor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.capacitacionpersonas.instructor.command.AgregarPuntuacionRegistroDesempenoCommand;

public class AgregarPuntuacionRegistroUseCase extends UseCase<RequestCommand<AgregarPuntuacionRegistroDesempenoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPuntuacionRegistroDesempenoCommand> agregarPuntuacionRegistroDesempenoCommandRequestCommand) {
        var command = agregarPuntuacionRegistroDesempenoCommandRequestCommand.getCommand();
        var instructor = Instructor.from(
                command.instructorId(), repository().getEventsBy(command.instructorId().value())
        );

        instructor.agregarPuntuacion(command.registroDesempenoId(), command.valor());

        emit().onResponse(new ResponseEvents(instructor.getUncommittedChanges()));
    }
}
