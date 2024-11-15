/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baide_ramon_idclasetrabajo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author eliza
 */
public class Baide_Ramon_IDCLASETRABAJO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        
        ArrayList<String> palabras = new ArrayList<>();
        System.out.println("Por favor, ingresa 10 palabras para el juego:");

        
        for (int i = 1; i <= 10; i++) {
            System.out.print("Palabra " + i + ": ");
            palabras.add(scanner.nextLine().toUpperCase());
        }

        boolean jugar = true;
        while (jugar) {
            
            System.out.println("\nPalabras disponibles: " + palabras);

            
            String palabra = palabras.get(random.nextInt(palabras.size()));
            char[] adivinada = new char[palabra.length()];
            for (int i = 0; i < palabra.length(); i++) {
                adivinada[i] = '_';
            }

            int oportunidades = 5;
            boolean palabraAdivinada = false;

            System.out.println("\n¡Comencemos el juego de adivinar la palabra!");

            while (oportunidades > 0 && !palabraAdivinada) {
                
                System.out.println("\nPalabra actual: " + String.valueOf(adivinada));
                System.out.println("Oportunidades restantes: " + oportunidades);
                System.out.print("Ingresa un carácter: ");
                char intento = scanner.nextLine().toUpperCase().charAt(0);

                
                boolean acierto = false;
                for (int i = 0; i < palabra.length(); i++) {
                    if (palabra.charAt(i) == intento && adivinada[i] == '_') {
                        adivinada[i] = intento;
                        acierto = true;
                    }
                }

                if (acierto) {
                    System.out.println("¡Le pegaste a un carácter!");
                } else {
                    System.out.println("Ese carácter no está en la palabra.");
                    oportunidades--;
                }

                
                palabraAdivinada = String.valueOf(adivinada).equals(palabra);
            }

            
            if (palabraAdivinada) {
                System.out.println("\n¡Felicidades! Adivinaste la palabra: " + palabra);
            } else {
                System.out.println("\nLo siento, se te acabaron las oportunidades. La palabra era: " + palabra);
            }

            
            System.out.print("\n¿Quieres jugar otra vez? (s/n): ");
            char respuesta = scanner.nextLine().toLowerCase().charAt(0);
            jugar = respuesta == 's';
        }

        System.out.println("¡Gracias por jugar!");
    }
    
}
