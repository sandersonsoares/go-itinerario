package br.com.itinerario.facade;

import br.com.itinerario.business.BilheteBusiness;
import br.com.itinerario.business.CidadeBusiness;
import br.com.itinerario.business.GrupoBusiness;
import br.com.itinerario.business.MotoristaBusiness;
import br.com.itinerario.business.OnibusBusiness;
import br.com.itinerario.business.PassageiroBusiness;
import br.com.itinerario.business.RotaBusiness;
import br.com.itinerario.business.UsuarioBusiness;
import br.com.itinerario.exception.DAOException;
import br.com.itinerario.model.Bilhete;
import br.com.itinerario.model.Cidade;
import br.com.itinerario.model.Grupo;
import br.com.itinerario.model.Motorista;

import br.com.itinerario.model.Onibus;
import br.com.itinerario.model.Passageiro;
import br.com.itinerario.model.Rota;
import br.com.itinerario.model.Usuario;
import java.io.Serializable;
import java.util.List;

public class Facade implements Serializable {

    private PassageiroBusiness passageiroBusiness;
    private OnibusBusiness onibusBusiness;
    private GrupoBusiness grupoBusiness;
    private UsuarioBusiness usuarioBusiness;
    private BilheteBusiness bilheteBusiness;
    private RotaBusiness rotaBusiness;
    private CidadeBusiness cidadeBusiness;
    private MotoristaBusiness motoristaBusiness;

    public Facade() {
        this.passageiroBusiness = new PassageiroBusiness();
        this.onibusBusiness = new OnibusBusiness();
        this.grupoBusiness = new GrupoBusiness();
        this.usuarioBusiness = new UsuarioBusiness();
        this.bilheteBusiness = new BilheteBusiness();
        this.rotaBusiness = new RotaBusiness();
        this.motoristaBusiness = new MotoristaBusiness();
        this.cidadeBusiness = new CidadeBusiness();
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

    // Cidade
    public void cadastrarCidade(Cidade cidade) throws DAOException {
        this.cidadeBusiness.salvar(cidade);
    }

    public void removerCidade(Cidade cidade) throws DAOException {
        this.cidadeBusiness.remover(cidade);
    }

    public Cidade buscarCidade(Long id) throws DAOException {
        return this.cidadeBusiness.buscar(id);
    }

    public List<Cidade> listarCidades() throws DAOException {
        return this.cidadeBusiness.listar();
    }

    // Motorista
    public void cadastrarMotorista(Motorista motorista) throws DAOException {
        this.motoristaBusiness.salvar(motorista);
    }

    public void removerMotorista(Motorista motorista) throws DAOException {
        this.motoristaBusiness.remover(motorista);
    }

    public void buscarMotorista(Long id) throws DAOException {
        this.motoristaBusiness.buscar(id);
    }

    public List<Motorista> listarMotoristas() throws DAOException {
        return this.motoristaBusiness.listar();
    }

    // Onibus
    public void cadastrarOnibus(Onibus onibus) throws Exception {
        onibusBusiness.salvar(onibus);
    }

    public List<Onibus> listarOnibus() throws Exception {
        return onibusBusiness.listar();
    }

    public void removerOnibus(Onibus onibus) throws DAOException {
        onibusBusiness.remover(onibus);
    }

    public Onibus buscarOnibus(Long id) throws DAOException {
        return onibusBusiness.buscar(id);
    }

    // Passageiro
    public void cadastrarPassageiro(Passageiro passageiro) throws DAOException {
        passageiroBusiness.salvar(passageiro);
    }

    public void removerPassageiro(Passageiro passageiro) throws DAOException {
        passageiroBusiness.remover(passageiro);
    }

    public Passageiro buscarPassageiro(Long id) throws DAOException {
        return passageiroBusiness.buscar(id);
    }

    public List<Passageiro> listarPassageiros() throws DAOException {
        return passageiroBusiness.listar();
    }

    // Rota
    public void cadastrarRota(Rota rota) throws DAOException {
        this.rotaBusiness.salvar(rota);
    }

    public void removerRota(Rota rota) throws DAOException {
        this.rotaBusiness.remover(rota);
    }

    public Rota buscarRota(Long id) throws DAOException {
        return this.rotaBusiness.buscar(id);
    }

    public List<Rota> listarRotas() throws DAOException {
        return this.rotaBusiness.listar();
    }

    // Usuario
    public Usuario logarUsuario(String login) {
        return usuarioBusiness.logarUsuario(login);
    }

    public void cadastrarUsuario(Usuario usuario) throws Exception {
        usuarioBusiness.salvar(usuario);
    }

    public void atualizarUsuario(Usuario usuario) throws Exception {
        usuarioBusiness.atualizar(usuario);
    }

    public void removerUsuario() {

    }

    public Usuario buscarUsuario(Long id) throws DAOException {
        return usuarioBusiness.buscar(id);
    }

    public List<Usuario> listarUsuarios() throws Exception {
        return usuarioBusiness.listar();
    }

    // Bilhete
    public void cadastrarBilhete(Bilhete bilhete) throws DAOException {
        this.bilheteBusiness.salvar(bilhete);
    }

    public void removerBilhete(Bilhete bilhete) throws DAOException {
        this.bilheteBusiness.remover(bilhete);
    }

    public Bilhete buscarBilhete(Long id) throws DAOException {
        return this.bilheteBusiness.buscar(id);
    }

    public List<Bilhete> listarBilhetes() throws DAOException {
        return this.bilheteBusiness.listar();
    }

    // Grupos de Usuario
    public void cadastrarGrupo(Grupo grupo) throws Exception {
        grupoBusiness.salvar(grupo);
    }

    public Grupo buscarGrupo(Long id) throws Exception {
        return grupoBusiness.buscarGrupo(id);
    }

    public List<Grupo> listarGrupos() throws Exception {
        return grupoBusiness.listar();
    }

    public Onibus buscarOnibus(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public void atualizarOnibus(Onibus onibus) throws Exception {
//        onibusBusiness.atualizar(onibus);
//    }
}
