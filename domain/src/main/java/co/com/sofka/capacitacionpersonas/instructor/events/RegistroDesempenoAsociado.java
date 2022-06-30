package co.com.sofka.capacitacionpersonas.instructor.events;

import co.com.sofka.capacitacionpersonas.instructor.values.DatosRegistro;
import co.com.sofka.capacitacionpersonas.instructor.values.InstructorId;
import co.com.sofka.capacitacionpersonas.instructor.values.Observaciones;
import co.com.sofka.capacitacionpersonas.instructor.values.RegistroDesempenoId;
import co.com.sofka.domain.generic.DomainEvent;

public class RegistroDesempenoAsociado extends DomainEvent {
    private final InstructorId instructorId;
    private final RegistroDesempenoId registroDesempenoId;
    private final DatosRegistro datosRegistro;
    private final Observaciones observaciones;

    public RegistroDesempenoAsociado(InstructorId instructorId, RegistroDesempenoId registroDesempenoId, DatosRegistro datosRegistro, Observaciones observaciones) {
        super("co.com.sofka.capacitacionpersonas.RegistroDesempenoAsociado");
        this.instructorId = instructorId;
        this.registroDesempenoId = registroDesempenoId;
        this.datosRegistro = datosRegistro;
        this.observaciones = observaciones;
    }

    public InstructorId instructorId() {
        return instructorId;
    }

    public RegistroDesempenoId registroDesempenoId() {
        return registroDesempenoId;
    }

    public DatosRegistro datosRegistro() {
        return datosRegistro;
    }

    public Observaciones observaciones() {
        return observaciones;
    }
}
