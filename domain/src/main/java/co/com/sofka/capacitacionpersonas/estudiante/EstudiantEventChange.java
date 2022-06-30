package co.com.sofka.capacitacionpersonas.estudiante;


import co.com.sofka.capacitacionpersonas.estudiante.events.*;
import co.com.sofka.domain.generic.EventChange;

public class EstudiantEventChange extends EventChange {
    public EstudiantEventChange(Estudiante estudiante) {

//        es como un constructor de agregados
        apply((EstudianteCreado event) -> {
            estudiante.cuenta = new Cuenta(event.cuentaId(), event.datosUsuario());
            estudiante.libreta = new Libreta(event.libretaId(), event.datos());
        });

        apply((MatriculaCreada event) -> {
            estudiante.matricula = new Matricula(event.matriculaId(), event.valorMatricula(), event.tipoMatricula());
        });

//        Cambiar el estado de la categoria de licencia de la entity
        apply((CategoriaLicenciaCambiada event) -> {
            estudiante.matricula.cambiarTipoLicencia(event.categoria());
        });

//        Actualizar datos de cuenta
        apply((DatosUsuActualizado event) -> {
            estudiante.cuenta.actualizarDatosUsu(event.email(), event.telefono());
        });

        apply((NotaAgregada event) -> {
            if (!estudiante.libreta.identity().equals(event.libretaId())) {
                throw new IllegalArgumentException("La libreta no se encuentra cread");
            }
            estudiante.libreta.agregarNotas(event.nota());
        });

        apply((ValorNotaLibretaModificada event) -> {
            if (!estudiante.libreta.identity().equals(event.libretaId())) {
                throw new IllegalArgumentException("La libreta no se encuentra cread");
            }
            estudiante.libreta.modificarValorNota(event.valorNotaNueva());
        });

    }
}
