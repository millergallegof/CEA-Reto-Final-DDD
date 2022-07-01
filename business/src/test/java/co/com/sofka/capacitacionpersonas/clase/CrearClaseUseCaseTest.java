package co.com.sofka.capacitacionpersonas.clase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.capacitacionpersonas.clase.commands.CrearClaseCommand;
import co.com.sofka.capacitacionpersonas.clase.events.ClaseCreada;
import co.com.sofka.capacitacionpersonas.clase.events.TemaCreado;
import co.com.sofka.capacitacionpersonas.clase.values.*;
import co.com.sofka.capacitacionpersonas.estudiante.events.MatriculaCreada;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CrearClaseUseCaseTest {
    @InjectMocks
    CrearClaseUseCase useCase;

    @Test
    void crearClase() {
        //arrage
        ClaseId claseId = ClaseId.of("C1234");
        TemaId temaId = TemaId.of("T1234");
        Nombre nombre = new Nombre("Frenos");
        Duracion duracion = new Duracion(5, "conduccion");
        EvaluacionId evaluacionId = EvaluacionId.of("E1234");
        Calificacion calificacion = new Calificacion(100);
        var command = new CrearClaseCommand(claseId, temaId, nombre, duracion, evaluacionId, calificacion);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var claseCreada = (ClaseCreada)events.get(0);
        var matriculaCreada = (TemaCreado)events.get(1);

        Assertions.assertEquals(100, claseCreada.calificacion().value());
        Assertions.assertEquals("Frenos", matriculaCreada.nombre().value());

    }
}