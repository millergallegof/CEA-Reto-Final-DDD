package co.com.sofka.capacitacionpersonas.estudiante.service;

import co.com.sofka.capacitacionpersonas.clase.values.ClaseId;

public interface EmailCambioCategoriaLicenciaService {
    void enviarCorreoCambioCatgoria(ClaseId claseId, String body);
}
