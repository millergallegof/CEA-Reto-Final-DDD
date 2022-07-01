package co.com.sofka.capacitacionpersonas.estudiante;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.capacitacionpersonas.estudiante.commands.CambiarCategoriaLicenciaCommand;

public class CambiarCategoriaLicenciaUseCase extends UseCase<RequestCommand<CambiarCategoriaLicenciaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarCategoriaLicenciaCommand> cambiarCategoriaLicenciaCommandRequestCommand) {
        var command = cambiarCategoriaLicenciaCommandRequestCommand.getCommand();
        var estudiante = Estudiante.from(
                command.estudianteId(), repository().getEventsBy(command.estudianteId().value())

        );

        estudiante.cambiarCategoriaLicencia(command.matriculaId(), command.categoria());

        emit().onResponse(new ResponseEvents(estudiante.getUncommittedChanges()));
    }
}
