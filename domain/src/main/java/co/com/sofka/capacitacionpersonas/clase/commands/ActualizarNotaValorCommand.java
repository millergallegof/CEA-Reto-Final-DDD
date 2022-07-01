package co.com.sofka.capacitacionpersonas.clase.commands;

import co.com.sofka.capacitacionpersonas.clase.values.ClaseId;
import co.com.sofka.capacitacionpersonas.clase.values.NotaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarNotaValorCommand extends Command {
    private final ClaseId claseId;
    private final NotaId notaId;
    private final Integer valorNuevo;

    public ActualizarNotaValorCommand(ClaseId claseId, NotaId notaId, Integer valorNuevo) {
        this.claseId = claseId;
        this.notaId = notaId;
        this.valorNuevo = valorNuevo;
    }

    public ClaseId claseId() {
        return claseId;
    }

    public NotaId notaId() {
        return notaId;
    }

    public Integer valorNuevo() {
        return valorNuevo;
    }
}
