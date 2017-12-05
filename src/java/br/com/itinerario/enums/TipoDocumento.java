package br.com.itinerario.enums;

/**
 *
 * @author Sandersoon
 */
public enum TipoDocumento {

    CPF("CPF"),
    IDENTIDADE("Identidade"),
    CNH("CNH"),
    OUTRO("Outro");

    private String tipoDocumento;

    private TipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    @Override
    public String toString() {
        return tipoDocumento;
    }

}
