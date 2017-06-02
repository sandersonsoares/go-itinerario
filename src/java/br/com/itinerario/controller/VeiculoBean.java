package br.com.itinerario.controller;

import br.com.itinerario.exception.DAOException;
import br.com.itinerario.model.Onibus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class VeiculoBean extends DefaultBean {

    private Onibus veiculo;
    private List<Onibus> veiculos;
    private String busca;

    public VeiculoBean() {
        super();
    }

    @PostConstruct
    public void init() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        
        try {
            if (id != null) {
                this.veiculo = this.fachada.buscarOnibus(Long.parseLong(id));
            } else {
                this.veiculo = new Onibus();
            }
            
            veiculos = fachada.listarOnibus();
        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }
    }
    
     public String salvar() {
        System.out.println(this.veiculo.getId());
        try {
            fachada.cadastrarOnibus(this.veiculo);
            return linkBean.listaVeiculos();
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return null;
    }

    public String removerOnibus(Onibus onibus) {
        try {
            fachada.removerOnibus(onibus);
            return linkBean.listaVeiculos();
        } catch (DAOException ex) {
            imprimirErro(ex.getMessage());
        }
        return null;
    }

    public void filtrar() {
        try {
            veiculos = fachada.listarOnibus();

        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }

        Iterator<Onibus> intOnibus = this.veiculos.iterator();
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

        this.veiculos = tempList;
    }

    public Onibus getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Onibus veiculo) {
        this.veiculo = veiculo;
    }

    public List<Onibus> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Onibus> veiculos) {
        this.veiculos = veiculos;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

}
