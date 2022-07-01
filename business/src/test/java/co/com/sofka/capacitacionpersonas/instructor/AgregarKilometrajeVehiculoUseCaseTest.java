package co.com.sofka.capacitacionpersonas.instructor;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.capacitacionpersonas.instructor.command.AgregarKilometrajeVehiculoCommand;
import co.com.sofka.capacitacionpersonas.instructor.events.InstructorCreado;
import co.com.sofka.capacitacionpersonas.instructor.events.KilometrajeAgregado;
import co.com.sofka.capacitacionpersonas.instructor.events.PeriocidadSalarioModificada;
import co.com.sofka.capacitacionpersonas.instructor.events.VehiculoAsociado;
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
class AgregarKilometrajeVehiculoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AgregarKilometrajeVehiculoUseCase useCase;


    @Test
    void agregarKilometrajeVehiculo() {
        //arrange
        InstructorId instructorId = InstructorId.of("I1234");
        VehiculoId vehiculoId = VehiculoId.of("V1234");
        Long kilometraje = 10050L;
        var command = new AgregarKilometrajeVehiculoCommand(instructorId, vehiculoId, kilometraje);

        when(repository.getEventsBy(instructorId.value())).thenReturn(history());
        useCase.addRepository(repository);

        // act
        var events = UseCaseHandler
                .getInstance().syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // assert
        var kilometrajeAgregado = (KilometrajeAgregado) events.get(0);
        Assertions.assertEquals(10050L, kilometrajeAgregado.kilometraje());

    }

    private List<DomainEvent> history() {
        InstructorId instructorId = InstructorId.of("I1234");
        ContratoId contratoId = ContratoId.of("C1234");
        TipoContrato tipoContrato = new TipoContrato("Fijo");
        FechaContrato fechaContrato = new FechaContrato(LocalDate.now(), LocalDate.now());
        Salario salario = new Salario(new ValorSalario("Peso", 1000000L), "mensualidad");
        VehiculoId vehiculoId = VehiculoId.of("V1234");
        TipoVehiculo tipoVehiculo = new TipoVehiculo("Moto");
        return List.of(
                new InstructorCreado(contratoId, tipoContrato, fechaContrato, salario),
                new VehiculoAsociado(instructorId, vehiculoId, tipoVehiculo)
        );
    }
}