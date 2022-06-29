package co.com.sofka.capacitacionpersonas.instructor;

import co.com.sofka.capacitacionpersonas.instructor.values.DatosRegistro;
import co.com.sofka.capacitacionpersonas.instructor.values.Observaciones;
import co.com.sofka.capacitacionpersonas.instructor.values.Puntuacion;
import co.com.sofka.capacitacionpersonas.instructor.values.RegistroDesempenoId;
import co.com.sofka.domain.generic.Entity;

public class RegistroDesempeno extends Entity<RegistroDesempenoId> {

    private DatosRegistro datosRegistro;
    private Observaciones observaciones;
    private Puntuacion puntuacion;

    public RegistroDesempeno(RegistroDesempenoId entityId, DatosRegistro datosRegistro, Observaciones observaciones) {
        super(entityId);
        this.datosRegistro = datosRegistro;
        this.observaciones = observaciones;
        this.puntuacion = null;
    }

    public void agregarPuntuacion(Integer points) {
        this.puntuacion = new Puntuacion(points);
    }

}
