package co.com.sofka.capacitacionpersonas.estudiante.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoMatricula implements ValueObject<String> {

    private final String categoriaLicencia;

    public TipoMatricula(String categoriaLicencia) {
        this.categoriaLicencia = Objects.requireNonNull(categoriaLicencia);
    }

    public TipoMatricula cambiarTipoLicencia(String categoriaLicencia) {
        return new TipoMatricula(categoriaLicencia);
    }

    @Override
    public String value() {
        return categoriaLicencia;
    }
}
