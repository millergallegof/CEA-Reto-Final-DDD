package co.com.sofka.capacitacionpersonas.instructor;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.capacitacionpersonas.instructor.command.AgregarPuntuacionRegistroDesempenoCommand;
import co.com.sofka.capacitacionpersonas.instructor.events.InstructorCreado;
import co.com.sofka.capacitacionpersonas.instructor.events.KilometrajeAgregado;
import co.com.sofka.capacitacionpersonas.instructor.events.PuntuacionAgregada;
import co.com.sofka.capacitacionpersonas.instructor.events.RegistroDesempenoAsociado;
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
class AgregarPuntuacionRegistroUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AgregarPuntuacionRegistroUseCase useCase;

    @Test
    void agregarPuntuacionRegistro() {
        //arrange
        InstructorId instructorId = InstructorId.of("I1234");
        RegistroDesempenoId registroDesempenoId = RegistroDesempenoId.of("R1234");
        Integer valor = 50;
        var command = new AgregarPuntuacionRegistroDesempenoCommand(instructorId, registroDesempenoId, valor);

        when(repository.getEventsBy(instructorId.value())).thenReturn(history());
        useCase.addRepository(repository);

        // act
        var events = UseCaseHandler
                .getInstance().syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // assert
        var puntuacionAgregada = (PuntuacionAgregada) events.get(0);
        Assertions.assertEquals(50, puntuacionAgregada.valor());


    }

    private List<DomainEvent> history() {
        InstructorId instructorId = InstructorId.of("I1234");
        ContratoId contratoId = ContratoId.of("C1234");
        TipoContrato tipoContrato = new TipoContrato("Fijo");
        FechaContrato fechaContrato = new FechaContrato(LocalDate.now(), LocalDate.now());
        Salario salario = new Salario(new ValorSalario("Peso", 1000000L), "mensualidad");
        RegistroDesempenoId registroDesempenoId = RegistroDesempenoId.of("R1234");
        DatosRegistro datosRegistro = new DatosRegistro("Juan");
        Observaciones observaciones = new Observaciones("Buen trabajo");
        return List.of(
                new InstructorCreado(contratoId, tipoContrato, fechaContrato, salario),
                new RegistroDesempenoAsociado(instructorId, registroDesempenoId, datosRegistro, observaciones)
        );
    }

}