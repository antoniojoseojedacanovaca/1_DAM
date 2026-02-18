/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioBlackJack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class MazoDeCartas {
       private HashSet<Carta> cartas;
    final static String[] valores = {"2", "3", "4", "5", "6", "8", "9", "10", "J", "Q", "K", "A"};

    public MazoDeCartas() {
        cartas = new HashSet<Carta>();
        for (Palos palo : Palos.values()) {
            for (String valor : valores) {
                cartas.add(new Carta(palo, valor));
            }
        }
        

    }
    Carta darCarta() {
    List<Carta> listaCartas = new ArrayList<>(cartas);
    Random aleatorio = new Random();   
    int nCarta = aleatorio.nextInt(listaCartas.size());
    Carta carta = listaCartas.get(nCarta);    
    cartas.remove(carta); 
    return carta;
}

}
