package model;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Vehiculo {

    protected String codvehiculo;
    protected String modelo;
    protected double precioBase;
    protected EstadoVehiculo estado;
    protected ArrayList<String> historialReaparaciones;

    public Vehiculo(String codvehiculo, String modelo, double precioBase) {
        this.codvehiculo = validarCaracteres(codvehiculo);
        this.modelo = modelo;
        this.precioBase = precioBase;
        this.estado = EstadoVehiculo.DISPONIBLE;
        this.historialReaparaciones = new ArrayList<String>();
    }

    public void cambiarEstado(EstadoVehiculo estado){
        this.estado = estado;
        }
    
    private String validarCaracteres(String caracteres) {
        if (caracteres.length() != 7 || caracteres.equals(null)) {
            throw new IllegalArgumentException("El codigo ded vehiculo tiene una cantidad de caracteres en invalida");
        }
        return caracteres;
    }

    public ArrayList<String> getHistorialReaparaciones() {
        return historialReaparaciones;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "codvehiculo=" + codvehiculo + ", modelo=" + modelo + ", precioBase=" + precioBase + ", estado=" + estado + ", historialReaparaciones=" + historialReaparaciones + '}';
    }
    
    abstract double calcularCostoReparacion(int horas);

    public void iniciarReparaciones(String nombreTaller, String descripcion) {
        estado = EstadoVehiculo.EN_REPARACION;
        LocalDate fechaActual = LocalDate.now();
        descripcion = descripcion + "/n" + fechaActual;
        historialReaparaciones.add(descripcion);

    }

    public boolean preguntarEstado(EstadoVehiculo estado){
        return this.estado.equals(estado);
    }
    
    public String getCodvehiculo() {
        return codvehiculo;
    }
         
    public void finalizarReparacion() {
        estado = EstadoVehiculo.DISPONIBLE;
    }

    public ArrayList<String> obtenerHistorialReparaciones() {
        return historialReaparaciones;
    }
    
    
    
}
