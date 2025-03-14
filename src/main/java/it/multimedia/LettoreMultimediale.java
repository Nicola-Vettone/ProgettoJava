package it.multimedia;

import java.util.Scanner;

/**
 * Lettore multimediale che gestisce 5 elementi
 */
public class LettoreMultimediale {
    
    private static final int MAX_ELEMENTI = 5;
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        ElementoMultimediale[] elementi = new ElementoMultimediale[MAX_ELEMENTI];
        
        // Crea elementi
        for (int i = 0; i < MAX_ELEMENTI; i++) {
            System.out.println("\nElemento " + (i + 1) + ":");
            elementi[i] = creaElemento();
        }
        
        // Esegui elementi
        int scelta;
        do {
            System.out.println("\nElemento da eseguire? (1-5, 0 per uscire):");
            scelta = leggiIntero(0, MAX_ELEMENTI);
            
            if (scelta > 0) {
                elementi[scelta - 1].esegui();
            }
        } while (scelta != 0);
        
        System.out.println("Programma terminato.");
        scanner.close();
    }
    
    // Crea un elemento multimediale
    private static ElementoMultimediale creaElemento() {
        System.out.println("Tipo? (1=Immagine, 2=Audio, 3=Video):");
        int tipo = leggiIntero(1, 3);
        
        System.out.println("Titolo:");
        String titolo = scanner.nextLine();
        
        switch (tipo) {
            case 1: // Immagine
                System.out.println("Luminosità:");
                int luminosita = leggiInteroPositivo();
                return new Immagine(titolo, luminosita);
                
            case 2: // Audio
                System.out.println("Durata:");
                int durataAudio = leggiInteroPositivo();
                System.out.println("Volume:");
                int volumeAudio = leggiInteroPositivo();
                return new Audio(titolo, durataAudio, volumeAudio);
                
            case 3: // Video
                System.out.println("Durata:");
                int durataVideo = leggiInteroPositivo();
                System.out.println("Volume:");
                int volumeVideo = leggiInteroPositivo();
                System.out.println("Luminosità:");
                int luminositaVideo = leggiInteroPositivo();
                return new Video(titolo, durataVideo, volumeVideo, luminositaVideo);
                
            default:
                throw new IllegalStateException("Tipo non valido");
        }
    }
    
    // Legge un intero tra min e max
    private static int leggiIntero(int min, int max) {
        while (true) {
            try {
                int valore = Integer.parseInt(scanner.nextLine());
                if (valore >= min && valore <= max) {
                    return valore;
                }
                System.out.println("Valore tra " + min + " e " + max + ":");
            } catch (NumberFormatException e) {
                System.out.println("Numero valido:");
            }
        }
    }
    
    // Legge un intero positivo
    private static int leggiInteroPositivo() {
        while (true) {
            try {
                int valore = Integer.parseInt(scanner.nextLine());
                if (valore > 0) {
                    return valore;
                }
                System.out.println("Valore positivo:");
            } catch (NumberFormatException e) {
                System.out.println("Numero valido:");
            }
        }
    }
}
