/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioBlackJack;

import java.util.HashSet;

/**
 *
 * @author Usuario
 */
public class Jugador {

    HashSet<Carta> misCartas;

    public Jugador() {
        misCartas = new HashSet<Carta>();
    }

    public void añadirCarta(Carta c) {
        misCartas.add(c);
    }

    public HashSet<Carta> getMisCartas() {
        return misCartas;
    }

    public void setMisCartas(HashSet<Carta> misCartas) {
        this.misCartas = misCartas;
    }

    public int calcularJugada() {
        int valor = 0;
        int ases = 0;
        for (Carta c : misCartas) {
            if (c.getValor().equalsIgnoreCase("A")) {
                ases++;
                valor += 11;
            } else if (c.getValor().equalsIgnoreCase("K") || c.getValor().equalsIgnoreCase("Q") || c.getValor().equalsIgnoreCase("J")) {
                valor += 10;
            } else {
                valor += Integer.parseInt(c.getValor());
            }
        }
        while (valor > 21 && ases > 0) {
            valor -= 10;
            ases--;
        }
        return valor;
    }
}
