package br.com.itinerario.facade;

import br.com.itinerario.business.OnibusBusiness;
import br.com.itinerario.business.PassageiroBusiness;
import br.com.itinerario.exception.DAOException;

import br.com.itinerario.model.Onibus;
import br.com.itinerario.model.Passageiro;
import java.io.Serializable;
import java.util.List;

public class Facade implements Serializable {

    private PassageiroBusiness passageiroBusiness;
    private OnibusBusiness onibusBusiness;

    public Facade() {
        passageiroBusiness = new PassageiroBusiness();
        onibusBusiness = new OnibusBusiness();
    }

    // Assento
    public void cadastrarAssento() {

    }

    public void removerAssento() {

    }

    public void buscarAssento() {

    }

    public void listarAssentos() {

    }


    // Funcionario
    public void cadastrarFuncionario() {

    }

    public void removerFuncionario() {

    }

    public void buscarFuncionario() {

    }

    public void listarFuncionarios() {

    }

    // Horario
    public void cadastrarHorario() {

    }

    public void removerHorario() {

    }

    public void buscarHorario() {

    }

    public void listarHorarios() {

    }

    // Motorista
    public void cadastrarMotorista() {

    }

    public void removerMotorista() {

    }

    public void buscarMotorista() {

    }

    public void listarMotoristas() {

    }

    // Onibus
    public void cadastrarOnibus(Onibus onibus) throws Exception {
        onibusBusiness.salvar(onibus);
    }


    public List<Onibus> listarOnibus() throws Exception {
        return onibusBusiness.listar();
    }

    // Passageiro
    public void cadastrarPassageiro(Passageiro passageiro) throws DAOException {
        passageiroBusiness.salvar(passageiro);
    }

    public void removerPassageiro() {

    }

    public void buscarPassageiro() {

    }

    public List<Passageiro> listarPassageiros() throws DAOException {
        return passageiroBusiness.listar();
    }


    // Rota
    public void cadastrarRota() {

    }

    public void removerRota() {

    }

    public void buscarRota() {

    }

    public void listarRotas() {

    }

    // Usuario
    public void cadastrarUsuario() {

    }

    public void removerUsuario() {

    }

    public void buscarUsuario() {

    }

    public void listarUsuarios() {

    }

    // VendaBilhete
    public void cadastrarVendaBilhete() {

    }

    public void removerVendaBilhete() {

    }

    public void buscarVendaBilhete() {

    }

    public void listarVendaBilhetes() {

    }

}
