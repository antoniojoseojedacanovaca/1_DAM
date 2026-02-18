/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioBlackJack;
/**
 *
 * @author Usuario
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.util.List<String> nombres = new java.util.ArrayList<>();
        nombres.add("Jugador 1");
        Juego partida = new Juego(nombres);

        System.out.println(" BIENVENIDO A CASHBACK BLACKJACK (JUEGUE CON RESPONSABILIDAD)");
        partida.jugar();
    }

}
