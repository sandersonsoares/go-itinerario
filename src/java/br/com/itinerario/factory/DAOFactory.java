package br.com.itinerario.factory;

import br.com.itinerario.dao.AssentoDAO;
import br.com.itinerario.dao.BilheteDAO;
import br.com.itinerario.dao.CidadeDAO;
import br.com.itinerario.dao.EnderecoDAO;
import br.com.itinerario.dao.FuncionarioDAO;
import br.com.itinerario.dao.GrupoDAO;
import br.com.itinerario.dao.MotoristaDAO;
import br.com.itinerario.dao.VeiculoDAO;
import br.com.itinerario.dao.PassageiroDAO;
import br.com.itinerario.dao.PessoaDAO;
import br.com.itinerario.dao.RotaDAO;
import br.com.itinerario.dao.UsuarioDAO;
import br.com.itinerario.dao.VendaBilheteDAO;
import br.com.itinerario.interfaces.DaoGeneric;
import br.com.itinerario.interfaces.IUsuarioDAO;
import br.com.itinerario.model.Cidade;
import br.com.itinerario.model.Rota;

public class DAOFactory {

    public static DaoGeneric createAssentoDAO() {
        return new AssentoDAO();
    }

    public static DaoGeneric createBilheteDAO() {
        return new BilheteDAO();
    }

    public static DaoGeneric<Cidade> createCidadeDAO() {
        return new CidadeDAO();
    }

    public static DaoGeneric createEnderecoDAO() {
        return new EnderecoDAO();
    }

    public static DaoGeneric createFuncionarioDAO() {
        return new FuncionarioDAO();
    }

    public static DaoGeneric createMotoristaDAO() {
        return new MotoristaDAO();
    }

    public static DaoGeneric createVeiculoDAO() {
        return new VeiculoDAO();
    }

    public static DaoGeneric createPassageiroDAO() {
        return new PassageiroDAO();
    }

    public static DaoGeneric createPessoaDAO() {
        return new PessoaDAO();
    }

    public static DaoGeneric<Rota> createRotaDAO() {
        return new RotaDAO();
    }

    public static IUsuarioDAO createUsuarioDAO() {
        return new UsuarioDAO();
    }

    public static DaoGeneric createVendaBilheteDAO() {
        return new VendaBilheteDAO();
    }

    public static DaoGeneric createGrupoDAO() {
        return new GrupoDAO();
    }

}
