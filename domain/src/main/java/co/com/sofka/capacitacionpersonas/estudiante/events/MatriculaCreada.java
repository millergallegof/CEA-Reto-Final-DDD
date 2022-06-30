package co.com.sofka.capacitacionpersonas.estudiante.events;

import co.com.sofka.capacitacionpersonas.estudiante.values.MatriculaId;
import co.com.sofka.capacitacionpersonas.estudiante.values.TipoMatricula;
import co.com.sofka.capacitacionpersonas.estudiante.values.ValorMatricula;
import co.com.sofka.domain.generic.DomainEvent;

public class MatriculaCreada extends DomainEvent {

    private final MatriculaId matriculaId;
    private final ValorMatricula valorMatricula;
    private final TipoMatricula tipoMatricula;


    public MatriculaCreada(MatriculaId matriculaId, ValorMatricula valorMatricula, TipoMatricula tipoMatricula) {
        super("co.com.sofka.capacitacionpersonas.MatriculaCreada");
        this.matriculaId = matriculaId;
        this.valorMatricula = valorMatricula;
        this.tipoMatricula = tipoMatricula;
    }


    public MatriculaId matriculaId() {
        return matriculaId;
    }

    public TipoMatricula tipoMatricula() {
        return tipoMatricula;
    }

    public ValorMatricula valorMatricula() {
        return valorMatricula;
    }

}
