package br.com.itinerario.controller;

import br.com.itinerario.enums.Estados;
import br.com.itinerario.exception.DAOException;
import br.com.itinerario.facade.Facade;
import br.com.itinerario.model.Cidade;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Sanderson
 */
@ManagedBean
@ViewScoped
public class CidadeBean extends DefaultBean {
    
    private Facade fachada;

    private Cidade cidade;
    private List<Cidade> cidades;

    private String busca;

    public CidadeBean() {
        this.cidade = new Cidade();
        this.cidades = new ArrayList<>();
        this.fachada = new Facade();
    }

    @PostConstruct
    private void init() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

        try {
            if (id != null) {
                this.cidade = this.fachada.buscarCidade(Long.parseLong(id));
            } else {
                this.cidade = new Cidade();
            }

            this.cidades = fachada.listarCidades();
        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }
    }

    public void filtrar() {
        try {
            this.cidades = fachada.listarCidades();
        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }

        Iterator<Cidade> insCidade = this.cidades.iterator();
        List<Cidade> tempList = new ArrayList<Cidade>();

        while (insCidade.hasNext()) {
            Cidade cidade = insCidade.next();

            if (cidade.getNome().contains(busca)) {
                tempList.add(cidade);
            }
        }

        this.cidades = tempList;
    }

    public void salvar() {
        try {
            this.cidade = this.fachada.cadastrarCidade(this.cidade);
            abrirDialog("sucess-dlg");
        } catch (DAOException ex) {
            imprimirErro(ex.getMessage());
        }
    }

    public void prepararCidade(Cidade cidade) {
        this.cidade = cidade;
        abrirDialog("apagar-dlg");
    }

    public void removerCidade() {
        try {
            this.cidade = this.fachada.removerCidade(this.cidade);
            abrirDialog("sucess-dlg");
        } catch (DAOException ex) {
            fecharDialog("apagar-dlg");
            imprimirErro(ex.getMessage());
        }
    }

    public Estados[] getListarEstados() {
        return Estados.values();
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

}
