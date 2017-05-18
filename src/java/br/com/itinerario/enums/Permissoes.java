package br.com.itinerario.enums;

public enum Permissoes {

//    Cadastros
    C_PASSAGEIROS("Cadastro de Passageiros"),
    C_VEICULOS("Cadastro de Veículos");
    
    private String permissao;

    private Permissoes(String permissao) {
        this.permissao = permissao;
    }

    public String getPermissao() {
        return permissao;
    }
    
}
