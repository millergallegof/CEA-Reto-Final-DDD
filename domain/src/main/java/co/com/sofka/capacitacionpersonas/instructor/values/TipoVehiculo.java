package co.com.sofka.capacitacionpersonas.instructor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoVehiculo implements ValueObject<TipoVehiculo.Props> {

    private final String tipo;
    private final Integer cilindraje;

    public TipoVehiculo(String tipo) {
        this.tipo = Objects.requireNonNull(tipo);
        this.cilindraje = 0;
    }
    public TipoVehiculo(String tipo, Integer cilindraje) {
        this.tipo = Objects.requireNonNull(tipo);
        this.cilindraje = Objects.requireNonNull(cilindraje);

        if (cilindraje < 0 ) {
            throw new IllegalArgumentException("el cilindraje no puede ser 0");
        }
    }

    public TipoVehiculo agregarCilindraje(Integer cilindraje) {
        return new TipoVehiculo(this.tipo, cilindraje);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String tipo() {
                return tipo;
            }

            @Override
            public Integer cilindraje() {
                return cilindraje;
            }
        };
    }

    public interface Props {
        String tipo();
        Integer cilindraje();
    }
}
