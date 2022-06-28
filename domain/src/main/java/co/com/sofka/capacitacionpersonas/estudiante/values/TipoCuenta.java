package co.com.sofka.capacitacionpersonas.estudiante.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoCuenta implements ValueObject<String> {
    private final String rolCuenta;

    public TipoCuenta(String rolCuenta) {
        this.rolCuenta = Objects.requireNonNull(rolCuenta);
    }

    @Override
    public String value() {
        return rolCuenta;
    }



}
