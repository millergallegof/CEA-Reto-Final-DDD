package co.com.sofka.capacitacionpersonas.estudiante;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.capacitacionpersonas.clase.values.ClaseId;
import co.com.sofka.capacitacionpersonas.estudiante.commands.CrearEstudianteCommand;
import co.com.sofka.capacitacionpersonas.estudiante.events.EstudianteCreado;
import co.com.sofka.capacitacionpersonas.estudiante.events.MatriculaCreada;
import co.com.sofka.capacitacionpersonas.estudiante.values.*;
import co.com.sofka.capacitacionpersonas.instructor.values.InstructorId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CrearEstudianteUseCaseTest {
    @InjectMocks
    CrearEstudianteUseCase useCase;

    @Test
    void crearEstudiante() {
        //arrage
        EstudianteId estudianteId = EstudianteId.of(EstudianteId.Type.CC, "E1234");
        ClaseId claseId = ClaseId.of("C1234");
        InstructorId instructorId = InstructorId.of("I1234");
        MatriculaId matriculaId = MatriculaId.of("M1234");
        ValorMatricula valorMatricula = new ValorMatricula("C2", 800000.0);
        TipoMatricula tipoMatricula = new TipoMatricula("C2");
        TipoCuenta tipoCuenta = new TipoCuenta("Estudiante");
        CuentaId cuentaId = CuentaId.of("C1234");
        DatosUsuario datosUsuario = new DatosUsuario("esteban@gmail.com", "12345");
        LibretaId libretaId = LibretaId.of("L1234");
        Datos datos = new Datos("Miller", "310");
        var command = new CrearEstudianteCommand(estudianteId, claseId, instructorId, matriculaId, valorMatricula, tipoMatricula, cuentaId, tipoCuenta, datosUsuario, libretaId, datos);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var estudianteCreado = (EstudianteCreado)events.get(0);
        var matriculaCreada = (MatriculaCreada)events.get(1);

        Assertions.assertEquals(800000.0, matriculaCreada.valorMatricula().value().valor());
        Assertions.assertEquals("esteban@gmail.com", estudianteCreado.datosUsuario().value().email());

    }

}