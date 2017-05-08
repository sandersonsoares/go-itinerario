package br.com.itinerario.controller;

import br.com.itinerario.enums.Sexo;
import br.com.itinerario.exception.DAOException;
import br.com.itinerario.facade.Facade;
import br.com.itinerario.model.Cidade;
import br.com.itinerario.model.Endereco;
import br.com.itinerario.model.Funcionario;
import br.com.itinerario.model.Passageiro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PessoaBean extends DefaultBean implements Serializable {

    private Funcionario funcionario;
    private Passageiro passageiro;
    private List<Passageiro> passageirosList;
    private Cidade cidade;
    private Endereco endereco;
    private Sexo sexo;
    private Facade facade;
    private String busca;
    private LinkUtilBean linkbean;

    public PessoaBean() {
        funcionario = new Funcionario();
        passageiro = new Passageiro();
        endereco = new Endereco();
        cidade = new Cidade();
        linkbean = new LinkUtilBean();
    }

    @PostConstruct
    private void init() {
        facade = new Facade();
        try {
            passageirosList = facade.listarPassageiros();
        } catch (DAOException ex) {
            Logger.getLogger(PessoaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void filtrar() {
        try {
            passageirosList = facade.listarPassageiros();
        } catch (DAOException ex) {
            Logger.getLogger(PessoaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator<Passageiro> intOnibus = this.passageirosList.iterator();
        List<Passageiro> tempList = new ArrayList<Passageiro>();

        while (intOnibus.hasNext()) {
            Passageiro passageiro = intOnibus.next();

            if (passageiro.getCpf().contains(busca)
                    || passageiro.getEmail().contains(busca)
                    || passageiro.getNome().contains(busca)) {
                tempList.add(passageiro);
            }
        }

        this.passageirosList = tempList;
    }

    public String salvarPassageiro() {
        try {
            facade.cadastrarPassageiro(this.passageiro);
            return linkbean.listaPassageiros();
        } catch (DAOException ex) {
            imprimirErro(ex.getMessage());
        }
        return null;
    }
    
    public Sexo[] getListarSexos() {
        return Sexo.values();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public List<Passageiro> getPassageirosList() {
        return passageirosList;
    }

    public void setPassageirosList(List<Passageiro> passageirosList) {
        this.passageirosList = passageirosList;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

}
