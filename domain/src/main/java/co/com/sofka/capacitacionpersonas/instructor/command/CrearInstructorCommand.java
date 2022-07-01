package co.com.sofka.capacitacionpersonas.instructor.command;

import co.com.sofka.capacitacionpersonas.instructor.values.*;
import co.com.sofka.domain.generic.Command;

public class CrearInstructorCommand extends Command {

    private final InstructorId instructorId;
    private final ContratoId contratoId;
    private final TipoContrato tipoContrato;
    private final FechaContrato fechaContrato;
    private final Salario salario;

    public CrearInstructorCommand(InstructorId instructorId, ContratoId contratoId, TipoContrato tipoContrato, FechaContrato fechaContrato, Salario salario) {
        this.instructorId = instructorId;
        this.contratoId = contratoId;
        this.tipoContrato = tipoContrato;
        this.fechaContrato = fechaContrato;
        this.salario = salario;
    }

    public InstructorId instructorId() {
        return instructorId;
    }

    public ContratoId contratoId() {
        return contratoId;
    }

    public TipoContrato tipoContrato() {
        return tipoContrato;
    }

    public FechaContrato fechaContrato() {
        return fechaContrato;
    }

    public Salario salario() {
        return salario;
    }
}
