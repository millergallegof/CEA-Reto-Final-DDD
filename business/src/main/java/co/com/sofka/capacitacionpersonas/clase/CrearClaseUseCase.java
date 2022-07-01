package co.com.sofka.capacitacionpersonas.clase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.capacitacionpersonas.clase.commands.CrearClaseCommand;
import co.com.sofka.capacitacionpersonas.clase.values.EstudianteId;
import co.com.sofka.capacitacionpersonas.clase.values.TemaId;

public class CrearClaseUseCase extends UseCase<RequestCommand<CrearClaseCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearClaseCommand> crearClaseCommandRequestCommand) {
        var command = crearClaseCommandRequestCommand.getCommand();
        var clase = new Clase(
                new EstudianteId(),
                new TemaId(),
                command.nombre(),
                command.duracion(),
                command.evaluacionId(),
                command.calificacion()
        );
        emit().onResponse(new ResponseEvents(clase.getUncommittedChanges()));

    }
}
