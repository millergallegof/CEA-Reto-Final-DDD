package co.com.sofka.capacitacionpersonas.clase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.capacitacionpersonas.clase.commands.ActualizarNotaValorCommand;

public class ActualizarValorNotaUseCase extends UseCase<RequestCommand<ActualizarNotaValorCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarNotaValorCommand> actualizarNotaValorCommandRequestCommand) {

        var command = actualizarNotaValorCommandRequestCommand.getCommand();
        var clase = Clase.from(
                command.claseId(), repository().getEventsBy(command.claseId().value())
        );

        clase.modificarValorNota(command.claseId(), command.notaId(), command.valorNuevo());

        emit().onResponse(new ResponseEvents(clase.getUncommittedChanges()));


    }
}
