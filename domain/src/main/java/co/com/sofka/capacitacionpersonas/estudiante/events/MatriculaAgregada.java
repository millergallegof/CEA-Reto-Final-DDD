package co.com.sofka.capacitacionpersonas.estudiante.events;

import co.com.sofka.capacitacionpersonas.estudiante.Matricula;
import co.com.sofka.domain.generic.DomainEvent;

public class MatriculaAgregada extends DomainEvent {
    private final Matricula matricula;

    public MatriculaAgregada(Matricula matricula) {
        super("co.com.sofka.capacitacionpersonas.MatriculaAgregada");
        this.matricula = matricula;
    }

    public Matricula getMatricula() {
        return matricula;
    }
}
