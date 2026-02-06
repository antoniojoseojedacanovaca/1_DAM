/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planestudiopoo;

/**
 *
 * @author Usuario
 */
public abstract class Vehiculo implements Comparable<Vehiculo>{

    private String marca;
    private double precioBase;

    public Vehiculo(String marca, double precioBase) {
        if (this.getPrecioBase() <= 0) {
            throw new IllegalArgumentException("El precio debe de ser superior a 0€.");
        }
        this.marca = marca;
        this.precioBase = precioBase;

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public abstract double calcularPrecioFinal();

    @Override
    public int compareTo(Vehiculo o){
        // Uso double porque el precio suele tener decimales así que
        // esto devolvera:
        // -1 si this es más barato
        // 0 si valen igual
        // 1 si this es más caro 
        return Double.compare(this.getPrecioBase(), o.getPrecioBase());
    }
    
}
