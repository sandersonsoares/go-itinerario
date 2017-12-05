package br.com.itinerario.controller;

import br.com.itinerario.enums.Estados;
import br.com.itinerario.exception.DAOException;
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

    private Cidade cidade;
    private List<Cidade> cidades;

    private String busca;

    public CidadeBean() {
        this.cidade = new Cidade();
        this.cidades = new ArrayList<>();
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
            System.out.println(this.cidades);
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

    public String salvar() {
        try {
            this.fachada.cadastrarCidade(this.cidade);
            return this.linkBean.listaCidades();
        } catch (DAOException ex) {
            imprimirErro(ex.getMessage());
        }
        return null;
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
