package co.com.sofka.capacitacionpersonas.instructor.command;

import co.com.sofka.capacitacionpersonas.instructor.values.ContratoId;
import co.com.sofka.capacitacionpersonas.instructor.values.InstructorId;
import co.com.sofka.domain.generic.Command;

public class ModificarPeriocidadContratoCommand extends Command {
    private final InstructorId instructorId;
    private final ContratoId contratoId;
    private final String nuevaPeriocidad;

    public ModificarPeriocidadContratoCommand(InstructorId instructorId, ContratoId contratoId, String nuevaPeriocidad) {
        this.instructorId = instructorId;
        this.contratoId = contratoId;
        this.nuevaPeriocidad = nuevaPeriocidad;
    }

    public InstructorId instructorId() {
        return instructorId;
    }

    public ContratoId contratoId() {
        return contratoId;
    }

    public String nuevaPeriocidad() {
        return nuevaPeriocidad;
    }
}
