package br.com.itinerario.controller;

import br.com.itinerario.enums.Estados;
import br.com.itinerario.enums.Sexo;
import br.com.itinerario.exception.DAOException;
import br.com.itinerario.facade.Facade;
import br.com.itinerario.model.Passageiro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class PessoaBean extends DefaultBean {

    private Facade fachada;
    
    private Passageiro passageiro;
    private List<Passageiro> passageiros;
    private Sexo sexo;
    private String busca;

    public PessoaBean() {
        super();
        this.fachada = new Facade();
    }

    @PostConstruct
    private void init() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

        try {
            if (id != null) {
                this.passageiro = this.fachada.buscarPassageiro(Long.parseLong(id));
            } else {
                this.passageiro = new Passageiro();
            }
            passageiros = this.fachada.listarPassageiros();
        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }
    }

    public Estados[] getListarEstados() {
        return Estados.values();
    }

    public void filtrarPassageiros() {
        try {
            this.passageiros = fachada.listarPassageiros();

        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }

        Iterator<Passageiro> intPassageiro = this.passageiros.iterator();
        List<Passageiro> tempList = new ArrayList<>();

        while (intPassageiro.hasNext()) {
            Passageiro passageiro = intPassageiro.next();

            if (passageiro.getNome().contains(busca)
                    || passageiro.getCpf().contains(busca)) {
                tempList.add(passageiro);
            }
        }

        this.passageiros = tempList;
    }
    
    public void preparaPassageiro(Passageiro passageiro){
        this.passageiro = passageiro;
        abrirDialog("apagar-dlg");
    }

    public void salvarPassageiro() {
        try {
            this.passageiro = this.fachada.cadastrarPassageiro(this.passageiro);
            abrirDialog("sucess-dlg");
        } catch (DAOException ex) {
            imprimirErro(ex.getMessage());
        }
    }

    public void removerPassageiro() {
        try {
            this.passageiro = this.fachada.removerPassageiro(this.passageiro);
            abrirDialog("sucess-dlg");
        } catch (DAOException ex) {
            imprimirErro(ex.getMessage());
            fecharDialog("apagar-dlg");
        }
    }

    public Sexo[] getListarSexos() {
        return Sexo.values();
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(List<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

}
