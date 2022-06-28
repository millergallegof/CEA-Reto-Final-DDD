package co.com.sofka.capacitacionpersonas.estudiante;

import co.com.sofka.capacitacionpersonas.estudiante.events.CategoriaLicenciaCambiada;
import co.com.sofka.capacitacionpersonas.estudiante.events.DatosUsuActualizado;
import co.com.sofka.capacitacionpersonas.estudiante.events.EstudianteCreado;
import co.com.sofka.capacitacionpersonas.estudiante.events.MatriculaAgregada;
import co.com.sofka.domain.generic.EventChange;

public class EstudiantEventChange extends EventChange {
    public EstudiantEventChange(Estudiante estudiante) {

//        es como un constructor de agregados
        apply((EstudianteCreado event) -> {
            estudiante.cuenta = event.getCuenta();
            estudiante.matricula = event.getMatricula();
        });

//        cambia el estado del agregado
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
