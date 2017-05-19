package br.com.itinerario.enums;

public enum Permissoes {

//    Cadastros
    C_PASSAGEIROS("Cadastro de Passageiros"),
    C_VEICULOS("Cadastro de Veículos"),
    C_USUARIOS("Cadastro de Usuários do Sistema"),
    C_GRUPOS("Cadastro de Grupos de Usuários"),
    //    VISUALIZAÇÃO
    R_PASSAGEIROS("Visualização de Passageiros"),
    R_VEICULOS("Visualização de Veículos"),
    R_USUARIOS("Visualização de Usuários do Sistema"),
    R_GRUPOS("Visualização de Grupos de Usuários"),
    //    ALTERAÇÃO
    U_PASSAGEIROS("Alteração de Passageiros"),
    U_VEICULOS("Alteração de Veículos"),
    U_USUARIOS("Alteração de Usuários do Sistema"),
    U_GRUPOS("Alteração de Grupos de Usuários"),
    //    REMOÇÃO
    D_PASSAGEIROS("Remoção de Passageiros"),
    D_VEICULOS("Remoção de Veículos"),
    D_USUARIOS("Remoção de Usuários do Sistema"),
    D_GRUPOS("Remoção de Grupos de Usuários");

    private String permissao;

    private Permissoes(String permissao) {
        this.permissao = permissao;
    }

    public String getPermissao() {
        return permissao;
    }

}
