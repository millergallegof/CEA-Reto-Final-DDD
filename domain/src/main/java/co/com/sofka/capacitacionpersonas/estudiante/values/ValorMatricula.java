package co.com.sofka.capacitacionpersonas.estudiante.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ValorMatricula implements ValueObject<ValorMatricula.Props> {

    private final String tipoMatricula;
    private final Double valor;

    public ValorMatricula(String tipoMatricula, Double valor) {
        this.tipoMatricula = Objects.requireNonNull(tipoMatricula);
        this.valor = Objects.requireNonNull(valor);

        if (valor < 0) {
            throw new IllegalArgumentException("No puede tener un valor menor a 0");
        }

    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String tipoMatricula() {
                return tipoMatricula;
            }

            @Override
            public Double valor() {
                return valor;
            }
        };
    }

    public interface Props {
        String tipoMatricula();
        Double valor();
    }
}
