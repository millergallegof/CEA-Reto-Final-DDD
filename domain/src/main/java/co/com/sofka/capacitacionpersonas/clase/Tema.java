package co.com.sofka.capacitacionpersonas.clase;

import co.com.sofka.capacitacionpersonas.clase.values.Duracion;
import co.com.sofka.capacitacionpersonas.clase.values.Fecha;
import co.com.sofka.capacitacionpersonas.clase.values.Nombre;
import co.com.sofka.capacitacionpersonas.clase.values.TemaId;
import co.com.sofka.domain.generic.Entity;

public class Tema extends Entity<TemaId> {
    private Nombre nombre;
    private Duracion duracion;
    private Fecha fecha;

    public Tema(TemaId entityId, Nombre nombre, Duracion duracion, Fecha fecha) {
        super(entityId);
        this.nombre = nombre;
        this.duracion = duracion;
        this.fecha = fecha;
    }
}
