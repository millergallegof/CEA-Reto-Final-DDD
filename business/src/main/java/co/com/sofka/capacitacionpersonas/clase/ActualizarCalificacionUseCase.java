package co.com.sofka.capacitacionpersonas.clase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.capacitacionpersonas.clase.commands.ActualizarCalificacionCommand;

public class ActualizarCalificacionUseCase extends UseCase<RequestCommand<ActualizarCalificacionCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarCalificacionCommand> actualizarCalificacionCommandRequestCommand) {
        var command = actualizarCalificacionCommandRequestCommand.getCommand();
        var clase = Clase.from(
                command.claseId(), repository().getEventsBy(command.claseId().value())
        );

        clase.modificarCalificacionEvaluacion(command.evaluacionId(), command.nuevaCalificacion());

        emit().onResponse(new ResponseEvents(clase.getUncommittedChanges()));
    }
}
