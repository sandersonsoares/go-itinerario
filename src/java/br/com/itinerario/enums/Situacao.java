package br.com.itinerario.enums;

/**
 *
 * @author Sandersoon
 */
public enum Situacao {

    DISPONIVEL("Disponível"),
    RESERVADO("Reservado"),
    VENDIDO("Vendido"),
    CANCELADO("Cancelado");

    private String situacao;

    private Situacao(String situacao) {
        this.situacao = situacao;
    }

    public String getSexo() {
        return situacao;
    }

    @Override
    public String toString() {
        return situacao;
    }

}
