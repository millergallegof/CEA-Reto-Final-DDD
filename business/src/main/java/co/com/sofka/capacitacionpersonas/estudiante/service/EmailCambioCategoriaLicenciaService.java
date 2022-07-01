package co.com.sofka.capacitacionpersonas.estudiante.service;

import co.com.sofka.capacitacionpersonas.clase.values.EstudianteId;

public interface EmailCambioCategoriaLicenciaService {
    void enviarCorreoCambioCatgoria(EstudianteId claseId, String body);
}
