package co.com.sofka.capacitacionpersonas.instructor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Salario implements ValueObject<Salario.Props> {
    private final ValorSalario valorSalario;
    private final String periocidad;

    public Salario(ValorSalario valorSalario, String periocidad) {
        this.valorSalario = Objects.requireNonNull(valorSalario);
        this.periocidad = Objects.requireNonNull(periocidad);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public ValorSalario valorSalario() {
                return valorSalario;
            }

            @Override
            public String periocidad() {
                return periocidad;
            }
        };
    }

    public interface Props {
        ValorSalario valorSalario();
        String periocidad();
    }

    public Salario modificarPeriocidad(String nuevaPeriocidad) {
        return new Salario(this.valorSalario, nuevaPeriocidad);
    }
}
