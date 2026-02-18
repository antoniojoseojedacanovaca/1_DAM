/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioBlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Juego {

    private List<Jugador> jugadores;
    private MazoDeCartas mazo;
    private Scanner sc = new Scanner(System.in);

    public Juego(List<String> nombres) {
        this.mazo = new MazoDeCartas();
        this.jugadores = new ArrayList<>();
        this.sc = new Scanner(System.in);
        jugadores.add(new Jugador());
    }

    public void jugar() {
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            System.out.println("Jugador " + (i + 1) + " es tu turno");
            jugador.añadirCarta(mazo.darCarta());
            jugador.añadirCarta(mazo.darCarta());
            boolean sePlanta = false;
            while (!sePlanta && jugador.calcularJugada() < 21) {
                System.out.println("Valor actual: " + jugador.calcularJugada());
                System.out.println("¿Te plantas? (si/no)");
                String respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("si")) {
                    jugador.añadirCarta(mazo.darCarta());
                } else {
                    sePlanta = true;
                }
            }
            System.out.println("Valor de la mano: " + jugador.calcularJugada());
        }
        System.out.println("Turno del crupier: ");
        Jugador crupier = new Jugador();
        while(crupier.calcularJugada()<17){
            crupier.añadirCarta(mazo.darCarta());
        }
        int manoCrupier = crupier.calcularJugada();
        System.out.println("Valor de la mano del crupier: "+manoCrupier);
        System.out.println("Resultado: ");
        for (int i = 0; i < jugadores.size(); i++) {
            int manoJugador = jugadores.get(i).calcularJugada();
            System.out.println("Jugador: "+(i+1)+" Valor de su mano:"+manoJugador);
            if(manoJugador>21){
                System.out.println("Te has pasado.");
            }else if (manoCrupier > 21 || manoJugador > manoCrupier){
                System.out.println("Ganas (lo que hubieras apostado x2)");
            }else if (manoCrupier == manoJugador){
                System.out.println("Empate");
            }else{
                System.out.println("Pierdes");
            }
        }
    }

}
