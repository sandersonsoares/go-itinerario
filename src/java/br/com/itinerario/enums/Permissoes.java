package br.com.itinerario.enums;

public enum Permissoes {

    //    SISTEMA
    ROLE_ACESSO_SISTEMA("Acesso ao Sistema"),
    //    PASSAGEIROS
    ROLE_CADASTRAR_PASSAGEIROS("Cadastro de Passageiros"),
    ROLE_VISUALIZAR_PASSAGEIROS("Visualização de Passageiros"),
    ROLE_ALTERAR_PASSAGEIROS("Alteração de Passageiros"),
    ROLE_REMOVER_PASSAGEIROS("Remoção de Passageiros"),
    //    VEICULOS
    ROLE_CADASTRAR_VEICULOS("Cadastro de Veículos"),
    ROLE_VISUALIZAR_VEICULOS("Visualização de Veículos"),
    ROLE_ALTERAR_VEICULOS("Alteração de Veículos"),
    ROLE_REMOVER_VEICULOS("Remoção de Veículos"),
    //    USUARIOS
    ROLE_CADASTRAR_USUARIOS("Cadastro de Usuários do Sistema"),
    ROLE_VISUALIZAR_USUARIOS("Visualização de Usuários do Sistema"),
    ROLE_ALTERAR_USUARIOS("Alteração de Usuários do Sistema"),
    ROLE_REMOVER_USUARIOS("Remoção de Usuários do Sistema"),
    //    GRUPOS
    ROLE_CADASTRAR_GRUPOS("Cadastro de Grupos de Usuários"),
    ROLE_VISUALIZAR_GRUPOS("Visualização de Grupos de Usuários"),
    ROLE_ALTERAR_GRUPOS("Alteração de Grupos de Usuários"),
    ROLE_REMOVER_GRUPOS("Remoção de Grupos de Usuários"),
    //    ROTAS
    ROLE_CADASTRAR_ROTAS("Cadastro de Rotas"),
    ROLE_VISUALIZAR_ROTAS("Visualização de Rotas"),
    ROLE_ALTERAR_ROTAS("Alteração de Rotas"),
    ROLE_REMOVER_ROTAS("Remoção de Rotas"),
    //    BILHETES
    ROLE_CADASTRAR_BILHETES("Cadastro de Bilhetes"),
    ROLE_VISUALIZAR_BILHETES("Visualização de Bilhetes"),
    ROLE_ALTERAR_BILHETES("Alteração de Bilhetes"),
    ROLE_REMOVER_BILHETES("Remoção de Bilhetes"),
    //    CIDADES
    ROLE_CADASTRAR_CIDADES("Cadastro de Cidades"),
    ROLE_VISUALIZAR_CIDADES("Visualização de Cidades"),
    ROLE_ALTERAR_CIDADES("Alteração de Cidades"),
    ROLE_REMOVER_CIDADES("Remoção de Cidades");

    private String permissao;

    private Permissoes(String permissao) {
        this.permissao = permissao;
    }

    public String getPermissao() {
        return permissao;
    }

}
