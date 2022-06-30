package co.com.sofka.capacitacionpersonas.instructor.events;

import co.com.sofka.capacitacionpersonas.instructor.values.ContratoId;
import co.com.sofka.capacitacionpersonas.instructor.values.FechaContrato;
import co.com.sofka.capacitacionpersonas.instructor.values.Salario;
import co.com.sofka.capacitacionpersonas.instructor.values.TipoContrato;
import co.com.sofka.domain.generic.DomainEvent;

public class InstructorCreado extends DomainEvent {
    private final ContratoId contratoId;
    private final TipoContrato tipoContrato;

    private final FechaContrato fechaContrato;
    private final Salario salario;

    public InstructorCreado(ContratoId contratoId,TipoContrato tipoContrato, FechaContrato fechaContrato, Salario salario) {
        super("co.com.sofka.capacitacionpersonas.");
        this.contratoId = contratoId;
        this.tipoContrato = tipoContrato;
        this.fechaContrato = fechaContrato;
        this.salario = salario;
    }

    public TipoContrato tipoContrato() {
        return tipoContrato;
    }

    public ContratoId contratoId() {
        return contratoId;
    }

    public FechaContrato fechaContrato() {
        return fechaContrato;
    }

    public Salario salario() {
        return salario;
    }



}
