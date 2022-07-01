package co.com.sofka.capacitacionpersonas.clase;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.capacitacionpersonas.clase.commands.ActualizarNotaValorCommand;
import co.com.sofka.capacitacionpersonas.clase.events.ClaseCreada;
import co.com.sofka.capacitacionpersonas.clase.events.NotaAsociada;
import co.com.sofka.capacitacionpersonas.clase.events.ValorNotaActualizado;
import co.com.sofka.capacitacionpersonas.clase.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarValorNotaUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    ActualizarValorNotaUseCase useCase;

    @Test
    void actualizarValorNota() {
        //arrange
        EstudianteId claseId = EstudianteId.of("C1234");
        NotaId notaId = NotaId.of("N1234");
        Integer valorNuevo = 35;
        var command = new ActualizarNotaValorCommand(claseId, notaId, valorNuevo);

        when(repository.getEventsBy(claseId.value())).thenReturn(history());
        useCase.addRepository(repository);

        // act
        var events = UseCaseHandler
                .getInstance().syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // assert
        var valorNotaActualizado = (ValorNotaActualizado) events.get(0);
        Assertions.assertEquals(35, valorNotaActualizado.valorNuevo());

    }

    private List<DomainEvent> history() {
        NotaId notaId = NotaId.of("N1234");
        EstudianteNota estudianteNota = new EstudianteNota("Miller");
        FechaNota fechaNota = new FechaNota(LocalDate.now());
        ValorNota valorNota = new ValorNota("Frenos", 25);
        EvaluacionId evaluacionId = EvaluacionId.of("E1234");
        Calificacion calificacion = new Calificacion(100);
        return List.of(
                new ClaseCreada(evaluacionId, calificacion),
                new NotaAsociada(notaId, estudianteNota, fechaNota, valorNota)
        );

    }
}