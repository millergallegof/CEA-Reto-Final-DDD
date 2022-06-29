package co.com.sofka.capacitacionpersonas.estudiante;

import co.com.sofka.capacitacionpersonas.estudiante.values.Datos;
import co.com.sofka.capacitacionpersonas.estudiante.values.LibretaId;
import co.com.sofka.capacitacionpersonas.estudiante.values.Notas;
import co.com.sofka.domain.generic.Entity;

public class Libreta extends Entity<LibretaId> {
    private Datos datos;
    private Notas notas;

    public Libreta(LibretaId entityId, Datos datos) {
        super(entityId);
        this.datos = datos;
        this.notas = null;
    }
}
