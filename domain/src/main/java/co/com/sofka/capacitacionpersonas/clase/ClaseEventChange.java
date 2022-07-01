package co.com.sofka.capacitacionpersonas.clase;

import co.com.sofka.capacitacionpersonas.clase.events.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashMap;

public class ClaseEventChange extends EventChange {
    public ClaseEventChange(Clase clase) {
        apply((ClaseCreada event) -> {
            clase.instructorId = event.instructorId();
            clase.evaluacion = new Evaluacion(event.evaluacionId(), event.calificacion());
            clase.notas = new HashMap<>();
        });

        apply((TemaCreado event) -> {
            clase.tema = new Tema(event.temaId(), event.nombre(), event.duracion());
        });

        apply((EvalaucionCreada event) -> {
            if (!clase.identity().equals(event.claseId())) {
                throw new IllegalArgumentException("La clase no se encuentra creada");
            }
            clase.evaluacion = new Evaluacion(event.evaluacionId(), event.calificacion());
        });

        apply((NotaAsociada event) -> {
            var notaId = event.notaId();
            var nota = new Nota(notaId, event.estudianteNota(), event.fechaNota(), event.valorNota());
            clase.notas.put(notaId, nota);
        });

        apply((CalificacionEvaluacionActualizado event) -> {
            if (!clase.evaluacion.identity().equals(event.evaluacionId())) {
                throw new IllegalArgumentException("La evaluacion no se encuentra creada");
            }
            clase.evaluacion.modificarCalificacion(event.calificacion());
        });

        apply((ValorNotaActualizado event) -> {
            if (clase.notas.size() == 0) {
                throw new IllegalArgumentException("No existen notas en la lista");
            }
            if (!clase.notas.containsKey(event.notaId())) {
                throw new IllegalArgumentException("la nota que desea modificar no existe");
            }
            clase.notas.get(event.notaId()).cambiarValorNota(event.valorNuevo());
        });


    }
}
