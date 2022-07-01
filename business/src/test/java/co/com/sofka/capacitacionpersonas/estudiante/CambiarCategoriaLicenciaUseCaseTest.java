package co.com.sofka.capacitacionpersonas.estudiante;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.capacitacionpersonas.clase.values.ClaseId;
import co.com.sofka.capacitacionpersonas.estudiante.commands.CambiarCategoriaLicenciaCommand;
import co.com.sofka.capacitacionpersonas.estudiante.events.CategoriaLicenciaCambiada;
import co.com.sofka.capacitacionpersonas.estudiante.events.EstudianteCreado;
import co.com.sofka.capacitacionpersonas.estudiante.events.MatriculaCreada;
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
class CambiarCategoriaLicenciaUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CambiarCategoriaLicenciaUseCase useCase;

    @Test
    void cambiarCategoriaLicencia() {
        //arrange
        EstudianteId estudianteId = EstudianteId.of(EstudianteId.Type.CC, "E1234");
        MatriculaId matriculaId = MatriculaId.of("M1234");
        String categoria = "Estudiante";
        var command = new CambiarCategoriaLicenciaCommand(estudianteId, matriculaId, categoria);

        when(repository.getEventsBy(estudianteId.value())).thenReturn(history());
        useCase.addRepository(repository);

        // act
        var events = UseCaseHandler
                .getInstance().syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // assert
        var categoriaLicenciaCambiada = (CategoriaLicenciaCambiada) events.get(0);
        Assertions.assertEquals("Estudiante", categoriaLicenciaCambiada.categoria());

    }

    private List<DomainEvent> history() {
        ClaseId claseId = ClaseId.of("C1234");
        InstructorId instructorId = InstructorId.of("I1234");
        MatriculaId matriculaId = MatriculaId.of("M1234");
        ValorMatricula valorMatricula = new ValorMatricula("C2", 800000.0);
        TipoMatricula tipoMatricula = new TipoMatricula("C2");
        TipoCuenta tipoCuenta = new TipoCuenta("Estudiante");
        CuentaId cuentaId = CuentaId.of("C1234");
        DatosUsuario datosUsuario = new DatosUsuario("esteban@gmail.com", "12345");
        return List.of(
                new EstudianteCreado(claseId, instructorId, cuentaId, tipoCuenta, datosUsuario),
                new MatriculaCreada(matriculaId, valorMatricula, tipoMatricula)
        );

    }



}