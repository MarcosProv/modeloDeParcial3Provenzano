package model;

import java.time.LocalDate;

public class VehiculoCompacto extends Vehiculo {

    private int anio;

    public VehiculoCompacto(int anio, String codvehiculo, String modelo, double precioBase) {
        super(codvehiculo, modelo, precioBase);
        this.anio = anio;
    }

    private boolean esVehiculoNuevo() {
        int anioActual = LocalDate.now().getYear();
        return anioActual == anio;
    }
    
    
    @Override
    public String toString() {
        return super.toString() + "VehiculoCompacto{" + "anio=" + anio + '}';
    }

    @Override
    public double calcularCostoReparacion(int horas) {
        double costoTotal = (precioBase * horas);
        if (esVehiculoNuevo()) {
            costoTotal *= 0.95;
        }
        return costoTotal;
    }


}
