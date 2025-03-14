package it.multimedia;

/**
 * Interfaccia che definisce un elemento multimediale riproducibile.
 * Un elemento è riproducibile se ha una durata e può essere riprodotto.
 */
public interface Riproducibile {
    
    /**
     * Riproduce l'elemento multimediale.
     */
    void play();
    
    /**
     * Restituisce la durata dell'elemento multimediale.
     * @return la durata in secondi
     */
    int getDurata();
}
