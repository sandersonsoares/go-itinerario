package br.com.itinerario.controller;

import br.com.itinerario.enums.Permissoes;
import br.com.itinerario.facade.Facade;
import br.com.itinerario.model.Grupo;
import br.com.itinerario.utils.PermissoesUtil;
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
    private List<Grupo> grupos;
    
    private Permissoes permissao;
    private List<Permissoes> permissoes;
    private PermissoesUtil permissoesUtil;

    private Facade fachada;

    public GrupoBean() {
        this.grupo = new Grupo();
        permissoes = new ArrayList<>();
        permissoesUtil = new PermissoesUtil();
        fachada = new Facade();
    }

    @PostConstruct
    private void init() {
        try {
            grupos = fachada.listarGrupos();
        } catch (Exception ex) {
            Logger.getLogger(GrupoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar() {
        try {
            grupo.setPermissoes(this.permissoesUtil.toForm());
            fachada.cadastrarGrupo(grupo);
        } catch (Exception ex) {
            Logger.getLogger(GrupoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void verPermissoesGrupo(Grupo grupo){
        this.permissoes = grupo.getPermissoes();
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

    public PermissoesUtil getPermissoesUtil() {
        return permissoesUtil;
    }

    public void setPermissoesUtil(PermissoesUtil permissoesUtil) {
        this.permissoesUtil = permissoesUtil;
    }

    public Permissoes getPermissao() {
        return permissao;
    }

}
