package co.com.sofka.capacitacionpersonas.clase.commands;

import co.com.sofka.capacitacionpersonas.clase.values.EstudianteId;
import co.com.sofka.capacitacionpersonas.clase.values.NotaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarNotaValorCommand extends Command {
    private final EstudianteId claseId;
    private final NotaId notaId;
    private final Integer valorNuevo;

    public ActualizarNotaValorCommand(EstudianteId claseId, NotaId notaId, Integer valorNuevo) {
        this.claseId = claseId;
        this.notaId = notaId;
        this.valorNuevo = valorNuevo;
    }

    public EstudianteId claseId() {
        return claseId;
    }

    public NotaId notaId() {
        return notaId;
    }

    public Integer valorNuevo() {
        return valorNuevo;
    }
}
