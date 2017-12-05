package br.com.itinerario.enums;

/**
 *
 * @author Sandersoon
 */
public enum FormaPagamento {
    
    DINHEIRO("Dinheiro"),
    CARTAO_CREDITO("Cartão de Crédito"),
    CARTAO_DEBITO("Cartão de Débito");

    private String formaPagamento;

    private FormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }


    @Override
    public String toString() {
        return formaPagamento;
    }
    
}
