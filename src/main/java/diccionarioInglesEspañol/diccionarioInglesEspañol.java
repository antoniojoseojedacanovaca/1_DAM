/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package diccionarioInglesEspañol;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class diccionarioInglesEspañol {

    /**
     * @param args the command line arguments
     */
    // Usamos HashMap porque no necesitamos orden específico (es más rápido)
    private static Map<String, Entrada> diccionario = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcionEscogida = 0;
        diccionario.put("de", new Entrada("de", "of"));
        diccionario.put("cordoba", new Entrada("Córdoba", "Cordoba"));
        diccionario.put("soy", new Entrada("soy", "I am"));
        diccionario.put("informatico", new Entrada("informatico", "computer scientist"));
        diccionario.put("bienvenido", new Entrada("bienvenido", "welcome"));
        do {
            mostrarMenu();
            opcionEscogida = sc.nextInt();
            sc.nextLine();
            switch (opcionEscogida) {
                case 1 -> {
                    insertarPalabra();
                }
                case 2 -> {
                    buscarPalabra();
                }
                case 3 -> {
                    editarEntrada();
                }
                case 4 -> {
                    traducirFrase();
                }
                case 5 -> {
                    System.out.println("Salida completada, vuelva pronto");
                }
                default ->
                    System.out.println("Introduzca una opción válida (1-5)");
            }
        } while (opcionEscogida != 5);

    }

    public static void mostrarMenu() {
        System.out.println("""
                           Introduzca una opción de las siguientes:
                           
                           1.- Inserta una nueva palabra en el diccionario (par Español-Inglés).
                           2.- Busca una palabra en el diccionario.
                           3.- Edita una entrada de diccionario.
                           4.- Traduce una frase.
                           5.- Salir.
                           
                           """);
    }

    public static void insertarPalabra() {
        System.out.print("Introduce palabra en español: ");
        String esp = sc.nextLine();
        System.out.print("Introduce traducción al inglés: ");
        String ing = sc.nextLine();
        // Creamos la entrada con lo nuevo
        Entrada nueva = new Entrada(esp, ing);
        // Se guarda en el map
        diccionario.put(esp, nueva);
        System.out.println("La palabra se añadión con éxito :)");
    }

    public static void buscarPalabra() {
        System.out.print("Escribe la palabra para traducirla: ");
        String palabra = sc.nextLine();

        // Primero miramos si está en español (clave)
        if (diccionario.containsKey(palabra)) {
            System.out.println("Resultado: " + diccionario.get(palabra).getValor());
        } // Segundo miramos si está en inglés (valor)
        else {
            boolean palabraEncontrada = false;
            for (Entrada e : diccionario.values()) {
                if (e.getValor().equalsIgnoreCase(palabra)) {
                    System.out.println("Resultado: " + e.getClave());
                    palabraEncontrada = true;
                    break;
                }
            }
            if (!palabraEncontrada) {
                System.out.println("La palabra no existe en el diccionario");
            }
        }
    }

    public static void editarEntrada() {
        System.out.println("""
                           Escoga una opción:
                           
                           1. Editar traducción español a inglés
                           2. Editar traducción inglés a español
                           """);
        int opcionEscogida = sc.nextInt();
        switch (opcionEscogida) {
            case 1 -> {
                System.out.println("Que palabra en español quieres editar");
                String esp = sc.nextLine();

                if (diccionario.containsKey(esp)) {
                    System.out.println("Introduce la traduccion nueva");
                    String traduccionNuevaEsp = sc.nextLine();
                    diccionario.get(esp).setValor(traduccionNuevaEsp);
                    System.out.println("La palabra se editó con éxito");
                } else {
                    System.out.println("La palabra a traducir no existe");
                }
            }
            case 2 -> {
                System.out.println("¿Qué palabra en inglés quieres editar?");
                String eng = sc.nextLine().toLowerCase();
                Entrada encontrada = null;

                // Buscamos el objeto que tiene ese valor en inglés
                for (Entrada e : diccionario.values()) {
                    if (e.getValor().equalsIgnoreCase(eng)) {
                        encontrada = e;
                        break;
                    }
                }

                if (encontrada != null) {
                    System.out.println("Introduce el nuevo término en español:");
                    String nuevoEsp = sc.nextLine().toLowerCase();

                    // Como el español es la clave, hay que borrar la vieja y poner la nueva
                    diccionario.remove(encontrada.getClave());
                    encontrada.setClave(nuevoEsp);
                    diccionario.put(nuevoEsp, encontrada);

                    System.out.println("¡Editado con éxito!");
                } else {
                    System.out.println("Esa traducción no existe.");
                }
            }
            default -> {
                System.out.println("Introduzca una opción valida, 1 o 2.");
            }
        }
    }

    public static void traducirFrase() {
        System.out.println("Introduce la frase que quieres traducir");
        String fraseEscogida = sc.nextLine().toLowerCase(); // minuscula para evitar errores
        
        // tenemos que dividir la frase con espacios para que no se vea todo junto 
        String[] palabra = fraseEscogida.split(" ");
        
        // aqi ponemos la frase final ya con su traduccion y todo eso
        String fraseTraducida = "";
        // esto ya es mas facil porque recorremos el array
        for (String p : palabra) {
            // comprobamos que esta en el diccionario en español (clave)
            if(diccionario.containsKey(p)){
                // llamamos al Entrada para conseguir la palabra en ingles (valor)
                Entrada aux = diccionario.get(p);
                fraseTraducida += aux.getValor() + " "; // para que se vea bonita
            }else{
                fraseTraducida += "Palabra desconocida ";
            }
        }
        System.out.println("Frase traducida: " + fraseTraducida.trim());
    }
}
