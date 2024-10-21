package model;

public class VehiculoSUV extends Vehiculo {

    private boolean traccionIntengra;

    public VehiculoSUV(boolean traccionIntengra, String codvehiculo, String modelo, double precioBase) {
        super(codvehiculo, modelo, precioBase);
        this.traccionIntengra = traccionIntengra;
    }

private boolean esTraccionIntegral(){
    return traccionIntengra;
}

    @Override
    public double calcularCostoReparacion(int horas) {
        double costoTotal = (precioBase * horas);
        if(esTraccionIntegral()){
            costoTotal *= 1.10;
        }
        return costoTotal;
    }

    @Override
    public String toString() {
        
        return super.toString() + "VehiculoSUV{" + "traccionIntengra=" + traccionIntengra + '}';
    }
    

}
