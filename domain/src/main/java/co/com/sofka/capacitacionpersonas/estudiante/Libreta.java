package co.com.sofka.capacitacionpersonas.estudiante;

import co.com.sofka.capacitacionpersonas.estudiante.values.Datos;
import co.com.sofka.capacitacionpersonas.estudiante.values.LibretaId;
import co.com.sofka.capacitacionpersonas.estudiante.values.Nota;
import co.com.sofka.domain.generic.Entity;

public class Libreta extends Entity<LibretaId> {
    private Datos datos;
    private Nota nota;

    public Libreta(LibretaId entityId, Datos datos) {
        super(entityId);
        this.datos = datos;
        this.nota = null;
    }

    public void agregarNotas(Nota notas) {
        this.nota = notas;
    }

    public void modificarValorNota(Integer valorNotaNueva) {
        this.nota = nota.modificarValorNota(valorNotaNueva);
    }

}
