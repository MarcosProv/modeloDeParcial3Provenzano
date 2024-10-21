package test;

import java.time.LocalDate;
import model.EstadoVehiculo;
import model.Taller;
import model.VehiculoCompacto;
import model.VehiculoSUV;

public class Main {

    public static void main(String[] args) {

        Taller taller = new Taller("Pepe's");

        System.out.println("1-1");
        try {
            VehiculoCompacto compacto1 = new VehiculoCompacto(2024, "ABC123", "Toyota Corolla", 2000.0);
            taller.agregarVehiculo(compacto1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("1-2");
        try {
            VehiculoCompacto compacto2 = new VehiculoCompacto(2023, "XYZ5678", "Honda Civic", 2200.0);
            System.out.println(compacto2);
            taller.agregarVehiculo(compacto2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("1-3");
        try {
            VehiculoSUV suv1 = new VehiculoSUV(false, "QRS7890", "VehiculoSUV", 4000.0);
            System.out.println(suv1);
            taller.agregarVehiculo(suv1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("2-1");
        try {
            System.out.println(taller.calcularCostoReparacion("XYZ5678", 5));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("2-1");
        try {
            System.out.println(taller.calcularCostoReparacion("QRS7890", 3));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("3-1");
        try {
            VehiculoCompacto compacto3 = new VehiculoCompacto(2024, "LMN1111", "Volkswagen Polo", 1800.0);
            VehiculoSUV suv2 = new VehiculoSUV(true, "OPQ2222", "Toyota RAV4", 3000.0);
            taller.agregarVehiculo(suv2);
            taller.agregarVehiculo(compacto3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("3-2");
        try {
            VehiculoSUV suv3 = new VehiculoSUV(true, "LMN1111", "Ford Explorer", 3500.0);
            taller.agregarVehiculo(suv3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("4-1");
        try{
            System.out.println(taller.traerVehiculosDisponibles());
            System.out.println(taller.traerVehiculos(EstadoVehiculo.DISPONIBLE));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } 
        
         try{
            taller.iniciarReparacion("LMN1111", "Se le volo el techo");
            System.out.println(taller.traerVehiculos(EstadoVehiculo.EN_REPARACION));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
