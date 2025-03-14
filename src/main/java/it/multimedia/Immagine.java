package it.multimedia;

import lombok.Getter;

/**
 * Classe che rappresenta un'immagine.
 * Un'immagine è un elemento multimediale non riproducibile con luminosità regolabile.
 */
public class Immagine extends ElementoMultimediale {
    
    @Getter
    private int luminosita;
    
    /**
     * Costruttore per la classe Immagine.
     * 
     * @param titolo il titolo dell'immagine
     * @param luminosita la luminosità iniziale dell'immagine
     */
    public Immagine(String titolo, int luminosita) {
        super(titolo);
        if (luminosita < 0) {
            throw new IllegalArgumentException("La luminosità non può essere negativa");
        }
        this.luminosita = luminosita;
    }
    
    /**
     * Aumenta la luminosità dell'immagine di un'unità.
     * 
     * @return l'istanza corrente per permettere chiamate a catena
     */
    public Immagine aumentaLuminosita() {
        luminosita++;
        return this;
    }
    
    /**
     * Diminuisce la luminosità dell'immagine di un'unità, se possibile.
     * 
     * @return l'istanza corrente per permettere chiamate a catena
     */
    public Immagine diminuisciLuminosita() {
        if (luminosita > 0) {
            luminosita--;
        }
        return this;
    }
    
    /**
     * Mostra l'immagine, stampando il titolo seguito da asterischi
     * che rappresentano la luminosità.
     */
    public void show() {
        StringBuilder sb = new StringBuilder(titolo);
        for (int i = 0; i < luminosita; i++) {
            sb.append("*");
        }
        System.out.println(sb.toString());
    }
    
    @Override
    public void esegui() {
        show();
    }
}
