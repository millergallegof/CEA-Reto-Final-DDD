package co.com.sofka.capacitacionpersonas.instructor;

import co.com.sofka.capacitacionpersonas.instructor.values.InstructorId;
import co.com.sofka.domain.generic.AggregateEvent;

public class Instructor extends AggregateEvent<InstructorId> {
    protected Contrato contrato;
    protected Vehiculo vehiculo;
    protected RegistroDesempeno registroDesempeno;


    public Instructor(InstructorId entityId) {
        super(entityId);
    }
}
