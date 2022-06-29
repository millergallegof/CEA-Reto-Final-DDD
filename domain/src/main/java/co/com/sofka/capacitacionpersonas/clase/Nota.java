package co.com.sofka.capacitacionpersonas.clase;

import co.com.sofka.capacitacionpersonas.clase.values.EstudianteNota;
import co.com.sofka.capacitacionpersonas.clase.values.FechaNota;
import co.com.sofka.capacitacionpersonas.clase.values.NotaId;
import co.com.sofka.capacitacionpersonas.clase.values.ValorNota;
import co.com.sofka.domain.generic.Entity;

public class Nota extends Entity<NotaId> {
    private EstudianteNota estudianteNota;
    private FechaNota fechaNota;
    private ValorNota valor;

    public Nota(NotaId entityId, EstudianteNota estudianteNota, FechaNota fechaNota, ValorNota valor) {
        super(entityId);
        this.estudianteNota = estudianteNota;
        this.fechaNota = fechaNota;
        this.valor = valor;
    }
}
