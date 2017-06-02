package br.com.itinerario.facade;

import br.com.itinerario.business.GrupoBusiness;
import br.com.itinerario.business.OnibusBusiness;
import br.com.itinerario.business.PassageiroBusiness;
import br.com.itinerario.business.UsuarioBusiness;
import br.com.itinerario.exception.DAOException;
import br.com.itinerario.model.Grupo;

import br.com.itinerario.model.Onibus;
import br.com.itinerario.model.Passageiro;
import br.com.itinerario.model.Usuario;
import java.io.Serializable;
import java.util.List;

public class Facade implements Serializable {

    private PassageiroBusiness passageiroBusiness;
    private OnibusBusiness onibusBusiness;
    private GrupoBusiness grupoBusiness;
    private UsuarioBusiness usuarioBusiness;

    public Facade() {
        passageiroBusiness = new PassageiroBusiness();
        onibusBusiness = new OnibusBusiness();
        grupoBusiness = new GrupoBusiness();
        usuarioBusiness = new UsuarioBusiness();
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
    
    public void removerOnibus(Onibus onibus) throws DAOException{
        onibusBusiness.remover(onibus);
    }
    
    public Onibus buscarOnibus(Long id) throws DAOException{
        return onibusBusiness.buscar(id);
    }

    // Passageiro
    public void cadastrarPassageiro(Passageiro passageiro) throws DAOException {
        passageiroBusiness.salvar(passageiro);
    }

    public void removerPassageiro(Passageiro passageiro) throws DAOException {
        passageiroBusiness.remover(passageiro);
    }

    public Passageiro buscarPassageiro(Long id) throws DAOException{
        return passageiroBusiness.buscar(id);
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

    // VendaBilhete
    public void cadastrarVendaBilhete() {

    }

    public void removerVendaBilhete() {

    }

    public void buscarVendaBilhete() {

    }

    public void listarVendaBilhetes() {

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
