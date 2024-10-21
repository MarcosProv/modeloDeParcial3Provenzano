package model;

import java.util.ArrayList;

public class Taller {

    private String nombreTaller;
    private ArrayList<Vehiculo> inventarioVehiculos;
    private ArrayList<Vehiculo> vehiculosEnReparacion;
    private ArrayList<Vehiculo> vehiculosFueraDeServicio;

    public Taller(String nombreTaller) {
        this.nombreTaller = nombreTaller;
        this.inventarioVehiculos = new ArrayList<Vehiculo>();
        this.vehiculosEnReparacion = new ArrayList<Vehiculo>();
        this.vehiculosFueraDeServicio = new ArrayList<Vehiculo>();
    }

    private Vehiculo buscarVehiculo(String codigo, ArrayList<Vehiculo> lista) {
        Vehiculo retorno = null;
        for (Vehiculo vehiculo : lista) {
            if (vehiculo.getCodvehiculo().equals(codigo)) {
                retorno = vehiculo;
            }
        }
        return retorno;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        if (buscarVehiculo(vehiculo.getCodvehiculo(), inventarioVehiculos) == null){
            inventarioVehiculos.add(vehiculo);
        } else {
            throw new IllegalArgumentException("El vehiculo ya existe");
        }
    }

    public double calcularCostoReparacion(String codigoVehiculo, int horas) {
        Vehiculo vehiculo = buscarVehiculo(codigoVehiculo, inventarioVehiculos);
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehiculo no existe");
        } else {
            return vehiculo.calcularCostoReparacion(horas);
        }
    }

    public void iniciarReparacion(String codigoVehiculo, String descripcion) {
        Vehiculo vehiculo = buscarVehiculo(codigoVehiculo, vehiculosEnReparacion);
        if (vehiculo != null) {
            throw new IllegalArgumentException("El vehiculo ya esta en reparacion");
        }
        vehiculo = buscarVehiculo(codigoVehiculo, inventarioVehiculos);
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehiculo no existe");
        } else {
            vehiculo.iniciarReparaciones(nombreTaller, descripcion);
        }
    }

    public void finalizarReparacion(String codigoVehiculo) {
        Vehiculo vehiculo = buscarVehiculo(codigoVehiculo, vehiculosEnReparacion);
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehiculo no esta en reparacion");
        } else {
            vehiculo.finalizarReparacion();
            vehiculosEnReparacion.remove(vehiculo);
        }
    }

    public ArrayList<Vehiculo> traerVehiculos(EstadoVehiculo estado) {
        ArrayList<Vehiculo> listaRetorno = new ArrayList<Vehiculo>();
        for (Vehiculo vehiculo : inventarioVehiculos) {
            if (vehiculo.preguntarEstado(estado)) {
                listaRetorno.add(vehiculo);
            }
        }
        return listaRetorno;
    }

    public ArrayList<Vehiculo> traerVehiculosDisponibles() {
        return traerVehiculos(EstadoVehiculo.DISPONIBLE);
    }

    public ArrayList<String> obtenerHistorialReparaciones(String codigoVehiculo) {
        Vehiculo vehiculo = buscarVehiculo(codigoVehiculo, inventarioVehiculos);
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehiculo no existe");
        } else {
            return vehiculo.getHistorialReaparaciones();
        }
    }

}
