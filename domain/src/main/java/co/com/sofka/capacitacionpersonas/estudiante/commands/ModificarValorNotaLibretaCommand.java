package co.com.sofka.capacitacionpersonas.estudiante.commands;

import co.com.sofka.capacitacionpersonas.estudiante.values.EstudianteId;
import co.com.sofka.capacitacionpersonas.estudiante.values.LibretaId;
import co.com.sofka.domain.generic.Command;

public class ModificarValorNotaLibretaCommand extends Command {
    private final EstudianteId estudianteId;
    private final LibretaId libretaId;
    private final Integer valorNotaNueva;

    public ModificarValorNotaLibretaCommand(EstudianteId estudianteId, LibretaId libretaId, Integer valorNotaNueva) {
        this.estudianteId = estudianteId;
        this.libretaId = libretaId;
        this.valorNotaNueva = valorNotaNueva;
    }

    public EstudianteId estudianteId() {
        return estudianteId;
    }

    public LibretaId libretaId() {
        return libretaId;
    }

    public Integer valorNotaNueva() {
        return valorNotaNueva;
    }
}
