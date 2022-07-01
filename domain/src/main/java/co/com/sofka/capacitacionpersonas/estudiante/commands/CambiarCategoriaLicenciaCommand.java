package co.com.sofka.capacitacionpersonas.estudiante.commands;

import co.com.sofka.capacitacionpersonas.estudiante.values.EstudianteId;
import co.com.sofka.capacitacionpersonas.estudiante.values.MatriculaId;
import co.com.sofka.domain.generic.Command;

public class CambiarCategoriaLicenciaCommand extends Command {

    private final EstudianteId estudianteId;
    private final MatriculaId matriculaId;
    private final String categoria;

    public CambiarCategoriaLicenciaCommand(EstudianteId estudianteId, MatriculaId matriculaId, String categoria) {
        this.estudianteId = estudianteId;
        this.matriculaId = matriculaId;
        this.categoria = categoria;
    }

    public EstudianteId estudianteId() {
        return estudianteId;
    }

    public MatriculaId matriculaId() {
        return matriculaId;
    }

    public String categoria() {
        return categoria;
    }
}
