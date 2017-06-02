package br.com.itinerario.business;

import br.com.itinerario.exception.DAOException;
import br.com.itinerario.interfaces.DaoGeneric;
import br.com.itinerario.model.Passageiro;
import br.com.itinerario.factory.DAOFactory;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Sandersoon
 */
public class PassageiroBusiness implements Serializable {

    private DaoGeneric passageiroDao;

    public PassageiroBusiness() {
        passageiroDao = DAOFactory.createPassageiroDAO();
    }

    public void salvar(Passageiro passageiro) throws DAOException {
        if (passageiro.getId() != null) {
            passageiroDao.update(passageiro);
        } else {
            passageiroDao.save(passageiro);
        }
    }

    public List<Passageiro> listar() throws DAOException {
        return passageiroDao.getAll();
    }

    public Passageiro buscar(Long id) throws DAOException {
        return (Passageiro) passageiroDao.getById(id);
    }

    public void remover(Passageiro passageiro) throws DAOException {
        passageiroDao.remove(passageiro);
    }
}
