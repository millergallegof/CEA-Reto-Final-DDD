package co.com.sofka.capacitacionpersonas.estudiante;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.capacitacionpersonas.estudiante.commands.ModificarValorNotaLibretaCommand;
import co.com.sofka.capacitacionpersonas.estudiante.values.EstudianteId;

public class ModificarValorNotaLibretaUseCase extends UseCase<RequestCommand<ModificarValorNotaLibretaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarValorNotaLibretaCommand> modificarValorNotaLibretaCommandRequestCommand) {
        var command = modificarValorNotaLibretaCommandRequestCommand.getCommand();
        var estudiante = Estudiante.from(
                command.estudianteId(), repository().getEventsBy(command.estudianteId().value())

        );

        estudiante.modificarValorNotaLibreta(command.libretaId(), command.valorNotaNueva());

        emit().onResponse(new ResponseEvents(estudiante.getUncommittedChanges()));
    }
}
