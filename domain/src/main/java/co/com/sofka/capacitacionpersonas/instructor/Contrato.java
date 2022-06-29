package co.com.sofka.capacitacionpersonas.instructor;

import co.com.sofka.capacitacionpersonas.instructor.values.ContratoId;
import co.com.sofka.capacitacionpersonas.instructor.values.FechaContrato;
import co.com.sofka.capacitacionpersonas.instructor.values.Salario;
import co.com.sofka.capacitacionpersonas.instructor.values.TipoContrato;
import co.com.sofka.domain.generic.Entity;

public class Contrato extends Entity<ContratoId> {
    private TipoContrato tipoContrato;
    private FechaContrato fechaContrato;
    private Salario salario;

    public Contrato(ContratoId entityId, TipoContrato tipoContrato, FechaContrato fechaContrato, Salario salario) {
        super(entityId);
        this.tipoContrato = tipoContrato;
        this.fechaContrato = fechaContrato;
        this.salario = salario;
    }
}
