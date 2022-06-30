package co.com.sofka.capacitacionpersonas.clase;

import co.com.sofka.capacitacionpersonas.clase.events.ClaseCreada;
import co.com.sofka.capacitacionpersonas.clase.events.EvalaucionCreada;
import co.com.sofka.domain.generic.EventChange;

import java.util.ArrayList;

public class ClaseEventChange extends EventChange {
    public ClaseEventChange(Clase clase) {
        apply((ClaseCreada event) -> {
            clase.tema = new Tema(event.getTemaId(), event.getNombre(), event.getDuracion());
            clase.evaluacion = new Evaluacion(event.getEvaluacionId(), event.getCalificacion());
            clase.notas = new ArrayList<>();
        });

        apply((EvalaucionCreada event) -> {
            if (!clase.identity().equals(event.getClaseId())) {
                throw new IllegalArgumentException("La evaluacion no se encuentra creada");
            }
            clase.evaluacion = new Evaluacion(event.getEvaluacionId(), event.getCalificacion());
        });

        apply((NotaCreada event) -> {
            var notaId = event.getNotaId();
            var nota = new Nota(notaId, event.getEstudianteNota(), event.getFechaNota(), event.getValorNota());
            clase.notas.add(nota);
        });

    }
}
