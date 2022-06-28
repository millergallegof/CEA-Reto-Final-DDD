package co.com.sofka.capacitacionpersonas.estudiante;

import co.com.sofka.capacitacionpersonas.estudiante.values.MatriculaId;
import co.com.sofka.capacitacionpersonas.estudiante.values.TipoMatricula;
import co.com.sofka.capacitacionpersonas.estudiante.values.ValorMatricula;
import co.com.sofka.domain.generic.Entity;

public class Matricula extends Entity<MatriculaId> {

    private ValorMatricula valorMatricula;
    private TipoMatricula tipoMatricula;

    public Matricula(MatriculaId entityId, ValorMatricula valorMatricula, TipoMatricula tipoMatricula) {
        super(entityId);
        this.valorMatricula = valorMatricula;
        this.tipoMatricula = tipoMatricula;
    }

    public void cambiarTipoLicencia(String categoriaNueva) {
        this.tipoMatricula = tipoMatricula.cambiarTipoLicencia(categoriaNueva);
    }

}
