package co.com.sofka.capacitacionpersonas.instructor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.capacitacionpersonas.instructor.command.CrearInstructorCommand;
import co.com.sofka.capacitacionpersonas.instructor.values.ContratoId;

public class CrearInstructorUseCase extends UseCase<RequestCommand<CrearInstructorCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearInstructorCommand> crearInstructorCommandRequestCommand) {
        var command = crearInstructorCommandRequestCommand.getCommand();
        var instructor = new Instructor(
                command.instructorId(),
                new ContratoId(),
                command.tipoContrato(),
                command.fechaContrato(),
                command.salario()
        );

        emit().onResponse(new ResponseEvents(instructor.getUncommittedChanges()));

    }
}
