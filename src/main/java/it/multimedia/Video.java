package it.multimedia;

import lombok.Getter;

/**
 * Classe che rappresenta un video.
 * Un video è un elemento multimediale riproducibile con volume e luminosità regolabili.
 */
public class Video extends ElementoMultimediale implements Riproducibile {
    
    @Getter
    private final int durata;
    @Getter
    private int volume;
    @Getter
    private int luminosita;
    
    /**
     * Costruttore per la classe Video.
     * 
     * @param titolo il titolo del video
     * @param durata la durata in secondi del video
     * @param volume il volume iniziale del video
     * @param luminosita la luminosità iniziale del video
     */
    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo);
        if (durata <= 0) {
            throw new IllegalArgumentException("La durata deve essere positiva");
        }
        if (volume < 0) {
            throw new IllegalArgumentException("Il volume non può essere negativo");
        }
        if (luminosita < 0) {
            throw new IllegalArgumentException("La luminosità non può essere negativa");
        }
        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;
    }
    
    /**
     * Aumenta il volume del video di un'unità.
     * 
     * @return l'istanza corrente per permettere chiamate a catena
     */
    public Video alzaVolume() {
        volume++;
        return this;
    }
    
    /**
     * Diminuisce il volume del video di un'unità, se possibile.
     * 
     * @return l'istanza corrente per permettere chiamate a catena
     */
    public Video abbassaVolume() {
        if (volume > 0) {
            volume--;
        }
        return this;
    }
    
    /**
     * Aumenta la luminosità del video di un'unità.
     * 
     * @return l'istanza corrente per permettere chiamate a catena
     */
    public Video aumentaLuminosita() {
        luminosita++;
        return this;
    }
    
    /**
     * Diminuisce la luminosità del video di un'unità, se possibile.
     * 
     * @return l'istanza corrente per permettere chiamate a catena
     */
    public Video diminuisciLuminosita() {
        if (luminosita > 0) {
            luminosita--;
        }
        return this;
    }
    
    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            StringBuilder sb = new StringBuilder(titolo);
            
            // Aggiunge punti esclamativi per il volume
            for (int j = 0; j < volume; j++) {
                sb.append("!");
            }
            
            // Aggiunge asterischi per la luminosità
            for (int j = 0; j < luminosita; j++) {
                sb.append("*");
            }
            
            System.out.println(sb.toString());
        }
    }
    
    @Override
    public void esegui() {
        play();
    }
}
