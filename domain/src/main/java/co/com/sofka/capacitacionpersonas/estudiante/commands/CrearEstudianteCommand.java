package co.com.sofka.capacitacionpersonas.estudiante.commands;


import co.com.sofka.capacitacionpersonas.estudiante.Cuenta;
import co.com.sofka.capacitacionpersonas.estudiante.Matricula;
import co.com.sofka.capacitacionpersonas.estudiante.values.EstudianteId;
import co.com.sofka.domain.generic.Command;


public class CrearEstudianteCommand extends Command {
    private final EstudianteId entityId;
    private final Matricula matricula;
    private final Cuenta cuenta;

    public CrearEstudianteCommand(EstudianteId entityId, Matricula matricula, Cuenta cuenta) {
        this.entityId = entityId;
        this.matricula = matricula;
        this.cuenta = cuenta;
    }
}
