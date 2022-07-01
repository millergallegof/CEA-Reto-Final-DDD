package co.com.sofka.capacitacionpersonas.clase;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.capacitacionpersonas.clase.events.ValorNotaActualizado;
import co.com.sofka.capacitacionpersonas.clase.service.EmailService;
import co.com.sofka.capacitacionpersonas.clase.values.EstudianteId;
import co.com.sofka.capacitacionpersonas.clase.values.NotaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NotificarCambioNotauseCaseTest {

    //    utiliza el servicio que es la interfaz- NO UTILIZAR EL DomainEventRepository
    @Mock
    EmailService serviceEmail;

    @InjectMocks
    NotificarCambioNotaUseCase useCase;

    @Test
    void enviarCorreoCambioNota() {
        // creacion del evento
        NotaId notaId = NotaId.of("N1234");
        Integer valorNuevo = 40;
        EstudianteId claseId = EstudianteId.of("C1234");
        var event = new ValorNotaActualizado(claseId, notaId, valorNuevo);

//        SE MOQUEA EL SERVICIO - utilizando el when para inyectar el usecase-servicio
//        se utiliza el metodo Mockito con su metodo doNothing para que no retorne nada
        Mockito.doNothing().when(serviceEmail).enviarCorreo(claseId, "Su Nota cambio de valor a 40");

//      al caso de uso se le agrega el servicio que moqueamos anteriormente
//        NOTA -> Se pueden tener varios servicios en un mismo caso de uso
        useCase.addServiceBuilder(new ServiceBuilder().addService(serviceEmail));
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

//        se hace la verificacion con el metodo verify
        Mockito.verify(serviceEmail).enviarCorreo(claseId, "Su Nota cambio de valor a 40");
//        se verifica que no existan eventos ya que cuando moqueamos le damos el metodo de que no haga nada
        Assertions.assertEquals(0, events.size());


    }

}