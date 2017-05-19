package br.com.itinerario.controller;

import br.com.itinerario.enums.Permissoes;
import br.com.itinerario.facade.Facade;
import br.com.itinerario.model.Grupo;
import br.com.itinerario.model.Usuario;
import br.com.itinerario.utils.PaginationUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class GrupoBean extends DefaultBean {

    private Grupo grupo;
    private Usuario usuario;
    private List<Usuario> usuarios;
    private List<Grupo> grupos;
    private Permissoes permissao;
    private List<Permissoes> permissoes;
    private Facade fachada;
    
//    Paginação
    private int quantidadePorPagina;
    private PaginationUtil pagination;
    private int paginaAtiva;

    public GrupoBean() {
        quantidadePorPagina = 5;
        paginaAtiva = 1;
        permissoes = new ArrayList<>();
        fachada = new Facade();
    }

    @PostConstruct
    private void init() {
        this.grupo = new Grupo();
        gerarLista();
        pagination = new PaginationUtil((List<Object>) (List) this.permissoes, quantidadePorPagina);
        permissoes = (List<Permissoes>) (List) pagination.getListaPaginada();
    }

    public void adicionarPermissao(Permissoes valor) {
        this.grupo.getPermissoes().add(valor);
        this.permissoes = (List<Permissoes>) (List) this.pagination.getLista();
        this.permissoes.remove(valor);
        pagination = new PaginationUtil((List<Object>) (List) this.permissoes, quantidadePorPagina);
        permissoes = (List<Permissoes>) (List) pagination.getListaPaginada();

    }

    public void removerPermissao(Permissoes valor) {
        this.grupo.getPermissoes().remove(valor);
        this.permissoes = (List<Permissoes>) (List) this.pagination.getLista();
        this.permissoes.add(valor);
        pagination = new PaginationUtil((List<Object>) (List) this.permissoes, quantidadePorPagina);
        permissoes = (List<Permissoes>) (List) pagination.getListaPaginada();
    }
    
    public void salvar(){
        try {
            fachada.cadastrarGrupo(grupo);
        } catch (Exception ex) {
            Logger.getLogger(GrupoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void gerarLista() {
        this.permissoes = new ArrayList<>();

        for (Permissoes elemento : getListarPermissoes()) {
            this.permissoes.add(elemento);
        }
    }

    public void getPagina(int numeroPagina) {
        this.pagination.getPagina(numeroPagina);
        this.permissoes = (List<Permissoes>) (List) pagination.getListaPaginada();
    }

    public int getPaginaAtiva() {
        return paginaAtiva;
    }

    public void setPaginaAtiva(int paginaAtiva) {
        this.paginaAtiva = paginaAtiva;
    }

    public PaginationUtil getPagination() {
        return pagination;
    }

    public void setPagination(PaginationUtil pagination) {
        this.pagination = pagination;
    }

    public List<Permissoes> getPermissoes() {
        return permissoes;
    }

    public Permissoes[] getListarPermissoes() {
        return Permissoes.values();
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
}
