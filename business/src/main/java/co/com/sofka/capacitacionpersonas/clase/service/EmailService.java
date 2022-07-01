package co.com.sofka.capacitacionpersonas.clase.service;

import co.com.sofka.capacitacionpersonas.clase.values.EstudianteId;

public interface EmailService {

    void enviarCorreo(EstudianteId claseId, String body);
}
