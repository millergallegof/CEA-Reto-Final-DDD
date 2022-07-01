package co.com.sofka.capacitacionpersonas.estudiante;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.capacitacionpersonas.estudiante.commands.CrearEstudianteCommand;
import co.com.sofka.capacitacionpersonas.estudiante.values.LibretaId;
import co.com.sofka.capacitacionpersonas.estudiante.values.TipoMatricula;
import co.com.sofka.capacitacionpersonas.estudiante.values.ValorMatricula;

public class CrearEstudianteUseCase extends UseCase<RequestCommand<CrearEstudianteCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearEstudianteCommand> crearEstudianteCommandRequestCommand) {
        var command = crearEstudianteCommandRequestCommand.getCommand();
        var estudiante = new Estudiante(
                command.estudianteId(),
                command.matriculaId(),
                command.valorMatricula(),
                command.tipoMatricula(),
                command.cuentaId(),
                command.tipoCuenta(),
                command.datosUsuario(),
                new LibretaId(),
                command.datos()

        );

        emit().onResponse(new ResponseEvents(estudiante.getUncommittedChanges()));
    }
}
