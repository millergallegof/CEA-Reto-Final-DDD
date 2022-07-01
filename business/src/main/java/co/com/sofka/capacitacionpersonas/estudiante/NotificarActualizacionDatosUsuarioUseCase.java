package co.com.sofka.capacitacionpersonas.estudiante;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

import co.com.sofka.capacitacionpersonas.estudiante.events.DatosUsuActualizado;
import co.com.sofka.capacitacionpersonas.estudiante.service.EmailCambioCategoriaLicenciaService;

import java.util.List;

public class NotificarActualizacionDatosUsuarioUseCase extends UseCase<TriggeredEvent<DatosUsuActualizado>, ResponseEvents> {


    @Override
    public void executeUseCase(TriggeredEvent<DatosUsuActualizado> datosUsuActualizadoTriggeredEvent) {
        var event = datosUsuActualizadoTriggeredEvent.getDomainEvent();

        var service = getService(EmailCambioCategoriaLicenciaService.class).orElseThrow();

        String body = String.format("Sus datos han sido actualizados su nuevo email es %s, y su telefono es %s", event.email(), event.telefono());
        service.enviarCorreoCambioCatgoria(event.estudianteId(), body);

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
