package co.com.sofka.capacitacionpersonas.estudiante;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.capacitacionpersonas.clase.values.ClaseId;
import co.com.sofka.capacitacionpersonas.estudiante.commands.ModificarValorNotaLibretaCommand;
import co.com.sofka.capacitacionpersonas.estudiante.events.*;
import co.com.sofka.capacitacionpersonas.estudiante.values.*;
import co.com.sofka.capacitacionpersonas.instructor.values.InstructorId;
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
class ModificarValorNotaLibretaUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    ModificarValorNotaLibretaUseCase useCase;

    @Test
    void modificarValorNotaLicencia() {
        //arrange
        EstudianteId estudianteId = EstudianteId.of(EstudianteId.Type.CC, "E1234");
        LibretaId libretaId = LibretaId.of("L1234");
        Integer valorNotaNueva = 50;
        var command = new ModificarValorNotaLibretaCommand(estudianteId, libretaId, valorNotaNueva);

        when(repository.getEventsBy(estudianteId.value())).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var valorNotaLibretaModificada = (ValorNotaLibretaModificada) events.get(0);
        Assertions.assertEquals(50, valorNotaLibretaModificada.valorNotaNueva());

    }

    private List<DomainEvent> history() {
        ClaseId claseId = ClaseId.of("Cl1234");
        InstructorId instructorId = InstructorId.of("I1234");
        TipoCuenta tipoCuenta = new TipoCuenta("Estudiante");
        CuentaId cuentaId = CuentaId.of("C1234");
        DatosUsuario datosUsuario = new DatosUsuario("esteban@gmail.com", "12345");
        LibretaId libretaId = LibretaId.of("L1234");
        Datos datos = new Datos("Miller", "310");
        Nota nota = new Nota("Frenos", 50);
        return List.of(
                new EstudianteCreado(claseId, instructorId, cuentaId, tipoCuenta, datosUsuario),
                new LibretaCreada(libretaId, datos),
                new NotaAgregada(libretaId, nota)
        );
    }


}