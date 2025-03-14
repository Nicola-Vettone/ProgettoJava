package it.multimedia;

import lombok.Getter;

/**
 * Classe che rappresenta una registrazione audio.
 */
public class Audio extends ElementoMultimediale implements Riproducibile {
    
    @Getter
    private final int durata;
    @Getter
    private int volume;
    
    /**
     * Costruttore per la classe Audio.
     * 
     * @param titolo il titolo dell'audio
     * @param durata la durata in secondi dell'audio
     * @param volume il volume iniziale dell'audio
     */
    public Audio(String titolo, int durata, int volume) {
        super(titolo);
        if (durata <= 0) {
            throw new IllegalArgumentException("La durata deve essere positiva");
        }
        if (volume < 0) {
            throw new IllegalArgumentException("Il volume non può essere negativo");
        }
        this.durata = durata;
        this.volume = volume;
    }
    
    /**
     * Aumenta il volume dell'audio di un'unità.
     * 
     * @return l'istanza corrente per permettere chiamate a catena
     */
    public Audio alzaVolume() {
        volume++;
        return this;
    }
    
    /**
     * Diminuisce il volume dell'audio di un'unità, se possibile.
     * 
     * @return l'istanza corrente per permettere chiamate a catena
     */
    public Audio abbassaVolume() {
        if (volume > 0) {
            volume--;
        }
        return this;
    }
    
    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            StringBuilder sb = new StringBuilder(titolo);
            for (int j = 0; j < volume; j++) {
                sb.append("!");
            }
            System.out.println(sb.toString());
        }
    }
    
    @Override
    public void esegui() {
        play();
    }
}
