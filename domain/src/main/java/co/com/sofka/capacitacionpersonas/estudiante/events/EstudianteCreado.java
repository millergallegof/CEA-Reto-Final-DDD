package co.com.sofka.capacitacionpersonas.estudiante.events;

import co.com.sofka.capacitacionpersonas.estudiante.Cuenta;
import co.com.sofka.capacitacionpersonas.estudiante.Matricula;
import co.com.sofka.domain.generic.DomainEvent;

// Evento de domino - cambiar de estados y para integrar con otro contexto
public class EstudianteCreado extends DomainEvent {
    private final Matricula matricula;
    private final Cuenta cuenta;

    public EstudianteCreado(Matricula matricula, Cuenta cuenta) {
//        super(type -> paquete donde se va a encaminar el evento de dominio entre paquetes
        super("co.com.sofka.capacitacionpersonas.EstudianteCreado");
        this.matricula = matricula;
        this.cuenta = cuenta;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
}
