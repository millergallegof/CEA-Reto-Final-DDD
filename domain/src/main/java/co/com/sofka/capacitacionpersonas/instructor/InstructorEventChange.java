package co.com.sofka.capacitacionpersonas.instructor;

import co.com.sofka.capacitacionpersonas.instructor.events.*;
import co.com.sofka.domain.generic.EventChange;

public class InstructorEventChange extends EventChange {
    public InstructorEventChange(Instructor instructor) {
        apply((InstructorCreado event) -> {
            instructor.contrato = new Contrato(event.contratoId(), event.tipoContrato(), event.fechaContrato(), event.salario());
            instructor.vehiculo = null;
            instructor.registroDesempeno = null;
        });

        apply((VehiculoAsociado event) -> {
            if (!instructor.identity().equals(event.instructorId())) {
                throw new IllegalArgumentException("El instructor no esta creado");
            }
            instructor.vehiculo = new Vehiculo(event.vehiculoId(), event.tipoVehiculo());
        });

        apply((RegistroDesempenoAsociado event) -> {
            if (!instructor.identity().equals(event.instructorId())) {
                throw new IllegalArgumentException("El instructor no esta creado");
            }
            instructor.registroDesempeno = new RegistroDesempeno(event.registroDesempenoId(), event.datosRegistro(), event.observaciones());
        }) ;

        apply((KilometrajeAgregado event) -> {
            if (!instructor.vehiculo.identity().equals(event.vehiculoId())) {
                throw new IllegalArgumentException("El vehiculo no esta creado");
            }
            instructor.vehiculo.agregarKilometraje(event.kilometraje());
        });

        apply((PuntuacionAgregada event) -> {
            if (!instructor.registroDesempeno.identity().equals(event.registroDesempenoId())) {
                throw new IllegalArgumentException("El registro no esta creado");
            }
            instructor.registroDesempeno.agregarPuntuacion(event.valor());
        });

        apply((PeriocidadSalarioModificada event) -> {
            if (!instructor.contrato.identity().equals(event.contratoId())) {
                throw new IllegalArgumentException("El contrato no esta creado");
            }
            instructor.contrato.cambiarPeriocidad(event.nuevaPeriocidad());
        });

    }
}
