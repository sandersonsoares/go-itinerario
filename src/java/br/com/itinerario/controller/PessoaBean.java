package br.com.itinerario.controller;

import br.com.itinerario.enums.Sexo;
import br.com.itinerario.exception.DAOException;
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
    
    private Passageiro passageiro;
    private List<Passageiro> passageiros;
    private Sexo sexo;
    private String busca;
    
    public PessoaBean() {
        super();
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
    
    public void filtrar() {
        try {
            passageiros = this.fachada.listarPassageiros();
        } catch (Exception ex) {
            imprimirErro(ex.getMessage());
        }
        Iterator<Passageiro> intOnibus = this.passageiros.iterator();
        List<Passageiro> tempList = new ArrayList<Passageiro>();
        
        while (intOnibus.hasNext()) {
            Passageiro passageiro = intOnibus.next();
            
            if (passageiro.getCpf().contains(busca)
                    || passageiro.getEmail().contains(busca)
                    || passageiro.getNome().contains(busca)) {
                tempList.add(passageiro);
            }
        }
        
        this.passageiros = tempList;
    }
    
    public String salvarPassageiro() {
        try {
            this.fachada.cadastrarPassageiro(this.passageiro);
            return this.linkBean.listaPassageiros();
        } catch (DAOException ex) {
            imprimirErro(ex.getMessage());
        }
        return null;
    }
    
    public void removerPassageiro(Passageiro passageiro) {
        try {
            this.fachada.removerPassageiro(passageiro);
        } catch (DAOException ex) {
            imprimirErro(ex.getMessage());
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
