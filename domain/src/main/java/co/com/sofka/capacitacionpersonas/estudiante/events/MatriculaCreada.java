package co.com.sofka.capacitacionpersonas.estudiante.events;

import co.com.sofka.capacitacionpersonas.estudiante.values.EstudianteId;
import co.com.sofka.capacitacionpersonas.estudiante.values.MatriculaId;
import co.com.sofka.capacitacionpersonas.estudiante.values.TipoMatricula;
import co.com.sofka.capacitacionpersonas.estudiante.values.ValorMatricula;
import co.com.sofka.domain.generic.DomainEvent;

public class MatriculaCreada extends DomainEvent {

    private final EstudianteId estudianteId;
    private final MatriculaId matriculaId;
    private final ValorMatricula valorMatricula;
    private final TipoMatricula tipoMatricula;


    public MatriculaCreada(EstudianteId estudianteId, MatriculaId matriculaId, ValorMatricula valorMatricula, TipoMatricula tipoMatricula) {
        super("co.com.sofka.capacitacionpersonas.MatriculaCreada");

        this.estudianteId = estudianteId;
        this.matriculaId = matriculaId;
        this.valorMatricula = valorMatricula;
        this.tipoMatricula = tipoMatricula;

    }

    public EstudianteId getEstudianteId() {
        return estudianteId;
    }

    public MatriculaId getMatriculaId() {
        return matriculaId;
    }

    public TipoMatricula getTipoMatricula() {
        return tipoMatricula;
    }

    public ValorMatricula getValorMatricula() {
        return valorMatricula;
    }

}
