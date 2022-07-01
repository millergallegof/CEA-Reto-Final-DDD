package co.com.sofka.capacitacionpersonas.clase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.capacitacionpersonas.clase.events.ValorNotaActualizado;
import co.com.sofka.capacitacionpersonas.clase.service.EmailService;
import co.com.sofka.capacitacionpersonas.clase.values.ClaseId;

import java.util.List;

public class NotificarCambioNotaUseCase extends UseCase<TriggeredEvent<ValorNotaActualizado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ValorNotaActualizado> valorNotaActualizadoTriggeredEvent) {
        var event = valorNotaActualizadoTriggeredEvent.getDomainEvent();

//        var clase = Clase.from(
//
//                ClaseId.of(event.aggregateRootId()), -> Esto trae o crea el id del agregado root
//                repository().getEventsBy(event.aggregateRootId())

        var service = getService(EmailService.class).orElseThrow();

        String body = String.format("Su Nota cambio de valor a %s", event.valorNuevo());
        service.enviarCorreo(event.claseId(), body);

        emit().onResponse(new ResponseEvents(List.of()));

    }
}
