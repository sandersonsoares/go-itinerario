package br.com.itinerario.business;

import br.com.itinerario.exception.DAOException;
import br.com.itinerario.factory.DAOFactory;
import br.com.itinerario.interfaces.DaoGeneric;
import br.com.itinerario.model.Motorista;
import java.util.List;

/**
 *
 * @author Sanderson
 */
public class MotoristaBusiness {

    private DaoGeneric<Motorista> motoristaDao;

    public MotoristaBusiness() {
        this.motoristaDao = DAOFactory.createMotoristaDAO();
    }

    public synchronized Motorista salvar(Motorista motorista) throws DAOException {
        if (motorista.getId() != null) {
            return motoristaDao.update(motorista);
        } else {
            return motoristaDao.save(motorista);
        }
    }

    public List<Motorista> listar() throws DAOException {
        return motoristaDao.getAll();
    }

    public synchronized Motorista remover(Motorista motorista) throws DAOException {
        return this.motoristaDao.remove(motorista);
    }

    public Motorista buscar(Long id) throws DAOException {
        return this.motoristaDao.getById(id);
    }
}
