package co.com.sofka.capacitacionpersonas.clase.values;

import co.com.sofka.domain.generic.ValueObject;

public class ValorNota implements ValueObject<ValorNota.Props> {

    private final String tema;
    private final Integer valor;

    public ValorNota(String tema, Integer valor) {
        this.tema = tema;
        this.valor = valor;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String tema() {
                return tema;
            }

            @Override
            public Integer valor() {
                return valor;
            }
        };
    }

    public interface Props {
        String tema();
        Integer valor();
    }
}
