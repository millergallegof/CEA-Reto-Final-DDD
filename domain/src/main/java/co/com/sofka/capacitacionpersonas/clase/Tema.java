package co.com.sofka.capacitacionpersonas.clase;

import co.com.sofka.capacitacionpersonas.clase.values.Duracion;
import co.com.sofka.capacitacionpersonas.clase.values.Fecha;
import co.com.sofka.capacitacionpersonas.clase.values.Nombre;
import co.com.sofka.capacitacionpersonas.clase.values.TemaId;
import co.com.sofka.domain.generic.Entity;

import java.time.LocalDate;

public class Tema extends Entity<TemaId> {
    private Nombre nombre;
    private Duracion duracion;
    private Fecha fecha;

    public Tema(TemaId entityId, Nombre nombre, Duracion duracion) {
        super(entityId);
        this.nombre = nombre;
        this.duracion = duracion;
        this.fecha = null;
    }

    public void agregarFecha(Fecha fecha) {
        this.fecha = fecha;
    }


}
