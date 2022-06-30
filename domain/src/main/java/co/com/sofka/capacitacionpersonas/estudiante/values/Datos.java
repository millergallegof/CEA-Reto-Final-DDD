package co.com.sofka.capacitacionpersonas.estudiante.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Datos implements ValueObject<Datos.Props> {

    private final String nombre;
    private final String telefono;

    public Datos(String nombre, String telefono) {
        this.nombre = Objects.requireNonNull(nombre);
        this.telefono = Objects.requireNonNull(telefono);
    }

    @Override
    public Datos.Props value() {
        return new Props() {
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public String telefono() {
                return telefono;
            }
        };
    }

    public interface Props {
        String nombre();
        String telefono();
    }

    public Datos modificarTelefono(String telefonoNuevo) {
        return new Datos(this.nombre, telefonoNuevo);
    }
}
