package co.com.sofka.capacitacionpersonas.clase.events;

import co.com.sofka.capacitacionpersonas.clase.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class NotaAsociada extends DomainEvent {
     private final NotaId notaId;
    private final EstudianteNota estudianteNota;
    private final FechaNota fechaNota;
    private final ValorNota valorNota;

    public NotaAsociada(NotaId notaId, EstudianteNota estudianteNota, FechaNota fechaNota, ValorNota valorNota) {
        super("co.com.sofka.capacitacionpersonas.NotaCreada");
        this.notaId = notaId;
        this.estudianteNota = estudianteNota;
        this.fechaNota = fechaNota;
        this.valorNota = valorNota;
    }

    public NotaId notaId() {
        return notaId;
    }

    public EstudianteNota estudianteNota() {
        return estudianteNota;
    }

    public FechaNota fechaNota() {
        return fechaNota;
    }

    public ValorNota valorNota() {
        return valorNota;
    }
}
