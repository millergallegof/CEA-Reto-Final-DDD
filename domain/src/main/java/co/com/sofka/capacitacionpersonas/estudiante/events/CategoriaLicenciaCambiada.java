package co.com.sofka.capacitacionpersonas.estudiante.events;

import co.com.sofka.capacitacionpersonas.estudiante.values.MatriculaId;
import co.com.sofka.domain.generic.DomainEvent;

public class CategoriaLicenciaCambiada extends DomainEvent {

    private final MatriculaId matriculaId;
    private final String categoria;

    public CategoriaLicenciaCambiada(MatriculaId matriculaId, String categoria) {
        super("co.com.sofka.capacitacionpersonas.CambiarCategoriaLicencia");
        this.matriculaId = matriculaId;
        this.categoria = categoria;
    }

    public MatriculaId getMatriculaId() {
        return matriculaId;
    }

    public String getCategoria() {
        return categoria;
    }
}
