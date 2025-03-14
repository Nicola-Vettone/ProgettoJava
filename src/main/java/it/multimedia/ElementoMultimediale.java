package it.multimedia;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Classe astratta che rappresenta un elemento multimediale generico.
 * Un elemento multimediale è identificato da un titolo.
 */
@Getter
@RequiredArgsConstructor
public abstract class ElementoMultimediale {
    
    /**
     * Titolo dell'elemento multimediale
     */
    protected final String titolo;
    
    /**
     * Esegue l'elemento multimediale.
     * Il comportamento dipende dal tipo specifico di elemento.
     */
    public abstract void esegui();
}
