/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.planestudiopoo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Usuario
 */
public class MainVehiculos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Vehiculo> listaConcesionario = new ArrayList<>();

        try {
            listaConcesionario.add(new Coche("Bugatti", 187650));
            listaConcesionario.add(new Moto("Kawasaki", 48567));
            listaConcesionario.add(new Moto("Kasawaki", 92));
        } catch (IllegalArgumentException errorPrecio) {
            System.out.println("Ha ocurrido un error al intentar dar de alta el vehículo: " + errorPrecio.getMessage());
        }
        System.out.println("base de Datos: ");
        for (Vehiculo vehiculo : listaConcesionario) {
            System.out.println(vehiculo.getMarca() + "cuesta" + vehiculo.getPrecioBase() + "€");
        }
        Collections.sort(listaConcesionario);
    }

}
