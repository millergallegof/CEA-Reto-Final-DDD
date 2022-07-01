package co.com.sofka.capacitacionpersonas.estudiante;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.capacitacionpersonas.clase.values.EstudianteId;
import co.com.sofka.capacitacionpersonas.estudiante.events.DatosUsuActualizado;
import co.com.sofka.capacitacionpersonas.estudiante.service.EmailCambioCategoriaLicenciaService;
import co.com.sofka.capacitacionpersonas.estudiante.values.CuentaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NotificarActualizacionDatosUsuarioUseCaseTest {

    @Mock
    EmailCambioCategoriaLicenciaService service;

    @InjectMocks
    NotificarActualizacionDatosUsuarioUseCase useCase;

    @Test
    void notificarActualizacionDatosusuario() {

        EstudianteId estudianteId = EstudianteId.of("C1234");
        CuentaId cuentaId = CuentaId.of("Cu1234");
        String email = "miller.gallegof@gmail.com";
        String telefono = "3107961838";
        var event = new DatosUsuActualizado(estudianteId, cuentaId, email, telefono);

        Mockito.doNothing().when(service).enviarCorreoCambioCatgoria(estudianteId, "Sus datos han sido actualizados su nuevo email es miller.gallegof@gmail.com, y su telefono es 3107961838");

        useCase.addServiceBuilder(new ServiceBuilder().addService(service));

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        Mockito.verify(service).enviarCorreoCambioCatgoria(estudianteId, "Sus datos han sido actualizados su nuevo email es miller.gallegof@gmail.com, y su telefono es 3107961838");

        Assertions.assertEquals(0, events.size());
    }

}