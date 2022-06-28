package co.com.sofka.capacitacionpersonas.estudiante;

import co.com.sofka.capacitacionpersonas.estudiante.values.CuentaId;
import co.com.sofka.capacitacionpersonas.estudiante.values.DatosUsuario;
import co.com.sofka.capacitacionpersonas.estudiante.values.TipoCuenta;
import co.com.sofka.domain.generic.Entity;

public class Cuenta extends Entity<CuentaId> {

    private TipoCuenta tipoCuenta;
    private DatosUsuario datosUsuario;


    public Cuenta(CuentaId entityId, DatosUsuario datosUsuario) {
        super(entityId);
        this.datosUsuario = datosUsuario;
    }

    public void actualizarDatosUsu(String email, String telefono) {
        this.datosUsuario = datosUsuario.actualizarDatosUsu(email, telefono);
    }

}
