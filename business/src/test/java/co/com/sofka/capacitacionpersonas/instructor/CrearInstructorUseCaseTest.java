package co.com.sofka.capacitacionpersonas.instructor;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.capacitacionpersonas.instructor.command.CrearInstructorCommand;
import co.com.sofka.capacitacionpersonas.instructor.events.InstructorCreado;
import co.com.sofka.capacitacionpersonas.instructor.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;



@ExtendWith(MockitoExtension.class)
class CrearInstructorUseCaseTest {
    @InjectMocks
    CrearInstructorUseCase useCase;

    @Test
    void crearInstructor() {
        //arrange
        InstructorId instructorId = InstructorId.of("I1234");
        ContratoId contratoId = ContratoId.of("C1234");
        TipoContrato tipoContrato = new TipoContrato("Fijo");
        FechaContrato fechaContrato = new FechaContrato(LocalDate.now(), LocalDate.now());
        Salario salario = new Salario(new ValorSalario("Peso", 1000000L), "mensualidad");
        var command = new CrearInstructorCommand(instructorId, contratoId, tipoContrato, fechaContrato, salario);
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var instructorCreado = (InstructorCreado)events.get(0);

        Assertions.assertEquals("Fijo", instructorCreado.tipoContrato().value());

    }

}