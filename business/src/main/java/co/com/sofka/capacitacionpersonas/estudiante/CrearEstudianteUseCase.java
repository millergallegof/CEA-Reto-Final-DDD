package co.com.sofka.capacitacionpersonas.estudiante;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.capacitacionpersonas.estudiante.commands.CrearEstudianteCommand;

public class CrearEstudianteUseCase extends UseCase<RequestCommand<CrearEstudianteCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearEstudianteCommand> crearEstudianteCommandRequestCommand) {

    }
}
