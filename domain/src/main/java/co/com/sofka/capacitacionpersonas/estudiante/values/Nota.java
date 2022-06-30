package co.com.sofka.capacitacionpersonas.estudiante.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nota implements ValueObject<Nota.Props> {
    private final String tema;
    private final Integer valor;

    public Nota(String tema, Integer valor) {
        this.tema = Objects.requireNonNull(tema);
        this.valor = Objects.requireNonNull(valor);

        if (valor < 0) {
            throw new IllegalArgumentException("El valor de la calificacion tiene que ser mayor a 0");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String tema() {
                return null;
            }

            @Override
            public Integer valor() {
                return null;
            }
        };
    }

    public interface Props {
        String tema();
        Integer valor();
    }

    public Nota modificarValorNota(Integer valorNotaNuevo) {
        return new Nota(this.tema, valorNotaNuevo);
    }
}
