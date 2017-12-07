package br.com.itinerario.facade;

import br.com.itinerario.business.BilheteBusiness;
import br.com.itinerario.business.CidadeBusiness;
import br.com.itinerario.business.GrupoBusiness;
import br.com.itinerario.business.MotoristaBusiness;
import br.com.itinerario.business.VeiculoBusiness;
import br.com.itinerario.business.PassageiroBusiness;
import br.com.itinerario.business.RotaBusiness;
import br.com.itinerario.business.UsuarioBusiness;
import br.com.itinerario.exception.DAOException;
import br.com.itinerario.model.Bilhete;
import br.com.itinerario.model.Cidade;
import br.com.itinerario.model.Grupo;
import br.com.itinerario.model.Motorista;

import br.com.itinerario.model.Veiculo;
import br.com.itinerario.model.Passageiro;
import br.com.itinerario.model.Rota;
import br.com.itinerario.model.Usuario;
import java.io.Serializable;
import java.util.List;

public class Facade implements Serializable {

    private PassageiroBusiness passageiroBusiness;
    private VeiculoBusiness veiculoBusiness;
    private GrupoBusiness grupoBusiness;
    private UsuarioBusiness usuarioBusiness;
    private BilheteBusiness bilheteBusiness;
    private RotaBusiness rotaBusiness;
    private CidadeBusiness cidadeBusiness;
    private MotoristaBusiness motoristaBusiness;

    public Facade() {
        this.passageiroBusiness = new PassageiroBusiness();
        this.veiculoBusiness = new VeiculoBusiness();
        this.grupoBusiness = new GrupoBusiness();
        this.usuarioBusiness = new UsuarioBusiness();
        this.bilheteBusiness = new BilheteBusiness();
        this.rotaBusiness = new RotaBusiness();
        this.motoristaBusiness = new MotoristaBusiness();
        this.cidadeBusiness = new CidadeBusiness();
    }

    // Cidade
    public Cidade cadastrarCidade(Cidade cidade) throws DAOException {
        return this.cidadeBusiness.salvar(cidade);
    }

    public Cidade removerCidade(Cidade cidade) throws DAOException {
        return this.cidadeBusiness.remover(cidade);
    }

    public Cidade buscarCidade(Long id) throws DAOException {
        return this.cidadeBusiness.buscar(id);
    }

    public List<Cidade> listarCidades() throws DAOException {
        return this.cidadeBusiness.listar();
    }

    // Motorista
    public Motorista cadastrarMotorista(Motorista motorista) throws DAOException {
        return this.motoristaBusiness.salvar(motorista);
    }

    public Motorista removerMotorista(Motorista motorista) throws DAOException {
        return this.motoristaBusiness.remover(motorista);
    }

    public Motorista buscarMotorista(Long id) throws DAOException {
        return this.motoristaBusiness.buscar(id);
    }

    public List<Motorista> listarMotoristas() throws DAOException {
        return this.motoristaBusiness.listar();
    }

    // Veículo
    public Veiculo cadastrarVeiculo(Veiculo veiculo) throws Exception {
        return veiculoBusiness.salvar(veiculo);
    }

    public List<Veiculo> listarVeiculo() throws Exception {
        return veiculoBusiness.listar();
    }

    public Veiculo removerVeiculo(Veiculo veiculo) throws DAOException {
        return veiculoBusiness.remover(veiculo);
    }

    public Veiculo buscarVeiculo(Long id) throws DAOException {
        return veiculoBusiness.buscar(id);
    }

    // Passageiro
    public Passageiro cadastrarPassageiro(Passageiro passageiro) throws DAOException {
        return passageiroBusiness.salvar(passageiro);
    }

    public Passageiro removerPassageiro(Passageiro passageiro) throws DAOException {
        return passageiroBusiness.remover(passageiro);
    }

    public Passageiro buscarPassageiro(Long id) throws DAOException {
        return passageiroBusiness.buscar(id);
    }

    public List<Passageiro> listarPassageiros() throws DAOException {
        return passageiroBusiness.listar();
    }

    // Rota
    public Rota cadastrarRota(Rota rota) throws DAOException {
        return this.rotaBusiness.salvar(rota);
    }

    public Rota removerRota(Rota rota) throws DAOException {
        return this.rotaBusiness.remover(rota);
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

    public Usuario cadastrarUsuario(Usuario usuario) throws Exception {
        return usuarioBusiness.salvar(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) throws Exception {
        return usuarioBusiness.salvar(usuario);
    }

    public Usuario removerUsuario(Usuario usuario) throws DAOException {
        return usuarioBusiness.remover(usuario);
    }

    public Usuario buscarUsuario(Long id) throws DAOException {
        return usuarioBusiness.buscar(id);
    }

    public List<Usuario> listarUsuarios() throws Exception {
        return usuarioBusiness.listar();
    }

    // Bilhete
    public Bilhete cadastrarBilhete(Bilhete bilhete) throws DAOException {
        return this.bilheteBusiness.salvar(bilhete);
    }

    public Bilhete removerBilhete(Bilhete bilhete) throws DAOException {
        return this.bilheteBusiness.remover(bilhete);
    }

    public Bilhete buscarBilhete(Long id) throws DAOException {
        return this.bilheteBusiness.buscar(id);
    }

    public List<Bilhete> listarBilhetes() throws DAOException {
        return this.bilheteBusiness.listar();
    }

    // Grupos de Usuario
    public Grupo cadastrarGrupo(Grupo grupo) throws Exception {
        return grupoBusiness.salvar(grupo);
    }

    public Grupo removerGrupo(Grupo grupo) throws Exception {
        return grupoBusiness.remover(grupo);
    }

    public Grupo buscarGrupo(Long id) throws Exception {
        return grupoBusiness.buscarGrupo(id);
    }

    public List<Grupo> listarGrupos() throws Exception {
        return grupoBusiness.listar();
    }
}
