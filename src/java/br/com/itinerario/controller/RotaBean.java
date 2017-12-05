package br.com.itinerario.controller;

import br.com.itinerario.exception.DAOException;
import br.com.itinerario.model.Cidade;
import br.com.itinerario.model.Rota;
import java.util.ArrayList;
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
public class RotaBean extends DefaultBean {

    private Rota rota;
    private List<Rota> rotas;
    private List<Cidade> cidades;

    public RotaBean() {
        this.rotas = new ArrayList<>();
    }

    @PostConstruct
    private void init() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

        try {
            if (id != null) {
                this.rota = this.fachada.buscarRota(Long.parseLong(id));
            } else {
                this.rota = new Rota();
            }

            this.rotas = fachada.listarRotas();
            this.cidades = fachada.listarCidades();
            System.out.println(this.rotas);
        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }
    }

    public String salvar() {
        try {
            this.fachada.cadastrarRota(this.rota);
            return this.linkBean.listaRotas();
        } catch (DAOException ex) {
            imprimirErro(ex.getMessage());
        }
        return null;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public List<Rota> getRotas() {
        return rotas;
    }

    public void setRotas(List<Rota> rotas) {
        this.rotas = rotas;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

}
