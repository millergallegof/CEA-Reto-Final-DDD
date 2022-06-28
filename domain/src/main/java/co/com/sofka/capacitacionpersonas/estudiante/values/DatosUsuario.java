package co.com.sofka.capacitacionpersonas.estudiante.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DatosUsuario implements ValueObject<DatosUsuario.Props> {

    private final String email;
    private final String telefono;

    public DatosUsuario(String email, String telefono) {
        this.email = Objects.requireNonNull(email);
        this.telefono = Objects.requireNonNull(telefono);

        if (!email.matches("^[a-zA-Z0-9_!#$%&'\\*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            throw new IllegalArgumentException("ingrese un correo correcto");
        }
    }

    @Override
    public DatosUsuario.Props value() {
        return new Props() {
            @Override
            public String email() {
                return email;
            }

            @Override
            public String telefono() {
                return telefono;
            }
        };
    }

    public interface Props {
        String email();
        String telefono();
    }

    public DatosUsuario actualizarDatosUsu(String email, String telefono) {
        return new DatosUsuario(email, telefono);
    }

}
