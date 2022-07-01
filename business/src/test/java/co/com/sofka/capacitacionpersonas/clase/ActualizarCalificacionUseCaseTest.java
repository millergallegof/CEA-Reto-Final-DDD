package co.com.sofka.capacitacionpersonas.clase;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.capacitacionpersonas.clase.commands.ActualizarCalificacionCommand;
import co.com.sofka.capacitacionpersonas.clase.events.CalificacionEvaluacionActualizado;
import co.com.sofka.capacitacionpersonas.clase.events.ClaseCreada;
import co.com.sofka.capacitacionpersonas.clase.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarCalificacionUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    ActualizarCalificacionUseCase useCase;

    @Test
    void actualizarCalificacion() {
        //arrange
        EstudianteId claseId = EstudianteId.of("C1234");
        EvaluacionId evaluacionId = EvaluacionId.of("E1234");
        Integer nuevaCalificacion = 35;
        var command = new ActualizarCalificacionCommand(claseId, evaluacionId, nuevaCalificacion);

        when(repository.getEventsBy(claseId.value())).thenReturn(history());
        useCase.addRepository(repository);

        // act
        var events = UseCaseHandler
                .getInstance().syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        // assert
        var calificacionEvaluacionActualizado = (CalificacionEvaluacionActualizado)events.get(0);
        Assertions.assertEquals(35, calificacionEvaluacionActualizado.calificacion());
    }

    private List<DomainEvent> history() {
        EvaluacionId evaluacionId = EvaluacionId.of("E1234");
        Calificacion calificacion = new Calificacion(100);
        return List.of(
                new ClaseCreada(evaluacionId, calificacion)
        );
    }
}