package co.com.sofka.capacitacionpersonas.clase;

import co.com.sofka.capacitacionpersonas.clase.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class NotaCreada extends DomainEvent {
     private final NotaId notaId;
    private final EstudianteNota estudianteNota;
    private final FechaNota fechaNota;
    private final ValorNota valorNota;

    public NotaCreada(NotaId notaId, EstudianteNota estudianteNota, FechaNota fechaNota, ValorNota valorNota) {
        super("co.com.sofka.capacitacionpersonas.NotaCreada");
        this.notaId = notaId;
        this.estudianteNota = estudianteNota;
        this.fechaNota = fechaNota;
        this.valorNota = valorNota;
    }

    public NotaId getNotaId() {
        return notaId;
    }

    public EstudianteNota getEstudianteNota() {
        return estudianteNota;
    }

    public FechaNota getFechaNota() {
        return fechaNota;
    }

    public ValorNota getValorNota() {
        return valorNota;
    }
}
