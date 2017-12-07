package br.com.itinerario.controller;

import br.com.itinerario.exception.DAOException;
import br.com.itinerario.facade.Facade;
import br.com.itinerario.model.Veiculo;
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
    
    private Facade fachada;

    private Veiculo veiculo;
    private List<Veiculo> veiculos;
    private String busca;

    public VeiculoBean() {
        super();
        this.fachada = new Facade();
    }

    @PostConstruct
    public void init() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

        try {
            if (id != null) {
                this.veiculo = this.fachada.buscarVeiculo(Long.parseLong(id));
            } else {
                this.veiculo = new Veiculo();
            }

            veiculos = fachada.listarVeiculo();
        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }
    }

    public void salvar() {
        try {
            this.veiculo = this.fachada.cadastrarVeiculo(this.veiculo);
            abrirDialog("sucess-dlg");
        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }
    }

    public void preparaVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
        abrirDialog("apagar-dlg");
    }

    public void removerVeiculo() {
        try {
            this.veiculo = this.fachada.removerVeiculo(this.veiculo);
            abrirDialog("sucess-dlg");
        } catch (DAOException ex) {
            fecharDialog("apagar-dlg");
            imprimirErro(ex.getMessage());
        }
    }

    public void filtrar() {
        try {
            veiculos = fachada.listarVeiculo();

        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }

        Iterator<Veiculo> intVeiculo = this.veiculos.iterator();
        List<Veiculo> tempList = new ArrayList<Veiculo>();

        while (intVeiculo.hasNext()) {
            Veiculo bus = intVeiculo.next();

            if (bus.getMarca().contains(busca)
                    || bus.getModelo().contains(busca)
                    || bus.getNumero().contains(busca)
                    || bus.getPlaca().contains(busca)) {
                tempList.add(bus);
            }
        }

        this.veiculos = tempList;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

}
