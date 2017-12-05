package br.com.itinerario.enums;

/**
 *
 * @author Sandersoon
 */
public enum LadoAssento {
    
    DIREITO("Direito"),
    ESQUERDO("Esquerdo");

    private String ladoAssento;

    private LadoAssento(String ladoAssento) {
        this.ladoAssento = ladoAssento;
    }

    public String getLadoAssento() {
        return ladoAssento;
    }

    @Override
    public String toString() {
        return ladoAssento;
    }
    
}
