package br.com.itinerario.controller;

import br.com.itinerario.model.Bilhete;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class BilheteBean extends DefaultBean {

    private Bilhete bilhete;
    private List<Bilhete> bilhetes;

    private String busca;

    public BilheteBean() {
        super();
        this.bilhete = new Bilhete();
        this.bilhetes = new ArrayList<>();
    }

    @PostConstruct
    private void init() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

        try {
            if (id != null) {
                this.bilhete = this.fachada.buscarBilhete(Long.parseLong(id));
            } else {
                this.bilhete = new Bilhete();
            }

            this.bilhetes = fachada.listarBilhetes();
        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }

    }

    public void filtrar() {
        try {
            this.bilhetes = fachada.listarBilhetes();
        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }

        Iterator<Bilhete> intBilhete = this.bilhetes.iterator();
        List<Bilhete> tempList = new ArrayList<Bilhete>();

        while (intBilhete.hasNext()) {
            Bilhete bilhete = intBilhete.next();

            if (bilhete.getPassageiro().getNome().contains(busca)
                    || bilhete.getNumero() == (Integer.parseInt(busca))) {
                tempList.add(bilhete);
            }
        }
        
        this.bilhetes = tempList;
    }

    public Bilhete getBilhete() {
        return bilhete;
    }

    public void setBilhete(Bilhete bilhete) {
        this.bilhete = bilhete;
    }

    public List<Bilhete> getBilhetes() {
        return bilhetes;
    }

    public void setBilhetes(List<Bilhete> bilhetes) {
        this.bilhetes = bilhetes;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

}
