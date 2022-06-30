package co.com.sofka.capacitacionpersonas.instructor;

import co.com.sofka.capacitacionpersonas.instructor.events.*;
import co.com.sofka.capacitacionpersonas.instructor.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Instructor extends AggregateEvent<InstructorId> {
    protected Contrato contrato;
    protected Vehiculo vehiculo;
    protected RegistroDesempeno registroDesempeno;

    public Instructor(InstructorId instructorId, ContratoId contratoId, TipoContrato tipoContrato, FechaContrato fechaContrato, Salario salario) {
        super(instructorId);
        appendChange(new InstructorCreado(contratoId, tipoContrato, fechaContrato, salario)).apply();
        subscribe(new InstructorEventChange(this));
    }

    public void asociarVehiculo(InstructorId instructorId, VehiculoId vehiculoId, TipoVehiculo tipoVehiculo) {
        appendChange(new VehiculoAsociado(instructorId, vehiculoId, tipoVehiculo)).apply();
    }

    public void asociarRegistroDesempeno(InstructorId instructorId, RegistroDesempenoId registroDesempenoId, DatosRegistro datosRegistro, Observaciones observaciones) {
        appendChange(new RegistroDesempenoAsociado(instructorId, registroDesempenoId, datosRegistro, observaciones)).apply();
    }

    public void agregarKilometraje(VehiculoId vehiculoId, Long kilometraje) {
        appendChange(new KilometrajeAgregado(vehiculoId, kilometraje)).apply();
    }

    public void agregarPuntuacion(RegistroDesempenoId registroDesempenoId, Integer valor) {
        appendChange(new PuntuacionAgregada(registroDesempenoId, valor)).apply();
    }

    public void modificarPeriocidadContrato(ContratoId contratoId, String nuevaPeriocidad) {
        appendChange(new PeriocidadSalarioModificada(contratoId, nuevaPeriocidad)).apply();
    }

    private Instructor(InstructorId instructorId) {
        super(instructorId);
        subscribe(new InstructorEventChange(this));
    }

    public static Instructor from(InstructorId instructorId, List<DomainEvent> events) {
        var instructor = new Instructor(instructorId);
        events.forEach(instructor::applyEvent);
        return instructor;
    }

}
