package br.com.itinerario.controller;

import br.com.itinerario.facade.Facade;
import br.com.itinerario.model.Onibus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean
@ViewScoped
public class OnibusBean extends DefaultBean implements Serializable {

    private Onibus onibus;
    private List<Onibus> onibusList;
    private Facade fachada;
    private String busca;
    private LinkUtilBean linkBean;

    public OnibusBean() {
        onibus = new Onibus();
        linkBean = new LinkUtilBean();
    }

    @PostConstruct
    private void init() {
        fachada = new Facade();
        try {
            onibusList = fachada.listarOnibus();
        } catch (Exception ex) {
            Logger.getLogger(OnibusBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String salvar() {
        try {
            fachada.cadastrarOnibus(onibus);
            return linkBean.listaVeiculos();
        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }
        return null;
    }
    
    public void filtrar() {
        try {
            onibusList = fachada.listarOnibus();
        } catch (Exception ex) {
            Logger.getLogger(OnibusBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        Iterator<Onibus> intOnibus = this.onibusList.iterator();
        List<Onibus> tempList = new ArrayList<Onibus>();

        while (intOnibus.hasNext()) {
            Onibus bus = intOnibus.next();

            if (bus.getMarca().contains(busca)
                    || bus.getModelo().contains(busca)
                    || bus.getNumero().contains(busca)
                    || bus.getPlaca().contains(busca)) {
                tempList.add(bus);
            }
        }

        this.onibusList = tempList;
    }

    public Onibus getOnibus() {
        return onibus;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }

    public List<Onibus> getOnibusList() {
        return onibusList;
    }

    public void setOnibusList(List<Onibus> onibusList) {
        this.onibusList = onibusList;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

}
