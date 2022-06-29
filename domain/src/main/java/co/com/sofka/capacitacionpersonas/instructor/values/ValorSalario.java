package co.com.sofka.capacitacionpersonas.instructor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ValorSalario implements ValueObject<ValorSalario.Props> {

    private final String tipoMoneda;
    private final Long valor;

    public ValorSalario(String tipoMoneda, Long valor) {
        this.tipoMoneda = Objects.requireNonNull(tipoMoneda);
        this.valor = Objects.requireNonNull(valor);

        if (valor < 0) {
            throw new IllegalArgumentException("ingres un valor mayor a 0");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String tipoMoneda() {
                return tipoMoneda;
            }

            @Override
            public Long valor() {
                return valor;
            }
        };
    }

    public interface Props {
        String tipoMoneda();
        Long valor();
    }
}
