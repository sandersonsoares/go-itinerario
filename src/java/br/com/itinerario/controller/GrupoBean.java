package br.com.itinerario.controller;

import br.com.itinerario.enums.Permissoes;
import br.com.itinerario.model.Grupo;
import br.com.itinerario.utils.PermissoesUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class GrupoBean extends DefaultBean {

    private Grupo grupo;
    private List<Grupo> grupos;

    private Permissoes permissao;
    private List<Permissoes> permissoes;
    private PermissoesUtil permissoesUtil;

    public GrupoBean() {
        super();
        permissoes = new ArrayList<>();
        permissoesUtil = new PermissoesUtil();
    }

    @PostConstruct
    private void init() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

        try {
            if (id != null) {
                this.grupo = fachada.buscarGrupo(Long.parseLong(id));
                permissoesUtil.fromForm(grupo.getPermissoes());
            } else {
                this.grupo = new Grupo();
            }

            grupos = fachada.listarGrupos();
        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }
    }

    public String salvar() {
        try {
            grupo.setPermissoes(this.permissoesUtil.toForm());
            fachada.cadastrarGrupo(grupo);
            return this.linkBean.listaGrupos();
        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }
        return null;
    }

    public void verPermissoesGrupo(Grupo grupo) {
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
