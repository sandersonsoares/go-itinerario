package br.com.itinerario.utils;

import br.com.itinerario.enums.Permissoes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sanderson
 */
public class PermissoesUtil {

//    PERMISSOES ////////////////////////////////
    // Sistema
    private boolean acessoSistema;
    // Passageiros
    private boolean cadastroPassageiros;
    private boolean visualizarPassageiros;
    private boolean alterarPassageiros;
    private boolean removerPassageiros;
    // Veiculos
    private boolean cadastroVeiculos;
    private boolean visualizarVeiculos;
    private boolean alterarVeiculos;
    private boolean removerVeiculos;
    // Usuarios
    private boolean cadastroUsuarios;
    private boolean visualizarUsuarios;
    private boolean alterarUsuarios;
    private boolean removerUsuarios;
    //Grupos
    private boolean cadastroGrupos;
    private boolean visualizarGrupos;
    private boolean alterarGrupos;
    private boolean removerGrupos;
    
/////////////////////////////////////////////////

//    Variaveis
    private List<Permissoes> permissoes;

    public List<Permissoes> toForm() {
        this.permissoes = new ArrayList<>();
        if (cadastroPassageiros){
            permissoes.add(Permissoes.ROLE_CADASTRAR_PASSAGEIROS);
        }
        if (visualizarPassageiros){
            permissoes.add(Permissoes.ROLE_VISUALIZAR_PASSAGEIROS);
        }
        if (alterarPassageiros){
            permissoes.add(Permissoes.ROLE_ALTERAR_PASSAGEIROS);
        }
        if (removerPassageiros){
            permissoes.add(Permissoes.ROLE_REMOVER_PASSAGEIROS);
        }
        if (cadastroVeiculos){
            permissoes.add(Permissoes.ROLE_CADASTRAR_VEICULOS);
        }
        if (visualizarVeiculos){
            permissoes.add(Permissoes.ROLE_VISUALIZAR_VEICULOS);
        }
        if (alterarVeiculos){
            permissoes.add(Permissoes.ROLE_ALTERAR_VEICULOS);
        }
        if (removerVeiculos){
            permissoes.add(Permissoes.ROLE_REMOVER_VEICULOS);
        }
        if (cadastroUsuarios){
            permissoes.add(Permissoes.ROLE_CADASTRAR_USUARIOS);
        }
        if (visualizarUsuarios){
            permissoes.add(Permissoes.ROLE_VISUALIZAR_USUARIOS);
        }
        if (alterarUsuarios){
            permissoes.add(Permissoes.ROLE_ALTERAR_USUARIOS);
        }
        if (removerUsuarios){
            permissoes.add(Permissoes.ROLE_REMOVER_USUARIOS);
        }
        if (cadastroGrupos){
            permissoes.add(Permissoes.ROLE_CADASTRAR_GRUPOS);
        }
        if (visualizarGrupos){
            permissoes.add(Permissoes.ROLE_VISUALIZAR_GRUPOS);
        }
        if (alterarGrupos){
            permissoes.add(Permissoes.ROLE_ALTERAR_GRUPOS);
        }
        if (removerGrupos){
            permissoes.add(Permissoes.ROLE_REMOVER_GRUPOS);
        }
        if (acessoSistema) {
            permissoes.add(Permissoes.ROLE_ACESSO_SISTEMA);
        }
        
        return permissoes;
    }

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

    public boolean isAcessoSistema() {
        return acessoSistema;
    }

    public void setAcessoSistema(boolean acessoSistema) {
        this.acessoSistema = acessoSistema;
    }

    public List<Permissoes> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissoes> permissoes) {
        this.permissoes = permissoes;
    }

    
}
