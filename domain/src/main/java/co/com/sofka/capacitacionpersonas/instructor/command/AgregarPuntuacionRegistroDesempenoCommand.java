package co.com.sofka.capacitacionpersonas.instructor.command;

import co.com.sofka.capacitacionpersonas.instructor.values.InstructorId;
import co.com.sofka.capacitacionpersonas.instructor.values.RegistroDesempenoId;
import co.com.sofka.domain.generic.Command;

public class AgregarPuntuacionRegistroDesempenoCommand extends Command {
    private final InstructorId instructorId;
    private final RegistroDesempenoId registroDesempenoId;
    private final Integer valor;

    public AgregarPuntuacionRegistroDesempenoCommand(InstructorId instructorId, RegistroDesempenoId registroDesempenoId, Integer valor) {
        this.instructorId = instructorId;
        this.registroDesempenoId = registroDesempenoId;
        this.valor = valor;
    }

    public InstructorId instructorId() {
        return instructorId;
    }

    public RegistroDesempenoId registroDesempenoId() {
        return registroDesempenoId;
    }

    public Integer valor() {
        return valor;
    }
}
