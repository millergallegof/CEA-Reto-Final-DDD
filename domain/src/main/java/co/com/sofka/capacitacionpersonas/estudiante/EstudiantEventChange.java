package co.com.sofka.capacitacionpersonas.estudiante;

import co.com.sofka.capacitacionpersonas.estudiante.events.*;
import co.com.sofka.domain.generic.EventChange;

public class EstudiantEventChange extends EventChange {
    public EstudiantEventChange(Estudiante estudiante) {

//        es como un constructor de agregados
        apply((EstudianteCreado event) -> {
            estudiante.matricula = new Matricula(event.getMatriculaId(), event.getValorMatricula(), event.getTipoMatricula());
            estudiante.cuenta = new Cuenta(event.getCuentaId(), event.getDatosUsuario());
            estudiante.libreta = new Libreta(event.getLibretaId(), event.getDatos());
        });

        apply((MatriculaCreada event) -> {
            estudiante.matricula = new Matricula(event.getMatriculaId(), event.getValorMatricula(), event.getTipoMatricula());
        });

//        cambia el estado del agregado
//        agregar matricula
        apply((MatriculaAgregada event) -> {
            estudiante.matricula = event.getMatricula();
        });

//        Cambiar el estado de la categoria de licencia de la entity
        apply((CategoriaLicenciaCambiada event) -> {
            estudiante.matricula.cambiarTipoLicencia(event.getCategoria());
        });

//        Actualizar datos de cuenta
        apply((DatosUsuActualizado event) -> {
            estudiante.cuenta.actualizarDatosUsu(event.getEmail(), event.getTelefono());
        });

    }
}
