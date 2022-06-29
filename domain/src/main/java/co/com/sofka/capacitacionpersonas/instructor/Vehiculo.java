package co.com.sofka.capacitacionpersonas.instructor;

import co.com.sofka.capacitacionpersonas.instructor.values.Kilometraje;
import co.com.sofka.capacitacionpersonas.instructor.values.TipoVehiculo;
import co.com.sofka.capacitacionpersonas.instructor.values.VehiculoId;
import co.com.sofka.domain.generic.Entity;

public class Vehiculo extends Entity<VehiculoId> {
    private TipoVehiculo tipoVehiculo;
    private Kilometraje kilometraje;

    public Vehiculo(VehiculoId entityId, TipoVehiculo tipoVehiculo) {
        super(entityId);
        this.tipoVehiculo = tipoVehiculo;
        this.kilometraje = null;
    }

    public void agregarKilometraje(Long kilometraje){
        this.kilometraje = new Kilometraje(kilometraje);
    }

}
