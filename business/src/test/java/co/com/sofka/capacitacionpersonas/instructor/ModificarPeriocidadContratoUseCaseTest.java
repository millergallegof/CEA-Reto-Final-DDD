package co.com.sofka.capacitacionpersonas.instructor;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.capacitacionpersonas.instructor.command.ModificarPeriocidadContratoCommand;
import co.com.sofka.capacitacionpersonas.instructor.events.InstructorCreado;
import co.com.sofka.capacitacionpersonas.instructor.events.PeriocidadSalarioModificada;
import co.com.sofka.capacitacionpersonas.instructor.values.*;
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
class ModificarPeriocidadContratoUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    ModificarPeriocidadContratoUseCase useCase;

    @Test
    void modificarPeriocidadContrato() {
        //arrange
        InstructorId instructorId = InstructorId.of("I1234");
        ContratoId contratoId = ContratoId.of("C1234");
        String nuevaPeriocidad = "Mensual";
        var command = new ModificarPeriocidadContratoCommand(instructorId, contratoId, nuevaPeriocidad);

        when(repository.getEventsBy(instructorId.value())).thenReturn(history());
        useCase.addRepository(repository);

        // act
        var events = UseCaseHandler
                .getInstance().syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // assert
        var periocidadSalarioModificada = (PeriocidadSalarioModificada) events.get(0);
        Assertions.assertEquals("Mensual", periocidadSalarioModificada.nuevaPeriocidad());
    }

    private List<DomainEvent> history() {
        InstructorId instructorId = InstructorId.of("I1234");
        ContratoId contratoId = ContratoId.of("C1234");
        TipoContrato tipoContrato = new TipoContrato("Fijo");
        FechaContrato fechaContrato = new FechaContrato(LocalDate.now(), LocalDate.now());
        Salario salario = new Salario(new ValorSalario("Peso", 1000000L), "mensualidad");
        return List.of(
                new InstructorCreado(contratoId, tipoContrato, fechaContrato, salario)
        );
    }


}