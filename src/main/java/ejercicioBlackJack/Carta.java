/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioBlackJack;

import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class Carta {

    private Palos palo;
    private String valor;
    static final String[] PALOS = {"♠", "♦", "♣", "♥"};

    public Carta(Palos palo, String valor) {
        this.palo = palo;
        this.valor = valor;
    }

    public Palos getPalo() {
        return palo;
    }

    public void setPalo(Palos palo) {
        this.palo = palo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    String dameCaracterPalo() {
        return switch (getPalo()) {
            case PICAS ->
                PALOS[0];
            case DIAMANTES ->
                PALOS[1];
            case TREBOLES ->
                PALOS[2];
            case CORAZONES ->
                PALOS[3];

        };

    }

    @Override
    public String toString() {
        return String.format("""
                ----- 
               |%-2s   |
               |  %s  |
               |   %2s|
                -----%n
               """, valor, dameCaracterPalo(), valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.palo, this.valor);
    }

}
