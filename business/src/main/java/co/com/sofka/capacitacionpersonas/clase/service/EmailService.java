package co.com.sofka.capacitacionpersonas.clase.service;

import co.com.sofka.capacitacionpersonas.clase.values.ClaseId;

public interface EmailService {

    void enviarCorreo(ClaseId claseId, String body);
}
