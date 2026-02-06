/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planestudiopoo;

/**
 *
 * @author Usuario
 */
public class Moto extends Vehiculo {

    public Moto(String marca, double precioBase) {
        super(marca, precioBase);
    }

    @Override
    public double calcularPrecioFinal() {
        return this.getPrecioBase() + (this.getPrecioBase()*0.1);
    }
    
}
