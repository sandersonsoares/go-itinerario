package br.com.itinerario.utils;

import br.com.itinerario.enums.Permissoes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sanderson
 *
 * Permissões
 */
public class PermissoesUtil {

    /*
    Passageiros
     */
    private boolean cadastroPassageiros;
    private boolean visualizarPassageiros;
    private boolean alterarPassageiros;
    private boolean removerPassageiros;
    /*
    Veículos
     */
    private boolean cadastroVeiculos;
    private boolean visualizarVeiculos;
    private boolean alterarVeiculos;
    private boolean removerVeiculos;
    /*
    Passageiros
     */
    private boolean cadastroUsuarios;
    private boolean visualizarUsuarios;
    private boolean alterarUsuarios;
    private boolean removerUsuarios;
    /*
    Grupos
     */
    private boolean cadastroGrupos;
    private boolean visualizarGrupos;
    private boolean alterarGrupos;
    private boolean removerGrupos;
    /*
    Rotas
     */
    private boolean cadastroRotas;
    private boolean visualizarRotas;
    private boolean alterarRotas;
    private boolean removerRotas;
    /*
    Bilhetes
     */
    private boolean cadastroBilhetes;
    private boolean visualizarBilhetes;
    private boolean alterarBilhetes;
    private boolean removerBilhetes;
    /*
    Cidades
     */
    private boolean cadastroCidades;
    private boolean visualizarCidades;
    private boolean alterarCidades;
    private boolean removerCidades;

    private List<Permissoes> permissoes;

    /**
     * Recupera as flags do formulário
     *
     * @return Lista de Permissões
     */
    public List<Permissoes> toForm() {
        this.permissoes = new ArrayList<>();

        /*
          Passageiros
         */
        if (cadastroPassageiros) {
            permissoes.add(Permissoes.ROLE_CADASTRAR_PASSAGEIROS);
        }
        if (visualizarPassageiros) {
            permissoes.add(Permissoes.ROLE_VISUALIZAR_PASSAGEIROS);
        }
        if (alterarPassageiros) {
            permissoes.add(Permissoes.ROLE_ALTERAR_PASSAGEIROS);
        }
        if (removerPassageiros) {
            permissoes.add(Permissoes.ROLE_REMOVER_PASSAGEIROS);
        }
        /*
          Veículos
         */
        if (cadastroVeiculos) {
            permissoes.add(Permissoes.ROLE_CADASTRAR_VEICULOS);
        }
        if (visualizarVeiculos) {
            permissoes.add(Permissoes.ROLE_VISUALIZAR_VEICULOS);
        }
        if (alterarVeiculos) {
            permissoes.add(Permissoes.ROLE_ALTERAR_VEICULOS);
        }
        if (removerVeiculos) {
            permissoes.add(Permissoes.ROLE_REMOVER_VEICULOS);
        }
        /*
          Usuários
         */
        if (cadastroUsuarios) {
            permissoes.add(Permissoes.ROLE_CADASTRAR_USUARIOS);
        }
        if (visualizarUsuarios) {
            permissoes.add(Permissoes.ROLE_VISUALIZAR_USUARIOS);
        }
        if (alterarUsuarios) {
            permissoes.add(Permissoes.ROLE_ALTERAR_USUARIOS);
        }
        if (removerUsuarios) {
            permissoes.add(Permissoes.ROLE_REMOVER_USUARIOS);
        }
        /*
          Grupos
         */
        if (cadastroGrupos) {
            permissoes.add(Permissoes.ROLE_CADASTRAR_GRUPOS);
        }
        if (visualizarGrupos) {
            permissoes.add(Permissoes.ROLE_VISUALIZAR_GRUPOS);
        }
        if (alterarGrupos) {
            permissoes.add(Permissoes.ROLE_ALTERAR_GRUPOS);
        }
        if (removerGrupos) {
            permissoes.add(Permissoes.ROLE_REMOVER_GRUPOS);
        }
        /*
          Rotas
         */
        if (cadastroRotas) {
            permissoes.add(Permissoes.ROLE_CADASTRAR_ROTAS);
        }
        if (visualizarRotas) {
            permissoes.add(Permissoes.ROLE_VISUALIZAR_ROTAS);
        }
        if (alterarRotas) {
            permissoes.add(Permissoes.ROLE_ALTERAR_ROTAS);
        }
        if (removerRotas) {
            permissoes.add(Permissoes.ROLE_REMOVER_ROTAS);
        }
        /*
          Bilhetes
         */
        if (cadastroBilhetes) {
            permissoes.add(Permissoes.ROLE_CADASTRAR_BILHETES);
        }
        if (visualizarBilhetes) {
            permissoes.add(Permissoes.ROLE_VISUALIZAR_BILHETES);
        }
        if (alterarBilhetes) {
            permissoes.add(Permissoes.ROLE_ALTERAR_BILHETES);
        }
        if (removerBilhetes) {
            permissoes.add(Permissoes.ROLE_REMOVER_BILHETES);
        }
        /*
          Cidades
         */
        if (cadastroCidades) {
            permissoes.add(Permissoes.ROLE_CADASTRAR_CIDADES);
        }
        if (visualizarCidades) {
            permissoes.add(Permissoes.ROLE_VISUALIZAR_CIDADES);
        }
        if (alterarCidades) {
            permissoes.add(Permissoes.ROLE_ALTERAR_CIDADES);
        }
        if (removerCidades) {
            permissoes.add(Permissoes.ROLE_REMOVER_CIDADES);
        }

        permissoes.add(Permissoes.ROLE_ACESSO_SISTEMA);

        return permissoes;
    }

    /**
     * Adiciona as permissões para o formulário
     */
    public void fromForm(List<Permissoes> permissoes) {
        
        /*
          Passageiros
         */
        if (permissoes.contains(Permissoes.ROLE_CADASTRAR_PASSAGEIROS)) {
            cadastroPassageiros = true;
        }
        if (permissoes.contains(Permissoes.ROLE_VISUALIZAR_PASSAGEIROS)) {
            visualizarPassageiros = true;
        }
        if (permissoes.contains(Permissoes.ROLE_ALTERAR_PASSAGEIROS)) {
            alterarPassageiros = true;
        }
        if (permissoes.contains(Permissoes.ROLE_REMOVER_PASSAGEIROS)) {
            removerPassageiros = true;
        }
        /*
          Veículos
         */
        if (permissoes.contains(Permissoes.ROLE_CADASTRAR_VEICULOS)) {
            cadastroVeiculos = true;
        }
        if (permissoes.contains(Permissoes.ROLE_VISUALIZAR_VEICULOS)) {
            visualizarVeiculos = true;
        }
        if (permissoes.contains(Permissoes.ROLE_ALTERAR_VEICULOS)) {
            alterarVeiculos = true;
        }
        if (permissoes.contains(Permissoes.ROLE_REMOVER_VEICULOS)) {
            removerVeiculos = true;
        }
        /*
          Usuários
         */
        if (permissoes.contains(Permissoes.ROLE_CADASTRAR_USUARIOS)) {
            cadastroUsuarios = true;
        }
        if (permissoes.contains(Permissoes.ROLE_VISUALIZAR_USUARIOS)) {
            visualizarUsuarios = true;
        }
        if (permissoes.contains(Permissoes.ROLE_ALTERAR_USUARIOS)) {
            alterarUsuarios = true;
        }
        if (permissoes.contains(Permissoes.ROLE_REMOVER_USUARIOS)) {
            removerUsuarios = true;
        }
        /*
          Grupos
         */
        if (permissoes.contains(Permissoes.ROLE_CADASTRAR_GRUPOS)) {
            cadastroGrupos = true;
        }
        if (permissoes.contains(Permissoes.ROLE_ALTERAR_GRUPOS)) {
            alterarGrupos = true;
        }
        if (permissoes.contains(Permissoes.ROLE_VISUALIZAR_GRUPOS)) {
            visualizarGrupos = true;
        }
        if (permissoes.contains(Permissoes.ROLE_REMOVER_GRUPOS)) {
            removerGrupos = true;
        }
        /*
          Rotas
         */
        if (permissoes.contains(Permissoes.ROLE_CADASTRAR_ROTAS)) {
            cadastroRotas = true;
        }
        if (permissoes.contains(Permissoes.ROLE_ALTERAR_ROTAS)) {
            alterarRotas = true;
        }
        if (permissoes.contains(Permissoes.ROLE_VISUALIZAR_ROTAS)) {
            visualizarRotas = true;
        }
        if (permissoes.contains(Permissoes.ROLE_REMOVER_ROTAS)) {
            removerRotas = true;
        }
        /*
          Bilhetes
         */
        if (permissoes.contains(Permissoes.ROLE_CADASTRAR_BILHETES)) {
            cadastroBilhetes = true;
        }
        if (permissoes.contains(Permissoes.ROLE_ALTERAR_BILHETES)) {
            alterarBilhetes = true;
        }
        if (permissoes.contains(Permissoes.ROLE_VISUALIZAR_BILHETES)) {
            visualizarBilhetes = true;
        }
        if (permissoes.contains(Permissoes.ROLE_REMOVER_BILHETES)) {
            removerBilhetes = true;
        }
        /*
          Cidades
         */
        if (permissoes.contains(Permissoes.ROLE_CADASTRAR_CIDADES)) {
            cadastroCidades = true;
        }
        if (permissoes.contains(Permissoes.ROLE_ALTERAR_CIDADES)) {
            alterarCidades = true;
        }
        if (permissoes.contains(Permissoes.ROLE_VISUALIZAR_CIDADES)) {
            visualizarCidades = true;
        }
        if (permissoes.contains(Permissoes.ROLE_REMOVER_CIDADES)) {
            removerCidades = true;
        }
    }
    
    /*
    Getters e Setters
    */

    public boolean getCadastroPassageiros() {
        return cadastroPassageiros;
    }

    public void setCadastroPassageiros(boolean cadastroPassageiros) {
        this.cadastroPassageiros = cadastroPassageiros;
    }

    public boolean getVisualizarPassageiros() {
        return visualizarPassageiros;
    }

    public void setVisualizarPassageiros(boolean visualizarPassageiros) {
        this.visualizarPassageiros = visualizarPassageiros;
    }

    public boolean getAlterarPassageiros() {
        return alterarPassageiros;
    }

    public void setAlterarPassageiros(boolean alterarPassageiros) {
        this.alterarPassageiros = alterarPassageiros;
    }

    public boolean getRemoverPassageiros() {
        return removerPassageiros;
    }

    public void setRemoverPassageiros(boolean removerPassageiros) {
        this.removerPassageiros = removerPassageiros;
    }

    public boolean getCadastroVeiculos() {
        return cadastroVeiculos;
    }

    public void setCadastroVeiculos(boolean cadastroVeiculos) {
        this.cadastroVeiculos = cadastroVeiculos;
    }

    public boolean getVisualizarVeiculos() {
        return visualizarVeiculos;
    }

    public void setVisualizarVeiculos(boolean visualizarVeiculos) {
        this.visualizarVeiculos = visualizarVeiculos;
    }

    public boolean getAlterarVeiculos() {
        return alterarVeiculos;
    }

    public void setAlterarVeiculos(boolean alterarVeiculos) {
        this.alterarVeiculos = alterarVeiculos;
    }

    public boolean getRemoverVeiculos() {
        return removerVeiculos;
    }

    public void setRemoverVeiculos(boolean removerVeiculos) {
        this.removerVeiculos = removerVeiculos;
    }

    public boolean getCadastroUsuarios() {
        return cadastroUsuarios;
    }

    public void setCadastroUsuarios(boolean cadastroUsuarios) {
        this.cadastroUsuarios = cadastroUsuarios;
    }

    public boolean getVisualizarUsuarios() {
        return visualizarUsuarios;
    }

    public void setVisualizarUsuarios(boolean visualizarUsuarios) {
        this.visualizarUsuarios = visualizarUsuarios;
    }

    public boolean getAlterarUsuarios() {
        return alterarUsuarios;
    }

    public void setAlterarUsuarios(boolean alterarUsuarios) {
        this.alterarUsuarios = alterarUsuarios;
    }

    public boolean getRemoverUsuarios() {
        return removerUsuarios;
    }

    public void setRemoverUsuarios(boolean removerUsuarios) {
        this.removerUsuarios = removerUsuarios;
    }

    public boolean getCadastroGrupos() {
        return cadastroGrupos;
    }

    public void setCadastroGrupos(boolean cadastroGrupos) {
        this.cadastroGrupos = cadastroGrupos;
    }

    public boolean getVisualizarGrupos() {
        return visualizarGrupos;
    }

    public void setVisualizarGrupos(boolean visualizarGrupos) {
        this.visualizarGrupos = visualizarGrupos;
    }

    public boolean getAlterarGrupos() {
        return alterarGrupos;
    }

    public void setAlterarGrupos(boolean alterarGrupos) {
        this.alterarGrupos = alterarGrupos;
    }

    public boolean getRemoverGrupos() {
        return removerGrupos;
    }

    public void setRemoverGrupos(boolean removerGrupos) {
        this.removerGrupos = removerGrupos;
    }

    public List<Permissoes> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissoes> permissoes) {
        this.permissoes = permissoes;
    }

    public boolean isCadastroRotas() {
        return cadastroRotas;
    }

    public void setCadastroRotas(boolean cadastroRotas) {
        this.cadastroRotas = cadastroRotas;
    }

    public boolean isVisualizarRotas() {
        return visualizarRotas;
    }

    public void setVisualizarRotas(boolean visualizarRotas) {
        this.visualizarRotas = visualizarRotas;
    }

    public boolean isAlterarRotas() {
        return alterarRotas;
    }

    public void setAlterarRotas(boolean alterarRotas) {
        this.alterarRotas = alterarRotas;
    }

    public boolean isRemoverRotas() {
        return removerRotas;
    }

    public void setRemoverRotas(boolean removerRotas) {
        this.removerRotas = removerRotas;
    }

    public boolean isCadastroBilhetes() {
        return cadastroBilhetes;
    }

    public void setCadastroBilhetes(boolean cadastroBilhetes) {
        this.cadastroBilhetes = cadastroBilhetes;
    }

    public boolean isVisualizarBilhetes() {
        return visualizarBilhetes;
    }

    public void setVisualizarBilhetes(boolean visualizarBilhetes) {
        this.visualizarBilhetes = visualizarBilhetes;
    }

    public boolean isAlterarBilhetes() {
        return alterarBilhetes;
    }

    public void setAlterarBilhetes(boolean alterarBilhetes) {
        this.alterarBilhetes = alterarBilhetes;
    }

    public boolean isRemoverBilhetes() {
        return removerBilhetes;
    }

    public void setRemoverBilhetes(boolean removerBilhetes) {
        this.removerBilhetes = removerBilhetes;
    }

    public boolean isCadastroCidades() {
        return cadastroCidades;
    }

    public void setCadastroCidades(boolean cadastroCidades) {
        this.cadastroCidades = cadastroCidades;
    }

    public boolean isVisualizarCidades() {
        return visualizarCidades;
    }

    public void setVisualizarCidades(boolean visualizarCidades) {
        this.visualizarCidades = visualizarCidades;
    }

    public boolean isAlterarCidades() {
        return alterarCidades;
    }

    public void setAlterarCidades(boolean alterarCidades) {
        this.alterarCidades = alterarCidades;
    }

    public boolean isRemoverCidades() {
        return removerCidades;
    }

    public void setRemoverCidades(boolean removerCidades) {
        this.removerCidades = removerCidades;
    }
    
    

}
