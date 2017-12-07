package br.com.itinerario.controller;

import br.com.itinerario.enums.Permissoes;
import br.com.itinerario.facade.Facade;
import br.com.itinerario.model.Grupo;
import br.com.itinerario.utils.PermissoesUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class GrupoBean extends DefaultBean {

    private Facade fachada;

    private Grupo grupo;
    private List<Grupo> grupos;
    private String busca;

    private Permissoes permissao;
    private List<Permissoes> permissoes;
    private PermissoesUtil permissoesUtil;

    public GrupoBean() {
        super();
        permissoes = new ArrayList<>();
        permissoesUtil = new PermissoesUtil();
        this.fachada = new Facade();
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

    public void salvar() {
        try {
            grupo.setPermissoes(this.permissoesUtil.toForm());
            this.grupo = fachada.cadastrarGrupo(grupo);
            abrirDialog("sucess-dlg");
        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }
    }

    public void preparaGrupo(Grupo grupo) {
        this.grupo = grupo;
        abrirDialog("apagar-dlg");
    }

    public void removerGrupo() {
        try {
            this.grupo = this.fachada.removerGrupo(this.grupo);
            abrirDialog("sucess-dlg");
        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
            fecharDialog("apagar-dlg");
        }
    }

    public void verPermissoesGrupo(Grupo grupo, String dialog) {
        this.permissoes = grupo.getPermissoes();
        this.grupo = grupo;
        abrirDialog(dialog);
    }

    public void filtrar() {
        try {
            this.grupos = fachada.listarGrupos();
        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }

        Iterator<Grupo> intGrupo = this.grupos.iterator();
        List<Grupo> tempList = new ArrayList<Grupo>();

        while (intGrupo.hasNext()) {
            Grupo grupo = intGrupo.next();

            if (grupo.getTitulo().contains(busca)) {
                tempList.add(grupo);
            }
        }

        this.grupos = tempList;
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

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }
    
}
